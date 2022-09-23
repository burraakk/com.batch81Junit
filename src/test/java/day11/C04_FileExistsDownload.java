package day11;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeClassAfterClass;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExistsDownload extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() {
        /*
        System.out.println(System.getProperty("user.dir"));  // C:\Users\burak\IdeaProjects\com.batch81JUnit
        //Şu an içinde bulunduğum yolu gösterir

        System.out.println(System.getProperty("user.home")); //C:\Users\burak
        //Geçerli kullanıcının ana dizini verir

        String farkliBolum = System.getProperty("user.home");
        //"C:\Users\burak\OneDrive\Masaüstü\selenium not.txt"  --> masaüstündeki dosyanin yolu
        String ortakBolum = "OneDrive\\Masaüstü\\selenium not.txt";

        String masaustuDosyaYolu = farkliBolum + ortakBolum;  //Masaüstündeki dosya yolunu gösterir

        System.out.println(masaustuDosyaYolu); //C:\Users\burakOneDrive\Masaüstü\selenium not.txt
        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyaYolu)));
        System.out.println(Files.exists(Paths.get(masaustuDosyaYolu)));

         */

        String dosyaYolu = "C:\\Users\\burak\\OneDrive\\Masaüstü\\selenium not.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // bir web sitesinden indirdiğimiz yada windows içinde oluşturduğumuz dosyanın indiğini yada
        // orda olduğunu test edebilmem için o dosyanın üzerine shift tuşuna basılı olarak sağ click
        // yapıp dosyanın yolunu kopyalayıp bir String değişkene atarız ve dosyayı doğrulamak için
        // Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); bu methodu kullanirim

    }
}
