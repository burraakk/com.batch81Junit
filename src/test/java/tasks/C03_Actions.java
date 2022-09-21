package tasks;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeClassAfterClass;

public class C03_Actions extends TestBaseBeforeClassAfterClass {


    @Test
    public void test() {
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin  2- Hover over Me First" kutusunun ustune gelin
        driver.get("http://webdriveruniversity.com/Actions");

        //Link 1" e tiklayin
        driver.findElement(By.xpath("//a[1]")).click();

        //Popup mesajini yazdirin

        //Popup'i tamam diyerek kapatin

        //“Click and hold" kutusuna basili tutun

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin

        //8- “Double click me" butonunu cift tiklayin

    }
}
