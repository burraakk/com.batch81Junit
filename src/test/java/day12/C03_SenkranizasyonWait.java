package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeClassAfterClass;

import java.time.Duration;

public class C03_SenkranizasyonWait extends TestBaseBeforeClassAfterClass {
    //Iki tane metod olusturun : implicitWait() , explicitWait()
    //Iki metod icin de asagidaki adimlari test edin.
    //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //Remove butonuna basin.
    //“It’s gone!” mesajinin goruntulendigini dogrulayin.
    //Add buttonuna basin
    //It’s back mesajinin gorundugunu test edin

    @Test
    public void implicitlyWaitTesti() {
        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //“It’s gone!” mesajinin goruntulendigini dogrulayin.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//*[@id='message']")).getText()); //mesaji görüntüledim

        //Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //It’s back mesajinin gorundugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//*[@id='message']")).getText()); //mesaji görüntüledim
        
    }

    @Test
    public void explicitWaitTest() {
        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //“It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement itsGoneWE = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));

        //Add buttonuna basin

        //It’s back mesajinin gorundugunu test edin
    }
}
