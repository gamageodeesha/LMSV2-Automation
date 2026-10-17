package VehicleTransfer;

import VehicleTransfer.Pending.SubmitForm;
import VehicleTransfer.Pending.PaginationTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class MainTestVehicleTransfer {
    public static void main(String[] args) throws Exception {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        // Login and navigate
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToSystem();

        // Pending Page
        SubmitForm pendingPage = new SubmitForm(driver);
        pendingPage.fillPendingPage();

        Thread.sleep(2000);

        // Verify validation messages
        pendingPage.verifyDateAndDeadlineValidationMessages();

        //Verify data fill
        pendingPage.fillFieldsAndUpdate();

        //Verify Cancel button
        pendingPage.clickCloseButtonAndVerify();

        //Verify Pagination
        PaginationTest pagination = new PaginationTest(driver);  // create instance
        pagination.clickNextAndVerify();

        System.out.println("✅ Test completed successfully.");
        driver.quit();
    }
}