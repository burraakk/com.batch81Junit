package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeClassAfterClass;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_GetScreenShot extends TestBaseBeforeClassAfterClass {
    @Test
    public void test() throws IOException {
        //Amazona gidip tüm saayfanın screenshot'ını alın
        driver.get("https://hepsiburada.com");

        /*
        Bir web sayfanin resmini alabilmek icin TakesScreenshot class'indan obje olusturup
        gecici bir File class'indan degiskene TakesScreenShot'tan olusturdugum obje'den
        tss.getScreenshotAs method'unu kullanarak gecici bir file olustururuz
         */

        TakesScreenshot ts = (TakesScreenshot) driver;
        File tumSayfaResmi = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmi, new File("target/ekranGoruntusu/"+driver.getTitle()+tarih+".jpeg"));

        //resmi resmin uzerine degil de yeni bir resim olarak alabilmek icin image ismine tarih ekleyip atadik
        //tarih in normal formati dosya isimlendirmeye uygun olmadigi icin tarih yazim formati ile oynayip uygun hale getirdik
        //sonra bu sekil bize her zaman lazim olabilir diye TestDataBase imize attik


    }
}
