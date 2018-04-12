package edu.bsuir.test.candidate;


import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.entity.enums.GeneratorMode;
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

public class EmailTest {

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
    public void сheckEmptyEmail() {
    }

    @Test
    @DisplayName("Корректный email ")
    @Description("Ввод корректного email ")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckEmailInLowerCase() throws InterruptedException {
        ccp.setEmail("korenchuk@gmail.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertFalse(ccp.isVisibleErrorEmail());
    }

    @Test
    @DisplayName("Верхний регистр ")
    @Description("Ввод корректного email в верхнем регистре")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckEmailInUpperCase() throws InterruptedException {
        ccp.setEmail("KORENCHUK@GMAIL.COM");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertFalse(ccp.isVisibleErrorEmail());
    }

    @Test
    @DisplayName("Цифры в аккаунте")
    @Description("Ввод email с цифрами в аккаунте ")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckEmailWithNumericInAccountNAme() throws InterruptedException {
        ccp.setEmail("kore2nchuk123@gmail.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertFalse(ccp.isVisibleErrorEmail());
    }

    @Test
    @DisplayName("Цифры в домене ")
    @Description("Ввод email с цифрами в домене ")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckEmailWithNumericInDomen() throws InterruptedException {
        ccp.setEmail("korenchuk@g6mai78l.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertFalse(ccp.isVisibleErrorEmail());
    }

    @Test
    @DisplayName("Знак '-' в аккаунте")
    @Description("Ввод email со знаком '-'  в аккаунте")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckEmailWithDashInAccountNAme() throws InterruptedException {
        ccp.setEmail("ko-ren-chuk@gmail.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertFalse(ccp.isVisibleErrorEmail());
    }

    @Test
    @DisplayName("Знак '-' в домене")
    @Description("Ввод email со знаком '-' в домене ")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckEmailWithDashInDomen() throws InterruptedException {
        ccp.setEmail("korenchuk@g-mai-l.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertFalse(ccp.isVisibleErrorEmail());
    }

    @Test
    @DisplayName("Знак '_' в аккаунте")
    @Description("Ввод email со знаком '_' в аккаунте ")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckEmailWithUnderscoreInAccountNAme() throws InterruptedException {
        ccp.setEmail("ko_ren_chuk@gmail.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertFalse(ccp.isVisibleErrorEmail());
    }

    @Test
    @DisplayName("Знак '_' в домене")
    @Description("Ввод email со знаком '_' в домене ")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckEmailWithUnderscoreInDomen() throws InterruptedException {
        ccp.setEmail("korenchuk@g_ma_il.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertFalse(ccp.isVisibleErrorEmail());
    }

    @Test
    @DisplayName("Знак '.' в аккаунте")
    @Description("Ввод email со знаком '.' в аккаунте ")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckEmailWithDotInAccountNAme() throws InterruptedException {
        ccp.setEmail("kore.nchuk@gmail.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertFalse(ccp.isVisibleErrorEmail());
    }

    @Test
    @DisplayName("Несколько '.' в домене")
    @Description("Ввод email со знаком '.' в домене ")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckEmailWithSomeDotsInDomen() throws InterruptedException {
        ccp.setEmail("korenchuk@gmail.mail.com.ru");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertFalse(ccp.isVisibleErrorEmail());
    }

    @Test
    @DisplayName("Отсутствие '.' в домене")
    @Description("Ввод email со знаком '.' в домене ")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckEmailWithoutDotsInDomen() throws InterruptedException {
        ccp.setEmail("korenchuk@gmailcom");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    @DisplayName("Большая строка")
    @Description("Ввод email содержащий 1000 букв в аккауне ")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckEmailMaxLenght() throws InterruptedException {
        String email="";
        for(int i=0;i<1000;i++){
            email+="k";
        }
        ccp.setEmail(email+"@gmail.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    @DisplayName("Спец. символы")
    @Description("Ввод email содержащий спец. символы в аккауне ")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckEmailDifferentSymbols() throws InterruptedException {
        String email = help.generateRandomString(1000, GeneratorMode.ANY_CHARACTERS);
        ccp.setEmail(email+"@gmail.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    @DisplayName("Отсутствие @ ")
    @Description("Ввод email не содержащий @ ")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckEmailWithoutAt() throws InterruptedException {
        ccp.setEmail("korenchukgmail.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    @DisplayName("Несколько @ ")
    @Description("Ввод email содержащий несколько @ ")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckEmailWithSomeAt() throws InterruptedException {
        ccp.setEmail("kore@nchuk@gmail.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    @DisplayName("Пробелы в аккаунте ")
    @Description("Ввод email содержащий пробелы в аккаунте ")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckEmailWithSpaceInAccountName() throws InterruptedException {
        ccp.setEmail("kore nchuk@gmail.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    @DisplayName("Пробелы в домене ")
    @Description("Ввод email содержащий пробелы в домене ")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckEmailWithSpaceDotsInDomen() throws InterruptedException {
        ccp.setEmail("korenchuk@gmail .com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    @DisplayName("Отсутствие аккаунта и домена ")
    @Description("Ввод email не содержащий аккаунта и домена ")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckEmailWithoutAccountNameAndDomen() throws InterruptedException {
        ccp.setEmail("@.");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    @DisplayName("Отсутствие аккаунта ")
    @Description("Ввод email не содержащий аккаунта ")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckEmailWithoutAccountName() throws InterruptedException {
        ccp.setEmail("@gmail.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    @DisplayName("Отсутствие домена ")
    @Description("Ввод email не содержащий домена ")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckEmailWithoutDomen() throws InterruptedException {
        ccp.setEmail("korenchuk@.");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    @DisplayName("Длинный домен ")
    @Description("Ввод email содержащий много символов в домене ")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckIncorrectDomen() throws InterruptedException {
        ccp.setEmail("korenchuk@gmail.russianfederation");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    @DisplayName("Спец символы в акакунте ")
    @Description("Ввод email  содержащий спец. символы в аккаунте ")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckEmailWithSpecificSymbolsInAccountName() throws InterruptedException {
        ccp.setEmail("k+or};<en!chuk@gmail.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    @DisplayName("Спец символы в домене ")
    @Description("Ввод email содержащий спец символы в домене ")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckEmailWithSpecificSymbolsInDomen() throws InterruptedException {
        ccp.setEmail("korenchuk@gmail.c+om");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    @DisplayName("Один символ в домене")
    @Description("Ввод email содержащий один символ в домене ")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckEmailWithOneLetterInDomen() throws InterruptedException {
        ccp.setEmail("korenchuk@gmail.c");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    @DisplayName("Кириллица в аккаунте")
    @Description("Ввод email содержащий кириллицу в аккаунте ")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckEmailWithCirilicInAccount() throws InterruptedException {
        ccp.setEmail("kоrеnchuk@gmail.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    @DisplayName("Кириллица в домене")
    @Description("Ввод email содержащий кириллицу в домене ")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckEmailWithCirilicInDomen() throws InterruptedException {
        ccp.setEmail("korenchuk@gmаil.cоm");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    @DisplayName("Кириллица ")
    @Description("Ввод email используя русский алфавит ")
    @Feature("Создание кандидата")
    @Story("Сценарий 10 – Проверка тексового поля 'Эл. почта'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckEmailWithCirilic() throws InterruptedException {
        ccp.setEmail("аня@почта.бай");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @After
    public void shutDown() {
        driver.close();
        WebDriverSingleton.destroyInstance();
    }
}