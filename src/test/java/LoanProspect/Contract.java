package LoanProspect;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Contract {
    WebDriver driver;

    public Contract(WebDriver driver) {
        this.driver = driver;
    }

    public void fileContractDetails() throws Exception {

        //Select Withdrawal method
        driver.findElement(By.xpath("//div[@id='mui-component-select-withdrawal_method']")).click();
        driver.findElement(By.xpath("//li[text()='Cash']")).click();

        // 1. Locate the Amount element from the table (e.g., "USD 10.00")
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement amountElement = wait2.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//td[contains(text(), 'USD')]")
        ));
        String rawAmount = amountElement.getText();
        System.out.println("Raw text found: " + rawAmount);

        // 2. Extract only the numeric part (removes "USD" and spaces)
        String numericValue = rawAmount.replaceAll("[^0-9.]", "");
        System.out.println("Cleaned numeric value: " + numericValue);

        // 3. Locate the Loan input field
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement loanField = wait1.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@name='withdrawal_amount']")));

        // 4. Enter the value into the field
        loanField.clear();
        // Sometimes clear() doesn't work on MUI fields, so we use keys to select all and delete
        loanField.sendKeys(Keys.CONTROL + "a");
        loanField.sendKeys(Keys.BACK_SPACE);
        loanField.sendKeys(numericValue);

        System.out.println("Successfully transferred value to Loan field.");
           /* } catch (Exception e) {
                System.err.println("Failed to sync Amount to Loan field: " + e.getMessage());
            }*/

        //Request for Contract Check
        driver.findElement(By.xpath("//span[normalize-space()='Request for Contract Check']")).click();
        Thread.sleep(4000);

        driver.findElement(By.xpath("//div[@data-placeholder='Reason']")).sendKeys(".");
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[text()='Yes']")).click();
        Thread.sleep(5000);

        //Again navigate to the edit page for final approval
        Thread.sleep(2000);
        /*WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement editButton6 = wait6.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[name()='svg' and @data-testid='PencilAltIcon'])[1]")));
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", editButton6);
        // Click using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", editButton6);*/

        /* Check LIST.......*/

        //Click Edit button and navigate to the contract to Verify the check List
        WebElement editBtn = driver.findElement(By.xpath("(//span[contains(@class,'MuiIconButton-label')])[6]"));
        editBtn.click();

        //Click Contract Check box
        driver.findElement(By.xpath("//input[@name='contract_check' and @type='checkbox']")).click();
        //Click Spare Key
        driver.findElement(By.xpath("//input[@name='spare_key_check' and @type='checkbox']")).click();
        //Click assessment letter check
        driver.findElement(By.xpath("//input[@name='assessment_letter_check' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@name='picture_collateral_automobile_check' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@name='car_engine_no_check' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@name='car_vincode_check' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@name='yellow_book_check' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@name='purchasement_certificate_check' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@name='customer_family_book_check' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@name='guarantor_family_book_check' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@name='customer_id_check' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@name='guarantor_id_check' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@name='customer_resident_cert_check' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@name='guarantor_resident_cert_check' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@name='customer_questionnaire_form_check' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@name='guarantor_questionnaire_form_check' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@name='village_head_confirmation_customer_check' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@name='village_head_confirmation_guarantor_check' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@name='customer_house_map_check' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@name='customer_finger_stamp_check' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@name='guarantor_finger_stamp_check' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@name='customer_income_statement_check' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@name='guarantor_income_statement_check' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@name='borrower_title_deed_check' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@name='ownership_certificate_of_realty_check' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@name='home_shop_picture_check' and @type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@name='bank_passbook_check' and @type='checkbox']")).click();

        //Click Approve button
        driver.findElement(By.xpath("//span[normalize-space()='Approved']")).click();
        Thread.sleep(4000);

        //Add reason and click yes to procees
        driver.findElement(By.xpath("//div[@data-placeholder='Reason']")).sendKeys("testingg...");
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[text()='Yes']")).click();
        Thread.sleep(5000);

        /* Next Approval >>> Disbursment .... */
        WebElement Editbtn3 = driver.findElement(By.xpath("(//span[contains(@class,'MuiIconButton-label')])[6]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Editbtn3);
        Editbtn3.click();

        /*WebElement editBtn2 = driver.findElement(By.xpath("(//span[contains(@class,'MuiIconButton-label')])[6]"));
        editBtn.click();*/

        //Click Add button
        driver.findElement(By.xpath("(//button[@title='Add'])[1]")).click();

        //Enter Disbursement date
        driver.findElement(By.xpath("(//input[@aria-label='Choose date'])[2]")).click();
        driver.findElement(By.xpath("//button[@aria-label='calendar view is open, go to text input view']")).click();
        driver.findElement(By.xpath("//input[@placeholder='mm/dd/yyyy']")).click();
        driver.findElement(By.xpath("//input[@placeholder='mm/dd/yyyy']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='mm/dd/yyyy']")).sendKeys("10/01/2026");
        driver.findElement(By.xpath("//span[text()='OK']")).click();
        Thread.sleep(500);

        //Account field
        driver.findElement(By.xpath("(//div[@role='button'][@aria-haspopup='listbox'])[16]")).click();
        driver.findElement(By.xpath("//li[@role='option' and normalize-space()='100001-Cash [USD]']")).click();
        Thread.sleep(500);

        // Read value from (//input[@name='net_payment_amount'])[2]
        /*WebElement source = driver.findElement(
                By.xpath("(//input[@name='net_payment_amount'])[2]")
        );
        String value = source.getAttribute("value");

        // Paste value into //input[@name='amount']
        WebElement target = driver.findElement(
                By.xpath("//input[@name='amount']")
        );
        target.clear();
        target.sendKeys(value);*/


        // 5. Click Receiver dropdown (value will stay now)
        driver.findElement(By.xpath("(//div[contains(@class,'MuiFormControl-root')]//div[@role='button' and @aria-haspopup='listbox'])[17]")).click();
        driver.findElement(By.xpath("//li[@role='option' and contains(text(),'Customer')]")).click();


        //Description field
        driver.findElement(By.xpath("(//div[contains(@class, 'MuiInputBase-root')]//input[@type='text'])[48]")).click();
        driver.findElement(By.xpath("(//div[contains(@class, 'MuiInputBase-root')]//input[@type='text'])[48]")).sendKeys("test..");


        //Amount field
        WebElement source = driver.findElement( By.xpath("(//input[@name='net_payment_amount'])[2]") );
        String value = source.getAttribute("value");
        // Paste value into //input[@name='amount']
        WebElement target = driver.findElement( By.xpath("//input[@name='amount']") );
        target.clear();
        target.sendKeys(value);

        //Click Save button
        driver.findElement(By.xpath("(//button[contains(@class, 'MuiButton-root')]//span[text()='Save'])[1]")).click();
        Thread.sleep(5000);

        //Click Disburse button
        driver.findElement(By.xpath("//button[contains(@class, 'MuiButton-root')]//span[text()='Disburse Payment']")).click();

        //Add reason and click yes to process
        driver.findElement(By.xpath("//div[@data-placeholder='Reason']")).sendKeys("testingg...");
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[text()='Yes']")).click();
        Thread.sleep(5000);


        /* ----- APPROVE PAYMENT --------- */
        //Click Edit button and navigate to the paymennt approve
        WebElement editBtn3 = driver.findElement(By.xpath("(//span[contains(@class,'MuiIconButton-label')])[6]"));
        editBtn3.click();

        //Click Disburse button
        driver.findElement(By.xpath("//button[contains(@class, 'MuiButton-root')]//span[text()='Approve Payment']")).click();

        //Add reason and click yes to process
        driver.findElement(By.xpath("//div[@data-placeholder='Reason']")).sendKeys("testing hii");
        Thread.sleep(500);
        driver.findElement(By.xpath("//span[text()='Yes']")).click();
        Thread.sleep(500);



        Thread.sleep(5000);
    }
}



