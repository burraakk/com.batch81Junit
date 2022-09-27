package tasks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.List;

public class C06_WebTables extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() {
        //ödev -1
        //“https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //Headers da bulunan department isimlerini yazdirin
        List<WebElement> depColumn = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-td'][6]"));
        depColumn.forEach(t-> System.out.println(t.getText()));

        //sutunun basligini yazdirin

        //Tablodaki tum datalari yazdirin

        //Tabloda kac cell (data) oldugunu yazdirin

        //Tablodaki satir sayisini yazdirin

        //Tablodaki sutun sayisini yazdirin

        //Tablodaki 3.kolonu yazdirin

        //Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin

        //Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini  girdigimde bana datayi yazdirsin

    }
}
