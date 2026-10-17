import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VehicleValuation {
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

            //To scroll until Valuation is visible
            WebElement element = driver.findElement(By.xpath("(//*[text()='Valuation'])[1]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500);

            // NAVIGATE TO VEHICLE VALUATION
            driver.findElement(By.xpath("(//*[text()='Valuation'])[1]")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//div[text()='Vehicle Valuation']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("(//div[text()='Valuation'])[2]")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("(//*[text()='Add New'])[2]")).click();
            Thread.sleep(1000);

            //To scroll until Valuation is visible
            WebElement element1 = driver.findElement(By.xpath("(//span[@titleaccess='Add vehicle valuation'])[1]"));
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js1.executeScript("arguments[0].scrollIntoView(true);", element1);
            Thread.sleep(2000);

            driver.findElement(By.xpath("(//span[@titleaccess='Add vehicle valuation'])[1]")).click();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//select[@name='salesperson_id']")).click();
            driver.findElement(By.xpath("//select[@name='salesperson_id']")).sendKeys("Siliphone   Ketmany ( Bee - 26 )");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//select[@name='condition']")).click();
            driver.findElement(By.xpath("//select[@name='condition']")).sendKeys("New");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@name='vin_code']")).click();
            driver.findElement(By.xpath("//input[@name='vin_code']")).clear();
            driver.findElement(By.xpath("//input[@name='vin_code']")).sendKeys("123");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@name='engine_no']")).click();
            driver.findElement(By.xpath("//input[@name='engine_no']")).clear();
            driver.findElement(By.xpath("//input[@name='engine_no']")).sendKeys("A555");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@name='owner_first_name_en']")).click();
            driver.findElement(By.xpath("//input[@name='owner_first_name_en']")).clear();
            driver.findElement(By.xpath("//input[@name='owner_first_name_en']")).sendKeys("Irudini");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@name='owner_last_name_en']")).click();
            driver.findElement(By.xpath("//input[@name='owner_last_name_en']")).clear();
            driver.findElement(By.xpath("//input[@name='owner_last_name_en']")).sendKeys("Wijayakoon");
            Thread.sleep(1000);

            WebElement vehicleInput = driver.findElement(By.xpath("//input[@id='vehicle']"));
            vehicleInput.click();
            vehicleInput.sendKeys("HONDA CRV DDFS");
            // Wait for dropdown to appear
            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement dropdownOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(., 'HONDA CRV DDFS')]") )); // This matches the dropdown text
            dropdownOption.click(); // Click the matching dropdown option
            Thread.sleep(1000);

            driver.findElement(By.xpath("//select[@name='year']")).click();
            driver.findElement(By.xpath("//select[@name='year']")).sendKeys("2020");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@name='grade']")).click();
            driver.findElement(By.xpath("//input[@name='grade']")).clear();
            driver.findElement(By.xpath("//input[@name='grade']")).sendKeys("A");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//select[@name='transmission']")).click();
            driver.findElement(By.xpath("//select[@name='transmission']")).sendKeys("Automatic");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@name='displacement']")).click();
            driver.findElement(By.xpath("//input[@name='displacement']")).clear();
            driver.findElement(By.xpath("//input[@name='displacement']")).sendKeys("2,000CC to 3,000CC");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@name='mileage']")).click();
            driver.findElement(By.xpath("//input[@name='mileage']")).clear();
            driver.findElement(By.xpath("//input[@name='mileage']")).sendKeys("500KM");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//select[@name='drive']")).click();
            driver.findElement(By.xpath("//select[@name='drive']")).sendKeys("2WD");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//select[@name='color']")).click();
            driver.findElement(By.xpath("//select[@name='color']")).sendKeys("Purple");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//select[@name='fuel']")).click();
            driver.findElement(By.xpath("//select[@name='fuel']")).sendKeys("Gasoline");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@name='number_plate_letters']")).click();
            driver.findElement(By.xpath("//input[@name='number_plate_letters']")).clear();
            driver.findElement(By.xpath("//input[@name='number_plate_letters']")).sendKeys("AAA");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@name='number_plate_numbers']")).click();
            driver.findElement(By.xpath("//input[@name='number_plate_numbers']")).clear();
            driver.findElement(By.xpath("//input[@name='number_plate_numbers']")).sendKeys("2020");
            Thread.sleep(1000);

            wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement provinceInput = driver.findElement(By.xpath("//input[@id='number_plate_province']"));
            provinceInput.click();
            provinceInput.sendKeys("Attapeu");
            // Wait for dropdown option to appear and select it
            dropdownOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(., 'Attapeu')]")));
            dropdownOption.click();  // This selects it and closes the dropdown
            Thread.sleep(2000);

            driver.findElement(By.xpath("//input[@name='register_date']")).click();
            driver.findElement(By.xpath("//button[@aria-label='Oct 1, 2025']")).click();
            driver.findElement(By.xpath("//span[text()='OK']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='expired_date']")).click();
            driver.findElement(By.xpath("//button[@aria-label='Oct 30, 2025']")).click();
            driver.findElement(By.xpath("//span[text()='OK']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='instalment_num']")).click();
            driver.findElement(By.xpath("//input[@name='instalment_num']")).clear();
            driver.findElement(By.xpath("//input[@name='instalment_num']")).sendKeys("6");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//select[@name='instalment_type']")).click();
            driver.findElement(By.xpath("//select[@name='instalment_type']")).sendKeys("Normal");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@name='owner_phone_number']")).click();
            driver.findElement(By.xpath("//input[@name='owner_phone_number']")).clear();
            driver.findElement(By.xpath("//input[@name='owner_phone_number']")).sendKeys("02021234567");
            Thread.sleep(500);

            driver.findElement(By.xpath("//div[@class='ql-editor ql-blank' and @contenteditable='true']")).click();
            driver.findElement(By.xpath("//div[@class='ql-editor ql-blank' and @contenteditable='true']")).clear();
            driver.findElement(By.xpath("//div[@class='ql-editor ql-blank' and @contenteditable='true']")).sendKeys("TEST");
            Thread.sleep(500);

            driver.findElement(By.xpath("//span[text()='Submit for Assessment']")).click();
            Thread.sleep(5000);

            //To scroll
            WebElement element2 = driver.findElement(By.xpath("(//a[descendant::*[local-name() = 'svg' and @data-testid='PencilAltIcon']])[last()]"));
            JavascriptExecutor js2 = (JavascriptExecutor) driver;
            js2.executeScript("arguments[0].scrollIntoView(true);", element2);
            Thread.sleep(3000);

            // wait is your existing WebDriverWait
            By pencilAnchors = By.xpath("(//a[descendant::*[local-name() = 'svg' and @data-testid='PencilAltIcon']])[last()]");
            WebElement newestEdit = wait.until(ExpectedConditions.elementToBeClickable(pencilAnchors));
            newestEdit.click();
            Thread.sleep(3000);

            //To scroll
            WebElement element3 = driver.findElement(By.xpath("//input[@name='otc_ltv']"));
            JavascriptExecutor js3 = (JavascriptExecutor) driver;
            js3.executeScript("arguments[0].scrollIntoView(true);", element3);
            Thread.sleep(3000);

            driver.findElement(By.xpath("//input[@name='otc_ltv']")).click();
            driver.findElement(By.xpath("//input[@name='otc_ltv']")).clear();
            driver.findElement(By.xpath("//input[@name='otc_ltv']")).sendKeys("10");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='loan_to_value']")).click();
            driver.findElement(By.xpath("//input[@name='loan_to_value']")).clear();
            driver.findElement(By.xpath("//input[@name='loan_to_value']")).sendKeys("50");
            Thread.sleep(500);

            driver.findElement(By.xpath("//span[text()='Complete Assessment']")).click();
            driver.findElement(By.xpath("//span[text()='Yes']")).click();
            Thread.sleep(5000);

            //Search Vin Code
            WebElement vincode = driver.findElement(By.xpath("//input[@name='vin_code']"));
            vincode.click();
            vincode.sendKeys("123");

            driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();

            // Wait for results or page stability
            Thread.sleep(2000);

            // Re-locate the field in case of re-render
            vincode = driver.findElement(By.xpath("//input[@name='vin_code']"));

            // Clear properly using keyboard simulation (works for React)
            vincode.sendKeys(Keys.CONTROL + "a"); // Select all text
            vincode.sendKeys(Keys.DELETE);        // Delete selected text

            // Optional: small wait
            Thread.sleep(500);

            // Verify or trigger change event
            vincode.sendKeys(Keys.TAB);

            // Now search again
            driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();


        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {

            driver.quit();
        }
    }
}

