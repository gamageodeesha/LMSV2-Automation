package VehicleTransfer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginToSystem() throws Exception {
        driver.get("https://lms-v2-staging.lalco.la/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.name("email")).sendKeys("odeeshag@lalco.la");
        driver.findElement(By.name("password")).sendKeys("Odeesha@2025");
        driver.findElement(By.xpath("//span[text()='Log In']")).click();

        Thread.sleep(2000);

        // Navigate to Valuation and click
        WebElement element4 = driver.findElement(By.xpath("(//*[normalize-space(text())='Valuation'])[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element4);
        element4.click();

        // Click Vehicle Valuation
        WebElement element5 = driver.findElement(By.xpath("(//*[normalize-space(text())='Vehicle Valuation'])[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element5);
        element5.click();

        Thread.sleep(2000);

        //Click Vehicle Transfer
        WebElement element6 = driver.findElement(By.xpath("(//*[normalize-space(text())='Vehicle Transfer'])[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element6);
        element6.click();

        Thread.sleep(2000);




    }
}
