package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BasicAuthentication {
    /*
    https://the-internet.herokuapp.com/basic_auth sayfasina gidin
asagidaki yontem ve test datalarini kullanarak authentication’i yapin
Html komutu : https://username:password@URL
Username    : admin
password    : admin
Basarili sekilde sayfaya girildigini dogrulayin
     */

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
        //driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/basic_auth");
        Thread.sleep(2000);

        //https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        //asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //Html komutu : https://username:password@URL
        //Username    : admin
        //password    : admin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //Basarili sekilde sayfaya girildigini dogrulayin
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
    }


}
