package edu.bsuir.test;

import edu.bsuir.driver.WebDriverSingleton;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.util.List;

public class TransitionToAdaptPageTest {

    private WebDriver driver = WebDriverSingleton.getInstance();

    @Test
    public void сheckTransitionToAdaptPageTest() {
        driver.get("http://testing.cld.iba.by/");
        WebElement login = driver.findElement(By.xpath("//input[@id='_58_login']"));
        login.sendKeys("kabanov@tc.by");
        WebElement password = driver.findElement(By.xpath("//input[@id='_58_password']"));
        password.sendKeys("welcome");
        password.sendKeys(Keys.RETURN);//*[@id="navigationIcon3"]

        WebElement cell = driver.findElement(By.xpath("//a[@href = 'http://testing.cld.iba.by/web/guest/recruiting']"));
        cell.click();
        Assert.assertEquals("Подбор и адаптация - Конструктор Талантов", driver.getTitle());


//        WebElement navigationIcon = driver.findElement(By.xpath("//*[@id='heading']/div"));
//        navigationIcon.click();
//        WebElement navigationIcon1 = driver.findElement(By.xpath("//*[@id='layout_2']/a"));
//        navigationIcon1.click();

//        WebDriverWait explicitWait = new WebDriverWait(driver, 40);
//        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='layout_2']/a")));
//        driver.findElement(By.xpath("//li[@id='layout_2']/a")).click();
//        Assert.assertEquals("Подбор и адаптация - Конструктор Талантов", driver.getTitle());
    }


    @After
    public void shutDown() {
        driver.close();
    }

}
