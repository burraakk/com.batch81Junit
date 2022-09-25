package day14;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void test1() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String filePath = "src/resources/ulkeler.xlsx";

        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(filePath);

        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(0);

        //-Sayfa1'ye gidip satir sayisinin 191, kullanilan satir sayisinin ise 4 oldugunu test edin
        int lastRow = sheet.getLastRowNum(); //  workbook.getSheet("Sayfa1").getLastRowNum();
        int lastColumn = row.getLastCellNum(); //  workbook.getSheet("Sayfa1").getRow(0).getLastCellNum();
        System.out.println(lastColumn + " " + lastRow);
        Assert.assertEquals(191, lastRow + 1);
        Assert.assertEquals(4, lastColumn);


    }
}
