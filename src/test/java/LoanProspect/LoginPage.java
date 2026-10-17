package LoanProspect;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

        // Navigate to Prospect page
        WebElement element4 = driver.findElement(By.xpath("(//*[normalize-space(text())='Prospect'])[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element4);
        element4.click();
        driver.findElement(By.xpath("//*[normalize-space(text())='Add Prospect']")).click();

        // Search & click Add Prospect
        driver.findElement(By.name("id")).sendKeys("56");
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
        driver.findElement(By.xpath("//a[contains(@href, '/dashboard/cosm/prospect/add?customer_id=56')]")).click();
    }
}
