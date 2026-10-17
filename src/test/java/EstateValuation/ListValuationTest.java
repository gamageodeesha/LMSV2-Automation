package EstateValuation;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;

public class ListValuationTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {
        driver = LoginAndNavigate.loginAndNavigateToAddPage();  // optional reuse
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Navigate to Valuation List
        driver.navigate().to("http://3.1.164.148/dashboard/real-estate-valuation");
    }

    @Test
    public void searchAndDeleteValuation() throws Exception {
        // Search by Deed No
        // Search by Deed No (use clickable wait)
        WebElement deedNo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='deed_no']")));
        deedNo.click();
        deedNo.sendKeys("500");
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
        // Wait for results or page stability
        Thread.sleep(2000);
        // Re-locate the field in case it's re-rendered
        deedNo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='deed_no']")));
        // 1) Try keyboard-based clear (works for most React inputs)
        deedNo.sendKeys(Keys.chord(Keys.CONTROL, "a")); // select all
        deedNo.sendKeys(Keys.DELETE);
        // small buffer
        Thread.sleep(300);
        // 2) Ensure React sees the change — dispatch an input event via JS as a fallback
        String clearScript =
                "const el = arguments[0];" +
                        "el.focus();" +
                        "el.value = '';" +
                        "el.dispatchEvent(new Event('input', { bubbles: true }));" +
                        "el.dispatchEvent(new Event('change', { bubbles: true }));";
        ((JavascriptExecutor) driver).executeScript(clearScript, deedNo);
        // Optional: move focus away to trigger any blur/change handlers
        deedNo.sendKeys(Keys.TAB);
        // Now search again (empty search or to refresh results)
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
        // short wait to let UI update
        Thread.sleep(1500);

        // Cancel
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement cancelBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//button[contains(@class,'MuiButtonBase-root') and @title='Cancel'])[1]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cancelBtn);
        cancelBtn.click();

        driver.findElement(By.xpath("//div[contains(@class,'ql-editor') and @data-placeholder='Reason']")).sendKeys("Testing purpose");
        driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
        Thread.sleep(1000);

        // Delete
        WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//button[contains(@class,'MuiButtonBase-root') and @title='Delete'])[1]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteBtn);
        deleteBtn.click();

        driver.findElement(By.xpath("//div[contains(@class,'ql-editor') and @data-placeholder='Reason']")).sendKeys("Testing purpose delete");
        driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
        Thread.sleep(1000);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        if (driver != null) driver.quit();
    }
}
