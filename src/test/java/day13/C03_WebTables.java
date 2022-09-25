package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.List;

public class C03_WebTables extends TestBaseBeforeClassAfterClass {
    @Test
    public void test() {
        //Bir önceki class'daki adrese gidelim
        //Login() methodunu kullanarak sayfaya giriş yapalım
        login();

        //input olarak verilen satır sayısı ve sutun sayısına sahip cell'deki text'i yazdıralım
        int satir = 3;
        int sutun = 4;
        WebElement cell = driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println("İstenen Hucre : " + cell.getText());

        //Price basligindaki tüm satirlari yazdiriniz
        List<WebElement> priceColumn = driver.findElements(By.xpath("//tbody//tr//td[6]"));
        priceColumn.forEach(t-> System.out.println(t.getText()));

    }

    private void login() {
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        WebElement userNameBox = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userNameBox).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).perform();
    }


}
