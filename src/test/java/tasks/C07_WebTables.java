package tasks;

import org.junit.Test;
import utilities.TestBaseBeforeClassAfterClass;

public class C07_WebTables extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() {

        //Bir metod oluşturun : printData(int row, int column);
        //Baska bir Test metodu oluşturun: printDataTest( );
        printDataTest();

        //yazdirilan datanin olmasi gereken dataya esit oldugunu test edin


    }

    private void printDataTest() {
        //Ve bu metodu printData( ) methodunu cagirmak icin kullanin.
        printdata(3,5);
    }

    private void printdata(int row, int column) {
        //Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu hücredeki(cell) veriyi yazdırmalıdır.
        //Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır

    }
}
