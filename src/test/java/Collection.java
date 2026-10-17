import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class Collection {
    public static void main(String[] args) {
        // Setup WebDriver using WebDriverManager
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        try {
            // 1. Navigate to the login page
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

            // Navigate to Collection
            //To scroll until a specific element is visible
            WebElement element = driver.findElement(By.xpath("//button//div[text()='Collection']/ancestor::button"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(2000);

            driver.findElement(By.xpath("//button//div[text()='Collection']/ancestor::button")).click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("//div[text()='Add Collection']")).click();
            Thread.sleep(5000);

            // Search & click Add collection
            driver.findElement(By.name("contract_no")).sendKeys("247");
            driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
            driver.findElement(By.xpath("//a[@href='/dashboard/cosm/collection/add?contract_id=115']")).click();
            Thread.sleep(5000);

            driver.findElement(By.xpath("//select[@name='collection_method']")).click();
            driver.findElement(By.xpath("//select[@name='collection_method']")).sendKeys("Cash"+ Keys.ENTER);
            /*driver.findElement(By.xpath("//select[option[text()='Cash']]")).click();*/
            Thread.sleep(1000);

            driver.findElement(By.xpath("//select[@name='branch']")).click();
            driver.findElement(By.xpath("//select[@name='branch']")).sendKeys("100 - Head Office"+ Keys.ENTER);
            /*driver.findElement(By.xpath("//select[@name='branch' and ./option[contains(text(), 'Head Office')]]")).click();*/
            Thread.sleep(1000);

            driver.findElement(By.xpath("//select[@name='collection_place']")).click();
            driver.findElement(By.xpath("//select[@name='collection_place']")).sendKeys("Office"+ Keys.ENTER);
            /* driver.findElement(By.xpath("//select[option[text()='Office'] and option[text()='Onsite']]")).click();*/
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@name='usd_amount']")).click();
            driver.findElement(By.xpath("//input[@name='usd_amount']")).clear();
            driver.findElement(By.xpath("//input[@name='usd_amount']")).sendKeys("2500");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//select[@name='pay_for']")).click();
            driver.findElement(By.xpath("//select[@name='pay_for']")).sendKeys("Others"+ Keys.ENTER);
            /*driver.findElement(By.xpath("//select[option[text()='Others']]")).click();*/
            Thread.sleep(1000);

            driver.findElement(By.xpath("//input[@name='pay_for_comment']")).click();
            driver.findElement(By.xpath("//input[@name='pay_for_comment']")).clear();
            driver.findElement(By.xpath("//input[@name='pay_for_comment']")).sendKeys(".");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//button[.//span[text()='Submit']]")).click();
            Thread.sleep(1000);


        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    private static void click() {
    }
}