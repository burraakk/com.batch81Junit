package tasks.automationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Exercise01 {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test1() throws InterruptedException {

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        String actualTitle = driver.getTitle();
        String expectedTitle = "Automation Exercise";

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Home Page is visible. Test PASSED");
        }else
            System.out.println("Home Page is not visible. Test FAILED. Actual Title : " + actualTitle );

        //4. Click on 'Signup / Login' button
        WebElement signUpLoginButton = driver.findElement(By.xpath("//*[@href='/login']"));
        signUpLoginButton.click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUserSignupButton = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        if (newUserSignupButton.isDisplayed()){
            System.out.println("New User Signup Button is visible. Test PASSED");
        }else
            System.out.println("New User Signup Button is not visible. Test FAILED");

        //6. Enter name and email address
        WebElement nameBox = driver.findElement(By.xpath("//*[@data-qa='signup-name']"));
        WebElement emailBox = driver.findElement(By.xpath("//*[@data-qa='signup-email']"));
        Thread.sleep(250);
        nameBox.sendKeys("Burak");
        Thread.sleep(250);
        emailBox.sendKeys("enesyildizz90@gmail.com");

        //7. Click 'Signup' button
        WebElement signUpButton = driver.findElement(By.xpath("//*[@data-qa='signup-button']"));
        Thread.sleep(250);
        signUpButton.click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInfo = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        if (enterAccountInfo.isDisplayed()){
            System.out.println("ENTER ACCOUNT INFORMATION is visible. Test PASSED");
        }else
            System.out.println("ENTER ACCOUNT INFORMATION is not visible. Test FAILED");

        //9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement titleMr = driver.findElement(By.xpath("//*[@value='Mr']"));
        WebElement nameBoxSignUpPage = driver.findElement(By.xpath("//*[@data-qa='name']"));
        WebElement emailBoxSignUpPage = driver.findElement(By.xpath("//*[@data-qa='email']"));
        WebElement passwordSignUpPage = driver.findElement(By.xpath("//*[@data-qa='password']"));
        WebElement dayBox = driver.findElement(By.xpath("//*[@id='days']"));
        WebElement monthBox = driver.findElement(By.xpath("//*[@id='months']"));
        WebElement yearBox = driver.findElement(By.xpath("//*[@id='years']"));

        Thread.sleep(250);
        titleMr.click();
        Thread.sleep(250);
        passwordSignUpPage.sendKeys("12345");
        Thread.sleep(250);
        dayBox.sendKeys("17");
        Thread.sleep(250);
        monthBox.sendKeys("April");
        Thread.sleep(250);
        yearBox.sendKeys("1995");

        //10. Select checkbox 'Sign up for our newsletter!'
        Thread.sleep(250);
        driver.findElement(By.name("newsletter")).click();

        //11. Select checkbox 'Receive special offers from our partners!'
        Thread.sleep(250);
        driver.findElement(By.xpath("//*[@id='optin']")).click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        Thread.sleep(250);
        driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys("Burak");
        Thread.sleep(250);
        driver.findElement(By.xpath("//*[@id='last_name']")).sendKeys("ÖZ");
        Thread.sleep(250);
        driver.findElement(By.xpath("//*[@id='company']")).sendKeys("TechPro");
        Thread.sleep(250);
        driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("Yıldız Mah. Güneş Sok.");
        Thread.sleep(250);
        driver.findElement(By.xpath("//*[@id='address2']")).sendKeys("TechPro A.Ş.");
        Thread.sleep(250);
        driver.findElement(By.xpath("//*[@id='country']")).sendKeys("n");
        Thread.sleep(250);
        driver.findElement(By.xpath("//*[@id='state']")).sendKeys("Trakya");
        Thread.sleep(250);
        driver.findElement(By.xpath("//*[@id='city']")).sendKeys("Kırklareli");
        Thread.sleep(250);
        driver.findElement(By.xpath("//*[@id='zipcode']")).sendKeys("39100");
        Thread.sleep(250);
        driver.findElement(By.xpath("//*[@id='mobile_number']")).sendKeys("5554443322");

        //13. Click 'Create Account button'
        Thread.sleep(250);
        driver.findElement(By.xpath("//*[@data-qa='create-account']")).click();

        //14. Verify that 'ACCOUNT CREATED!' is visible

        //15. Click 'Continue' button

        //16. Verify that 'Logged in as username' is visible

        //17. Click 'Delete Account' button

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

    }




}
