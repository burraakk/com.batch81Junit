package day08.day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeClassAfterClass;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C05 extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1(){

        //https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //test.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[@href='download/test.txt']")).click();

        //Ardından dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = "C:\\Users\\burak\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //İndirildigini dosyada gösterin
        System.out.println(Files.exists(Paths.get(dosyaYolu)));

    }
}
