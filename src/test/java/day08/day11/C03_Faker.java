package day08.day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;

public class C03_Faker extends TestBaseBeforeClassAfterClass {

    // faker class'i kullanmak icin mvn repository.com adresinden java faker kütüphanesinin aratir
    // ve en cok kullanilani pom.xml dosyamiza ekleriz
    // ve faker class'indan bir obje olusturup email icin faker.internet methodunu kullanarak
    // emailAdress() methodunu seceriz
    // password icinde ayni internet methodunu kullaniriz
    // isim ve soyisimler icin faker.name() methodu ile firstname() ve lastname() methodunu kullaniriz
    // faker claas'ini kullanma amacimiz form dordurmamiz gereken sitelerde defalarca kendi üretecegimiz
    // veriler yerine bizim icin random veriler üretir ve isimizi kolaylastirir

    @Test
    public void test1() {
        //"https://facebook.com"  Adresine gidin
        driver.get("https://facebook.com");

        //“create new account”  butonuna basin
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //“firstName” giris kutusuna bir isim yazin
        //“surname” giris kutusuna bir soyisim yazin
        //“email” giris kutusuna bir email yazin
        //“email” onay kutusuna emaili tekrar yazin
        //Bir sifre girin
        //Tarih icin gun secin
        //Tarih icin ay secin
        //Tarih icin yil secin
        //Cinsiyeti secin
        //Kaydol butonuna basın
        //Sayfayi kapatin

        //“firstName” giris kutusuna bir isim yazin
        Faker faker = new Faker();
        WebElement name = driver.findElement(By.xpath("//*[@class='inputtext _58mg _5dba _2ph-'][1]"));
        String email = faker.internet().emailAddress();

        actions.click(name).sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(email).
                sendKeys(Keys.TAB).sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("1").
                sendKeys(Keys.TAB).sendKeys("Tem").
                sendKeys(Keys.TAB).sendKeys("1990").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();



    }
}
