package LoanProspect;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BackCancelButton {
    WebDriver driver;
    WebDriverWait wait;

    public BackCancelButton(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void loginToSystem() throws Exception {
        driver.get("http://3.1.164.148/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.name("email")).sendKeys("odeeshag@lalco.la");
        driver.findElement(By.name("password")).sendKeys("Odeesha@2025");
        driver.findElement(By.xpath("//span[text()='Log In']")).click();

        Thread.sleep(2000);

        // Navigate to Prospect page
        WebElement prospectMenu = driver.findElement(
                By.xpath("(//*[normalize-space(text())='Prospect'])[1]"));
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", prospectMenu);
        prospectMenu.click();

        driver.findElement(
                By.xpath("//*[normalize-space(text())='Add Prospect']")).click();

        // Search customer
        driver.findElement(By.name("id")).sendKeys("56");
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();

        driver.findElement(By.xpath(
                        "//a[contains(@href, '/dashboard/cosm/prospect/add?customer_id=56')]"))
                .click();
    }

}
