package LoanProspect;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class MainTest {
    public static void main(String[] args) throws Exception {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();

        // Login and navigate
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToSystem();

        //Draft Save Page
        DraftSave draftSave = new DraftSave(driver);
        draftSave.validateDraftCreation();

        // Case tab actions
        CaseTab caseTab = new CaseTab(driver);
        caseTab.fillCaseDetails();

        // Loan tab actions
        LoanTab loanTab = new LoanTab(driver);
        loanTab.fillLoanDetails();

        // Document tab actions
        DocumentTab documentTab = new DocumentTab(driver);
        documentTab.fillDocumentDetails();

        // CIB Information tab actions
        CIBInformation CIBInformation = new CIBInformation(driver);
        CIBInformation.fillCIBDetails();

        // Approve tab actions
        Approve Approve = new Approve(driver);
        Approve.fillApproveDetails();

        //Navigate to the created Contract
        Contract Contract = new Contract(driver);
        Contract.fileContractDetails();

        System.out.println("✅ Test completed successfully.");
        // driver.quit();
    }
}
