package edu.bsuir.test.candidate;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.entity.Helper;
import edu.bsuir.test.services.SignIn;
import edu.bsuir.test.services.enums.Role;
import edu.bsuir.web.page.CreateCandidatePage;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;


public class DateTest {

    public WebDriver driver ;
    public SignIn form = new SignIn();
    public CreateCandidatePage ccp = new CreateCandidatePage();
    public Helper help = new Helper();

    @Before
    public void init() throws SAXException, ParserConfigurationException, XPathExpressionException, IOException {
        driver = WebDriverSingleton.getInstance();
        form.signIn(Role.CHIEF_RECRUITER);
        ccp.openCreateProfile();
    }

    @Test
    @DisplayName("Формат DDMMYYYY")
    @Description("Ввод дате в формате DDMMYYYY ")
    @Feature("Создание кандидата")
    @Story("Сценарий 12 – Проверка поля 'Даты рождения'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckDateInFormateDDMMYYYY() {
        ccp.setDayOfBirthDay("20");
        ccp.setDayOfBirthMonth("04");
        ccp.setDayOfBirthYear("2018");

        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorDate());
    }

    @Test
    @DisplayName("Формат DMYYYY")
    @Description("Ввод дате в формате DMYYYY")
    @Feature("Создание кандидата")
    @Story("Сценарий 12 – Проверка поля 'Даты рождения'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckDateInFormateDMYYYY() {
        ccp.setDayOfBirthDay("2");
        ccp.setDayOfBirthMonth("4");
        ccp.setDayOfBirthYear("2018");

        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorDate());
    }

    @Test
    @DisplayName("Формат DDMMYY")
    @Description("Ввод дате в формате DDMMYY")
    @Feature("Создание кандидата")
    @Story("Сценарий 12 – Проверка поля 'Даты рождения'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckDateInFormateDDMMYY() {
        ccp.setDayOfBirthDay("20");
        ccp.setDayOfBirthMonth("04");
        ccp.setDayOfBirthYear("18");

        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorDate());
    }

    @Test
    @DisplayName("Несуществующий день")
    @Description("Ввод дате несуществующего дня (45 число)")
    @Feature("Создание кандидата")
    @Story("Сценарий 12 – Проверка поля 'Даты рождения'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckAnrealDay() {
        ccp.setDayOfBirthDay("45");
        ccp.setDayOfBirthMonth("04");
        ccp.setDayOfBirthYear("2018");

        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorDate());
    }

    @Test
    @DisplayName("Несуществующий месяц")
    @Description("Ввод дате несуществующего месяца (45 месяц)")
    @Feature("Создание кандидата")
    @Story("Сценарий 12 – Проверка поля 'Даты рождения'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckAnrealMonth() {
        ccp.setDayOfBirthDay("20");
        ccp.setDayOfBirthMonth("45");
        ccp.setDayOfBirthYear("2018");

        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorDate());
    }

    @Test
    @DisplayName("Несуществующий год")
    @Description("Ввод дате несуществующего год (2067)")
    @Feature("Создание кандидата")
    @Story("Сценарий 12 – Проверка поля 'Даты рождения'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckAnrealYear() {
        ccp.setDayOfBirthDay("20");
        ccp.setDayOfBirthMonth("02");
        ccp.setDayOfBirthYear("2067");

        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorDate());
    }

    @Test
    @DisplayName("31 февраля")
    @Description("Ввод 31 февраля")
    @Feature("Создание кандидата")
    @Story("Сценарий 12 – Проверка поля 'Даты рождения'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckAnrealFebruaryDay() {
        ccp.setDayOfBirthDay("31");
        ccp.setDayOfBirthMonth("02");
        ccp.setDayOfBirthYear("2014");

        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorDate());
    }

    @Test
    @DisplayName("29 февраля высокосный год")
    @Description("Ввод 29 февраля высокосный год")
    @Feature("Создание кандидата")
    @Story("Сценарий 12 – Проверка поля 'Даты рождения'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckFebruaryDay29() {
        ccp.setDayOfBirthDay("29");
        ccp.setDayOfBirthMonth("02");
        ccp.setDayOfBirthYear("1992");

        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorDate());
    }

    @Test
    @DisplayName("29 февраля невысокосный год")
    @Description("Ввод 29 февраля невысокосный год")
    @Feature("Создание кандидата")
    @Story("Сценарий 12 – Проверка поля 'Даты рождения'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckAnrealFebruaryDay29() {
        ccp.setDayOfBirthDay("29");
        ccp.setDayOfBirthMonth("02");
        ccp.setDayOfBirthYear("1993");

        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorDate());
    }

    @After
    public void shutDown() throws IOException {
        help.closeBrowser() ;
    }
}
