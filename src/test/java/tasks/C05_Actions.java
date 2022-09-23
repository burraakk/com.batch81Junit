package tasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.ArrayList;
import java.util.List;

public class C05_Actions extends TestBaseBeforeClassAfterClass {

    WebElement searchBox;
    @Test
    public void test1() {
        //amazon'a gidin
        driver.get("https://www.amazon.com/");

        //Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        List<WebElement> allMenuOptions = new ArrayList<>(driver.findElements(By.xpath("//option")));
        for (WebElement element : allMenuOptions) {
            System.out.println(element.getText());
        }

        //dropdown menude 40 eleman olduğunu doğrulayın
        int allMenuSize = allMenuOptions.size();
        int expectedSize = 40;
        Assert.assertNotEquals(expectedSize, allMenuSize);

    }

    @Test
    public void test2() {
        //dropdown menuden elektronik bölümü seçin
        WebElement dropDownMenu = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        dropDownMenu.sendKeys("Electronics");

        //arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone", Keys.ENTER);
        String result = driver.
                findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).
                getText();
        System.out.println("Arama sonucu 'iphone' : " + result);

        //sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String expectedWord = "iphone";
        Assert.assertTrue(result.contains(expectedWord));

        //Dördüncü ürüne relative locater kullanarak tıklayin
        WebElement soldakiElement = driver.findElement(By.xpath("(//*[@class='s-image'])[3]"));
        WebElement dorduncuUrun = driver.findElement(RelativeLocator.with(By.className("s-image")).toRightOf(soldakiElement));
        dorduncuUrun.click();

        //ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        String productTitle = driver.findElement(By.xpath("//*[@id='productTitle']")).getText();
        String fiyat;
        try {
            fiyat = driver.findElement(By.xpath("//*[@class='a-section a-spacing-micro']")).getText();
        }catch (Exception e) {
            fiyat = driver.findElement(By.xpath("//*[@class='a-color-price a-text-bold']")).getText();
        }
        WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
        addToCart.click();

    }

    @Test
    public void test3() {
        //yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com/");

        //dropdown’dan bebek bölümüne secin
        WebElement dropDownMenu = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(dropDownMenu);
        select.selectByVisibleText("Baby");

        //bebek puset aratıp bulundan sonuç sayısını yazdırın
        searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("bebek puset", Keys.ENTER);
        String result = driver.
                findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).
                getText();
        System.out.println("Arama sonucu 'bebek puset' : " + result);

        //sonuç yazsının puset içerdiğini test edin
        String expectedWord = "puset";
        Assert.assertTrue(result.contains(expectedWord));

        //üçüncü ürüne relative locater kullanarak tıklayin
        WebElement usttekiElement = driver.findElement(By.xpath("(//*[@class='s-image'])[2]"));
        WebElement asagidakiElement = driver.findElement(By.xpath("(//*[@class='s-image'])[4]"));
        WebElement ucuncuUrun = driver.findElement
                (RelativeLocator.with(By.className("s-image")).above(asagidakiElement).toRightOf(usttekiElement));
        ucuncuUrun.click();

        //title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        String productTitle = driver.findElement(By.xpath("//*[@id='productTitle']")).getText();
        String fiyat;
        try {
            fiyat = driver.findElement(By.xpath("//*[@class='a-section a-spacing-micro']")).getText();
        }catch (Exception e) {
            fiyat = driver.findElement(By.xpath("//*[@class='a-color-price a-text-bold']")).getText();
        }
        WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
        addToCart.click();


    }

    @Test
    public void test4() {
        //sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
    }

}
