package LoanProspect;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class CaseTab {
    WebDriver driver;

    public CaseTab(WebDriver driver) {
        this.driver = driver;
    }

    public void fillCaseDetails() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Contract Type
        driver.findElement(By.name("contract_type")).click();
        driver.findElement(By.xpath("//select[@name='contract_type']/option[@value='2']")).click();

        // Branch
        driver.findElement(By.name("call_centre_id")).click();
        driver.findElement(By.xpath("//select[@name='call_centre_id']/option[@value='22']")).click();

        // Customer Profile
        driver.findElement(By.name("customer_profile")).click();
        driver.findElement(By.xpath("//select[@name='customer_profile']/option[@value='2']")).click();

        // Salesperson selection
        selectFromDropdown("//input[@id='salesperson']", "Kha",
                "//*[contains(text(),'Khamkhoun PHETLAVANH (Khoun - 3196)')]");

        // Sales Assistant
        selectFromDropdown("//input[@id='sales_assistant']", "Mai",
                "//*[contains(text(),'Maiphone INSOMPHAR (Mai - 3987)')]");

        // Call Center Salesperson
        selectFromDropdown("//input[@id='cc_salesperson']", "Mai",
                "//*[contains(text(),'Phitsamai BOULDAVIENG (Phit - 4938)')]");

        // Double Count Person
        selectFromDropdown("//input[@id='double_count_person']", "Kha",
                "//*[contains(text(),'Xaysomvang SENGKHAMPHOU (Vang - 2424)')]");

        // Drop-down selections
        driver.findElement(By.name("customer_introduced_by")).click();
        driver.findElement(By.xpath("//select[@name='customer_introduced_by']/option[@value='1']")).click();

        driver.findElement(By.name("customer_intro_approach")).click();
        driver.findElement(By.xpath("//select[@name='customer_intro_approach']/option[@value='4']")).click();

        // Case Outline
        driver.findElement(By.xpath("//div[@data-placeholder='Case Outline / ຮ່າງເກສ']")).sendKeys(
                "ຕ້ອງການເອົາເງີນໄປເປີດປ້ຳນ້ຳມັນເພີ່");

        //Customer Monthly Income
        driver.findElement(By.name("customer.monthly_income")).sendKeys("35000");

        //Customer Monthly Expenditure
        driver.findElement(By.name("customer.monthly_expenditure")).sendKeys("20000");

        /*WebElement element1 = driver.findElement(By.name("enabled_1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
        element1.click();*/

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement guarantorToggle = wait2.until(ExpectedConditions.presenceOfElementLocated(By.name("enabled_0")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", guarantorToggle);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", guarantorToggle);


        /*WebElement checkbox = driver.findElement(By.xpath("(//td[normalize-space()='Asset Assessed']/following-sibling::td//input[@type='checkbox'])[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
        checkbox.click();

        driver.findElement(By.xpath("(//td[normalize-space()='Asset Assessed']/following-sibling::td//input[@type='checkbox'])[2]")).click();*/

        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement assetAssessedCheckbox2 = wait4.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[normalize-space()='Asset Assessed']/following-sibling::td//input[@type='checkbox'])[1]")));
        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", assetAssessedCheckbox2);

        // Click using JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", assetAssessedCheckbox2);



        driver.findElement(By.xpath("//div[@data-placeholder='Objective of Fund / ຈຸດປະສົງຂອງຕົ້ນທືນ']")).sendKeys("Testing 1");
        driver.findElement(By.xpath("//div[@data-placeholder='Repayment Source / ແຫຼ່ງການຊຳລະຄືນ']")).sendKeys("Testing 2");
        driver.findElement(By.xpath("//div[@data-placeholder='Special Notes / ໝາຍເຫດພິເສດ']")).sendKeys("Testing 3");
    }

    /*private void selectFromDropdown(String inputXpath, String textToType, String dropdownValueXpath) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inputXpath)));
        input.click();
        input.sendKeys(textToType);
        Thread.sleep(1000);
        WebElement value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownValueXpath)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", value);
        value.click();
    }*/

    private void selectFromDropdown(String inputXpath, String textToType, String dropdownValueXpath) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(inputXpath)));
        input.click();
        input.clear();
        input.sendKeys(textToType);
        Thread.sleep(1000); // wait for dropdown to render
        // Wait for dropdown option to appear
        WebElement value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownValueXpath)));
        // Move to the parent element if necessary
        WebElement clickableOption = null;
        try {
            clickableOption = value.findElement(By.xpath("./ancestor-or-self::li[contains(@class,'MuiAutocomplete-option')]"));
        } catch (NoSuchElementException e1) {
            try {
                clickableOption = value.findElement(By.xpath("./ancestor-or-self::div[contains(@class,'MuiAutocomplete-option')]"));
            } catch (NoSuchElementException e2) {
                clickableOption = value; // fallback
            }
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickableOption);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", clickableOption);

        Thread.sleep(500); // stabilize before next action
    }


}
