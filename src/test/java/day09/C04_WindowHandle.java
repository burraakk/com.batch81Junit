package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C04_WindowHandle {
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        Thread.sleep(2000);

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Opening a new window']")).isDisplayed());

        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

        //Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        List<String> windowList = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));

        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertEquals(driver.getTitle(),"New Window");

        //Sayfadaki textin “New Window” olduğunu doğrulayın.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='example']")).getText().equals("New Window"));

        //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        Thread.sleep(2000);
        driver.switchTo().window(windowList.get(0));
        Assert.assertEquals(driver.getTitle(), "The Internet");
        Thread.sleep(2000);


    }
}
