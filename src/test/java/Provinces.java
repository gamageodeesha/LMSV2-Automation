import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Provinces {
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
            WebElement element = driver.findElement(By.xpath("(//*[text()='Provinces'])[1]")); // your element
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);


            driver.findElement(By.xpath("(//*[text()='Provinces'])[1]")).click();
            Thread.sleep(5000);


            driver.findElement(By.xpath("//*[text()='Provinces List']")).click();
            Thread.sleep(5000);

            driver.findElement(By.xpath("//span[text()='Create Province']")).click();
            Thread.sleep(5000);

            driver.findElement(By.xpath("//input[@name='province_name']")).click();
            driver.findElement(By.xpath("//input[@name='province_name']")).clear();
            driver.findElement(By.xpath("//input[@name='province_name']")).sendKeys("Attapeu");
            Thread.sleep(5000);

            driver.findElement(By.xpath("//span[text()='Create Province']")).click();
            Thread.sleep(5000);

            //To scroll until a specific element is visible
            element = driver.findElement(By.xpath("//tr[1]//a[@aria-label='Edit']"));
            js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);


            driver.findElement(By.xpath("//tr[1]//a[@aria-label='Edit']")).click();
            Thread.sleep(5000);

            WebElement titleInput = driver.findElement(By.xpath("//input[@name='province_name']"));
            titleInput.click();
            titleInput.sendKeys(Keys.CONTROL + "a");
            titleInput.sendKeys(Keys.DELETE);
            titleInput.sendKeys("Central");
            Thread.sleep(5000);

            driver.findElement(By.xpath("//span[text()='Update Province']")).click();
            Thread.sleep(5000);

            //Search Province
            WebElement province = driver.findElement(By.xpath("//input[@name='province_name']"));
            province.click();
            province.sendKeys("Central");
            Thread.sleep(500);

            driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();

            // Wait for results or page stability
            Thread.sleep(2000);

            // Re-locate the field in case of re-render
            province = driver.findElement(By.xpath("//input[@name='province_name']"));

            // Clear properly using keyboard simulation (works for React)
            province.sendKeys(Keys.CONTROL + "a"); // Select all text
            province.sendKeys(Keys.DELETE);        // Delete selected text
            Thread.sleep(500);

            // Verify or trigger change event
            province.sendKeys(Keys.TAB);

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


