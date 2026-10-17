package EstateValuation;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class EditValuationTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {
        driver = LoginAndNavigate.loginAndNavigateToAddPage();  // Reuse login and navigation
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to valuation list page after login
        driver.navigate().to("http://3.1.164.148/dashboard/real-estate-valuation");
    }

    @Test
    public void editValuationAndCompleteAssessment() throws Exception {
        // Search for the valuation (if needed)
        WebElement deedNo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='deed_no']")));
        deedNo.clear();
        deedNo.sendKeys("500"); // Deed no you added earlier
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
        Thread.sleep(2000);

        // Click Edit
        WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//a[contains(@class,'MuiButtonBase-root') and @title='Edit'])[1]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", editBtn);
        editBtn.click();

        // Click "Land" tab
        WebElement landBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[.//span[text()='Land']]")));
        landBtn.click();

        // --- Price from Village Head section ---
        WebElement villageHeadName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='village_head_name']")));
        villageHeadName.clear();
        villageHeadName.sendKeys("Asia Lotus");

        WebElement villageHeadPhone = driver.findElement(By.xpath("//input[@name='village_head_phone']"));
        villageHeadPhone.clear();
        villageHeadPhone.sendKeys("02094859632");

        WebElement villageHeadPrice = driver.findElement(By.xpath("//input[@name='village_head_price_per_square_meter']"));
        villageHeadPrice.clear();
        villageHeadPrice.sendKeys("300");

        WebElement villageHeadComments = driver.findElement(By.xpath("//input[@name='village_head_comments']"));
        villageHeadComments.clear();
        villageHeadComments.sendKeys("Testing");

        // --- Nearby Territory Price section ---
        WebElement nearbyName = driver.findElement(By.xpath("//input[@name='near_by_name']"));
        nearbyName.clear();
        nearbyName.sendKeys("Kasun");

        WebElement nearbyPhone = driver.findElement(By.xpath("//input[@name='near_by_phone_number']"));
        nearbyPhone.clear();
        nearbyPhone.sendKeys("Gunasekara");

        WebElement nearbyArea = driver.findElement(By.xpath("//input[@name='near_by_area']"));
        nearbyArea.clear();
        nearbyArea.sendKeys("230");

        WebElement nearbyPrice = driver.findElement(By.xpath("//input[@name='near_by_price_per_square_meter']"));
        nearbyPrice.clear();
        nearbyPrice.sendKeys("480");

        WebElement nearbyRemarks = driver.findElement(By.xpath("//input[@name='near_by_remarks']"));
        nearbyRemarks.clear();
        nearbyRemarks.sendKeys("Testing 23");

        // Complete Assessment
        WebElement completeBtn = driver.findElement(By.xpath("//span[text()='Complete Assessment']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", completeBtn);
        completeBtn.click();

        // Confirm Yes
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Yes']"))).click();

        // Verification (basic)
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().toLowerCase().contains("completed")
                        || driver.getPageSource().toLowerCase().contains("success"),
                "❌ Assessment completion not verified!");
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        if (driver != null) driver.quit();
    }
}
