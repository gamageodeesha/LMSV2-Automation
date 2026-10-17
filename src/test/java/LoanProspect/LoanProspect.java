package LoanProspect;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class LoanProspect {
    public static void main(String[] args) throws Exception {

        WebDriver driver = WebDriverManager.chromedriver().create();
        //Thread.sleep(50000);
        driver.manage().window().maximize();
        // Thread.sleep(2000);
        driver.get("http://3.1.164.148/");
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //WebDriver driver = WebDriverManager.chromedriver().create();
        //driver.manage().window().maximize();
        //driver.get("http://3.1.164.148/");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='email']")).click();
        driver.findElement(By.xpath("//input[@name='email']")).clear();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("demo.crm@lalco.la");

        //driver.findElement(By.xpath("//input[@name='password']")).click();
        driver.findElement(By.xpath("//*[@name='password']")).click();
        driver.findElement(By.xpath("//input[@name='password']")).clear();
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password123!");

        //capture using span>text
        driver.findElement(By.xpath("//span[text()='Log In']")).click();

        //Scroll & click Expense
        WebElement element4 = driver.findElement(By.xpath("(//*[normalize-space(text())='Prospect'])[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element4);
        Thread.sleep(1000);
        element4.click();

        driver.findElement(By.xpath("//*[normalize-space(text())='Add Prospect']")).click();

        //search by customer ID
        driver.findElement(By.xpath("//input[@name='id']")).click();
        driver.findElement(By.xpath("//input[@name='id']")).sendKeys("156");
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
        //Click Add prospect
        driver.findElement(By.xpath("//a[contains(@href, '/dashboard/cosm/prospect/add?customer_id=156')]")).click();

        Thread.sleep(3000);
        //Contract Type
        driver.findElement(By.xpath("//select[@name='contract_type']")).click();
        driver.findElement(By.xpath("//select[@name='contract_type']/option[@value='2']")).click();

        //Branch
        driver.findElement(By.xpath("//select[@name='call_centre_id']")).click();
        driver.findElement(By.xpath("//select[@name='call_centre_id']/option[@value='22']")).click();

        //Customer Profile
        driver.findElement(By.xpath("//select[@name='customer_profile']")).click();
        driver.findElement(By.xpath("//select[@name='customer_profile']/option[@value='2']")).click();

        //Contract Salesperson
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // 1️⃣ Click the Salesperson input
        WebElement salespersonInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='salesperson']")));
        salespersonInput.click();
        // 2️⃣ Type "Kha"
        salespersonInput.sendKeys("Kha");
        Thread.sleep(1000);
        // 3️⃣ Wait for dropdown to appear
        WebElement dropdownValue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Khamkhoun PHETLAVANH (Khoun - 3196)')]")));
        // 4️⃣ Click the matching value
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
        dropdownValue.click();

        //Sales Assistant
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        // 1️⃣ Click the Salesperson input
        WebElement salespersonInput1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='sales_assistant']")));
        salespersonInput1.click();
        // 2️⃣ Type "Kha"
        salespersonInput1.sendKeys("Mai");
        Thread.sleep(1000);
        // 3️⃣ Wait for dropdown to appear
        WebElement dropdownValue1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Maiphone INSOMPHAR (Mai - 3987)')]")));
        // 4️⃣ Click the matching value
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownValue1);
        dropdownValue1.click();

        //Call Center Salesperson
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        // 1️⃣ Click the Salesperson input
        WebElement salespersonInput2 = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='cc_salesperson']")));
        salespersonInput2.click();
        // 2️⃣ Type "Kha"
        salespersonInput2.sendKeys("Mai");
        Thread.sleep(1000);
        // 3️⃣ Wait for dropdown to appear
        WebElement dropdownValue2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Phitsamai BOULDAVIENG (Phit - 4938)')]")));
        // 4️⃣ Click the matching value
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownValue2);
        dropdownValue2.click();

        //Double Count Person
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        // 1️⃣ Click the Salesperson input
        WebElement salespersonInput3 = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='double_count_person']")));
        salespersonInput3.click();
        // 2️⃣ Type "Kha"
        salespersonInput3.sendKeys("Kha");
        Thread.sleep(1000);
        // 3️⃣ Wait for dropdown to appear
        WebElement dropdownValue3 = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Sony  BOUDSIDAKHAM (Ny - 843)')]")));
        // 4️⃣ Click the matching value
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownValue3);
        dropdownValue3.click();

        //Customer Introduction
        driver.findElement(By.xpath("//select[@name='customer_introduced_by']")).click();
        driver.findElement(By.xpath("//select[@name='customer_introduced_by']/option[@value='1']")).click();

        //Approach List
        driver.findElement(By.xpath("//select[@name='customer_intro_approach']")).click();
        driver.findElement(By.xpath("//select[@name='customer_intro_approach']/option[@value='4']")).click();

        //Case OutLine
        driver.findElement(By.xpath("//div[@data-placeholder='Case Outline / ຮ່າງເກສ']")).click();
        driver.findElement(By.xpath("//div[@data-placeholder='Case Outline / ຮ່າງເກສ']")).sendKeys("ຕ້ອງການເອົາເງີນໄປເປີດປ້ຳນ້ຳມັນເພີ່ມອາຊີບແມ່ນເຈົ້າຂອງບໍລິສັດ ສົມສັກ ປູກຝັ່ງ -ລ້ຽງສັດ ຄົບວົງຈອນ ຈຳກັດຜູ້ດຽວ ແລະເຈົ້າຂອງປ້ຳນ້ຳມັນ ລາຍຮັບຕໍ່ເດືອນແມ່ນ 5000$ ອາຊີບຜູ້ຄ້ຳເຮັດວຽກນຳກັນຈັດການບັນຊິລາຍຮັບອັນດຽວກັບຜົວ  ຕ້ອງການເງີນ22,000$ດອກເບ້ຍ3%ທຳນຽມ1%");

        //Customer Monthly Income
        driver.findElement(By.xpath("//input[@name='customer.monthly_income']")).click();
        driver.findElement(By.xpath("//input[@name='customer.monthly_income']")).sendKeys("35000");

        //Customer Monthly Expenditure
        driver.findElement(By.xpath("//input[@name='customer.monthly_expenditure']")).click();
        driver.findElement(By.xpath("//input[@name='customer.monthly_expenditure']")).sendKeys("20000");

        //Scrool & Guarantor Select
        WebElement element1 = driver.findElement(By.xpath("//input[@name='enabled_1']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
        element1.click();
        driver.findElement(By.xpath("//input[@name='enabled_0']")).click();

        //Select Guarantor
        driver.findElement(By.xpath("(//input[contains(@class, 'PrivateSwitchBase-input') and @type='checkbox'])[1]")).click();

        //Select Asset
        driver.findElement(By.xpath("(//td[normalize-space()='Asset Assessed']/following-sibling::td//input[@type='checkbox'])[1]")).click();

        //Objective of Found
        driver.findElement(By.xpath("//div[@data-placeholder='Objective of Fund / ຈຸດປະສົງຂອງຕົ້ນທືນ']")).click();
        driver.findElement(By.xpath("//div[@data-placeholder='Objective of Fund / ຈຸດປະສົງຂອງຕົ້ນທືນ']")).sendKeys("Testing 1");

        //Repayment Source
        driver.findElement(By.xpath("//div[@data-placeholder='Repayment Source / ແຫຼ່ງການຊຳລະຄືນ']")).click();
        driver.findElement(By.xpath("//div[@data-placeholder='Repayment Source / ແຫຼ່ງການຊຳລະຄືນ']")).sendKeys("Testing 2");

        //Special Notes
        driver.findElement(By.xpath("//div[@data-placeholder='Special Notes / ໝາຍເຫດພິເສດ']")).click();
        driver.findElement(By.xpath("//div[@data-placeholder='Special Notes / ໝາຍເຫດພິເສດ']")).sendKeys("Testing 3");

        //Scrool & Loan tab Select
        WebElement element2 = driver.findElement(By.xpath("//*[normalize-space(text())='Loan / ການກູ້ຢືມ']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
        element2.click();






        Thread.sleep(3000);

    }


}
