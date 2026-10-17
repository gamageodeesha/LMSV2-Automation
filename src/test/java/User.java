import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Random;

public class User {
    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = WebDriverManager.chromedriver().create();
        //Thread.sleep(50000);
        driver.manage().window().maximize();
        // Thread.sleep(2000);
        driver.get("http://3.1.164.148/");
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

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
        //Thread.sleep(2000);

        //driver.findElement(By.xpath("//div[text()='Users']")).click();
        driver.findElement(By.xpath("//*[text()='Users']")).click();
        //Thread.sleep(2000);

        //LIST ALL PAGE
        //driver.findElement(By.xpath("//*[text()='List All']")).click();
        //Thread.sleep(2000);


        // Generate random values
        Random random = new Random();
        int randomNum = random.nextInt(10000); // 0-9999
        //String timestamp = String.valueOf(System.currentTimeMillis());

        //Define some sample first/last names
        String[] firstNames = {"Chethana", "Kavya", "Anjali", "Ramesh", "Nimal", "Sanjay", "Priya"};
        String[] lastNames  = {"Hasini", "Perera", "Fernando", "Silva", "Kumara", "Raj", "Senanayake"};

        //Pick a random first/last name from the list and append a random number for uniqueness
        String firstName = firstNames[random.nextInt(firstNames.length)] + randomNum;
        String lastName  = lastNames[random.nextInt(lastNames.length)] + randomNum;
        String userName  = firstName.toLowerCase() + lastName.toLowerCase() + System.currentTimeMillis();
        String nickName  = firstName.toLowerCase();
        String email     = firstName.toLowerCase() + randomNum + "@gmail.com";
        String staffNo   = "STAFF" + randomNum;

        /*String firstName = "Chethana" + randomNum;
        String lastName = "Hasini" + randomNum;
        String userName = "Chethanahasini" + System.currentTimeMillis();
        String nickName = "chethana" + randomNum;
        String email = "chethana" + randomNum + "@gmail.com";
        String staffNo = "STAFF" + randomNum;
        //String phoneNo = "0209" + (100000 + random.nextInt(900000));*/
        String phoneNo = generateValidPhoneNumber(random);

        // ADD USER
        driver.findElement(By.xpath("//*[text()='Add User']")).click();

        // First Name
        driver.findElement(By.xpath("//*[@name='first_name']")).click();
        driver.findElement(By.xpath("//*[@name='first_name']")).clear();
        driver.findElement(By.xpath("//*[@name='first_name']")).sendKeys(firstName);

        // Last Name
        driver.findElement(By.xpath("//*[@name='last_name']")).click();
        driver.findElement(By.xpath("//*[@name='last_name']")).clear();
        driver.findElement(By.xpath("//*[@name='last_name']")).sendKeys(lastName);

        // User Name
        driver.findElement(By.xpath("//*[@name='username']")).click();
        driver.findElement(By.xpath("//*[@name='username']")).clear();
        driver.findElement(By.xpath("//*[@name='username']")).sendKeys(userName);

        // Nick Name
        driver.findElement(By.xpath("//*[@name='nickname']")).click();
        driver.findElement(By.xpath("//*[@name='nickname']")).clear();
        driver.findElement(By.xpath("//*[@name='nickname']")).sendKeys(nickName);

        // Email
        driver.findElement(By.xpath("//*[@name='email']")).click();
        driver.findElement(By.xpath("//*[@name='email']")).clear();
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys(email);

        // Staff No
        driver.findElement(By.xpath("//*[@name='staff_no']")).click();
        driver.findElement(By.xpath("//*[@name='staff_no']")).clear();
        driver.findElement(By.xpath("//*[@name='staff_no']")).sendKeys(staffNo);

        // Phone No
        driver.findElement(By.xpath("//*[@name='phone_no']")).click();
        driver.findElement(By.xpath("//*[@name='phone_no']")).clear();
        driver.findElement(By.xpath("//*[@name='phone_no']")).sendKeys(phoneNo);

