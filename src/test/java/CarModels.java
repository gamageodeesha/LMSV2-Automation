import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CarModels {
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


            wait.until(ExpectedConditions.urlContains("dashboard"));

            //To scroll until a specific element is visible
            WebElement element = driver.findElement(By.xpath("//*[text()='Car Models']")); // your element
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);


            driver.findElement(By.xpath("//*[text()='Car Models']")).click();
            Thread.sleep(5000);


            driver.findElement(By.xpath("//*[text()='Car Models List']")).click();
            Thread.sleep(5000);

            driver.findElement(By.xpath("//span[text()='Create Car Model']")).click();
            Thread.sleep(5000);

            driver.findElement(By.xpath("//select[@name='car_make']")).click();
            driver.findElement(By.xpath("//select[@name='car_make']")).sendKeys("AUDI");
            Thread.sleep(5000);

            driver.findElement(By.xpath("//input[@name='title']")).click(); //Click command
            driver.findElement(By.xpath("//input[@name='title']")).clear(); //Clear command
            driver.findElement(By.xpath("//input[@name='title']")).sendKeys("BYD"); //Type command

            driver.findElement(By.xpath("//input[@name='code']")).click(); //Click command
            driver.findElement(By.xpath("//input[@name='code']")).clear(); //Clear command
            driver.findElement(By.xpath("//input[@name='code']")).sendKeys("8888"); //Type command
            Thread.sleep(4000);

            driver.findElement(By.xpath("//span[text()='Create Car Model']")).click();
            Thread.sleep(5000);

            //To scroll until a specific element is visible
            element = driver.findElement(By.xpath("//tr[1]//a[@aria-label='Edit']"));
            js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);

            driver.findElement(By.xpath("//tr[1]//a[@aria-label='Edit']")).click();
            Thread.sleep(4000);

            String os = System.getProperty("os.name").toLowerCase();
            String selectAllChord = os.contains("mac")
                    ? Keys.chord(Keys.COMMAND, "a")
                    : Keys.chord(Keys.CONTROL, "a");

            // === Update TITLE field ===
            WebElement titleInput = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='title']")));
            titleInput.click();
            titleInput.sendKeys(selectAllChord);
            titleInput.sendKeys(Keys.DELETE);
            titleInput.sendKeys("BMW");
            Thread.sleep(4000);

            // === Update CODE field ===
            WebElement codeInput = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='code']")));
            codeInput.click();
            codeInput.sendKeys(selectAllChord);
            codeInput.sendKeys(Keys.DELETE);
            codeInput.sendKeys("0033");

            driver.findElement(By.xpath("//span[text()='Update Car Model']")).click();
            Thread.sleep(5000);

            //Search Car model
            WebElement carmodel = driver.findElement(By.xpath("//input[@name='title']"));
            carmodel.click();
            carmodel.sendKeys("BYD");
            Thread.sleep(500);

            driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();

            // Wait for results or page stability
            Thread.sleep(2000);

            // Re-locate the field in case of re-render
            carmodel = driver.findElement(By.xpath("//input[@name='title']"));

            // Clear properly using keyboard simulation (works for React)
            carmodel.sendKeys(Keys.CONTROL + "a"); // Select all text
            carmodel.sendKeys(Keys.DELETE);        // Delete selected text
            Thread.sleep(500);

            // Verify or trigger change event
            carmodel.sendKeys(Keys.TAB);

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
