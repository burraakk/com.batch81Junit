package day16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;

public class C02_JSExecutor extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() throws InterruptedException {
        //Amazona gidelim
        driver.get("https://www.amazon.com/");

        //Aşağıdaki careers butonunu görene kadar js ile scroll yapalım
        WebElement careers = driver.findElement(By.xpath("//*[text()='Careers']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",careers);

        //Careers butonuna js ile click yapalım
        Thread.sleep(2000);
        jse.executeScript("arguments[0].click();",careers);
    }
}
