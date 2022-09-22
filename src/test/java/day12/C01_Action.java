package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeClassAfterClass;

public class C01_Action extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() throws InterruptedException {
        //Automationexercises.com sitesine gidelim
        driver.get("https://www.automationexercise.com");
        //Product bölümüne girelim
        driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();
        //ilk ürüne tıklayalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[data-product-id=\"1\"]")).click();


    }
}
