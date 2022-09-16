package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {
    /*
          ●https://www.amazon.com/ adresinegidin.
          -Test1
          Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
          oldugunu testedin
          -Test2
          1.Kategori menusunden Books seceneginisecin
          2.Arama kutusuna Java yazin vearatin
          3.Bulunan sonuc sayisiniyazdirin
          4.Sonucun Java kelimesini icerdigini testedin
*/
    static WebDriver driver;
    Select select;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test1() {
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu testedin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select = new Select(ddm);
        /*
        DropDown menuye ulasmak icin select class'indan bir obje olustururuz
        ve locate ettigimiz dropdown webelement'inin select class'ina tanimlariz
        ve getOption methodunu kullanarak dropdown'u bir liste atarak dropdown menunun
        butun elemanlarının sayısına ulasabiliriz
         */
        List<WebElement> ddmList = select.getOptions();
        System.out.println(ddmList.size());
        int expectedSayi = 45;
        int actualDdm = ddmList.size();
        Assert.assertNotEquals(expectedSayi,actualDdm);

    }

    @Test
    public void test2() {
        //          1.Kategori menusunden Books secenegini secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select = new Select(ddm);
        //select.selectByVisibleText("Books");
        //select.selectByIndex(5);
        select.selectByValue("search-alias=stripbooks-intl-ship");

        System.out.println("--->"+select.getFirstSelectedOption().getText());

        //          2.Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

        //          3.Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi  = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisi.getText());

        //          4.Sonucun Java kelimesini icerdigini test edin
        String expectedKelime = "Java";
        String actualSonucYazisi = sonucYazisi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));


    }


}
