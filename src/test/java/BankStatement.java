import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BankStatement {
    public static void main(String[] args) {
        // Setup WebDriver using WebDriverManager
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        try {
            // Navigate to the login page first
            driver.get("http://3.1.164.148/authentication/login-unguarded");

            // Wait for email field to be visible and enter credentials
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
            emailInput.sendKeys("demo.crm@lalco.la");

            WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
            passwordInput.sendKeys("Password123!");

            // Click the Login button
            driver.findElement(By.xpath("//span[text()='Log In']")).click();

            // Wait for the URL to contain "dashboard" after login
            wait.until(ExpectedConditions.urlContains("dashboard"));

            //To scroll until a specific element is visible
            WebElement element = driver.findElement(By.xpath("//button//div[text()='Bank Statement']/ancestor::button")); // your element
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);

            driver.findElement(By.xpath("//button//div[text()='Bank Statement']/ancestor::button")).click();
            Thread.sleep(4000);

            driver.findElement(By.xpath("//div[text()='Upload Bank Statement']")).click();
            Thread.sleep(4000);

            //Bank Name
            driver.findElement(By.xpath("//select[@name='bank_name']")).click();
            driver.findElement(By.xpath("//option[text()='BCEL']")).click();
            Thread.sleep(1000);

            //Choose Files
            WebElement uploadField = driver.findElement(By.xpath("//input[@type='file']"));
            uploadField.sendKeys("C:\\Users\\Irudini\\Downloads\\Telegram Desktop\\BCELAccStatement_010120101060987003_29-08-2025_29-08-2025.xlsx");
            Thread.sleep(500);

            //Click Upload Bankstatement Button
            driver.findElement(By.xpath("//button[.//span[text()='Upload Bankstatement']]")).click();
            Thread.sleep(5000);

            /*//To scroll until a specific element is visible
            WebElement element1 = driver.findElement(By.xpath("//button//div[text()='Bank Statement']/ancestor::button")); // your element
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js1.executeScript("arguments[0].scrollIntoView(true);", element1);

            driver.findElement(By.xpath("//button//div[text()='Bank Statement']/ancestor::button")).click();
            Thread.sleep(500);*/

            driver.findElement(By.xpath("(//div[text()='Add New'])[1]")).click();
            Thread.sleep(500);

            //Bank Name
            driver.findElement(By.xpath("//select[@name='bank_name']")).click();
            driver.findElement(By.xpath("//option[text()='BCEL']")).click();
            Thread.sleep(500);

            //Bank Account No
            driver.findElement(By.xpath("//input[@name='account_no']")).sendKeys("1002003004005");
            Thread.sleep(500);

            //Reference No
            driver.findElement(By.xpath("//input[@name='reference_no']")).sendKeys("1001");
            Thread.sleep(500);

            //Currency
            driver.findElement(By.xpath("//select[@name='currency']")).click();
            driver.findElement(By.xpath("//option[text()='USD']")).click();
            Thread.sleep(500);

            //Amount
            driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("3000");
            Thread.sleep(500);

            //Description
            driver.findElement(By.xpath("//input[@name='description']")).sendKeys("test");
            Thread.sleep(500);

            //Transfer date
            driver.findElement(By.xpath("//input[@aria-label='Choose date']")).click();
            driver.findElement(By.xpath("//button[@aria-label='calendar view is open, go to text input view']")).click();
            driver.findElement(By.xpath("//input[@placeholder='mm/dd/yyyy']")).sendKeys("10/10/2025");
            driver.findElement(By.xpath("//span[text()='OK']")).click();
            Thread.sleep(500);

            //Create BankStatement
            driver.findElement(By.xpath("//span[text()='Create Bankstatement']")).click();
            Thread.sleep(5000);


        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

