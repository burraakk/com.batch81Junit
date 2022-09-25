package tasks;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.ArrayList;
import java.util.List;

public class C08_WebTables extends TestBaseBeforeClassAfterClass {
    @Test
    public void test() {

        //login( ) metodun oluşturun ve oturum açın.
        login();

        //table( ) metodu oluşturun
        table();

        //printRows( ) metodu oluşturun
        printRows();

        //printCells( ) metodu oluşturun
        printCells();

        //printColumns( ) metodu oluşturun
        printColumns();

    }

    private void printColumns() {
        //table body’sinde bulunan toplam sutun(column) sayısını bulun.
        List<WebElement> columnList = driver.findElements(By.xpath("//thead//tr//th"));
        int columnSize = columnList.size();
        System.out.println("\ncolumnSize = " + columnSize);

        //Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        WebElement columns = driver.findElement(By.xpath("//thead//tr"));
        System.out.println("\nHeaders\n" + columns.getText());

        //5.column daki elementleri konsolda yazdırın.
        List<WebElement> column5 = driver.findElements(By.xpath("//tbody//td[5]"));
        System.out.println("\n-----COLUM-5-----");
        column5.forEach(t-> System.out.println(t.getText()));

    }

    private void printCells() {
        //table//td body’sinde bulunan toplam hücre(cell) sayısını bulun.
        List<WebElement> cellList = driver.findElements(By.xpath("//tbody//td"));
        int cellCount = cellList.size();
        System.out.println("\ncellCount = " + cellCount + "\n");

        //Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        List<String> allCells = List.of(driver.findElement(By.xpath("//tbody")).getText());
        System.out.println("--------TUM HUCRELER--------");
        allCells.forEach(t-> System.out.print(t+" "));
        System.out.println("\n");

    }

    private void printRows() {
        //table//tr body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> rowList = driver.findElements(By.xpath("//tbody//tr"));
        int rowSize = rowList.size();

        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        System.out.println("\nAll Rows");
        rowList.forEach(t-> System.out.println(t.getText()));

        //4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println("\nRow 4");
        WebElement row4 = driver.findElement(By.xpath("//tbody//tr[4]"));
        System.out.println(row4.getText());
    }

    private void table() {

        //Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> columnList = driver.findElements(By.xpath("//table//thead//tr//th"));
        int columnSize = columnList.size();
        System.out.println("columnSize = " + columnSize);

        //Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        WebElement headers = driver.findElement(By.xpath("//thead//tr"));
        System.out.println("\nBasliklar\n" + headers.getText());
        WebElement body = driver.findElement(By.xpath("//tbody"));
        System.out.println("\n-----Tum Body-----\n" + body.getText());
    }

    private void login() {

        //https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
        driver.get("https://qa-environment.concorthotel.com/admin/HotelRoomAdmin");
        driver.findElement(By.xpath("//*[@id='details-button']")).click();
        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();

        //Username : manager  ○ Password : Manager1!
        driver.findElement(By.xpath("//*[@id='UserName']")).sendKeys("manager");
        actions.sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();
    }
}
