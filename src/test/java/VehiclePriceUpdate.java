import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VehiclePriceUpdate {
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

            driver.findElement(By.xpath("//div[text()='Vehicle Price Update']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//span[text()='Vehicle Price Update New']")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("//input[@name='buying_price']")).click();
            driver.findElement(By.xpath("//input[@name='buying_price']")).clear();
            driver.findElement(By.xpath("//input[@name='buying_price']")).sendKeys("100000");
            Thread.sleep(3000);

            driver.findElement(By.xpath("//input[@name='selling_price']")).click();
            driver.findElement(By.xpath("//input[@name='selling_price']")).clear();
            driver.findElement(By.xpath("//input[@name='selling_price']")).sendKeys("200000");
            Thread.sleep(3000);

            driver.findElement(By.xpath("(//input[@aria-label='Choose date'])[1]")).click();
            driver.findElement(By.xpath("//button[text()='2024']")).click();
            driver.findElement(By.xpath("//span[text()='OK']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("(//input[@type='text' and @readonly])[2]")).click();
            driver.findElement(By.xpath("//button[@aria-label='Oct 10, 2025']")).click();
            driver.findElement(By.xpath("//span[text()='OK']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("//select[@name='vehicle']")).click();
            driver.findElement(By.xpath("//select[@name='vehicle']/option[text()='TOYOTA - Vitz'][1]")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("//select[@name='vehicle_dealer_shop']")).click();
            driver.findElement(By.xpath("//select[@name='vehicle_dealer_shop']/option[text()='KHR MOTERS - 12']")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("//span[text()='Create Vehicle Price']")).click();
            Thread.sleep(5000);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {

            driver.quit();
        }
    }
}

