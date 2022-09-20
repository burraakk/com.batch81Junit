package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeClassAfterClass;

public class C05_Actions extends TestBaseBeforeClassAfterClass {
    @Test
    public void test() throws InterruptedException {
        //https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        Thread.sleep(2000);

        //“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMeButton = driver.findElement(By.xpath("//*[text()='Drag me']"));
        WebElement dropHereButton = driver.findElement(By.xpath("//*[text()='Drop here'][1]"));
        Actions action = new Actions(driver);
        action.dragAndDrop(dragMeButton, dropHereButton).perform();
        Thread.sleep(2000);

        //“Drop here” yazisi yerine “Dropped!” oldugunu test edin
        //Assert.assertEquals("Dropped!", driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());
        Assert.assertEquals("Dropped!", dropHereButton.getText());
    }
}
