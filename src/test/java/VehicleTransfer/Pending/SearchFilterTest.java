package VehicleTransfer.Pending;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchFilterTest {
    WebDriver driver;

    public SearchFilterTest(WebDriver driver) {
        this.driver = driver;
    }

    public void SearchfilterVerify() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        

    }
}
