package LoanProspect;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoanTab {
    WebDriver driver;

    public LoanTab(WebDriver driver) {
        this.driver = driver;
    }

    public void fillLoanDetails() throws Exception {
        WebElement loanTab = driver.findElement(By.xpath("//*[normalize-space(text())='Loan / ການກູ້ຢືມ']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loanTab);
        loanTab.click();

        //Payment Schedule
        driver.findElement(By.xpath("//select[@name='payment_schedule_type']")).click();
        driver.findElement(By.xpath("//select[@name='payment_schedule_type']/option[@value='1']")).click();

        //Payment Upfront
        driver.findElement(By.xpath("//select[@name='is_upfront']")).click();
        driver.findElement(By.xpath("//select[@name='is_upfront']/option[@value='0']")).click();

        //Trading Currency
        driver.findElement(By.xpath("//select[@name='trading_currency']")).click();
        driver.findElement(By.xpath("//select[@name='trading_currency']/option[@value='1']")).click();

        //First Payment Date
        /*driver.findElement(By.xpath("//label[contains(text(),'First Payment Date')]/following::input[1]")).click();
        driver.findElement(By.xpath("//label[contains(text(),'First Payment Date')]/following::input[1]")).sendKeys("2025-11-05");
*/
        driver.findElement(By.xpath("//label[contains(text(),'First Payment Date')]/following::input[1]")).click();
        driver.findElement(By.xpath("//button[@aria-label='calendar view is open, go to text input view']")).click();
        driver.findElement(By.xpath("//button[@aria-label='calendar view is open, go to text input view']")).click();
        driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='yyyy-mm-dd']")).sendKeys("10/10/2025");
        driver.findElement(By.xpath("//span[text()='OK']")).click();
        Thread.sleep(500);

        //Number of Payment
        driver.findElement(By.xpath("//input[@name='no_of_payment']")).click();
        driver.findElement(By.xpath("//input[@name='no_of_payment']")).clear();
        driver.findElement(By.xpath("//input[@name='no_of_payment']")).sendKeys("16");

        //Loan Amount
        driver.findElement(By.xpath("//input[@name='loan_amount']")).click();
        driver.findElement(By.xpath("//input[@name='loan_amount']")).clear();
        driver.findElement(By.xpath("//input[@name='loan_amount']")).sendKeys("68700");

        //Approval Fee Amount
        driver.findElement(By.xpath("//input[@name='fee']")).click();
        driver.findElement(By.xpath("//input[@name='fee']")).clear();
        driver.findElement(By.xpath("//input[@name='fee']")).sendKeys("500");

        //Interest
        driver.findElement(By.xpath("//input[@name='interest_rate']")).click();
        driver.findElement(By.xpath("//input[@name='interest_rate']")).clear();
        driver.findElement(By.xpath("//input[@name='interest_rate']")).sendKeys("9");

        //Early Repayment
        driver.findElement(By.xpath("//select[@name='early_repayment']")).click();
        driver.findElement(By.xpath("//select[@name='early_repayment']/option[@value='0']")).click();

        Thread.sleep(3000);
        // You can add more loan-tab related steps here later
    }
}
