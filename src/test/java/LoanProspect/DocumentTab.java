package LoanProspect;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DocumentTab {
    WebDriver driver;

    public DocumentTab(WebDriver driver) {
        this.driver = driver;
    }

    public void fillDocumentDetails() throws Exception {
        WebElement DocumentTab = driver.findElement(By.xpath("//*[normalize-space(text())='Documentation / ເອກະສານທີ່ກ່ຽຂ້ອງ']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DocumentTab);
        DocumentTab.click();

        //Customer Family Book
        WebElement uploadField0 = driver.findElement(By.xpath("(//input[contains(@title, 'Customer Family Book.')])[1]"));
        uploadField0.sendKeys("C:\\Users\\odees\\OneDrive\\Pictures\\Screenshots\\district.png");

        //Customer ID Card
        WebElement uploadField1 = driver.findElement(By.xpath("//input[contains(@title, 'Customer ID Card.')]"));
        uploadField1.sendKeys("C:\\Users\\odees\\OneDrive\\Pictures\\Screenshots\\Overlap.png");

        //Village Head
       /* WebElement uploadField2 = driver.findElement(By.xpath("//span[normalize-space()='Village Head File']/following::input[@type='file'][1]"));
        uploadField2.sendKeys("C:\\Users\\odees\\OneDrive\\Pictures\\Screenshots\\overlapping.png");
*/
        //Accounts Receivable Documents
        WebElement uploadField3 = driver.findElement(By.xpath("//input[contains(@title, 'Accounts Receivable Documents For Customer.')]"));
        uploadField3.sendKeys("C:\\Users\\odees\\OneDrive\\Pictures\\Screenshots\\date.png");

        //Questionnaire Form
        WebElement uploadField4 = driver.findElement(By.xpath("//input[contains(@title, 'Questionnaire Form.')]"));
        uploadField4.sendKeys("C:\\Users\\odees\\OneDrive\\Pictures\\Screenshots\\date.png");

        //Real Estate Documents
        WebElement uploadField5 = driver.findElement(By.xpath("//input[contains(@title, 'Real Estate Documents Of Customer.')]"));
        uploadField5.sendKeys("C:\\Users\\odees\\OneDrive\\Pictures\\Screenshots\\popup1.png");

        //Other Documents
        WebElement uploadField6 = driver.findElement(By.xpath("//input[contains(@title, 'Other (Picture of appearance of home or shop).')]"));
        uploadField6.sendKeys("C:\\Users\\odees\\OneDrive\\Pictures\\Screenshots\\district.png");

        //Guarantor Family Book
        WebElement uploadField7 = driver.findElement(By.xpath("//input[contains(@title, 'Guarantor Family Book.')]"));
        uploadField7.sendKeys("C:\\Users\\odees\\OneDrive\\Pictures\\Screenshots\\district.png");





        Thread.sleep(5000);

    }


}