        //Department
        driver.findElement(By.xpath("//span[text()='Departments']")).click();
        driver.findElement(By.xpath("//li[./descendant::span[text()='accounts']]//input[@type='checkbox']")).click();

        //Groups
        WebElement element = driver.findElement(By.xpath("//span[text()='Groups']"));
        // Create an Actions object, passing in the WebDriver instance
        Actions actions = new Actions(driver);
        //Perform the double-click action
        actions.doubleClick(element).perform();
        driver.findElement(By.xpath("//span[text()='Groups']")).click();
        driver.findElement(By.xpath("//li[./descendant::span[text()='Sales']]//input[@type='checkbox']")).click();

        //Status
        WebElement element1 = driver.findElement(By.xpath("//input[@name='status']"));
        // Create an Actions object, passing in the WebDriver instance
        Actions actions1 = new Actions(driver);
        //Perform the double-click action
        actions1.doubleClick(element1).perform();
        driver.findElement(By.xpath("//input[@name='status']")).click();
        //create user
        driver.findElement(By.xpath("//span[text()='Create User']")).click();


        //Edit Page
        driver.findElement(By.xpath("//tr[1]//a[@aria-label='Edit User Details']")).click();

        driver.findElement(By.xpath("//*[@name='first_name']")).click();
        driver.findElement(By.xpath("//*[@name='first_name']")).clear();
        driver.findElement(By.xpath("//*[@name='first_name']")).sendKeys("Nadeesha");

        driver.findElement(By.xpath("//span[text()='Update User']")).click();

        //status change -->Activate or deactivate
        driver.findElement(By.xpath("//*[@name='status']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Cancel']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@name='status']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Ok']")).click();
        Thread.sleep(1000);
        //pagination
        //driver.findElement(By.xpath("//*[@class='navigationActive']/a[text()='2']")).click();

        //search text
        driver.findElement(By.xpath("//input[@placeholder='Search users']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search users']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Search users']")).sendKeys("Amadi");
        driver.findElement(By.xpath("//input[@placeholder='Search users']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search users']")).clear();
        //driver.findElement(By.xpath("//input[@placeholder='Search users']")).sendKeys("Odeesha");

        //search drop down
        //driver.findElement(By.xpath("//*[@name='sort']")).click();
        //driver.findElement(By.xpath("//option[text()='Last update (newest)']")).click();

        Thread.sleep(5000);


    }
    //Helper method to generate a valid phone number
    private static String generateValidPhoneNumber(Random random) {
        int formatType = random.nextInt(3) + 1; // 1..3

        switch (formatType) {
            case 1: {
                // 020 + [2,5,7,8,9] + 7 digits -> 11 digits
                int[] validSecond = {2, 5, 7, 8, 9};
                int second = validSecond[random.nextInt(validSecond.length)];
                String last7 = String.format("%07d", random.nextInt(10_000_000));
                return "020" + second + last7;
            }
            case 2: {
                // 030 + [2,4,5,7,9] + 6 digits -> 10 digits
                int[] validSecond = {2, 4, 5, 7, 9};
                int second = validSecond[random.nextInt(validSecond.length)];
                String last6 = String.format("%06d", random.nextInt(1_000_000));
                return "030" + second + last6;
            }
            case 3: {
                // 0 + [21,23,31,34,36,38,41,51,54,61,64,71,74,81,84,86,88] + [2,3,4,7] + 5 digits -> 9 digits
                int[] validFirst = {21,23,31,34,36,38,41,51,54,61,64,71,74,81,84,86,88};
                int[] validSecond = {2,3,4,7};
                int first = validFirst[random.nextInt(validFirst.length)];
                int second = validSecond[random.nextInt(validSecond.length)];
                String last5 = String.format("%05d", random.nextInt(100_000));
                return "0" + first + second + last5;
            }
            default:
                // fallback (should never hit)
                return "0202" + String.format("%07d", 0);
        }
    }

}