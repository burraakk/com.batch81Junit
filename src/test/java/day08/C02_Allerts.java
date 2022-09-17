package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Allerts {
        /*
bir web sitesine girdigimizde karsımıza bir uyarı mesajı yada bir buttona tıkladığımızda bir uyarı cıkabilir
eğer bu uyarıya incele(mause sağ-tik inspect) yapabiliyorsak bu tür alert lere html alert denir.
ve istedigimiz locate'i alabiliriz. Ama gelen uyarı kutusuna müdahale (sağ tik inspect ile) edemiyorsak
bu tür alertlere  js alert denir.
js alert'lere müdahale edebilmek icin

-- tamam ya da ok icin
driver.switchTo().alert().accept();

--iptal icin
driver.switchTo().alert().dismiss();

--alert icindeki mesajı almak icin
driver.switchTo().alert().getText();

--alert bizden bir metin istiyorsa
driver.switchTo().alert().sendKeys("");

methodları kullanilir!!

 */

    //internet.herokuapp.com/javascript_alerts adresine gidin.

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test1() throws InterruptedException {

        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın
        // ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);
        //Allert üzerindeki mesaji yazdirin
        System.out.println("1.Butonun Allert Mesajı : " + driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();
        WebElement message = driver.findElement(By.xpath("//*[@id='result']"));
        String actualMessage = message.getText();
        String expectedMessage = "You successfully clicked an alert";
        Assert.assertEquals(expectedMessage, actualMessage);

    }

    @Test
    public void test2() throws InterruptedException {

        // 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //“successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);

        //Allert üzerindeki mesaji yazdirin
        System.out.println("2.Butonun Allert Mesajı : " + driver.switchTo().alert().getText());

        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);
        WebElement message = driver.findElement(By.xpath("//*[@id='result']"));
        String actualMessage = message.getText();
        String unExpectedMessage = "successfully";
        Assert.assertTrue(!actualMessage.contains(unExpectedMessage));

    }

    @Test
    public void test3() throws InterruptedException {

        // 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);

        //Allert üzerindeki mesaji yazdirin
        System.out.println("2.Butonun Allert Mesajı : " + driver.switchTo().alert().getText());

        String myName= "Burak";
        driver.switchTo().alert().sendKeys(myName);
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        WebElement message = driver.findElement(By.xpath("//*[@id='result']"));
        String actualMessage = message.getText();
        String expectedMessage = myName;
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }
}
