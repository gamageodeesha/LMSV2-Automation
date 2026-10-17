import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VoidRequest {
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
            WebElement element = driver.findElement(By.xpath("//div[text()='Void Requests']")); // your element
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);

            driver.findElement(By.xpath("//div[text()='Void Requests']")).click();
            Thread.sleep(4000);

            driver.findElement(By.xpath("//span[text()='New Void Request']")).click();
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@name='contract_no']")).click();
            driver.findElement(By.xpath("//input[@name='contract_no']")).sendKeys("173");
            Thread.sleep(500);

            driver.findElement(By.xpath("//span[text()='Search']")).click();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//input[@type='checkbox' and @name='selected_0']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='amount_usd']")).click();
            driver.findElement(By.xpath("//input[@name='amount_usd']")).sendKeys("580");
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='reason']")).click();
            driver.findElement(By.xpath("//input[@name='reason']")).sendKeys("TEST");
            Thread.sleep(1000);

            //Choose Files
            WebElement uploadField = driver.findElement(By.xpath("//input[@type='file']"));
            uploadField.sendKeys("C:\\Users\\Irudini\\Pictures\\1LALCO.jpg");
            Thread.sleep(2000);

            driver.findElement(By.xpath("//span[text()='Submit']")).click();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//span[text()='Yes']")).click();
            Thread.sleep(3000);


        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

