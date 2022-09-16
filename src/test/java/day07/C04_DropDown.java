package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04_DropDown {
    /*Bir class oluşturun: DropDown
    https://the-internet.herokuapp.com/dropdown adresine gidin.
    Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    Tüm dropdown değerleri(value) yazdırın
    Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    False yazdırın.
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        //    Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm = driver.findElement(By.xpath("//*[@id='dropdown']"));
        Select options = new Select(ddm);
        Thread.sleep(1000);
        options.selectByIndex(1);
        System.out.println(options.getFirstSelectedOption().getText());

        //    Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        Thread.sleep(1000);
        options.selectByValue("2");
        System.out.println(options.getFirstSelectedOption().getText());

        //    Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        Thread.sleep(1000);
        options.selectByVisibleText("Option 1");
        System.out.println(options.getFirstSelectedOption().getText());

        //    Tüm dropdown değerleri(value) yazdırın
        List<WebElement> ddmList = options.getOptions();
        for (WebElement each : ddmList) {
            System.out.println(each.getText());
        }

        //    Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        int ddmListSize = ddmList.size();
        int expectedSize = 4;
        if (ddmListSize==expectedSize){
            System.out.println("True");
        }else
            System.out.println("False");

    }

}
