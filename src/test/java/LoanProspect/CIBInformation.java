package LoanProspect;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CIBInformation {
    WebDriver driver;

    public CIBInformation(WebDriver driver) {
        this.driver = driver;
    }

    public void fillCIBDetails() throws Exception {
        WebElement CIBInformation = driver.findElement(By.xpath("//*[normalize-space(text())='CIB Information / ຂໍ້ມູນ CIB']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CIBInformation);
        CIBInformation.click();

        /*//CIB of Customer
        driver.findElement(By.xpath("//div[@id='mui-component-select-customer_id']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//ul[@role='listbox']")
        ));

        driver.findElement(By.xpath("//div[@id='mui-component-select-customer_id']/")).click();

*/
        // Open dropdown
        driver.findElement(By.id("mui-component-select-customer_id")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Wait for dropdown listbox
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//ul[@role='listbox']")
        ));
        // Click Customer option
        WebElement customerOption = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//ul[@role='listbox']//li[contains(.,'Customer')]")
                )
        );
        customerOption.click();

        /*driver.findElement(By.xpath("//div[@id='mui-component-select-has_cib']")).click();
        driver.findElement(By.xpath("//ul[@role='listbox']//li[normalize-space(text())='No']']")).click();
*/
        // Click the dropdown
        driver.findElement(By.id("mui-component-select-has_cib")).click();

        // Explicit wait for the dropdown listbox to appear
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//ul[@role='listbox']")
        ));

        // Wait until "No" option is clickable
        WebElement noOption = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//ul[@role='listbox']//li[@data-value='0']")
                )
        );
        // Click "No"
        noOption.click();

        //Financial Institute
        driver.findElement(By.xpath("//input[@name='financial_institute']")).click();
        driver.findElement(By.xpath("//input[@name='financial_institute']")).sendKeys("Commercial");

        //Contract Date
        driver.findElement(By.xpath("//label[contains(text(),'Contract Date / ວັນທີເຮັດສັນຍາ')]/following::input[1]")).click();
        driver.findElement(By.xpath("//button[@aria-label='calendar view is open, go to text input view']")).click();
        driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']")).click();
        driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']")).sendKeys("2025-12-10");
        driver.findElement(By.xpath("//span[text()='OK']")).click();
        Thread.sleep(500);

        //Due Date
        driver.findElement(By.xpath("//label[contains(text(),'Due Date / ວັນທີ່ຊຳລະ')]/following::input[1]")).click();
        driver.findElement(By.xpath("//button[@aria-label='calendar view is open, go to text input view']")).click();
        driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']")).click();
        driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']")).sendKeys("2025-10-09");
        driver.findElement(By.xpath("//span[text()='OK']")).click();
        Thread.sleep(500);

        //Amount Field
        driver.findElement(By.xpath("//input[@name='amount']")).click();
        driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("5000");

        //Currency Field
        //driver.findElement(By.xpath("//div[@id='mui-component-select-currency']")).click();

       /* // Click the dropdown first
        driver.findElement(By.xpath("(//label[normalize-space()='Currency / ສະກຸນເງິນ']/following::div[@role='button'][1])[2]")).click();

        // Wait for the dropdown listbox to appear
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//ul[@role='listbox']")
        ));

        // Wait until "USD" option is clickable
        WebElement usdOption = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//ul[@role='listbox']//li[@data-value='1']")));
        // Click "USD"
        usdOption.click();*/

        //Remaining amount
        driver.findElement(By.xpath("//input[@name='remaining_amount']")).click();
        driver.findElement(By.xpath("//input[@name='remaining_amount']")).sendKeys("1500");

        //Delay days
        driver.findElement(By.xpath("//input[@name='delay_days']")).click();
        driver.findElement(By.xpath("//input[@name='delay_days']")).sendKeys("24");

        // Click the Rank dropdown first
        driver.findElement(By.id("mui-component-select-ranks")).click();

        // Wait for the dropdown listbox to appear
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait3.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//ul[@role='listbox']")));
        //  Wait until "A" option is clickable
        WebElement optionA = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//ul[@role='listbox']//li[@data-value='A']")));
        // Click "A"
        optionA.click();

        // Click the collateral_type dropdown
        driver.findElement(By.id("mui-component-select-collateral_type")).click();

        // Wait for the dropdown listbox to appear
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait4.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//ul[@role='listbox']")
        ));

        // Wait until "Vehicle / ຍານພາຫະນະ" option is clickable
        WebElement vehicleOption = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//ul[@role='listbox']//li[@data-value='3']")));
        // Click the option
        vehicleOption.click();

        //Other text
        driver.findElement(By.xpath("//div[@id='remarks']//div[contains(@class,'ql-editor')]")).click();
        driver.findElement(By.xpath("//div[@id='remarks']//div[contains(@class,'ql-editor')]")).sendKeys("Testingg");

        //comment the text box for
        





    }
}
