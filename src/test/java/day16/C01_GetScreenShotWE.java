package day16;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBaseBeforeClassAfterClass;

import java.io.File;
import java.io.IOException;

public class C01_GetScreenShotWE extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() throws IOException {
        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        //Nutella aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);

        //Arama sonuc yazisinin resmini alalim
        WebElement searchResult = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        File nutellaSearchResult = searchResult.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(nutellaSearchResult,new File("target/ekranGoruntusu/searchResultSS.jpeg"));

        // sadece webelementin resmini alacaksak TakeScreenShot class'ini kullanmama gerek yok
        // locate ettigimiz webelementi direk gecici bir file'a atip FileUtils ile kopyalayip
        // yolunu (path) belirtiriz

        // Belirli bölgelerin ekran görüntüsünü almak istersek o bölgeyi locate etmek gerekir.
        // Aynı zamanda belirli bölgeyi çekmek istediğimizde alttaki objeyi oluşturmaya gerek yok ! Arasındaki tek fark bu !
        // TakesScreenshot ts= (TakesScreenshot) driver;

        // WebElement'in screenshot'ını alırken, tüm sayfanınkini alırken yaptığımız
        // TakeScreenShot class'ından obje üretme işlemini yapmıyoruz.
        // Bunun yerine locate'ini aldığımız WebElement üzerinden
        // getScreenshot method'unu çalıştırıyoruz



    }
}
