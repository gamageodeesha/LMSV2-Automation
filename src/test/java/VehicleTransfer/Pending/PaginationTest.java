package VehicleTransfer.Pending;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaginationTest {

    WebDriver driver;

    public PaginationTest(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNextAndVerify() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Capture current table data before clicking Next
        List<WebElement> rowsBefore = driver.findElements(By.xpath("//table[contains(@class,'MuiTable-root')]/tbody/tr"));
        System.out.println("Rows before clicking Next: " + rowsBefore.size());

        if (rowsBefore.isEmpty()) {
            System.out.println("No rows found in table before clicking Next.");
            return;
        }

        // Click Next button
        WebElement nextBtn = driver.findElement(By.xpath("(//a[@rel='next'])[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextBtn);
        nextBtn.click();

        Thread.sleep(2000); // Wait for page/table to load

        // Capture table data after clicking Next
        List<WebElement> rowsAfter = driver.findElements(By.xpath("//table[contains(@class,'MuiTable-root')]/tbody/tr"));
        System.out.println("Rows after clicking Next: " + rowsAfter.size());

        // Verify table updated
        if (rowsAfter.isEmpty()) {
            System.out.println("No rows found after clicking Next.");
            return;
        }

        if (!rowsAfter.get(0).getText().equals(rowsBefore.get(0).getText())) {
            System.out.println("Pagination successful. Table updated correctly.");
        } else {
            System.out.println("Table did not update after clicking Next.");
        }
    }
}