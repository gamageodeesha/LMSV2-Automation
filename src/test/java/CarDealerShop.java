import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CarDealerShop {
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

            driver.findElement(By.xpath("//div[text()='Car Dealer Shop']")).click();
            Thread.sleep(500);

            driver.findElement(By.xpath("(//*[text()='Add New'])[4]")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("//input[@name='shop_name']")).click();
            driver.findElement(By.xpath("//input[@name='shop_name']")).clear();
            driver.findElement(By.xpath("//input[@name='shop_name']")).sendKeys("Company 1");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@name='shop_phone_no']")).click();
            driver.findElement(By.xpath("//input[@name='shop_phone_no']")).clear();
            driver.findElement(By.xpath("//input[@name='shop_phone_no']")).sendKeys("02020829292");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@name='shop_address']")).click();
            driver.findElement(By.xpath("//input[@name='shop_address']")).clear();
            driver.findElement(By.xpath("//input[@name='shop_address']")).sendKeys("1/A, Primrose Road, Kandy");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@name='shop_email']")).click();
            driver.findElement(By.xpath("//input[@name='shop_email']")).clear();
            driver.findElement(By.xpath("//input[@name='shop_email']")).sendKeys("company1@gmail.com");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@name='bank_name']")).click();
            driver.findElement(By.xpath("//input[@name='bank_name']")).clear();
            driver.findElement(By.xpath("//input[@name='bank_name']")).sendKeys("Bank1");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@name='bank_branch']")).click();
            driver.findElement(By.xpath("//input[@name='bank_branch']")).clear();
            driver.findElement(By.xpath("//input[@name='bank_branch']")).sendKeys("Branch1");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@name='bank_account_no']")).click();
            driver.findElement(By.xpath("//input[@name='bank_account_no']")).clear();
            driver.findElement(By.xpath("//input[@name='bank_account_no']")).sendKeys("1234567890");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@name='bank_account_name']")).click();
            driver.findElement(By.xpath("//input[@name='bank_account_name']")).clear();
            driver.findElement(By.xpath("//input[@name='bank_account_name']")).sendKeys("Account1");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//span[text()='Add Contact Person']")).click();
            Thread.sleep(5000);

            driver.findElement(By.xpath("//input[@name='contacts.0.firstname']")).click();
            driver.findElement(By.xpath("//input[@name='contacts.0.firstname']")).clear();
            driver.findElement(By.xpath("//input[@name='contacts.0.firstname']")).sendKeys("Irudini");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@name='contacts.0.lastname']")).click();
            driver.findElement(By.xpath("//input[@name='contacts.0.lastname']")).clear();
            driver.findElement(By.xpath("//input[@name='contacts.0.lastname']")).sendKeys("Wijayakoon");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@name='contacts.0.phone']")).click();
            driver.findElement(By.xpath("//input[@name='contacts.0.phone']")).clear();
            driver.findElement(By.xpath("//input[@name='contacts.0.phone']")).sendKeys("02020222222");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@name='contacts.0.designation']")).click();
            driver.findElement(By.xpath("//input[@name='contacts.0.designation']")).clear();
            driver.findElement(By.xpath("//input[@name='contacts.0.designation']")).sendKeys("Manager");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//span[text()='Create Vehicle Dealer Shop']")).click();
            Thread.sleep(5000);


        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {

            driver.quit();
        }
    }
}
