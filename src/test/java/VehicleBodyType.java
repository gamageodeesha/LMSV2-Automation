import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VehicleBodyType {
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

            driver.findElement(By.xpath("//div[text()='Vehicle Body Type']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//span[text()='Create Vehicle Body Type']")).click();
            Thread.sleep(5000);

            driver.findElement(By.xpath("//input[@name='type']")).click();
            driver.findElement(By.xpath("//input[@name='type']")).clear();
            driver.findElement(By.xpath("//input[@name='type']")).sendKeys("Hatchback");
            Thread.sleep(3000);

            driver.findElement(By.xpath("//input[@name='description']")).click();
            driver.findElement(By.xpath("//input[@name='description']")).clear();
            driver.findElement(By.xpath("//input[@name='description']")).sendKeys("Passenger cars with a rear door that swings upward to provide access to a cargo area, typically sharing the passenger compartment. They are generally compact and practical for city driving.");
            Thread.sleep(3000);

            driver.findElement(By.xpath("//span[text()='Create Vehicle Body Type']")).click();
            Thread.sleep(5000);


        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {

            driver.quit();
        }
    }
}
