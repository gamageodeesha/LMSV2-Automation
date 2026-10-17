package EstateValuation;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class AddValuationTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {
        driver = LoginAndNavigate.loginAndNavigateToAddPage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void addRealEstateValuation() throws Exception {

        // Salesperson
        WebElement salesperson = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='salesperson_id']")));
        salesperson.click();
        salesperson.sendKeys("Siliphone   Ketmany ( Bee - 26 )");

        // Deed No
        WebElement deedNo = driver.findElement(By.xpath("//input[@name='deed_no']"));
        deedNo.clear();
        deedNo.sendKeys("500");

        // Register Date
        driver.findElement(By.xpath("//input[@name='register_date']")).click();
        driver.findElement(By.xpath("//button[@aria-label='calendar view is open, go to text input view']")).click();
        driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']")).click();
        driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']")).sendKeys("2026-01-10");
        driver.findElement(By.xpath("//span[text()='OK']")).click();
        /*driver.findElement(By.xpath("//button[@aria-label='Oct 1, 2025']")).click();
        driver.findElement(By.xpath("//span[text()='OK']")).click();*/

        // Ledger details
        driver.findElement(By.xpath("//input[@name='ledger_book_no']")).sendKeys("400");
        driver.findElement(By.xpath("//input[@name='ledger_page_no']")).sendKeys("695");
        driver.findElement(By.xpath("//input[@name='map_no']")).sendKeys("100");
        driver.findElement(By.xpath("//input[@name='land_no']")).sendKeys("250");
        driver.findElement(By.xpath("//input[@name='land_area_square_meter']")).sendKeys("340");

        // Owner Type
        driver.findElement(By.xpath("//div[@id='mui-component-select-owner_type']")).click();
        driver.findElement(By.xpath("//li[normalize-space(text())='Individual']")).click();

        // Province
        WebElement provinceInput = driver.findElement(By.xpath("//input[@id='province_id']"));
        provinceInput.click();
        provinceInput.sendKeys("Oudomxay");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(., 'Oudomxay')]"))).click();

        // District
        WebElement districtInput = driver.findElement(By.xpath("//input[@id='district_id']"));
        districtInput.click();
        districtInput.sendKeys("Beng");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(., 'Beng')]"))).click();

        // Village
        WebElement villageInput = driver.findElement(By.xpath("//input[@id='village_id']"));
        villageInput.click();
        villageInput.sendKeys("B. Bangkham");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(., 'B. Bangkham')]"))).click();

        // Unit No
        WebElement unitNo = driver.findElement(By.xpath("//input[@name='unit_no' and not(@disabled)]"));
        unitNo.clear();
        unitNo.sendKeys("30");

        // Owner details
        driver.findElement(By.xpath("//input[@name='owner_first_name']")).sendKeys("Samadi");
        driver.findElement(By.xpath("//input[@name='owner_last_name']")).sendKeys("Gamage");
        driver.findElement(By.xpath("//input[@name='owner_phone_number']")).sendKeys("02094859635");
        driver.findElement(By.xpath("//input[@name='owner_first_name_lo']")).sendKeys("Samadi1");
        driver.findElement(By.xpath("//input[@name='owner_last_name_lo']")).sendKeys("Perera");

        // Mortgage type
        driver.findElement(By.xpath("//label[contains(text(), 'Mortgage Type')]/following::div[@role='button'][1]")).click();
        driver.findElement(By.xpath("//li[@data-value='No']")).click();

        // Submit
        driver.findElement(By.xpath("//span[text()='Submit for Assessment']")).click();
        driver.findElement(By.xpath("//textarea[@placeholder='Enter reason for submission...']")).click();
        driver.findElement(By.xpath("//textarea[@placeholder='Enter reason for submission...']")).sendKeys("testing hii");
        driver.findElement(By.xpath("//button[.//span[text()='Submit']]")).click();



        // Assertion or confirmation check
        Thread.sleep(2000);
        Assert.assertTrue(driver.getPageSource().contains("Successfully"), "Valuation submission failed!");
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        if (driver != null) driver.quit();
    }
}
