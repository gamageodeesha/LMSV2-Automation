package LoanProspect;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class DraftSave {

    WebDriver driver;
    WebDriverWait wait;

    public DraftSave(WebDriver driver) {
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

    public void validateDraftCreation() {

        // Click Save as Draft without filling fields
        driver.findElement(By.xpath(
                "//span[normalize-space(text())='Save as Draft']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));

        boolean isAllValidationDisplayed = true;

        // ===============================
        // Check Contract Type Validation
        // ===============================
        try {
            WebElement contractTypeError = driver.findElement(
                    By.xpath("//select[@name='contract_type']/following::div[contains(@class,'error')][1]"));

            if (!contractTypeError.isDisplayed()) {
                System.out.println("❌ Contract Type validation message NOT displayed");
                isAllValidationDisplayed = false;
            }

        } catch (NoSuchElementException e) {
            System.out.println("❌ Contract Type validation message NOT displayed");
            isAllValidationDisplayed = false;
        }

        // ===============================
        // Check Branch Validation
        // ===============================
        try {
            WebElement branchError = driver.findElement(
                    By.xpath("//select[@name='call_centre_id']/following::div[contains(@class,'error')][1]"));

            if (!branchError.isDisplayed()) {
                System.out.println("❌ Branch validation message NOT displayed");
                isAllValidationDisplayed = false;
            }

        } catch (NoSuchElementException e) {
            System.out.println("❌ Branch validation message NOT displayed");
            isAllValidationDisplayed = false;
        }

        // ===============================
        // Check Customer Profile Validation
        // ===============================
        try {
            WebElement profileError = driver.findElement(
                    By.xpath("//*[contains(text(),'Customer Profile') and contains(text(),'required')]"));

            if (!profileError.isDisplayed()) {
                System.out.println("❌ Customer Profile validation message NOT displayed");
                isAllValidationDisplayed = false;
            }

        } catch (NoSuchElementException e) {
            System.out.println("❌ Customer Profile validation message NOT displayed");
            isAllValidationDisplayed = false;
        }

        if (isAllValidationDisplayed) {
            System.out.println("✅ All required field validation messages are displayed.");
        }

        // ===============================
        // Fill Required Fields
        // ===============================

        Select contractType = new Select(driver.findElement(By.name("contract_type")));
        contractType.selectByValue("2");

        Select branch = new Select(driver.findElement(By.name("call_centre_id")));
        branch.selectByValue("22");

        Select profile = new Select(driver.findElement(By.name("customer_profile")));
        profile.selectByValue("2");

        // Click Save as Draft again
        driver.findElement(By.xpath(
                "//span[normalize-space(text())='Save as Draft']")).click();

        // ===============================
        // Verify Draft Created
        // ===============================
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(),'Draft') or contains(text(),'success')]")));

            System.out.println("✅ Draft Created Successfully!");
        } catch (Exception e) {
            System.out.println("❌ Draft NOT created!");
        }
    }


    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        DraftSave draft = new DraftSave(driver);

        draft.loginToSystem();
        draft.validateDraftCreation();

        Thread.sleep(3000);
        driver.quit();
    }
}
