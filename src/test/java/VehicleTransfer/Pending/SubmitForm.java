package VehicleTransfer.Pending;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;

public class SubmitForm {

    WebDriver driver;

    public SubmitForm(WebDriver driver) {
        this.driver = driver;
    }

    public void fillPendingPage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Click Pending menu
            WebElement pendingPage = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("(//*[normalize-space(text())='Pending'])[1]")
                    )
            );

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pendingPage);
            pendingPage.click();

            // Wait until Submit button is visible (means page loaded)
            // Wait until Submit button is visible (page loaded confirmation)
            WebElement submitButton = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("(//button[.//span[text()='Submit']])[1]")
                    )
            );

            System.out.println("Pending page loaded successfully.");
            // Click Submit button after page load
            submitButton.click();

            System.out.println("Submit button clicked successfully.");

        } catch (TimeoutException e) {
            System.err.println("Pending page is not loading");
            throw new RuntimeException("Pending page is not loading");
        } catch (Exception e) {
            System.err.println("Unexpected error while loading Pending page: " + e.getMessage());
        }
    }

    //Verify validation messages for Date & Deadline
    public void verifyDateAndDeadlineValidationMessages() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click Update button
        driver.findElement(By.xpath("(//button[.//span[text()='Update / ຢືນຢັນ']])[1]")).click();

        // Wait for Date validation message
        WebElement dateError = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(text(),'Submit Date is required')]")
                )
        );

        // Wait for Deadline validation message
        WebElement deadlineError = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(text(),'Deadline is required')]")
                )
        );

        // Assertions
        Assert.assertTrue(dateError.isDisplayed(), "Submit Date validation message is NOT displayed");
        Assert.assertTrue(deadlineError.isDisplayed(), "Deadline validation message is NOT displayed");

        System.out.println("Validation messages displayed successfully.");
    }

    // Method to fill Submit Date, Deadline, Remarks and click Update
    public void fillFieldsAndUpdate() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {

            // Fill Submit Date
            WebElement submitDateField = driver.findElement(By.xpath("//input[@name='submit_date']"));
            submitDateField.click();
            driver.findElement(By.xpath("//button[@aria-label='calendar view is open, go to text input view']")).click();
            driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']")).click();
            driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']")).clear();
            driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']")).sendKeys("2026-02-23");
            driver.findElement(By.xpath("//span[text()='OK']")).click();

            // Fill Deadline Date
            WebElement deadlineField = driver.findElement(By.xpath("//input[@name='deadline']"));
            deadlineField.click();
            driver.findElement(By.xpath("//button[@aria-label='calendar view is open, go to text input view']")).click();
            driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']")).click();
            driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']")).clear();
            driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']")).sendKeys("2026-03-23");
            driver.findElement(By.xpath("//span[text()='OK']")).click();

            // Fill Remarks
            driver.findElement(By.xpath("//input[@name='remarks']")).click();
            driver.findElement(By.xpath("//input[@name='remarks']")).sendKeys("Testing");

            // Click Update button
            WebElement updateBtn = driver.findElement(By.xpath("(//button[.//span[text()='Update / ຢືນຢັນ']])[1]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", updateBtn);
            updateBtn.click();

            // Wait for either success or error message
            WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(@class,'toast') or contains(@class,'notification') or contains(text(),'success') or contains(text(),'error')]")
            ));

            String msgText = message.getText();
            if (msgText.toLowerCase().contains("success")) {
                System.out.println("Update successful: " + msgText);
            } else if (msgText.toLowerCase().contains("error")) {
                System.err.println("Update failed: " + msgText);
            } else {
                System.out.println("Update result: " + msgText);
            }

        } catch (Exception e) {
            System.err.println("Error while filling fields and updating: " + e.getMessage());
        }
    }

    // Method to handle Close / Cancel button
    public void clickCloseButtonAndVerify() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {

            //open the popup
            WebElement submitbtn = driver.findElement(By.xpath("(//button[.//span[text()='Submit']])[1]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitbtn);
            submitbtn.click();

            Thread.sleep(2000);

            // Click Close / Cancel button
            WebElement closeBtn = driver.findElement(By.xpath("(//button[.//span[text()='Close / ປິດ']])[1]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", closeBtn);
            closeBtn.click();

            Thread.sleep(2000);

            // Optional: wait until popup is closed
            // Assuming popup has a known locator, e.g., a container with class 'popup-container'
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'popup-container')]")));

            System.out.println("Submit Popup closed successfully.");
        } catch (Exception e) {
            System.err.println("Error while closing popup: " + e.getMessage());
        }
    }
}