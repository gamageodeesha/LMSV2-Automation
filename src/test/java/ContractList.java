import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class ContractList {
    public static void main(String[] args) {
        // Setup WebDriver using WebDriverManager
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        try {
            // 1. Navigate to the login page
            driver.get("http://3.1.164.148/authentication/login-unguarded");

            // Wait for email field to be visible and enter credentials
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
            emailInput.sendKeys("demo.crm@lalco.la");

            WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
            passwordInput.sendKeys("Password123!");

            // Click the Login button
            driver.findElement(By.xpath("//span[text()='Log In']")).click();

            // Wait for the URL to contain "dashboard" after login
            wait.until(ExpectedConditions.urlContains("dashboard"));

            // Navigate to Contract List
            //To scroll until a specific element is visible
            WebElement element = driver.findElement(By.xpath("//button//div[text()='Contract']/ancestor::button"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);

            driver.findElement(By.xpath("//button//div[text()='Contract']/ancestor::button")).click();
            Thread.sleep(4000);

            driver.findElement(By.xpath("//div[text()='Contract List']")).click();
            Thread.sleep(4000);



            // 1. Select Specific Contract
            //To scroll until a specific element is visible
            WebElement element1 = driver.findElement(By.xpath("//a[@id='115']"));
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js1.executeScript("arguments[0].scrollIntoView(true);", element1);

            driver.findElement(By.xpath("//a[@id='115']")).click();
            Thread.sleep(5000);

            //Method
            driver.findElement(By.xpath("//div[@id='mui-component-select-withdrawal_method']")).click();
            driver.findElement(By.xpath("//li[text()='Cash']")).click();

            // --- START OF CORRECTED AMOUNT LOGIC ---
            try {
                // 1. Locate the Amount element from the table (e.g., "USD 10.00")
                WebElement amountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//td[contains(text(), 'USD')]")
                ));
                String rawAmount = amountElement.getText();
                System.out.println("Raw text found: " + rawAmount);

                // 2. Extract only the numeric part (removes "USD" and spaces)
                String numericValue = rawAmount.replaceAll("[^0-9.]", "");
                System.out.println("Cleaned numeric value: " + numericValue);

                // 3. Locate the Loan input field
                WebElement loanField = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@name='withdrawal_amount']")
                ));

                // 4. Enter the value into the field
                loanField.clear();
                // Sometimes clear() doesn't work on MUI fields, so we use keys to select all and delete
                loanField.sendKeys(Keys.CONTROL + "a");
                loanField.sendKeys(Keys.BACK_SPACE);
                loanField.sendKeys(numericValue);

                System.out.println("Successfully transferred value to Loan field.");
            } catch (Exception e) {
                System.err.println("Failed to sync Amount to Loan field: " + e.getMessage());
            }


            //Request for Contract Check
            driver.findElement(By.xpath("//span[normalize-space()='Request for Contract Check']")).click();
            Thread.sleep(4000);

            driver.findElement(By.xpath("//div[@data-placeholder='Reason']")).sendKeys(".");
            Thread.sleep(500);
            driver.findElement(By.xpath("//span[text()='Yes']")).click();
            Thread.sleep(5000);





            // 2. Pending Approval
            //Select Specific Contract
            //To scroll until a specific element is visible
            WebElement element2 = driver.findElement(By.xpath("//a[@id='115']"));
            JavascriptExecutor js2 = (JavascriptExecutor) driver;
            js2.executeScript("arguments[0].scrollIntoView(true);", element2);

            driver.findElement(By.xpath("//a[@id='115']")).click();
            Thread.sleep(5000);


            // AUTOMATICALLY CLICK ALL CHECKBOXES
            // Wait for the checklist section to load
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//input[@type='checkbox']")));

            List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
            System.out.println("Found " + checkboxes.size() + " checkboxes. Starting click process...");

            for (WebElement checkbox : checkboxes) {
                // Check if checkbox is already selected to avoid unchecking it
                if (!checkbox.isSelected()) {
                    try {
                        // Using JavaScript click because MUI spans often intercept normal clicks
                        js.executeScript("arguments[0].click();", checkbox);

                        String name = checkbox.getAttribute("name");
                        System.out.println("Successfully clicked: " + (name != null ? name : "Unnamed Checkbox"));
                    } catch (Exception e) {
                        System.err.println("Failed to click a checkbox: " + e.getMessage());
                    }
                }
            }
            Thread.sleep(10000);


            //Approved
            driver.findElement(By.xpath("//button[contains(., 'Approved')]")).click();
            Thread.sleep(4000);

            driver.findElement(By.xpath("//div[@data-placeholder='Reason']")).sendKeys(".");
            Thread.sleep(500);
            driver.findElement(By.xpath("//span[text()='Yes']")).click();
            Thread.sleep(5000);


            // 3. Pending Disbursement
            // Select Specific Contract
            //To scroll until a specific element is visible
            WebElement element3 = driver.findElement(By.xpath("//a[@id='115']"));
            JavascriptExecutor js3 = (JavascriptExecutor) driver;
            js3.executeScript("arguments[0].scrollIntoView(true);", element3);

            driver.findElement(By.xpath("//a[@id='115']")).click();
            Thread.sleep(5000);

            driver.findElement(By.xpath("//span[text()='Disburse Payment']")).click();
            Thread.sleep(4000);

            //Click Approval
            driver.findElement(By.xpath("//div[@data-placeholder='Reason']")).sendKeys(".");
            Thread.sleep(500);
            driver.findElement(By.xpath("//span[text()='Yes']")).click();
            Thread.sleep(5000);


            // 4. Disbursement Approval
            // Select Specific Contract
            //To scroll until a specific element is visible
            WebElement element4 = driver.findElement(By.xpath("//a[@id='115']"));
            JavascriptExecutor js4 = (JavascriptExecutor) driver;
            js4.executeScript("arguments[0].scrollIntoView(true);", element4);

            driver.findElement(By.xpath("//a[@id='115']")).click();
            Thread.sleep(5000);

            driver.findElement(By.xpath("//span[text()='Approve Payment']")).click();
            Thread.sleep(4000);

            //Click Approval
            driver.findElement(By.xpath("//div[@data-placeholder='Reason']")).sendKeys(".");
            Thread.sleep(500);
            driver.findElement(By.xpath("//span[text()='Yes']")).click();
            Thread.sleep(5000);

            // Small pause to verify visually
            Thread.sleep(3000);




            // 5. View Contract
            //To scroll until a specific element is visible
            WebElement element5 = driver.findElement(By.xpath("(//a[@id='115'])[1]"));
            JavascriptExecutor js5 = (JavascriptExecutor) driver;
            js5.executeScript("arguments[0].scrollIntoView(true);", element5);

            driver.findElement(By.xpath("(//a[@id='115'])[1]")).click();
            Thread.sleep(50000);


            //Checklist Tab
            // --- CHECKLIST TAB & SLOW SCROLL LOGIC ---
            System.out.println("Starting scroll logic...");

            // 1. Ensure you are on the Checklist Tab first
            WebElement checklistTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(., 'Checklist')]")));
            checklistTab.click();
            Thread.sleep(2000); // Wait for tab content to load

            // 2. Slow Scroll Logic (Integrated directly, no extra class needed)
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

            // Get the current total height of the page
            long totalHeight = (long) jsExecutor.executeScript("return document.body.scrollHeight");
            int scrollStep = 150; // Pixels per step
            int pause = 300;     // Milliseconds between steps

            for (int i = 0; i < totalHeight; i += scrollStep) {
                jsExecutor.executeScript("window.scrollBy(0, " + scrollStep + ");");
                Thread.sleep(pause);

                // Update height in case of infinite loading/dynamic content
                totalHeight = (long) jsExecutor.executeScript("return document.body.scrollHeight");
            }

            System.out.println("Reached the bottom of the Checklist.");



        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

