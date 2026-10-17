package EstateValuation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddRealEstate {
    public static void main(String[] args) throws Exception {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("http://3.1.164.148/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='email']")).click();
        driver.findElement(By.xpath("//input[@name='email']")).clear();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("demo.crm@lalco.la");

        //driver.findElement(By.xpath("//input[@name='password']")).click();
        driver.findElement(By.xpath("//*[@name='password']")).click();
        driver.findElement(By.xpath("//input[@name='password']")).clear();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password123!");

        //capture using span>text
        driver.findElement(By.xpath("//span[text()='Log In']")).click();

        WebElement element1 = driver.findElement(By.xpath("(//*[normalize-space(text())='Valuation'])[1]"));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].scrollIntoView(true);", element1);

        //Click valuation
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement valuationBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[normalize-space(text())='Valuation'])[1]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", valuationBtn);
        Thread.sleep(500); // small buffer for animation
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", valuationBtn);

        //Navigate to real estate > Add New
        driver.findElement(By.xpath("//*[normalize-space(text())='Real Estate Valuation']")).click();
        driver.findElement(By.xpath("//a[@href='/dashboard/real-estate-valuation/search-customer-real-estate']//div[normalize-space(text())='Add New']")).click();

        driver.findElement(By.xpath("//input[@name='id']")).click();
        driver.findElement(By.xpath("//input[@name='id']")).clear();
        driver.findElement(By.xpath("//input[@name='id']")).sendKeys("152");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
        driver.findElement(By.xpath("(//a[contains(@href, '/dashboard/real-estate-valuation/create')])[1]")).click();

        driver.findElement(By.xpath("//select[@name='salesperson_id']")).click();
        driver.findElement(By.xpath("//select[@name='salesperson_id']")).sendKeys("Siliphone   Ketmany ( Bee - 26 )");

        driver.findElement(By.xpath("//input[@name='deed_no']")).click();
        driver.findElement(By.xpath("//input[@name='deed_no']")).clear();
        driver.findElement(By.xpath("//input[@name='deed_no']")).sendKeys("500");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@name='register_date']")).click();
        driver.findElement(By.xpath("//button[@aria-label='calendar view is open, go to text input view']")).click();
        driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']")).click();
        driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']")).sendKeys("2026-01-10");
        driver.findElement(By.xpath("//span[text()='OK']")).click();
        /*driver.findElement(By.xpath("//button[@aria-label='Oct 1, 2025']")).click();
        driver.findElement(By.xpath("//span[text()='OK']")).click();*/
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@name='ledger_book_no']")).click();
        driver.findElement(By.xpath("//input[@name='ledger_book_no']")).clear();
        driver.findElement(By.xpath("//input[@name='ledger_book_no']")).sendKeys("400");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@name='ledger_page_no']")).click();
        driver.findElement(By.xpath("//input[@name='ledger_page_no']")).clear();
        driver.findElement(By.xpath("//input[@name='ledger_page_no']")).sendKeys("695");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@name='map_no']")).click();
        driver.findElement(By.xpath("//input[@name='map_no']")).clear();
        driver.findElement(By.xpath("//input[@name='map_no']")).sendKeys("100");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@name='land_no']")).click();
        driver.findElement(By.xpath("//input[@name='land_no']")).clear();
        driver.findElement(By.xpath("//input[@name='land_no']")).sendKeys("250");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@name='land_area_square_meter']")).click();
        driver.findElement(By.xpath("//input[@name='land_area_square_meter']")).clear();
        driver.findElement(By.xpath("//input[@name='land_area_square_meter']")).sendKeys("340");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@id='mui-component-select-owner_type']")).click();
        driver.findElement(By.xpath("//li[normalize-space(text())='Individual']")).click();
        Thread.sleep(1000);

       /* driver.findElement(By.xpath("//input[@id='province_id']")).click();
        driver.findElement(By.xpath("//input[@id='province_id']")).sendKeys("Attapeu");
*/
        //province
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement provinceInput = driver.findElement(By.xpath("//input[@id='province_id']"));
        provinceInput.click();
        provinceInput.sendKeys("Oudomxay");
        Thread.sleep(3000);
        // Wait for dropdown option to appear and select it
        WebElement dropdownOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(., 'Oudomxay')]")));
        Thread.sleep(3000);
        dropdownOption.click();  // This selects it and closes the dropdown
        Thread.sleep(1000);

        //District
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement districtInput = driver.findElement(By.xpath("//input[@id='district_id']"));
        districtInput.click();
        districtInput.sendKeys("Beng");
        Thread.sleep(3000);
        // Wait for dropdown option to appear and select it
        WebElement dropdownOption1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(., 'Beng')]")));
        Thread.sleep(3000);
        dropdownOption1.click();  // This selects it and closes the dropdown
        Thread.sleep(1000);

        //Village
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement villageInput = driver.findElement(By.xpath("//input[@id='village_id']"));
        villageInput.click();
        villageInput.sendKeys("B. Bangkham");
        Thread.sleep(3000);
        // Wait for dropdown option to appear and select it
        WebElement dropdownOption2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(., 'B. Bangkham')]")));
        Thread.sleep(2000);
        dropdownOption2.click();  // This selects it and closes the dropdown
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@name='unit_no' and not(@disabled) and contains(@class,'MuiOutlinedInput-input')]")).click();
        driver.findElement(By.xpath("//input[@name='unit_no' and not(@disabled) and contains(@class,'MuiOutlinedInput-input')]")).clear();
        driver.findElement(By.xpath("//input[@name='unit_no' and not(@disabled) and contains(@class,'MuiOutlinedInput-input')]")).sendKeys("30");
        Thread.sleep(1000);

        /*WebElement unitField = driver.findElement(By.xpath("(//label[contains(text(),'Unit')])[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", unitField);
        unitField.sendKeys("U123");*/

        driver.findElement(By.xpath("//input[@name='owner_first_name']")).click();
        driver.findElement(By.xpath("//input[@name='owner_first_name']")).clear();
        driver.findElement(By.xpath("//input[@name='owner_first_name']")).sendKeys("Samadi");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@name='owner_last_name']")).click();
        driver.findElement(By.xpath("//input[@name='owner_last_name']")).clear();
        driver.findElement(By.xpath("//input[@name='owner_last_name']")).sendKeys("Gamage");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@name='owner_phone_number']")).click();
        driver.findElement(By.xpath("//input[@name='owner_phone_number']")).clear();
        driver.findElement(By.xpath("//input[@name='owner_phone_number']")).sendKeys("02094859635");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@name='owner_first_name_lo']")).click();
        driver.findElement(By.xpath("//input[@name='owner_first_name_lo']")).clear();
        driver.findElement(By.xpath("//input[@name='owner_first_name_lo']")).sendKeys("Samadi1");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@name='owner_last_name_lo']")).click();
        driver.findElement(By.xpath("//input[@name='owner_last_name_lo']")).clear();
        driver.findElement(By.xpath("//input[@name='owner_last_name_lo']")).sendKeys("Perera");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//label[contains(text(), 'Mortgage Type')]/following::div[@role='button'][1]")).click();
        driver.findElement(By.xpath("//li[@data-value='No']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//span[text()='Submit for Assessment']")).click();

        driver.findElement(By.xpath("(//a[contains(@class,'MuiButtonBase-root') and @title='Edit'])[1]")).click();
        driver.findElement(By.xpath("//button[.//span[text()='Land']]")).click();

        //Price from village head section
        driver.findElement(By.xpath("//input[@name='village_head_name']")).click();
        driver.findElement(By.xpath("//input[@name='village_head_name']")).sendKeys("Asia Lotus");

        driver.findElement(By.xpath("//input[@name='village_head_phone']")).click();
        driver.findElement(By.xpath("//input[@name='village_head_phone']")).sendKeys("02094859632");

        driver.findElement(By.xpath("//input[@name='village_head_price_per_square_meter']")).click();
        driver.findElement(By.xpath("//input[@name='village_head_price_per_square_meter']")).sendKeys("300");


        driver.findElement(By.xpath("//input[@name='village_head_comments']")).click();
        driver.findElement(By.xpath("//input[@name='village_head_comments']")).sendKeys("Testing");

        //Nearby territory price section
        driver.findElement(By.xpath("//input[@name='near_by_name']")).click();
        driver.findElement(By.xpath("//input[@name='near_by_name']")).sendKeys("Kasun");

        driver.findElement(By.xpath("//input[@name='near_by_phone_number']")).click();
        driver.findElement(By.xpath("//input[@name='near_by_phone_number']")).sendKeys("Gunasekara");

        driver.findElement(By.xpath("//input[@name='near_by_area']")).click();
        driver.findElement(By.xpath("//input[@name='near_by_area']")).sendKeys("230");

        driver.findElement(By.xpath("//input[@name='near_by_price_per_square_meter']")).click();
        driver.findElement(By.xpath("//input[@name='near_by_price_per_square_meter']")).sendKeys("480");

        driver.findElement(By.xpath("//input[@name='near_by_remarks']")).click();
        driver.findElement(By.xpath("//input[@name='near_by_remarks']")).sendKeys("Testing 23");

        driver.findElement(By.xpath("//input[@name='near_by_remarks']")).click();
        driver.findElement(By.xpath("//input[@name='near_by_remarks']")).sendKeys("Testing 23");


        driver.findElement(By.xpath("//span[text()='Complete Assessment']")).click();
        driver.findElement(By.xpath("//span[text()='Yes']")).click();



        //Scroll & click cancel
        WebElement element4 = driver.findElement(By.xpath("(//button[contains(@class,'MuiButtonBase-root') and @title='Cancel'])[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element4);
        element4.click();

        driver.findElement(By.xpath("//div[contains(@class,'ql-editor') and @data-placeholder='Reason']")).click();
        driver.findElement(By.xpath("//div[contains(@class,'ql-editor') and @data-placeholder='Reason']")).sendKeys("Testing purpose");
        driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
        Thread.sleep(1000);

        //Scroll & click Delete
        WebElement element = driver.findElement(By.xpath("(//button[contains(@class,'MuiButtonBase-root') and @title='Delete'])[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

        driver.findElement(By.xpath("//div[contains(@class,'ql-editor') and @data-placeholder='Reason']")).click();
        driver.findElement(By.xpath("//div[contains(@class,'ql-editor') and @data-placeholder='Reason']")).sendKeys("Testing purpose delete");
        driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
        Thread.sleep(1000);


        //Search Title deed No
        WebElement deedNo = driver.findElement(By.xpath("//input[@name='deed_no']"));
        deedNo.click();
        deedNo.sendKeys("500");

        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();

        // Wait for results or page stability
        Thread.sleep(2000);

        // Re-locate the field in case of re-render
        deedNo = driver.findElement(By.xpath("//input[@name='deed_no']"));

        // Clear properly using keyboard simulation (works for React)
        deedNo.sendKeys(Keys.CONTROL + "a"); // Select all text
        deedNo.sendKeys(Keys.DELETE);        // Delete selected text

        // Optional: small wait
        Thread.sleep(500);

        // Verify or trigger change event
        deedNo.sendKeys(Keys.TAB);

        // Now search again
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();



        Thread.sleep(2000);

    }
}
