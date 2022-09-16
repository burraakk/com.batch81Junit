package day06;

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

public class C02_Assertion {

    // Not : BeforeAfter methodunda testleri farklı sayfalarda açıp kapatıyor,
    // BeforeAfterCLass methodlarında aynı sayfada açıp sonra kapatıyor.
    // BeforeAfter methodunda methodların static yapmaya gerek yok ama
    // BeforeAfterCLass'da static yapmak zorunlu.

    //assertTrue
    //beklenen bir sonucun true olduğunun kabul edilmesi gerektiği zaman kullanılır.
    // Parametre olarak iki değer alır.
    // İlk parametre de bir mesaj gönderilir ikinci parametrede ise gönderilen mesajın doğruluğu için koşul belirlenir.
    //assertFalse
    //beklenen bir sonucun false olması durumunda kullanılır.
    // İki parametre alır. Parametrelerden biri mesajdır diğeri ise koşuldur.
    // assertFalse ile koşul yerine getirilmez ise assertionError hatası fırlatır.

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");

    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test1(){
        //- url'in "amazon" icergini test et
        String expectedURL = "amazon";
        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedURL));
    }

    @Test
    public void test2(){
        //- title'in "facebook" icermedigini test et
        String expectedTitle = "facebook";
        String actualTitle = driver.getTitle();
        Assert.assertFalse("Title facebook icermiyor",actualTitle.contains(expectedTitle));

    }

    @Test
    public void test3(){
        //- sol ust kosede amazon logosunun gorundugunu test et
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue("Kösede amazon logosu var",logo.isDisplayed());

    }

    @Test
    public void test4(){
        //URL nin www.facebook.com oldugunu test edin
        String exceptedUrl = "http://www.facebook.com";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("URL www.facebook.com degil", exceptedUrl, actualUrl);
    }



}
