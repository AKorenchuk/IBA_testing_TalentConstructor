package edu.bsuir.test;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.test.services.SignIn;
import edu.bsuir.test.services.enums.Role;
import edu.bsuir.web.page.LoginPage;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;


public class LoginTest {

    public static final String INVALID_DATA_MESSAGE = "Ваш запрос завершился с ошибкой.";
    public static final String REQUIRED_FIELD_MESSAGE = "Это обязательное поле.";


    public WebDriver driver;
    public SignIn form = new SignIn();
    public LoginPage lp = new LoginPage();

    @Before
    public void init(){
        driver = WebDriverSingleton.getInstance();
    }

    @Test
    @DisplayName("Проверка корректных данных")
    @Description("Вход в систему за главного рекрутера")
    @Feature("Вход в систему")
    @Story("Сценарий 1 – Логирование")
    @Severity(SeverityLevel.NORMAL)
    public void сheckPositiveLoginAndPassword() throws SAXException, ParserConfigurationException, XPathExpressionException, IOException {
        form.signIn(Role.CHIEF_RECRUITER);
        WebElement profileInfo = driver.findElement(By.xpath("//*[@id='user-email']"));
        Assert.assertEquals("kabanov@tc.by", profileInfo.getText());
    }


    @Test
    @DisplayName("Проверка некорректных данных")
    @Description("Вход в систему с несуществующим логином и паролем")
    @Feature("Вход в систему")
    @Story("Сценарий 1 – Логирование")
    @Severity(SeverityLevel.NORMAL)
    public void сheckNegativeLoginAndPassword() {
        form.signIn("login","password");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }


    @Test
    @DisplayName("Несуществующий логин")
    @Description("Вход в систему с несуществующим логином")
    @Feature("Вход в систему")
    @Story("Сценарий 1 – Логирование")
    @Severity(SeverityLevel.NORMAL)
    public void сheckNegativeLogin() {
        form.signIn("login","welcom");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }


    @Test
    @DisplayName("Несуществующий пароль")
    @Description("Вход в систему с несуществующим паролем")
    @Feature("Вход в систему")
    @Story("Сценарий 1 – Логирование")
    @Severity(SeverityLevel.NORMAL)
    public void сheckNegativePassword() {
        form.signIn("kabanov@tc.by","password");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }


    @Test
    @DisplayName("Нулевой логин и пароль")
    @Description("Вход в систему при пустом логине и пароле")
    @Feature("Вход в систему")
    @Story("Сценарий 2 – Пустое поле")
    @Severity(SeverityLevel.NORMAL)
    public void сheckNullLoginAndPassword() {
        lp.openLoginPage();
        lp.clickLoginButton();
        Assert.assertEquals(REQUIRED_FIELD_MESSAGE, lp.getLoginErrorMessage());
        Assert.assertEquals(REQUIRED_FIELD_MESSAGE, lp.getPasswordErrorMessage());
    }

    @Test
    @DisplayName("Нулевой пароль")
    @Description("Вход в систему при пустом пароле")
    @Feature("Вход в систему")
    @Story("Сценарий 2 – Пустое поле")
    @Severity(SeverityLevel.NORMAL)
    public void сheckNullPassword() {
        form.signIn("kabanov@tc.by","");
        Assert.assertEquals(REQUIRED_FIELD_MESSAGE, lp.getPasswordErrorMessage());
    }

    @Test
    @DisplayName("Нулевой логин")
    @Description("Вход в систему при пустом логине")
    @Feature("Вход в систему")
    @Story("Сценарий 2 – Пустое поле")
    @Severity(SeverityLevel.NORMAL)
    public void сheckNullLogin() {
        form.signIn("","welcome");
        Assert.assertEquals(REQUIRED_FIELD_MESSAGE, lp.getLoginErrorMessage());
    }


