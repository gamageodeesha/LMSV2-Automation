//package com.realestate.tests;
package EstateValuation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginAndNavigate {

    public static WebDriver loginAndNavigateToAddPage() throws Exception {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://lms-v2-staging.lalco.la/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Login
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("demo.crm@lalco.la");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password123!");
        driver.findElement(By.xpath("//span[text()='Log In']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement element1 = driver.findElement(By.xpath("(//*[normalize-space(text())='Valuation'])[1]"));
        JavascriptExecutor js1 = (JavascriptExecutor) driver; js1.executeScript("arguments[0].scrollIntoView(true);", element1);

        Thread.sleep(4000);
        // Navigate to Valuation
        WebElement valuationBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//*[normalize-space(text())='Valuation'])[1]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", valuationBtn);

        // Real Estate → Add New
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[normalize-space(text())='Real Estate Valuation']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@href='/dashboard/real-estate-valuation/search-customer-real-estate']//div[normalize-space(text())='Add New']"))).click();

        // Search customer
        WebElement idField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='id']")));
        idField.clear();
        idField.sendKeys("189");
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();

        // Click create link
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//a[contains(@href, '/dashboard/real-estate-valuation/create')])[1]"))).click();

        return driver;
    }
}
