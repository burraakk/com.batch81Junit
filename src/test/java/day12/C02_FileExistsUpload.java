package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;

public class C02_FileExistsUpload extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));

        //Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = "C:\\Users\\burak\\Downloads\\test.txt";
        dosyaSec.sendKeys(dosyaYolu);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

    }
}
