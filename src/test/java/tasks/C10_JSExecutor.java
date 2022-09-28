package tasks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;

public class C10_JSExecutor extends TestBaseBeforeClassAfterClass {

    //hotelmycamp anasayfasina gidin
    //2 farkli test method’u olusturarak actions classi ve Js Executor kullanarak
    //asagidaki oda turlerinden  ust sira ortadaki odayi tiklayin
    //istediginiz oda inceleme sayfasi acildigini test  edin


    @Test
    public void testActions() throws InterruptedException {
        //hotelmycamp anasayfasina gidin
        driver.get("https://www.hotelmycamp.com/");
        //asagidaki oda turlerinden  ust sira ortadaki odayi tiklayin

        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                perform();
        WebElement room = driver.findElement(By.xpath("//p/a[@href='/RoomDetail/425']"));
        Thread.sleep(2000);
        actions.click(room).perform();

        //istediginiz oda inceleme sayfasi acildigini test  edin
        WebElement roomHeader = driver.findElement(By.xpath("//h1[text()='dsafsaf']"));
        Assert.assertTrue(roomHeader.isDisplayed());

    }

    @Test
    public void testJSExecutor() throws InterruptedException {
        //hotelmycamp anasayfasina gidin
        driver.get("https://www.hotelmycamp.com/");

        //asagidaki oda turlerinden  ust sira ortadaki odayi tiklayin
        WebElement room = driver.findElement(By.xpath("//p/a[@href='/RoomDetail/425']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",room);
        Thread.sleep(2000);
        jse.executeScript("arguments[0].click();",room);

        //istediginiz oda inceleme sayfasi acildigini test  edin
        WebElement roomHeader = driver.findElement(By.xpath("//h1[text()='dsafsaf']"));
        Assert.assertTrue(roomHeader.isDisplayed());

    }
}
