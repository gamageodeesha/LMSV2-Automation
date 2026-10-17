import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CarMakes {
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

            driver.findElement(By.xpath("//*[text()='Car Makes']")).click();
            Thread.sleep(4000);

            driver.findElement(By.xpath("//*[text()='Car Makes List']")).click();
            Thread.sleep(4000);

            driver.findElement(By.xpath("//span[text()='Create Car Make']")).click();
            Thread.sleep(4000);

            driver.findElement(By.xpath("//input[@name='title']")).click(); //Click command
            driver.findElement(By.xpath("//input[@name='title']")).clear(); //Clear command
            driver.findElement(By.xpath("//input[@name='title']")).sendKeys("Benz"); //Type command
            Thread.sleep(500);

            driver.findElement(By.xpath("//input[@name='code']")).click(); //Click command
            driver.findElement(By.xpath("//input[@name='code']")).clear(); //Clear command
            driver.findElement(By.xpath("//input[@name='code']")).sendKeys("123"); //Type command
            Thread.sleep(500);

            driver.findElement(By.xpath("//span[text()='Create Car Make']")).click();
            Thread.sleep(5000);

            //To scroll until a specific element is visible
            WebElement element = driver.findElement(By.xpath("//tr[1]//a[@aria-label='Edit']")); // your element
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);

            driver.findElement(By.xpath("//tr[1]//a[@aria-label='Edit']")).click();
            Thread.sleep(5000);

            WebElement titleInput = driver.findElement(By.xpath("//input[@name='title']"));
            titleInput.click();
            titleInput.sendKeys(Keys.CONTROL + "a");
            titleInput.sendKeys(Keys.DELETE);
            titleInput.sendKeys("BMW");
            Thread.sleep(4000);

            /*driver.findElement(By.xpath("//input[@name='code']")).click();
            driver.findElement(By.xpath("//input[@name='code']")).clear();
            driver.findElement(By.xpath("//input[@name='code']")).sendKeys("000");
            Thread.sleep(5000);     */

            driver.findElement(By.xpath("//span[text()='Update Car Make']")).click();
            Thread.sleep(4000);

            //Search Car make
            WebElement carmake = driver.findElement(By.xpath("//input[@name='search']"));
            carmake.click();
            carmake.sendKeys("BYD");
            Thread.sleep(500);

            driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();

            // Wait for results or page stability
            Thread.sleep(2000);

            // Re-locate the field in case of re-render
            carmake = driver.findElement(By.xpath("//input[@name='search']"));

            // Clear properly using keyboard simulation (works for React)
            carmake.sendKeys(Keys.CONTROL + "a"); // Select all text
            carmake.sendKeys(Keys.DELETE);        // Delete selected text
            Thread.sleep(500);

            // Verify or trigger change event
            carmake.sendKeys(Keys.TAB);

            // Now search again
            driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
            Thread.sleep(4000);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the browser window
            driver.quit();
        }
    }
}
