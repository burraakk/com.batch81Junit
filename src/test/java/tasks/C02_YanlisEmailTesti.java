package tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_YanlisEmailTesti {
    // 1.Bir Class olusturalimYanlisEmailTesti
// 2.http://automationpractice.com/index.php sayfasinagidelim
// 3.Sign in butonunabasalim
// 4.Email kutusuna @isareti olmayan bir mail yazipenter'a
// bastigimizda "Invalid email address" uyarisi ciktigini testedelim

    static WebDriver driver;;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        //Sign in butonunabasalim
        Thread.sleep(1000);
        WebElement signInButton = driver.findElement(By.xpath("//*[@class='login']"));
        signInButton.click();

        //Email kutusuna @isareti olmayan bir mail yazip enter'a
        //bastigimizda "Invalid email address" uyarisi ciktigini testedelim
        Thread.sleep(1000);
        WebElement emailBox = driver.findElement(By.xpath("//*[@id='email_create']"));
        emailBox.sendKeys("burak.gmail.com", Keys.ENTER);

        WebElement invalidEmailAddressError = driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        Assert.assertTrue(invalidEmailAddressError.isDisplayed());
        Thread.sleep(1000);

    }
}
