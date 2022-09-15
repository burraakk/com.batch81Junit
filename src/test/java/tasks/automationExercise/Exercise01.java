package tasks.automationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
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
    public void test1(){

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
        //7. Click 'Signup' button
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        //9. Fill details: Title, Name, Email, Password, Date of birth
        //10. Select checkbox 'Sign up for our newsletter!'
        //11. Select checkbox 'Receive special offers from our partners!'
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //13. Click 'Create Account button'
        //14. Verify that 'ACCOUNT CREATED!' is visible
        //15. Click 'Continue' button
        //16. Verify that 'Logged in as username' is visible
        //17. Click 'Delete Account' button
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

    }




}
