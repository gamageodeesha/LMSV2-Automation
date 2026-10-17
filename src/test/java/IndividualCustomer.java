import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IndividualCustomer {
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

            //To scroll until a customers is visible
            WebElement element = driver.findElement(By.xpath("//div[text()='Customers']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);

            driver.findElement(By.xpath("//div[text()='Customers']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//span[contains(@class,'MuiButton-label') and contains(.,'Create Customer')]")).click();
            Thread.sleep(500);

            // --- Detail Tab ---

            driver.findElement(By.xpath("//div[@id='mui-component-select-cust_type']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//li[normalize-space(.)='Individual']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//div[@id='mui-component-select-title']")).click();
            driver.findElement(By.xpath("//li[normalize-space(.)='Ms.']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='first_name']")).click();
            driver.findElement(By.xpath("//input[@name='first_name']")).clear();
            driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Irudini");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='last_name']")).click();
            driver.findElement(By.xpath("//input[@name='last_name']")).clear();
            driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Wijayakoon");
            Thread.sleep(500);

            driver.findElement(By.xpath("//div[@id='mui-component-select-business_type']")).click();
            driver.findElement(By.xpath("//li[normalize-space(.)='Accommodation – Food service - ທີພັກ-ອາຫານການກິນ']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='first_name_local']")).click();
            driver.findElement(By.xpath("//input[@name='first_name_local']")).clear();
            driver.findElement(By.xpath("//input[@name='first_name_local']")).sendKeys("ອິຣູດີນີ");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='last_name_local']")).click();
            driver.findElement(By.xpath("//input[@name='last_name_local']")).clear();
            driver.findElement(By.xpath("//input[@name='last_name_local']")).sendKeys("ວິໄຊຄູນ");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='id_familybook_reg_no']")).click();
            driver.findElement(By.xpath("//input[@name='id_familybook_reg_no']")).clear();
            driver.findElement(By.xpath("//input[@name='id_familybook_reg_no']")).sendKeys("1234567890");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='familybook_issue_date']")).click();
            driver.findElement(By.xpath("//button[@aria-label='Oct 10, 2025']")).click();
            driver.findElement(By.xpath("//span[text()='OK']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='passport_no']")).click();
            driver.findElement(By.xpath("//input[@name='passport_no']")).clear();
            driver.findElement(By.xpath("//input[@name='passport_no']")).sendKeys("0987654321");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='passport_issue_date']")).click();
            driver.findElement(By.xpath("//button[@aria-label='Oct 10, 2025']")).click();
            driver.findElement(By.xpath("//span[text()='OK']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//div[@id='mui-component-select-gender']")).click();
            driver.findElement(By.xpath("//li[text()='Female']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='date_of_birth']")).click();
            driver.findElement(By.xpath("//button[@aria-label='Oct 10, 2025']")).click();
            driver.findElement(By.xpath("//span[text()='OK']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//div[@id='mui-component-select-marital_status']")).click();
            driver.findElement(By.xpath("//li[text()='Single']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='children']")).click();
            driver.findElement(By.xpath("//input[@name='children']")).clear();
            driver.findElement(By.xpath("//input[@name='children']")).sendKeys("0");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='main_phone_no']")).click();
            driver.findElement(By.xpath("//input[@name='main_phone_no']")).clear();
            driver.findElement(By.xpath("//input[@name='main_phone_no']")).sendKeys("02021234567");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='secondary_phone_no']")).click();
            driver.findElement(By.xpath("//input[@name='secondary_phone_no']")).clear();
            driver.findElement(By.xpath("//input[@name='secondary_phone_no']")).sendKeys("0302123456");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='whatsapp_no']")).click();
            driver.findElement(By.xpath("//input[@name='whatsapp_no']")).clear();
            driver.findElement(By.xpath("//input[@name='whatsapp_no']")).sendKeys("02021234567");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='email']")).click();
            driver.findElement(By.xpath("//input[@name='email']")).clear();
            driver.findElement(By.xpath("//input[@name='email']")).sendKeys("irudiniwijayakoon@gmail.com");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='emergency_contact_name']")).click();
            driver.findElement(By.xpath("//input[@name='emergency_contact_name']")).clear();
            driver.findElement(By.xpath("//input[@name='emergency_contact_name']")).sendKeys("Kevin");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='emergency_contact_phone_no']")).click();
            driver.findElement(By.xpath("//input[@name='emergency_contact_phone_no']")).clear();
            driver.findElement(By.xpath("//input[@name='emergency_contact_phone_no']")).sendKeys("02020829292");
            Thread.sleep(500);

            // Province Field
            WebElement provinceInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@aria-autocomplete='list'])[1]")));
            provinceInput.click();
            provinceInput.sendKeys("Attapeu - ອັດຕະປື" + Keys.ENTER);
            Thread.sleep(500);

            // District Field
            WebElement districtInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@aria-autocomplete='list'])[2]")));
            districtInput.click();
            districtInput.sendKeys("Saysetha - ໄຊເຊດຖາ" + Keys.ENTER);
            Thread.sleep(500);

            // Village Field
            WebElement villageInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@aria-autocomplete='list'])[3]")));
            villageInput.click();
            villageInput.sendKeys("B. Dakyieng - " + Keys.ENTER);
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='unit_no']")).click();
            driver.findElement(By.xpath("//input[@name='unit_no']")).clear();
            driver.findElement(By.xpath("//input[@name='unit_no']")).sendKeys("123");
            Thread.sleep(500);

            driver.findElement(By.xpath("//div[@id='mui-component-select-found_source']")).click();
            driver.findElement(By.xpath("//li[text()='Introduction']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='facebook_url']")).click();
            driver.findElement(By.xpath("//input[@name='facebook_url']")).clear();
            driver.findElement(By.xpath("//input[@name='facebook_url']")).sendKeys("https://www.facebook.com");
            Thread.sleep(500);

            driver.findElement(By.xpath("//div[@id='mui-component-select-career_type']")).click();
            driver.findElement(By.xpath("//li[text()='Businessman - ນັກທຸລະກິດ']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("(//input[@name='occupation'])[1]")).click();
            driver.findElement(By.xpath("(//input[@name='occupation'])[1]")).clear();
            driver.findElement(By.xpath("(//input[@name='occupation'])[1]")).sendKeys("Manager");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='work_phone']")).click();
            driver.findElement(By.xpath("//input[@name='work_phone']")).clear();
            driver.findElement(By.xpath("//input[@name='work_phone']")).sendKeys("0302222222");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='work_email']")).click();
            driver.findElement(By.xpath("//input[@name='work_email']")).clear();
            driver.findElement(By.xpath("//input[@name='work_email']")).sendKeys("work@gmail.com");
            Thread.sleep(500);

            driver.findElement(By.xpath("//div[@id='mui-component-select-work_start_year']")).click();
            driver.findElement(By.xpath("//li[@data-value='2025']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='monthly_income']")).click();
            driver.findElement(By.xpath("//input[@name='monthly_income']")).clear();
            driver.findElement(By.xpath("//input[@name='monthly_income']")).sendKeys("5000");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='monthly_expense']")).click();
            driver.findElement(By.xpath("//input[@name='monthly_expense']")).clear();
            driver.findElement(By.xpath("//input[@name='monthly_expense']")).sendKeys("2000");
            Thread.sleep(500);

            // --- Relatives Tab ---

            //To scroll until a Relative Tab is visible
            WebElement element1 = driver.findElement(By.xpath("//span[text()='Relatives']"));
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js1.executeScript("arguments[0].scrollIntoView(true);", element1);

            driver.findElement(By.xpath("//span[text()='Relatives']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='relative_first_name_0']")).click();
            driver.findElement(By.xpath("//input[@name='relative_first_name_0']")).clear();
            driver.findElement(By.xpath("//input[@name='relative_first_name_0']")).sendKeys("Sheron");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='relative_last_name_0']")).click();
            driver.findElement(By.xpath("//input[@name='relative_last_name_0']")).clear();
            driver.findElement(By.xpath("//input[@name='relative_last_name_0']")).sendKeys("Fonseka");
            Thread.sleep(500);

            driver.findElement(By.xpath("(//input[@name='relationship'])[1]")).click();
            driver.findElement(By.xpath("(//input[@name='relationship'])[1]")).clear();
            driver.findElement(By.xpath("(//input[@name='relationship'])[1]")).sendKeys("Cousin");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='phone_no']")).click();
            driver.findElement(By.xpath("//input[@name='phone_no']")).clear();
            driver.findElement(By.xpath("//input[@name='phone_no']")).sendKeys("0302233333");
            Thread.sleep(500);

            /*// Province Field
            WebElement provinceInput1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@aria-autocomplete='list'])[7]")));
            provinceInput1.click();
            provinceInput1.sendKeys("Attapeu - ອັດຕະປື" + Keys.ENTER);
            Thread.sleep(500);*/

            /*// District Field
            WebElement districtInput1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@aria-autocomplete='list'])[8]")));
            districtInput1.click();
            districtInput1.sendKeys("Saysetha - ໄຊເຊດຖາ" + Keys.ENTER);
            Thread.sleep(500);*/

            driver.findElement(By.xpath("//input[@name='address']")).click();
            driver.findElement(By.xpath("//input[@name='address']")).clear();
            driver.findElement(By.xpath("//input[@name='address']")).sendKeys("1/A, Fairy lane, colombo");
            Thread.sleep(500);

            driver.findElement(By.xpath("(//input[@name='occupation'])[2]")).click();
            driver.findElement(By.xpath("(//input[@name='occupation'])[2]")).clear();
            driver.findElement(By.xpath("(//input[@name='occupation'])[2]")).sendKeys("R & D Division");
            Thread.sleep(500);

            driver.findElement(By.xpath("(//input[@name='company_name'])[1]")).click();
            driver.findElement(By.xpath("(//input[@name='company_name'])[1]")).clear();
            driver.findElement(By.xpath("(//input[@name='company_name'])[1]")).sendKeys("IFS");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='position']")).click();
            driver.findElement(By.xpath("//input[@name='position']")).clear();
            driver.findElement(By.xpath("//input[@name='position']")).sendKeys("Director of IT Management");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='income_salary']")).click();
            driver.findElement(By.xpath("//input[@name='income_salary']")).clear();
            driver.findElement(By.xpath("//input[@name='income_salary']")).sendKeys("50000");
            Thread.sleep(500);

            driver.findElement(By.xpath("(//div[contains(@class, 'MuiSelect-root') and .//input[@name='currency']])[1]")).click();
            driver.findElement(By.xpath("//li[text()='USD']")).click();
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



            // --- Letter of credit Tab ---
            //To scroll until a Vehicles Tab is visible
            WebElement element6 = driver.findElement(By.xpath("//span[text()='Letter of Credit']"));
            JavascriptExecutor js6 = (JavascriptExecutor) driver;
            js6.executeScript("arguments[0].scrollIntoView(true);", element6);

            driver.findElement(By.xpath("//span[text()='Letter of Credit']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//div[@id='mui-component-select-lc_type']")).click();
            driver.findElement(By.xpath("//li[text()='Revocable / ສັນຍາທີ່ສາມາດເບີກຖອນໄດ້']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("(//input[@name='company_name'])[2]")).click();
            driver.findElement(By.xpath("(//input[@name='company_name'])[2]")).clear();
            driver.findElement(By.xpath("(//input[@name='company_name'])[2]")).sendKeys("Big Hit Entertainment");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='person_name']")).click();
            driver.findElement(By.xpath("//input[@name='person_name']")).clear();
            driver.findElement(By.xpath("//input[@name='person_name']")).sendKeys("Shim");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='start_date']")).click();
            driver.findElement(By.xpath("//button[@aria-label='Oct 10, 2025']")).click();
            driver.findElement(By.xpath("//span[text()='OK']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='end_date']")).click();
            driver.findElement(By.xpath("//button[@aria-label='Oct 10, 2025']")).click();
            driver.findElement(By.xpath("//span[text()='OK']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='amount']")).click();
            driver.findElement(By.xpath("//input[@name='amount']")).clear();
            driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("40000");
            Thread.sleep(500);

            driver.findElement(By.xpath("//div[@id='mui-component-select-lc_currency']")).click();
            driver.findElement(By.xpath("//li[text()='USD']")).click();
            Thread.sleep(500);



            // --- Non-Security/Receivables Tab ---
            //To scroll until a Vehicles Tab is visible
            WebElement element7 = driver.findElement(By.xpath("//span[text()='Non-Securities / Receivables']"));
            JavascriptExecutor js7 = (JavascriptExecutor) driver;
            js7.executeScript("arguments[0].scrollIntoView(true);", element7);

            driver.findElement(By.xpath("//span[text()='Non-Securities / Receivables']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='receive_from']")).click();
            driver.findElement(By.xpath("//input[@name='receive_from']")).clear();
            driver.findElement(By.xpath("//input[@name='receive_from']")).sendKeys("40000");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='date']")).click();
            driver.findElement(By.xpath("//button[@aria-label='Oct 10, 2025']")).click();
            driver.findElement(By.xpath("//span[text()='OK']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='receivable_amount']")).click();
            driver.findElement(By.xpath("//input[@name='receivable_amount']")).clear();
            driver.findElement(By.xpath("//input[@name='receivable_amount']")).sendKeys("40000");
            Thread.sleep(500);

            driver.findElement(By.xpath("(//div[@id='mui-component-select-currency'])[2]")).click();
            driver.findElement(By.xpath("//li[text()='USD']")).click();
            Thread.sleep(500);


            //Click Create Button
            driver.findElement(By.xpath("//span[text()='Create']")).click();
            Thread.sleep(5000);


            //Search Customer
            WebElement customer = driver.findElement(By.xpath("//input[@name='search']"));
            customer.click();
            customer.sendKeys("Irudini");
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

