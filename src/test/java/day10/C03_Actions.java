package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeClassAfterClass;

public class C03_Actions extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1(){
        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");
        //Account menüsünden create a list linkine tiklayalim
        WebElement accountList = driver.findElement(By.xpath("//a[@data-csa-c-slot-id='nav-link-accountList']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountList).perform();
        /*
        Bir web sitesinde bir mouse ile açılan bir web elementine ulaşmak istersek
        actions.moveToElement() methodunu kullanmamız gerekir. Aksi takdirde
        html kodları arasında web elementi bulur ama ulaşamadığı için
        ElementNotInteractableException: element not interactable exception'ı fırlatır
         */
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

    }
}
