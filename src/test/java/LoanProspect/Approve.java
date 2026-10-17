package LoanProspect;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Approve {
    WebDriver driver;

    public Approve(WebDriver driver) {
        this.driver = driver;
    }

    public void fillApproveDetails() throws Exception {

        //Submit for Approval
        driver.findElement(By.xpath("//span[normalize-space(text())='Submit for Approval']")).click();

        //Enter Reason
        driver.findElement(By.xpath("//div[contains(@class,'ql-editor') and @data-placeholder='Reason']")).click();
        driver.findElement(By.xpath("//div[contains(@class,'ql-editor') and @data-placeholder='Reason']")).sendKeys("Approve test 1");
        driver.findElement(By.xpath("//button[.//span[normalize-space()='Yes']]")).click();

        /* ---------- Click Edit button if we are in prospect list page ---------- */
        /*Thread.sleep(2000);
        //Click the Edit button to navigate from the Prospect List page to the Edit Prospect page.
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement editButton = wait5.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@aria-label='Edit'])[1]")));
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", editButton);
        // Click using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", editButton);*/


        Thread.sleep(3000);
        //Submit for Credit Manager Approval & click
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space(text())='Submit for Credit Manager Approval']")));
        ((JavascriptExecutor) driver).executeScript( "arguments[0].scrollIntoView({block: 'center'});", submitBtn);
        submitBtn.click();

        Thread.sleep(2000);

        //Submit for Continue button & click
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement continueBtn = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Continue']")));
        ((JavascriptExecutor) driver).executeScript( "arguments[0].scrollIntoView({block: 'center'});", continueBtn);
        continueBtn.click();

        //Click yes button
        driver.findElement(By.xpath("//span[normalize-space()='Yes']")).click();


        /* ---------- Click Edit button if we are in the prospect list page ---------- */
        //Again navigate to the edit page for final approval
        /*Thread.sleep(2000);
        WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement editButton6 = wait6.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@aria-label='Edit'])[1]")));
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", editButton6);
        // Click using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", editButton6);*/

        Thread.sleep(3000);
        //Scroll to Approve button & click
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement ApproveBtn = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space(text())='Approved']")));
        ((JavascriptExecutor) driver).executeScript( "arguments[0].scrollIntoView({block: 'center'});", ApproveBtn);
        ApproveBtn.click();

        Thread.sleep(2000);
        //Submit for Continue button & click
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement continueBtn2 = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Continue']")));
        ((JavascriptExecutor) driver).executeScript( "arguments[0].scrollIntoView({block: 'center'});", continueBtn2);
        continueBtn2.click();

        //Click yes button
        driver.findElement(By.xpath("//span[normalize-space()='Yes']")).click();

        Thread.sleep(5000);
    }
}