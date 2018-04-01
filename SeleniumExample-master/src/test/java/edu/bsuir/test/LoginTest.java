package edu.bsuir.test;


import edu.bsuir.driver.WebDriverSingleton;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class LoginTest {

    public WebDriver driver;

    @Before
    public void init(){
        driver = WebDriverSingleton.getInstance();
    }

    @Test
    public void сheckPositiveLoginAndPassword() throws IOException {
        driver.get("http://testing.cld.iba.by");
        WebElement login = driver.findElement(By.xpath("//input[@id='_58_login']"));
        login.sendKeys("kabanov@tc.by");
        WebElement password = driver.findElement(By.xpath("//input[@id='_58_password']"));
        password.sendKeys("welcome");
        password.sendKeys(Keys.RETURN);
        WebElement profileInfo = driver.findElement(By.xpath("//div[@class = 'tc-theme-user-info-title-text']/p"));
        Assert.assertEquals("kabanov@tc.by", profileInfo.getText());

    }


    @Test
    public void сheckNegativeLoginAndPassword() throws IOException {
        driver.get("http://testing.cld.iba.by");
        WebElement login = driver.findElement(By.xpath("//input[@id='_58_login']"));
        login.sendKeys("login");
        WebElement password = driver.findElement(By.xpath("//input[@id='_58_password']"));
        password.sendKeys("password");
        password.sendKeys(Keys.RETURN);
        WebElement profileInfo = driver.findElement(By.xpath("//div[@class = 'tc-theme-user-info-title-text']/p"));
        Assert.assertEquals("kabanov@tc.by", profileInfo.getText());

    }


    @Test
    public void сheckNegativeLogin() {
        driver.get("http://testing.cld.iba.by");
        WebElement login = driver.findElement(By.xpath("//input[@id='_58_login']"));
        login.sendKeys("login");
        WebElement password = driver.findElement(By.xpath("//input[@id='_58_password']"));
        password.sendKeys("welcome");
        password.sendKeys(Keys.RETURN);
        WebElement error = driver.findElement(By.xpath("//div[@class = 'alert alert-error']"));
        Assert.assertEquals("Ваш запрос завершился с ошибкой.", error.getText());
            WebElement error1 = driver.findElement(By.xpath("//fieldset[@class = 'input-container']/div[@class = 'alert alert-error']"));
            Assert.assertEquals("Аутентификация не пройдена. Пожалуйста, попробуйте снова.", error1.getText());
    }

    @Test
    public void сheckNegativePassword() {
            driver.get("http://testing.cld.iba.by");
            WebElement login = driver.findElement(By.xpath("//input[@id='_58_login']"));
            login.sendKeys("kabanov@tc.by");
            WebElement password = driver.findElement(By.xpath("//input[@id='_58_password']"));
            password.sendKeys("password");
            password.sendKeys(Keys.RETURN);
            WebElement error = driver.findElement(By.xpath("//div[@class = 'alert alert-error']"));
            Assert.assertEquals("Ваш запрос завершился с ошибкой.", error.getText());
            WebElement error1 = driver.findElement(By.xpath("//fieldset[@class = 'input-container']/div[@class = 'alert alert-error']"));
            Assert.assertEquals("Аутентификация не пройдена. Пожалуйста, попробуйте снова.", error1.getText());
        }
    @Test
    public void сheckNullLoginAndPassword() {
        driver.get("http://testing.cld.iba.by");
        WebElement button = driver.findElement(By.xpath("//button[text()=' Войти ']"));
        button.click();
        WebElement error1 = driver.findElement(By.xpath(
                "//div[@class='form-validator-stack help-inline' and @id='yui_patched_v3_11_0_1_1522521336989_194']/div"));
        Assert.assertEquals("Это обязательное поле.", error1.getText());
//        WebElement error2 = driver.findElement(By.xpath(
//                "//div[@class='form-validator-stack help-inline' and @id='yui_patched_v3_11_0_1_1522521336989_186']/div"));
//        Assert.assertEquals("Это обязательное поле.", error2.getText());
    }

    @Test
    public void сheckNullPassword() {
        driver.get("http://testing.cld.iba.by");
        WebElement login = driver.findElement(By.xpath("//input[@id='_58_login']"));
        login.sendKeys("kabanov@tc.by");
        WebElement button = driver.findElement(By.xpath("//button[text()=' Войти ']"));
        button.click();
        WebElement error1 = driver.findElement(By.xpath(
                "//div[@class='form-validator-stack help-inline' and @id='yui_patched_v3_11_0_1_1522521336989_194']/div"));
        Assert.assertEquals("Это обязательное поле.", error1.getText());
    }

    @Test
    public void сheckNullLogin() {
        driver.get("http://testing.cld.iba.by");
        WebElement login = driver.findElement(By.xpath("//input[@id='_58_login']"));
        login.sendKeys("kabanov@tc.by");
        WebElement button = driver.findElement(By.xpath("//button[text()=' Войти ']"));
        button.click();
        WebElement error1 = driver.findElement(By.xpath(
                "//div[@class='form-validator-stack help-inline' and @id='yui_patched_v3_11_0_1_1522521336989_194']/div"));
        Assert.assertEquals("Это обязательное поле.", error1.getText());
    }


    @Test
    public void сheckChangeOfPlacesOfLoginAndPassword() {
        driver.get("http://testing.cld.iba.by");
        WebElement login = driver.findElement(By.xpath("//input[@id='_58_login']"));
        login.sendKeys("welcome");
        WebElement password = driver.findElement(By.xpath("//input[@id='_58_password']"));
        password.sendKeys("kabanov@tc.by");
        password.sendKeys(Keys.RETURN);
        WebElement error = driver.findElement(By.xpath("//div[@class = 'alert alert-error']"));
        Assert.assertEquals("Ваш запрос завершился с ошибкой.", error.getText());
        WebElement error1 = driver.findElement(By.xpath("//fieldset[@class = 'input-container']/div[@class = 'alert alert-error']"));
        Assert.assertEquals("Аутентификация не пройдена. Пожалуйста, попробуйте снова.", error1.getText());
    }

    @Test
    public void сheckScriptAtLogin() {
        driver.get("http://testing.cld.iba.by");
        WebElement login = driver.findElement(By.xpath("//input[@id='_58_login']"));
        login.sendKeys("<script>alert(123)</script>");
        WebElement password = driver.findElement(By.xpath("//input[@id='_58_password']"));
        password.sendKeys("welcome");
        password.sendKeys(Keys.RETURN);
        WebElement error = driver.findElement(By.xpath("//div[@class = 'alert alert-error']"));
        Assert.assertEquals("Ваш запрос завершился с ошибкой.", error.getText());
        WebElement error1 = driver.findElement(By.xpath("//fieldset[@class = 'input-container']/div[@class = 'alert alert-error']"));
        Assert.assertEquals("Аутентификация не пройдена. Пожалуйста, попробуйте снова.", error1.getText());
    }

    @Test
    public void сheckScriptAtPassword() {
        driver.get("http://testing.cld.iba.by");
        WebElement login = driver.findElement(By.xpath("//input[@id='_58_login']"));
        login.sendKeys("kabanov@tc.by");
        WebElement password = driver.findElement(By.xpath("//input[@id='_58_password']"));
        password.sendKeys("<script>alert(123)</script>");
        password.sendKeys(Keys.RETURN);
        WebElement error = driver.findElement(By.xpath("//div[@class = 'alert alert-error']"));
        Assert.assertEquals("Ваш запрос завершился с ошибкой.", error.getText());
        WebElement error1 = driver.findElement(By.xpath("//fieldset[@class = 'input-container']/div[@class = 'alert alert-error']"));
        Assert.assertEquals("Аутентификация не пройдена. Пожалуйста, попробуйте снова.", error1.getText());
    }

    @Test
    public void сheckLoginEndsWithSpace() {
        driver.get("http://testing.cld.iba.by");
        WebElement login = driver.findElement(By.xpath("//input[@id='_58_login']"));
        login.sendKeys("kabanov@tc.by   ");
        WebElement password = driver.findElement(By.xpath("//input[@id='_58_password']"));
        password.sendKeys("welcome");
        password.sendKeys(Keys.RETURN);
        WebElement error = driver.findElement(By.xpath("//div[@class = 'alert alert-error']"));
        Assert.assertEquals("Ваш запрос завершился с ошибкой.", error.getText());
        WebElement error1 = driver.findElement(By.xpath("//fieldset[@class = 'input-container']/div[@class = 'alert alert-error']"));
        Assert.assertEquals("Аутентификация не пройдена. Пожалуйста, попробуйте снова.", error1.getText());
    }

    @Test
    public void сheckLoginStartsWithSpace() {
        driver.get("http://testing.cld.iba.by");
        WebElement login = driver.findElement(By.xpath("//input[@id='_58_login']"));
        login.sendKeys("   kabanov@tc.by");
        WebElement password = driver.findElement(By.xpath("//input[@id='_58_password']"));
        password.sendKeys("welcome");
        password.sendKeys(Keys.RETURN);
        WebElement error = driver.findElement(By.xpath("//div[@class = 'alert alert-error']"));
        Assert.assertEquals("Ваш запрос завершился с ошибкой.", error.getText());
        WebElement error1 = driver.findElement(By.xpath("//fieldset[@class = 'input-container']/div[@class = 'alert alert-error']"));
        Assert.assertEquals("Аутентификация не пройдена. Пожалуйста, попробуйте снова.", error1.getText());
    }


    @Test
    public void сheckPasswordEndsWithSpace() {
        driver.get("http://testing.cld.iba.by");
        WebElement login = driver.findElement(By.xpath("//input[@id='_58_login']"));
        login.sendKeys("kabanov@tc.by");
        WebElement password = driver.findElement(By.xpath("//input[@id='_58_password']"));
        password.sendKeys("welcome   ");
        password.sendKeys(Keys.RETURN);
        WebElement error = driver.findElement(By.xpath("//div[@class = 'alert alert-error']"));
        Assert.assertEquals("Ваш запрос завершился с ошибкой.", error.getText());
        WebElement error1 = driver.findElement(By.xpath("//fieldset[@class = 'input-container']/div[@class = 'alert alert-error']"));
        Assert.assertEquals("Аутентификация не пройдена. Пожалуйста, попробуйте снова.", error1.getText());
    }

    @Test
    public void сheckPasswordStartsWithSpace() {
        driver.get("http://testing.cld.iba.by");
        WebElement login = driver.findElement(By.xpath("//input[@id='_58_login']"));
        login.sendKeys("kabanov@tc.by");
        WebElement password = driver.findElement(By.xpath("//input[@id='_58_password']"));
        password.sendKeys("   welcome");
        password.sendKeys(Keys.RETURN);
        WebElement error = driver.findElement(By.xpath("//div[@class = 'alert alert-error']"));
        Assert.assertEquals("Ваш запрос завершился с ошибкой.", error.getText());
        WebElement error1 = driver.findElement(By.xpath("//fieldset[@class = 'input-container']/div[@class = 'alert alert-error']"));
        Assert.assertEquals("Аутентификация не пройдена. Пожалуйста, попробуйте снова.", error1.getText());
    }

    @Test
    public void сheckPasswordDifferentCase() {
        driver.get("http://testing.cld.iba.by");
        WebElement login = driver.findElement(By.xpath("//input[@id='_58_login']"));
        login.sendKeys("kabanov@tc.by");
        WebElement password = driver.findElement(By.xpath("//input[@id='_58_password']"));
        password.sendKeys("welComE");
        password.sendKeys(Keys.RETURN);
        WebElement error = driver.findElement(By.xpath("//div[@class = 'alert alert-error']"));
        Assert.assertEquals("Ваш запрос завершился с ошибкой.", error.getText());
        WebElement error1 = driver.findElement(By.xpath("//fieldset[@class = 'input-container']/div[@class = 'alert alert-error']"));
        Assert.assertEquals("Аутентификация не пройдена. Пожалуйста, попробуйте снова.", error1.getText());
    }

    @Test
    public void сheckPasswordUpperCase() {
        driver.get("http://testing.cld.iba.by");
        WebElement login = driver.findElement(By.xpath("//input[@id='_58_login']"));
        login.sendKeys("kabanov@tc.by");
        WebElement password = driver.findElement(By.xpath("//input[@id='_58_password']"));
        password.sendKeys("WELCOME");
        password.sendKeys(Keys.RETURN);
        WebElement error = driver.findElement(By.xpath("//div[@class = 'alert alert-error']"));
        Assert.assertEquals("Ваш запрос завершился с ошибкой.", error.getText());
        WebElement error1 = driver.findElement(By.xpath("//fieldset[@class = 'input-container']/div[@class = 'alert alert-error']"));
        Assert.assertEquals("Аутентификация не пройдена. Пожалуйста, попробуйте снова.", error1.getText());
    }

    @Test
    public void сheckLoginDifferentCase() {
        driver.get("http://testing.cld.iba.by");
        WebElement login = driver.findElement(By.xpath("//input[@id='_58_login']"));
        login.sendKeys("kaBanoV@tc.by");
        WebElement password = driver.findElement(By.xpath("//input[@id='_58_password']"));
        password.sendKeys("welcome");
        password.sendKeys(Keys.RETURN);
        WebElement error = driver.findElement(By.xpath("//div[@class = 'alert alert-error']"));
        Assert.assertEquals("Ваш запрос завершился с ошибкой.", error.getText());
        WebElement error1 = driver.findElement(By.xpath("//fieldset[@class = 'input-container']/div[@class = 'alert alert-error']"));
        Assert.assertEquals("Аутентификация не пройдена. Пожалуйста, попробуйте снова.", error1.getText());
    }

    @Test
    public void сheckLoginWithCorner() {
        driver.get("http://testing.cld.iba.by");
        WebElement login = driver.findElement(By.xpath("//input[@id='_58_login']"));
        login.sendKeys("<kabanov@tc.by>");
        WebElement password = driver.findElement(By.xpath("//input[@id='_58_password']"));
        password.sendKeys("welcome");
        password.sendKeys(Keys.RETURN);
        WebElement error = driver.findElement(By.xpath("//div[@class = 'alert alert-error']"));
        Assert.assertEquals("Ваш запрос завершился с ошибкой.", error.getText());
        WebElement error1 = driver.findElement(By.xpath("//fieldset[@class = 'input-container']/div[@class = 'alert alert-error']"));
        Assert.assertEquals("Аутентификация не пройдена. Пожалуйста, попробуйте снова.", error1.getText());
    }


    @Test
    public void сheckLoginWithCyrillic() {
        driver.get("http://testing.cld.iba.by");
        WebElement login = driver.findElement(By.xpath("//input[@id='_58_login']"));
        login.sendKeys("kаbаnоv@tc.bу");
        WebElement password = driver.findElement(By.xpath("//input[@id='_58_password']"));
        password.sendKeys("welcome");
        password.sendKeys(Keys.RETURN);
        WebElement error = driver.findElement(By.xpath("//div[@class = 'alert alert-error']"));
        Assert.assertEquals("Ваш запрос завершился с ошибкой.", error.getText());
        WebElement error1 = driver.findElement(By.xpath("//fieldset[@class = 'input-container']/div[@class = 'alert alert-error']"));
        Assert.assertEquals("Аутентификация не пройдена. Пожалуйста, попробуйте снова.", error1.getText());
    }

    @Test
    public void сheckPasswordWithCyrillic() {
        driver.get("http://testing.cld.iba.by");
        WebElement login = driver.findElement(By.xpath("//input[@id='_58_login']"));
        login.sendKeys("kabanov@tc.by");
        WebElement password = driver.findElement(By.xpath("//input[@id='_58_password']"));
        password.sendKeys("wеlcоmе");
        password.sendKeys(Keys.RETURN);
        WebElement error = driver.findElement(By.xpath("//div[@class = 'alert alert-error']"));
        Assert.assertEquals("Ваш запрос завершился с ошибкой.", error.getText());
        WebElement error1 = driver.findElement(By.xpath("//fieldset[@class = 'input-container']/div[@class = 'alert alert-error']"));
        Assert.assertEquals("Аутентификация не пройдена. Пожалуйста, попробуйте снова.", error1.getText());
    }

    @After
    public  void shutDown() {
        driver.quit();
    }

}