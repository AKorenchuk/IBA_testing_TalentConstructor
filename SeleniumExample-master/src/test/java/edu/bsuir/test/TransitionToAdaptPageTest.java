package edu.bsuir.test;

import edu.bsuir.driver.WebDriverSingleton;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;


public class TransitionToAdaptPageTest {

    private WebDriver driver = WebDriverSingleton.getInstance();

    @Test
    public void сheckTransitionToAdaptPageTest() {
        driver.get("http://testing.cld.iba.by");
        WebElement login = driver.findElement(By.xpath("//input[@id='_58_login']"));
        login.sendKeys("kabanov@tc.by");
        WebElement password = driver.findElement(By.xpath("//input[@id='_58_password']"));
        password.sendKeys("welcome");
        password.sendKeys(Keys.RETURN);

        WebDriverWait wait1 = new WebDriverWait(driver, 120);
        WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='layout_2']/a")));
        element1.click();
        Assert.assertEquals("Подбор и адаптация - Конструктор Талантов", driver.getTitle());
    }


    @After
    public void shutDown() {
        driver.close();
    }

}
