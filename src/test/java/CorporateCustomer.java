import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CorporateCustomer {
    public static void main(String[] args) {

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        try {

            driver.get("http://3.1.164.148/authentication/login-unguarded");


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
            emailInput.sendKeys("demo.crm@lalco.la");

            WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
            passwordInput.sendKeys("Password123!");

            driver.findElement(By.xpath("//span[text()='Log In']")).click();
            Thread.sleep(5000);

            wait.until(ExpectedConditions.urlContains("dashboard"));

            //To scroll until a specific element is visible
            WebElement element = driver.findElement(By.xpath("//div[text()='Customers']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);

            driver.findElement(By.xpath("//div[text()='Customers']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//span[contains(@class,'MuiButton-label') and contains(.,'Create Customer')]")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//div[@id='mui-component-select-cust_type']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//li[text()='Corporate']")).click();
            Thread.sleep(500);

            // Business Type
            driver.findElement(By.xpath("//div[@id='mui-component-select-business_type']")).click();
            driver.findElement(By.xpath("//li[normalize-space(.)='Accommodation – Food service - ທີພັກ-ອາຫານການກິນ']")).click();
            Thread.sleep(500);

            // Corporation No
            driver.findElement(By.xpath("//input[@name='id_familybook_reg_no']")).click();
            driver.findElement(By.xpath("//input[@name='id_familybook_reg_no']")).clear();
            driver.findElement(By.xpath("//input[@name='id_familybook_reg_no']")).sendKeys("123456789");
            Thread.sleep(500);

            // Registration Date
            driver.findElement(By.xpath("//input[@name='registration_date']")).click();
            driver.findElement(By.xpath("//button[@aria-label='Oct 1, 2025']")).click();
            driver.findElement(By.xpath("//span[text()='OK']")).click();
            Thread.sleep(500);

            // Company Name (Eng)
            driver.findElement(By.xpath("//input[@name='full_name']")).click();
            driver.findElement(By.xpath("//input[@name='full_name']")).clear();
            driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Lalco");
            Thread.sleep(500);

            // Company Name (Lao)
            driver.findElement(By.xpath("//input[@name='full_name_local']")).click();
            driver.findElement(By.xpath("//input[@name='full_name_local']")).clear();
            driver.findElement(By.xpath("//input[@name='full_name_local']")).sendKeys("ລາໂຄ");
            Thread.sleep(500);

            // Representative Name
            driver.findElement(By.xpath("//input[@name='representative_name']")).click();
            driver.findElement(By.xpath("//input[@name='representative_name']")).clear();
            driver.findElement(By.xpath("//input[@name='representative_name']")).sendKeys("Irudini");
            Thread.sleep(500);

            // Main Phone No.
            driver.findElement(By.xpath("//input[@name='main_phone_no']")).click();
            driver.findElement(By.xpath("//input[@name='main_phone_no']")).clear();
            driver.findElement(By.xpath("//input[@name='main_phone_no']")).sendKeys("02021234567");
            Thread.sleep(500);

            // Secondary Phone No.
            driver.findElement(By.xpath("//input[@name='secondary_phone_no']")).click();
            driver.findElement(By.xpath("//input[@name='secondary_phone_no']")).clear();
            driver.findElement(By.xpath("//input[@name='secondary_phone_no']")).sendKeys("0302123456");
            Thread.sleep(500);

            // Whatsapp No.
            driver.findElement(By.xpath("//input[@name='whatsapp_no']")).click();
            driver.findElement(By.xpath("//input[@name='whatsapp_no']")).clear();
            driver.findElement(By.xpath("//input[@name='whatsapp_no']")).sendKeys("02021234567");
            Thread.sleep(500);

            // Company Email
            driver.findElement(By.xpath("//input[@name='email']")).click();
            driver.findElement(By.xpath("//input[@name='email']")).clear();
            driver.findElement(By.xpath("//input[@name='email']")).sendKeys("irudiniwijayakoon@gmail.com");
            Thread.sleep(500);

            // Emergency Contact Name
            driver.findElement(By.xpath("//input[@name='emergency_contact_name']")).click();
            driver.findElement(By.xpath("//input[@name='emergency_contact_name']")).clear();
            driver.findElement(By.xpath("//input[@name='emergency_contact_name']")).sendKeys("Kevin");
            Thread.sleep(500);

            // Emergency Contact Phone No.
            driver.findElement(By.xpath("//input[@name='emergency_contact_phone_no']")).click();
            driver.findElement(By.xpath("//input[@name='emergency_contact_phone_no']")).clear();
            driver.findElement(By.xpath("//input[@name='emergency_contact_phone_no']")).sendKeys("02020829292");
            Thread.sleep(500);

            // Emergency Contact Email
            driver.findElement(By.xpath("//input[@name='emergency_contact_email']")).click();
            driver.findElement(By.xpath("//input[@name='emergency_contact_email']")).clear();
            driver.findElement(By.xpath("//input[@name='emergency_contact_email']")).sendKeys("irudiniwijayakoon@gmail.com");
            Thread.sleep(500);

            // Province
            WebElement provinceInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@aria-autocomplete='list'])[1]")));
            provinceInput.click();
            provinceInput.sendKeys("Attapeu - ອັດຕະປື" + Keys.ENTER);
            Thread.sleep(500);

            // District
            WebElement districtInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@aria-autocomplete='list'])[2]")));
            districtInput.click();
            districtInput.sendKeys("Saysetha - ໄຊເຊດຖາ" + Keys.ENTER);
            Thread.sleep(500);

            // Village
            WebElement villageInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@aria-autocomplete='list'])[3]")));
            villageInput.click();
            villageInput.sendKeys("B. Dakyieng - " + Keys.ENTER);
            Thread.sleep(500);

            // Address (Unit)
            driver.findElement(By.xpath("//input[@name='unit_no']")).click();
            driver.findElement(By.xpath("//input[@name='unit_no']")).clear();
            driver.findElement(By.xpath("//input[@name='unit_no']")).sendKeys("123");
            Thread.sleep(500);

            // How did you know about us?
            driver.findElement(By.xpath("//div[@id='mui-component-select-found_source']")).click();
            driver.findElement(By.xpath("//li[text()='Introduction']")).click();
            Thread.sleep(500);

            // Facebook URL
            driver.findElement(By.xpath("//input[@name='facebook_url']")).click();
            driver.findElement(By.xpath("//input[@name='facebook_url']")).clear();
            driver.findElement(By.xpath("//input[@name='facebook_url']")).sendKeys("https://www.facebook.com");
            Thread.sleep(500);

            // Total Income
            driver.findElement(By.xpath("//input[@name='total_income']")).click();
            driver.findElement(By.xpath("//input[@name='total_income']")).clear();
            driver.findElement(By.xpath("//input[@name='total_income']")).sendKeys("5000");
            Thread.sleep(500);

            // Total Expenditure
            driver.findElement(By.xpath("//input[@name='total_expenditure']")).click();
            driver.findElement(By.xpath("//input[@name='total_expenditure']")).clear();
            driver.findElement(By.xpath("//input[@name='total_expenditure']")).sendKeys("2000");
            Thread.sleep(500);


            // --- Vehicles Tab ---

            //To scroll until a Vehicles Tab is visible
            WebElement element2 = driver.findElement(By.xpath("//span[text()='Vehicles']"));
            JavascriptExecutor js2 = (JavascriptExecutor) driver;
            js2.executeScript("arguments[0].scrollIntoView(true);", element2);

            driver.findElement(By.xpath("//span[text()='Vehicles']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//div[@id='mui-component-select-vehicle_type']")).click();
            driver.findElement(By.xpath("//li[text()='Car']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='maker']")).click();
            driver.findElement(By.xpath("//input[@name='maker']")).clear();
            driver.findElement(By.xpath("//input[@name='maker']")).sendKeys("Toyota");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='model']")).click();
            driver.findElement(By.xpath("//input[@name='model']")).clear();
            driver.findElement(By.xpath("//input[@name='model']")).sendKeys("Sport");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='year']")).click();
            driver.findElement(By.xpath("//input[@name='year']")).clear();
            driver.findElement(By.xpath("//input[@name='year']")).sendKeys("2025");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='owner_first_name']")).click();
            driver.findElement(By.xpath("//input[@name='owner_first_name']")).clear();
            driver.findElement(By.xpath("//input[@name='owner_first_name']")).sendKeys("Sandali");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='owner_last_name']")).click();
            driver.findElement(By.xpath("//input[@name='owner_last_name']")).clear();
            driver.findElement(By.xpath("//input[@name='owner_last_name']")).sendKeys("Konara");
            Thread.sleep(500);

            driver.findElement(By.xpath("//div[@id='mui-component-select-relationship']")).click();
            driver.findElement(By.xpath("//li[text()='Family Living Together']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='who_is_it']")).click();
            driver.findElement(By.xpath("//input[@name='who_is_it']")).clear();
            driver.findElement(By.xpath("//input[@name='who_is_it']")).sendKeys("Friend");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='value']")).click();
            driver.findElement(By.xpath("//input[@name='value']")).clear();
            driver.findElement(By.xpath("//input[@name='value']")).sendKeys("6000");
            Thread.sleep(500);

            driver.findElement(By.xpath("//div[@id='mui-component-select-vehicle_currency']")).click();
            driver.findElement(By.xpath("//li[text()='USD']")).click();
            Thread.sleep(500);



            // --- Real Estate Tab ---

            //To scroll until a Vehicles Tab is visible
            WebElement element3 = driver.findElement(By.xpath("//span[text()='Real Estates']"));
            JavascriptExecutor js3 = (JavascriptExecutor) driver;
            js3.executeScript("arguments[0].scrollIntoView(true);", element3);

            driver.findElement(By.xpath("//span[text()='Real Estates']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//div[@id='mui-component-select-estate_type']")).click();
            driver.findElement(By.xpath("//li[text()='Land']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='land_area']")).click();
            driver.findElement(By.xpath("//input[@name='land_area']")).clear();
            driver.findElement(By.xpath("//input[@name='land_area']")).sendKeys("600");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='land_owner_first_name']")).click();
            driver.findElement(By.xpath("//input[@name='land_owner_first_name']")).clear();
            driver.findElement(By.xpath("//input[@name='land_owner_first_name']")).sendKeys("Shane");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='land_owner_last_name']")).click();
            driver.findElement(By.xpath("//input[@name='land_owner_last_name']")).clear();
            driver.findElement(By.xpath("//input[@name='land_owner_last_name']")).sendKeys("Fernando");
            Thread.sleep(500);

            driver.findElement(By.xpath("//div[@id='mui-component-select-land_owner_relationship']")).click();
            driver.findElement(By.xpath("//li[text()='Person Themselves']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='land_who_is']")).click();
            driver.findElement(By.xpath("//input[@name='land_who_is']")).clear();
            driver.findElement(By.xpath("//input[@name='land_who_is']")).sendKeys("Shem");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='land_value']")).click();
            driver.findElement(By.xpath("//input[@name='land_value']")).clear();
            driver.findElement(By.xpath("//input[@name='land_value']")).sendKeys("100000");
            Thread.sleep(500);

            driver.findElement(By.xpath("(//div[@id='mui-component-select-vehicle_currency'])[2]")).click();
            driver.findElement(By.xpath("//li[text()='USD']")).click();
            Thread.sleep(500);


            // --- Income Tab
            //To scroll until a Vehicles Tab is visible
            WebElement element4 = driver.findElement(By.xpath("//span[text()='Income']"));
            JavascriptExecutor js4 = (JavascriptExecutor) driver;
            js4.executeScript("arguments[0].scrollIntoView(true);", element4);

            driver.findElement(By.xpath("//span[text()='Income']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//div[@id='mui-component-select-income_type']")).click();
            driver.findElement(By.xpath("//li[text()='House Rental - ເຮືອນເຊົ່າ']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='income_amount']")).click();
            driver.findElement(By.xpath("//input[@name='income_amount']")).clear();
            driver.findElement(By.xpath("//input[@name='income_amount']")).sendKeys("80000");
            Thread.sleep(500);

            driver.findElement(By.xpath("//div[@id='mui-component-select-income_currency']")).click();
            driver.findElement(By.xpath("//li[text()='USD']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='income_asset']")).click();
            driver.findElement(By.xpath("//input[@name='income_asset']")).clear();
            driver.findElement(By.xpath("//input[@name='income_asset']")).sendKeys("70000");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='income_note']")).click();
            driver.findElement(By.xpath("//input[@name='income_note']")).clear();
            driver.findElement(By.xpath("//input[@name='income_note']")).sendKeys("Test");
            Thread.sleep(500);


            // --- Bank accounts Tab ---
            //To scroll until a Vehicles Tab is visible
            WebElement element5 = driver.findElement(By.xpath("//span[text()='Bank Accounts']"));
            JavascriptExecutor js5 = (JavascriptExecutor) driver;
            js5.executeScript("arguments[0].scrollIntoView(true);", element5);

            driver.findElement(By.xpath("//span[text()='Bank Accounts']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='bank_name']")).click();
            driver.findElement(By.xpath("//input[@name='bank_name']")).clear();
            driver.findElement(By.xpath("//input[@name='bank_name']")).sendKeys("commercial");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='branch']")).click();
            driver.findElement(By.xpath("//input[@name='branch']")).clear();
            driver.findElement(By.xpath("//input[@name='branch']")).sendKeys("Kandy");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='account_number']")).click();
            driver.findElement(By.xpath("//input[@name='account_number']")).clear();
            driver.findElement(By.xpath("//input[@name='account_number']")).sendKeys("4276923");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='account_name']")).click();
            driver.findElement(By.xpath("//input[@name='account_name']")).clear();
            driver.findElement(By.xpath("//input[@name='account_name']")).sendKeys("Savings");
            Thread.sleep(500);

            driver.findElement(By.xpath("//div[@id='mui-component-select-status']")).click();
            driver.findElement(By.xpath("//li[text()='Active']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//div[@id='mui-component-select-expired_month']")).click();
            driver.findElement(By.xpath("//li[text()='03 - March']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='expired_year']")).click();
            driver.findElement(By.xpath("//input[@name='expired_year']")).clear();
            driver.findElement(By.xpath("//input[@name='expired_year']")).sendKeys("2030");
            Thread.sleep(500);


            //Click Create Button
            driver.findElement(By.xpath("//span[text()='Create']")).click();
            Thread.sleep(5000);



            //Search Customer
            WebElement customer = driver.findElement(By.xpath("//input[@name='search']"));
            customer.click();
            customer.sendKeys("BYD");
            Thread.sleep(500);

            driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();

            // Wait for results or page stability
            Thread.sleep(2000);

            // Re-locate the field in case of re-render
            customer = driver.findElement(By.xpath("//input[@name='search']"));

            // Clear properly using keyboard simulation (works for React)
            customer.sendKeys(Keys.CONTROL + "a"); // Select all text
            customer.sendKeys(Keys.DELETE);        // Delete selected text
            Thread.sleep(500);

            // Verify or trigger change event
            customer.sendKeys(Keys.TAB);

            // Now search again
            driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
            Thread.sleep(4000);


        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {

            driver.quit();
        }
    }
}

