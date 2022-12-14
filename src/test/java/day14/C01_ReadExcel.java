package day14;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void test1() throws IOException {
        //- Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);  // Oluşturmuş olduğumuz dosyayı sistemde işleme alır

        //- Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //- WorkbookFactory.create(fileInputStream)  // Workbook objesiyle fis objesiyle akişa aldigimiz dosyamiza bir excel
        Workbook workbook = WorkbookFactory.create(fis);

        //- Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet = workbook.getSheet("Sayfa1"); // excel dosyasında calısmak istediğimiz sayfayı sectik

        //- Row objesi olusturun sheet.getRow(index)
        Row row = sheet.getRow(3); //Sayfa1'deki 3. satırı bu şekilde seçerim

        //- Cell objesi olusturun row.getCell(index)
        Cell cell = row.getCell(3); //Satir secimi yapıldıktan sonra hücre seçimi bu şekilde yapılır
        System.out.println("Cell : " + cell);

        //- 3. index'deki satirin 3. index'indeki datanin Cezayir oldugunu test edin
        String expectedData = "Cezayir";
        String actualData = cell.toString();
        Assert.assertEquals(expectedData, actualData);

        for (int i = 0; i <=0 ; i++) {
            for (int j = 0; j < 4 ; j++) {
                System.out.print(workbook.getSheet("Sayfa1").getRow(9).getCell(j).toString()+ " ");
            }
        }

    }
}
