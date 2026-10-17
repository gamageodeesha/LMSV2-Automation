import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class broker {
    public static void main(String[] args) throws Exception {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("http://3.1.164.148/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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

        // Scroll & click broker tab
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement brokerTab = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[normalize-space(text())='Broker']")));
        brokerTab.click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addNew = wait1.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(@href,'broker/new')]//div[normalize-space(text())='Add New']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addNew);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(addNew)).click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addNew);
        }*/
        driver.findElement(By.xpath("//*[normalize-space(text())='Broker']")).click();
        driver.findElement(By.xpath("//a[contains(@href,'broker/new')]//div[normalize-space(text())='Add New']")).click();

        driver.findElement(By.xpath("//input[@name='company_name']")).click();
        driver.findElement(By.xpath("//input[@name='company_name']")).clear();
        driver.findElement(By.xpath("//input[@name='company_name']")).sendKeys("ABD");

        driver.findElement(By.xpath("//select[@name='business_type']")).click();
        //driver.findElement(By.xpath("//select[@name='business_type']")).clear();
        driver.findElement(By.xpath("//select[@name='business_type']/option[text()='Finance Institute']")).click();

        driver.findElement(By.xpath("//input[@name='business_type_other']")).click();
        driver.findElement(By.xpath("//input[@name='business_type_other']")).clear();
        driver.findElement(By.xpath("//input[@name='business_type_other']")).sendKeys("testing");

        driver.findElement(By.xpath("//input[@name='first_name']")).click();
        driver.findElement(By.xpath("//input[@name='first_name']")).clear();
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Dinakshi");

        driver.findElement(By.xpath("//input[@name='last_name']")).click();
        driver.findElement(By.xpath("//input[@name='last_name']")).clear();
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Perera");

        driver.findElement(By.xpath("//input[@name='bank_name']")).click();
        driver.findElement(By.xpath("//input[@name='bank_name']")).clear();
        driver.findElement(By.xpath("//input[@name='bank_name']")).sendKeys("BOC");

        driver.findElement(By.xpath("//input[@name='branch']")).click();
        driver.findElement(By.xpath("//input[@name='branch']")).clear();
        driver.findElement(By.xpath("//input[@name='branch']")).sendKeys("Homagama");

        driver.findElement(By.xpath("//input[@name='bank_account_no']")).click();
        driver.findElement(By.xpath("//input[@name='bank_account_no']")).clear();
        driver.findElement(By.xpath("//input[@name='bank_account_no']")).sendKeys("32534534");

        driver.findElement(By.xpath("//input[@name='bank_account_name']")).click();
        driver.findElement(By.xpath("//input[@name='bank_account_name']")).clear();
        driver.findElement(By.xpath("//input[@name='bank_account_name']")).sendKeys("Dinakshi213");

        driver.findElement(By.xpath("//input[@name='contact_no']")).click();
        driver.findElement(By.xpath("//input[@name='contact_no']")).clear();
        driver.findElement(By.xpath("//input[@name='contact_no']")).sendKeys("02094859635");

        driver.findElement(By.xpath("//input[@name='email']")).click();
        driver.findElement(By.xpath("//input[@name='email']")).clear();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test65ppfl@gmail.com");

        driver.findElement(By.xpath("//select[@name='address_province']")).click();
        driver.findElement(By.xpath("//select[@name='address_province']/option[text()='Attapeu - ອັດຕະປື']")).click();

        driver.findElement(By.xpath("//select[@name='address_district']")).click();
        driver.findElement(By.xpath("//select[@name='address_district']/option[text()='Sanamxay - ສະໜາມໄຊ']")).click();

        driver.findElement(By.xpath("//select[@name='address_village']")).click();
        driver.findElement(By.xpath("//select[@name='address_village']/option[text()='B. Bangvilay']")).click();

        driver.findElement(By.xpath("//input[@name='facebook_url']")).click();
        driver.findElement(By.xpath("//input[@name='facebook_url']")).clear();
        driver.findElement(By.xpath("//input[@name='facebook_url']")).sendKeys("https://www.facebook.com/yourpage");

        driver.findElement(By.xpath("//input[@name='whatsapp_url']")).click();
        driver.findElement(By.xpath("//input[@name='whatsapp_url']")).clear();
        driver.findElement(By.xpath("//input[@name='whatsapp_url']")).sendKeys("https://www.whatsp.com/hellow");

        driver.findElement(By.xpath("//input[@name='relationship']")).click();
        driver.findElement(By.xpath("//input[@name='relationship']")).clear();
        driver.findElement(By.xpath("//input[@name='relationship']")).sendKeys("Friend");

        driver.findElement(By.xpath("//input[@name='job']")).click();
        driver.findElement(By.xpath("//input[@name='job']")).clear();
        driver.findElement(By.xpath("//input[@name='job']")).sendKeys("Manager");

        driver.findElement(By.xpath("//input[@name='receive_from']")).click();
        driver.findElement(By.xpath("//input[@name='receive_from']")).clear();
        driver.findElement(By.xpath("//input[@name='receive_from']")).sendKeys("friend");

        driver.findElement(By.xpath("//select[@name='refer_by_type']")).click();
        driver.findElement(By.xpath("//select[@name='refer_by_type']/option[text()='Broker']")).click();

        driver.findElement((By.xpath("//span[text()='Create Broker']"))).click();

        Thread.sleep(5000);

    }
}
