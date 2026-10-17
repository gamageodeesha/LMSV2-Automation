import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Vehicles {
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

            driver.findElement(By.xpath("//div[text()='Vehicles']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("(//*[text()='Add New'])[3]")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("//div[@id='mui-component-select-maker_id']")).click();
            driver.findElement(By.xpath("//li[text()='TOYOTA']")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("//div[@id='mui-component-select-model_id']")).click();
            driver.findElement(By.xpath("//li[text()='BYD']")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("//div[@id='mui-component-select-country_id']")).click();
            driver.findElement(By.xpath("//li[text()='Australia']")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("//div[@id='mui-component-select-body_type']")).click();
            driver.findElement(By.xpath("//li[text()='Sport']")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("//span[text()='Create Vehicle']")).click();
            Thread.sleep(5000);


        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {

            driver.quit();
        }
    }
}