    @Test
    @DisplayName("Смена мест логина и пароля")
    @Description("Ввод корректного логина в поле для ввода пароля и корректного пароля в поле логина")
    @Feature("Вход в систему")
    @Story("Сценарий 3 – Смена мест")
    @Severity(SeverityLevel.NORMAL)
    public void сheckChangeOfPlacesOfLoginAndPassword() {
        form.signIn("welcome","kabanov@tc.by");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    @DisplayName("Инъекция в поле логина")
    @Description("Ввод скрипта в поле логина")
    @Feature("Вход в систему")
    @Story("Сценарий 3 – Инъекции")
    @Severity(SeverityLevel.NORMAL)
    public void сheckScriptAtLogin() {
        form.signIn("<script>alert(kabanov@tc.by)</script>","welcome");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    @DisplayName("Инъекция в поле пароля")
    @Description("Ввод скрипта в поле пароля")
    @Feature("Вход в систему")
    @Story("Сценарий 3 – Инъекции")
    @Severity(SeverityLevel.NORMAL)
    public void сheckScriptAtPassword() {
        form.signIn("kabanov@tc.by","<script>alert(welcome)</script>");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    @DisplayName("Пробелы в поле логина")
    @Description("Ввод корректного пароля и логина  с пробелыми на конце")
    @Feature("Вход в систему")
    @Story("Сценарий 4 – Пробелы")
    @Severity(SeverityLevel.NORMAL)
    public void сheckLoginEndsWithSpace() {
        form.signIn("kabanov@tc.by   ","welcome");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    @DisplayName("Пробелы в поле логина")
    @Description("Ввод корректного пароля и логина  с пробелами в начале")
    @Feature("Вход в систему")
    @Story("Сценарий 4 – Пробелы")
    @Severity(SeverityLevel.NORMAL)
    public void сheckLoginStartsWithSpace() {
        form.signIn("   kabanov@tc.by","welcome");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }


    @Test
    @DisplayName("Пробелы в поле пароля")
    @Description("Ввод корректного логина и пароля с пробелами на конце")
    @Feature("Вход в систему")
    @Story("Сценарий 4 – Пробелы")
    @Severity(SeverityLevel.NORMAL)
    public void сheckPasswordEndsWithSpace() {
        form.signIn("kabanov@tc.by","welcome   ");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    @DisplayName("Пробелы в поле пароля")
    @Description("Ввод корректного логина и пароля с пробелами в начале")
    @Feature("Вход в систему")
    @Story("Сценарий 4 – Пробелы")
    @Severity(SeverityLevel.NORMAL)
    public void сheckPasswordStartsWithSpace() {
        form.signIn("kabanov@tc.by","   welcome");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    @DisplayName("Разный регистр в поле пароля")
    @Description("Ввод корректного логина и пароля с буквами разного регистра")
    @Feature("Вход в систему")
    @Story("Сценарий 5 – Регистр ")
    @Severity(SeverityLevel.NORMAL)
    public void сheckPasswordDifferentCase() {
        form.signIn("kabanov@tc.by","welComE");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    @DisplayName("Разный регистр в поле пароля")
    @Description("Ввод корректного логина и пароля с буквами верхнего регистра")
    @Feature("Вход в систему")
    @Story("Сценарий 5 – Регистр ")
    @Severity(SeverityLevel.NORMAL)
    public void сheckPasswordUpperCase() {
        form.signIn("kabanov@tc.by","WELCOME");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    @DisplayName("Разный регистр в поле логина")
    @Description("Ввод корректного пароля и логина с буквами разного регистра")
    @Feature("Вход в систему")
    @Story("Сценарий 5 – Регистр ")
    @Severity(SeverityLevel.NORMAL)
    public void сheckLoginDifferentCase() {
        form.signIn("kaBanoV@tc.by","welcome");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    @DisplayName("Разный регистр в поле логина")
    @Description("Ввод корректного пароля и логина с буквами верхнего регистра")
    @Feature("Вход в систему")
    @Story("Сценарий 5 – Регистр ")
    @Severity(SeverityLevel.NORMAL)
    public void сheckLoginUpperCase() {
        form.signIn("KABANOV@TC.BY","welcome");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    @DisplayName("Спецсимволы в поле логина")
    @Description("Ввод корректного пароля и логина со знаками < и >")
    @Feature("Вход в систему")
    @Story("Сценарий 6 – Специальные символы ")
    @Severity(SeverityLevel.NORMAL)
    public void сheckLoginWithCorner() {
        form.signIn("<kabanov@tc.by>","welcome");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }


    @Test
    @DisplayName("Кириллица в логине")
    @Description("Ввод корректного пароля и логина с кирилличными буквами")
    @Feature("Вход в систему")
    @Story("Сценарий 7 – Кириллица ")
    @Severity(SeverityLevel.NORMAL)
    public void сheckLoginWithCyrillic() {
        form.signIn("kаbаnоv@tc.bу","welcome");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    @DisplayName("Кириллица в пароле")
    @Description("Ввод корректного логина и пароля с кирилличными буквами")
    @Feature("Вход в систему")
    @Story("Сценарий 7 – Кириллица ")
    @Severity(SeverityLevel.NORMAL)
    public void сheckPasswordWithCyrillic() {
        form.signIn("kаbаnоv@tc.bу","wеlcоmе");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @After
    public  void shutDown() {
        driver.close();
        WebDriverSingleton.destroyInstance();
    }

}