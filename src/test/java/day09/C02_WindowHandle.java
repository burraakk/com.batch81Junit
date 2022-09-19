package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WindowHandle {
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
    public void test1(){
        //1- Amazon Sayfasina girelim
        driver.get("https://www.amazon.com");

        //2- Url'nin amazon içerdiğini test edelim
        String actualUrlAmazon = driver.getCurrentUrl();
        String expectedUrlAmazon = "amazon";
        Assert.assertTrue(actualUrlAmazon.contains(expectedUrlAmazon));
        String amazonWindowHandle = driver.getWindowHandle();

        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestbuyWindowHandle = driver.getWindowHandle();

        //4- title'in Best Buy içerdiğini test edelim
        String actualTitleBestbuy = driver.getTitle();
        String expectedTitleBestbuy = "Best Buy";
        Assert.assertTrue(actualTitleBestbuy.contains(expectedTitleBestbuy));

        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("java", Keys.ENTER);

        //6- Arama sonuclarının java içerdiğini test edelim
        WebElement aramaSonucu = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String arananSonuc = "java";
        String actualSonuc = aramaSonucu.getText();
        Assert.assertTrue(actualSonuc.contains(arananSonuc));

        //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestbuyWindowHandle);

        //8- Logonun görünürlüğünü test edelim
        WebElement logo = driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());

        //9- Sayfaları Kapatalım
        driver.quit();
    }
}
