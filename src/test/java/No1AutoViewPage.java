import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class No1AutoViewPage{
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        try {

            driver.get("http://3.1.164.148/authentication/login-unguarded");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            String sharedOptionText = "sameera Harshana (samee - 22222)";
            String sharedOptionXPath = String.format("//li[text()='%s']", sharedOptionText);


            wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
            emailInput.sendKeys("demo.crm@lalco.la");

            WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
            passwordInput.sendKeys("Password123!");

            driver.findElement(By.xpath("//span[text()='Log In']")).click();
            Thread.sleep(5000);

            wait.until(ExpectedConditions.urlContains("dashboard"));


            //To scroll until a specific element is visible
            WebElement element = driver.findElement(By.xpath("//div[text()='Number 1 Auto']"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);

            driver.findElement(By.xpath("//div[text()='Number 1 Auto']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//div[text()='List No.1 Auto']")).click();
            Thread.sleep(5000);

            //Scroll to view icon
            WebElement viewIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@title='View Details'])[1]")));
            js.executeScript("arguments[0].scrollIntoView(true);", viewIcon);
            //Click View icon
            viewIcon.click();
            Thread.sleep(2000);

            //Date
            driver.findElement(By.xpath("//input[@name='ringi_date']")).click();
            driver.findElement(By.xpath("//button[@aria-label='calendar view is open, go to text input view']")).click();
            driver.findElement(By.xpath("//input[@placeholder='mm/dd/yyyy']")).sendKeys("10/10/2025");
            driver.findElement(By.xpath("//span[text()='OK']")).click();


            // Staff in charge
            WebElement inputField2 = driver.findElement(By.xpath("//input[@id='ringi_staff_incharge']"));
            inputField2.click();
            inputField2.sendKeys("sameera");
            WebElement dropdownOption2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sharedOptionXPath)));
            dropdownOption2.click();


            // Sale
            WebElement inputField3 = driver.findElement(By.xpath("//input[@id='ringi_staff_sales']"));
            inputField3.click();
            inputField3.sendKeys("sameera");
            WebElement dropdownOption3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sharedOptionXPath)));
            dropdownOption3.click();

            // Checker
            WebElement inputField4 = driver.findElement(By.xpath("//input[@id='ringi_staff_checker']"));
            inputField4.click();
            inputField4.sendKeys("sameera");
            WebElement dropdownOption4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sharedOptionXPath)));
            dropdownOption4.click();


            // Collection
            WebElement inputField5 = driver.findElement(By.xpath("//input[@id='ringi_staff_collection']"));
            inputField5.click();
            inputField5.sendKeys("sameera");
            WebElement dropdownOption5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sharedOptionXPath)));
            dropdownOption5.click();


            //Contact Customer
            driver.findElement(By.xpath("//div[@id='mui-component-select-ringi_contract_customer']")).click();
            driver.findElement(By.xpath("//li[text()='不可 / ບໍ່ໄດ້']")).click();

            //Contact Guarantor
            driver.findElement(By.xpath("//div[@id='mui-component-select-ringi_contract_guarantor']")).click();
            driver.findElement(By.xpath("//li[text()='可能 / ໄດ້']")).click();

            //Have Land Customer
            driver.findElement(By.xpath("//div[@id='mui-component-select-ringi_have_land_customer']")).click();
            driver.findElement(By.xpath("//li[text()='有 / ມີ']")).click();

            //Have Land Guarantor
            driver.findElement(By.xpath("//div[@id='mui-component-select-ringi_have_land_guarantor']")).click();
            driver.findElement(By.xpath("//li[text()='無 / ບໍ່ມີ']")).click();

            //Customer other Asset:
            WebElement customerAsset = driver.findElement(By.xpath("//input[@name='ringi_customer_other_asset']"));
            customerAsset.click();
            customerAsset.clear();
            customerAsset.sendKeys("Test 1");

            //Guarantor other Asset:
            WebElement guarantorAsset = driver.findElement(By.xpath("//input[@name='ringi_guarantor_other_asset']"));
            guarantorAsset.click();
            guarantorAsset.clear();
            guarantorAsset.sendKeys("Test 2");


            //Add new button (The Auctioneer section)
            By addNewButtonLocator = By.xpath("//button[@title='Add new']");
            WebElement addNewButton = wait.until(ExpectedConditions.visibilityOfElementLocated(addNewButtonLocator));
            // Scroll, wait, and click using JavaScript for robustness
            js.executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -150);", addNewButton);
            Thread.sleep(1000);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addNewButton);


            //shop/person
            driver.findElement(By.xpath("//div[@id='mui-component-select-shop_person']")).click();
            driver.findElement(By.xpath("//li[text()='Shop']")).click();

            //Name:
            driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Shein");

            //Phone:
            driver.findElement(By.xpath("//input[@name='phone_1']")).sendKeys("02020829292");

            //Job
            driver.findElement(By.xpath("//input[@name='job']")).sendKeys("Shop");

            //Buying Price
            driver.findElement(By.xpath("//input[@name='price']")).sendKeys("1000");

            //Selling price
            driver.findElement(By.xpath("//input[@name='selling_price']")).sendKeys("1500");

            //Currency
            driver.findElement(By.xpath("//div[@id='mui-component-select-currency']")).click();
            driver.findElement(By.xpath("//li[text()='USD']")).click();

            // Date line
            driver.findElement(By.xpath("//input[@name='date_line']")).click();
            driver.findElement(By.xpath("//button[@aria-label='calendar view is open, go to text input view']")).click();
            driver.findElement(By.xpath("//input[@placeholder='mm/dd/yyyy']")).sendKeys("10/10/2025");
            driver.findElement(By.xpath("//span[text()='OK']")).click();
            Thread.sleep(500);

            //How to Know
            driver.findElement(By.xpath("//input[@name='how_to_know']")).sendKeys("Introduction");
            Thread.sleep(500);

            /*//Person incharge
            WebElement inputField6 = driver.findElement(By.xpath("(//input[@aria-autocomplete='list'])[5]")); // Assuming mui-66210 is the current unique ID
            inputField6.click();
            inputField6.sendKeys("sameera");
            Thread.sleep(250);
            WebElement dropdownOption6 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sharedOptionXPath)));
            dropdownOption6.click();*/

            //shop/person Name
            driver.findElement(By.xpath("//div[@id='mui-component-select-selected_shop_id']")).click();
            WebElement shopOption1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-value='0']")));
            shopOption1.click();
            Thread.sleep(500);

            //Rank
            driver.findElement(By.xpath("//div[@id='mui-component-select-ringi_shop_rank']")).click();
            driver.findElement(By.xpath("//li[text()='A: ຂາຍພໍຕົ້ນທືນ ແລະ ດອກເບ້ຍ']")).click();
            Thread.sleep(500);

            //Price should be
            driver.findElement(By.xpath("//input[@name='ringi_price']")).sendKeys("1000");

            //Price from FB:
            driver.findElement(By.xpath("//input[@name='fb_price']")).sendKeys("2000");

            //Collection policy remaining debt after car sold
            driver.findElement(By.xpath("//div[@data-placeholder='Collection policy']")).sendKeys("Test 1");

            //History of negotiation
            driver.findElement(By.xpath("//div[@data-placeholder='History of negotiation']")).sendKeys("Test 2");

            //Remark
            driver.findElement(By.xpath("//div[@data-placeholder='Remark']")).sendKeys("Test 3");


            //Repair or not?
            driver.findElement(By.xpath("//div[@id='mui-component-select-repair_is_repair']")).click();
            driver.findElement(By.xpath("//li[text()='No / ບໍມີ']")).click();
            Thread.sleep(500);

            //Total Amounts
            driver.findElement(By.xpath("//input[@name='repair_amount']")).sendKeys("30000");

            //Currency
            driver.findElement(By.xpath("//div[@id='mui-component-select-repair_currency']")).click();
            driver.findElement(By.xpath("//li[text()='USD']")).click();
            Thread.sleep(500);

            //Staff in charge (Repair)
            WebElement repairStaffInput = driver.findElement(By.xpath("//input[@id='repair_staff_incharge']"));
            repairStaffInput.click();
            repairStaffInput.sendKeys("sameera"); // Use a partial name to trigger the dropdown
            WebElement dropdownOptionRepair = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sharedOptionXPath)));
            dropdownOptionRepair.click();

            //Price compare not enough principal
            driver.findElement(By.xpath("//input[@name='credit_price_compare']")).sendKeys("1000");

            //% of Minus per Principal
            driver.findElement(By.xpath("//input[@name='credit_minus_per_principal']")).sendKeys("20");

            //% of Minus per total outstanding
            driver.findElement(By.xpath("//input[@name='credit_minus_per_outstanding']")).sendKeys("50");

            //Rank
            driver.findElement(By.xpath("//div[@id='mui-component-select-credit_rank']")).click();
            driver.findElement(By.xpath("//li[text()='A: ຂາຍພໍຕົ້ນທືນ ແລະ ດອກເບ້ຍ']")).click();

            //Other Asset:
            driver.findElement(By.xpath("//input[@name='credit_other_asset']")).sendKeys("Test");

            //How to collect the Minus:
            driver.findElement(By.xpath("//input[@name='credit_how_collect_minus']")).sendKeys("Test");


            //Status
            driver.findElement(By.xpath("//div[@id='mui-component-select-status']")).click();
            driver.findElement(By.xpath("//li[text()='Lalco Office']")).click();
            Thread.sleep(500);

            //Click Approve Button
            driver.findElement(By.xpath("//span[text()='Approve']")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//span[text()='Yes']")).click();
            Thread.sleep(5000);


        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {

            driver.quit();
        }
    }

}

