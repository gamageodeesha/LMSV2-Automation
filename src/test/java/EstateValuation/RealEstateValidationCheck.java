//package com.realestate.tests;
package EstateValuation;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class RealEstateValidationCheck {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {
        driver = LoginAndNavigate.loginAndNavigateToAddPage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void verifyRequiredFieldValidations() throws Exception {
        // Click Save as Draft
        WebElement saveDraftBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[normalize-space()='Save as Draft']")));
        saveDraftBtn.click();

        // Define required fields and their XPaths
        List<String> fieldXpaths = Arrays.asList(
                "//input[@name='deed_no']",
                "//input[@name='ledger_book_no']",
                "//div[@id='mui-component-select-owner_type']",
                "(//input[@name='unit_no'])[1]",
                "//input[@name='owner_first_name']",
                "//div[@id='mui-component-select-is_mortgaged']"
        );

        for (String xpath : fieldXpaths) {
            try {
                WebElement field = driver.findElement(By.xpath(xpath));

                // find first <p> tag following this field
                WebElement validationMessage = field.findElement(By.xpath("./following::p[1]"));
                String actualText = validationMessage.getText().trim();

                Assert.assertEquals(actualText, "This field is required.",
                        "❌ Validation mismatch for field: " + xpath);

                System.out.println("✅ Validation correct for field: " + xpath);

            } catch (NoSuchElementException e) {
                Assert.fail("❌ No validation message found for field: " + xpath);
            }
        }
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        if (driver != null) {
            driver.quit();
        }
    }
}
