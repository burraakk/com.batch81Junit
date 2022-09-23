package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.List;

public class C02_WebTables extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() {
        //login( ) metodun oluşturun ve oturum açın.
        login();

        //table( ) metodu oluşturun
        table();

        //printRows( ) metodu oluşturun
        printRows();

    }

    private void printRows() {
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirList = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir Sayisi : "  + satirList.size());

        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        //System.out.println(driver.findElement(By.xpath("//tbody")).getText());
        satirList.forEach(t-> System.out.println(t.getText())); //lambda ile

        //4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println("4. satir :\n" + driver.findElement(By.xpath("//tbody//tr[4]")).getText());

        System.out.print("4.row elements lambda : ");   //lambda ile
        satirList.stream().map(WebElement::getText).limit(4).skip(3).forEach(System.out::println);

    }

    private void table() {
        //Tüm table body’sinin boyutunu(sutun sayisi) bulun.
        List<WebElement> sutunList = driver.findElements(By.xpath("//thead//tr//th"));
        System.out.println("Sutun Sayisi : " + sutunList.size());

        //Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        WebElement basliklar = driver.findElement(By.xpath("//thead//tr"));
        System.out.println("Basliklar : " + basliklar.getText());
        WebElement body = driver.findElement(By.xpath("//tbody"));
        System.out.println("Tum Body :\n" + body.getText());

    }

    private void login() {
        //https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin
        //Username : manager
        //Password : Manager1!
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        WebElement userNameBox = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userNameBox).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).perform();

    }
}
