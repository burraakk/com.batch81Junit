package tasks.automationExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Exercise2 {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    /*
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Delete Account' button
10. Verify that 'ACCOUNT DELETED!' is visible
     */

    @Test
    public void test1(){
        //3. Verify that home page is visible successfully
        String actualTitle = driver.getTitle();
        String expectedTitle = "Automation Exercise";
        Assert.assertTrue(actualTitle.equals(expectedTitle));
    }

    @Test
    public void test2() throws InterruptedException {
        //4. Click on 'Signup / Login' button
        Thread.sleep(2000);
        WebElement signUpButton = driver.findElement(By.xpath("//*[@href='/login']"));
        signUpButton.click();

        //5. Verify 'Login to your account' is visible
        WebElement loginToYourAccount = driver.findElement(By.xpath("//*[text()='Login to your account']"));
        Assert.assertTrue(loginToYourAccount.isDisplayed());
    }

    @Test
    public void test3() throws InterruptedException {
        //6. Enter correct email address and password
        WebElement emailBox = driver.findElement(By.cssSelector("*[data-qa='login-email']"));
        WebElement passwordBox = driver.findElement(By.cssSelector("*[data-qa='login-password']"));
        Thread.sleep(2000);
        emailBox.sendKeys("deneme3@gmail.com");
        Thread.sleep(2000);
        passwordBox.sendKeys("12345");
        Thread.sleep(2000);

        //7. Click 'login' button
        WebElement loginButton = driver.findElement(By.cssSelector("*[data-qa='login-button']"));
        loginButton.click();

        //8. Verify that 'Logged in as username' is visible
        WebElement loggedIn = driver.findElement(By.xpath("//*[text()='Burak']"));
        Assert.assertTrue(loggedIn.isDisplayed());
    }

    @Test
    public void test4() throws InterruptedException {
        //9. Click 'Delete Account' button
        Thread.sleep(2000);
        WebElement deleteButton = driver.findElement(By.xpath("//*[@href='/delete_account']"));
        deleteButton.click();
        Thread.sleep(2000);

        //10. Verify that 'ACCOUNT DELETED!' is visible
    }
}
