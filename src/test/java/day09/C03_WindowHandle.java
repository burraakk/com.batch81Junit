package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WindowHandle {
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
        //Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");

        //Sayfa’nin window handle degerini String bir degiskene atayin
        String amazonWH = driver.getWindowHandle();

        //Sayfa title’nin “Amazon” icerdigini test edin
        String actualTitleAmazon = driver.getTitle();
        String expectedTitleAmazon = "Amazon";
        Assert.assertTrue(actualTitleAmazon.contains(expectedTitleAmazon));

        //Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        Thread.sleep(2000);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.techproeducation.com");

        //Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String actualTitleTechPro = driver.getTitle();
        String expectedTitleTechPro = "TECHPROEDUCATION";
        Assert.assertFalse(actualTitleTechPro.contains(expectedTitleTechPro));

        //Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        Thread.sleep(2000);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");

        //Sayfa title’nin “Walmart” icerdigini test edin
        String actualTitleWalmart = driver.getTitle();
        String expectedTitleWalmart = "Walmart";
        Assert.assertTrue(actualTitleWalmart.contains(expectedTitleWalmart));

        //Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        Thread.sleep(2000);
        driver.switchTo().window(amazonWH);
        String actualUrl = driver.getCurrentUrl();
        String exceptedUrl = "https://www.amazon.com/";
        Assert.assertTrue(actualUrl.equals(exceptedUrl));
        Thread.sleep(2000);

    }
}
