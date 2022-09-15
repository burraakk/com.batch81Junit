package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //    1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com");

        //    2- arama kutusunu locate edelim
        WebElement seachBox = driver.findElement(By.id("twotabsearchtextbox"));

        //    3- “Samsung headphones” ile arama yapalim
        seachBox.sendKeys("Samsung headphones", Keys.ENTER);

        //    4- Bulunan sonuc sayisini yazdiralim
        //WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small'][1]"));
        //System.out.println(sonucYazisi.getText());
        String[] sonucYazisi = driver.findElement
                (By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small'][1]")).getText().split(" ");
        System.out.println("Bulunan Sonuc Sayisi : " + sonucYazisi[2]);

        //    5- Ilk urunu tiklayalim
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='s-image'][1]")).click();

        //    6- Sayfadaki tum basliklari yazdiralim
        System.out.println("Birinci Basliklar : " + driver.findElement(By.xpath("//h1")).getText());
        System.out.println("İkinci Basliklar : " + driver.findElement(By.xpath("//h2")).getText());
        System.out.println("Ucuncu Basliklar : " + driver.findElement(By.xpath("//h3")).getText());
    }
}
