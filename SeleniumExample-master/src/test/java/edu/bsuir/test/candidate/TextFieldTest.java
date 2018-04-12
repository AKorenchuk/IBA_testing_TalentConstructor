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

public class TextFieldTest {


    public WebDriver driver ;
    public SignIn form = new SignIn();
    public CreateCandidatePage ccp = new CreateCandidatePage();
    public  Helper help = new Helper();



    @Before
    public void init() throws SAXException, ParserConfigurationException, XPathExpressionException, IOException {
        driver = WebDriverSingleton.getInstance();
        form.signIn(Role.CHIEF_RECRUITER);
        ccp.openCreateProfile();
    }


    @Test
    @DisplayName("Ввод букв")
    @Description("Ввод имени, содержащий 20 букв")
    @Feature("Создание кандидата")
    @Story("Сценарий 1 – Проверка тексового поля 'Имя'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckFirstName() {
        String firstName = help.generateRandomString(20, GeneratorMode.ALPHA);
        ccp.setName(firstName);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorName());
    }

    @Test
    @DisplayName("Ввод символов")
    @Description("Ввод имени, содержащий 20 любых символов")
    @Feature("Создание кандидата")
    @Story("Сценарий 1 – Проверка тексового поля 'Имя'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckSpecificSymbolsAtFirstName() {
        String firstName = help.generateRandomString(20, GeneratorMode.ANY_CHARACTERS);
        ccp.setName(firstName);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorName());
    }

    @Test
    @DisplayName("Ввод большой строки")
    @Description("Ввод имени, содержащий 200 любых символов")
    @Feature("Создание кандидата")
    @Story("Сценарий 1 – Проверка тексового поля 'Имя'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckLenghtOfFirstName() {
        String firstName = help.generateRandomString(200, GeneratorMode.ANY_CHARACTERS);
        ccp.setName(firstName);
        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorName());
    }


    @Test
    @DisplayName("Ввод букв")
    @Description("Ввод фамилии, содержащий 20 букв")
    @Feature("Создание кандидата")
    @Story("Сценарий 2 – Проверка тексового поля 'Фамилия'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckLastName() {
        String lastName = help.generateRandomString(20, GeneratorMode.ALPHA);
        ccp.setLastName(lastName);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorLastName());
    }

    @Test
    @DisplayName("Ввод символов")
    @Description("Ввод фамилии, содержащий 20 любых символов")
    @Feature("Создание кандидата")
    @Story("Сценарий 2 – Проверка тексового поля 'Фамилия'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckSpecificSymbolsAtLastName() {
        String lastName = help.generateRandomString(20, GeneratorMode.ANY_CHARACTERS);
        ccp.setLastName(lastName);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorLastName());
    }

    @Test
    @DisplayName("Ввод большой строки")
    @Description("Ввод фамилии, содержащий 200 любых символов")
    @Feature("Создание кандидата")
    @Story("Сценарий 2 – Проверка тексового поля 'Фамилия'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckLenghtOfLastName() {
        String lastName = help.generateRandomString(200, GeneratorMode.ANY_CHARACTERS);
        ccp.setLastName(lastName);
        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorLastName());
    }

    @Test
    @DisplayName("Ввод букв")
    @Description("Ввод отчества, содержащий 20 букв")
    @Feature("Создание кандидата")
    @Story("Сценарий 3 – Проверка тексового поля 'Отчество'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckSecondName() {
        String secondName = help.generateRandomString(20, GeneratorMode.ALPHA);
        ccp.setSecondName(secondName);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorSecondName());
    }

    @Test
    @DisplayName("Ввод специальных символов")
    @Description("Ввод отчества, содержащий 20 специальных символов")
    @Feature("Создание кандидата")
    @Story("Сценарий 3 – Проверка тексового поля 'Отчество'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckSpecificSymbolsAtSecondName() {
        String secondName = help.generateRandomString(20, GeneratorMode.ANY_CHARACTERS);
        ccp.setSecondName(secondName);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorSecondName());
    }

    @Test
    @DisplayName("Ввод большой строки")
    @Description("Ввод отчества, содержащий 200 спец. символов и букв")
    @Feature("Создание кандидата")
    @Story("Сценарий 3 – Проверка тексового поля 'Отчество'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckLenghtOfSecondName() {
        String secondName = help.generateRandomString(200, GeneratorMode.ANY_CHARACTERS);
        ccp.setSecondName(secondName);
        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorSecondName());
    }

    @Test
    @DisplayName("Ввод букв")
    @Description("Ввод skype, содержащий 20 букв")
    @Feature("Создание кандидата")
    @Story("Сценарий 4 – Проверка тексового поля 'Skype'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckSkype() {
        String skype = help.generateRandomString(20, GeneratorMode.ALPHA);
        ccp.setSkype(skype);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorSkype());
    }

    @Test
    @DisplayName("Ввод спец. символов")
    @Description("Ввод skype, содержащий 20 спец. символов")
    @Feature("Создание кандидата")
    @Story("Сценарий 4 – Проверка тексового поля 'Skype'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckSpecificSymbolsAtSkype() {
        String skype = help.generateRandomString(20, GeneratorMode.ANY_CHARACTERS);
        ccp.setSkype(skype);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorSkype());
    }

    @Test
    @DisplayName("Ввод большой строки")
    @Description("Ввод skype, содержащий 200 спец. символов и букв")
    @Feature("Создание кандидата")
    @Story("Сценарий 4 – Проверка тексового поля 'Skype'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckLenghtOfSkype() {
        String skype = help.generateRandomString(200, GeneratorMode.ANY_CHARACTERS);
        ccp.setSkype(skype);
        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorSkype());
    }

    @Test
    @DisplayName("Ввод букв")
    @Description("Ввод страны, содержащий 20 букв")
    @Feature("Создание кандидата")
    @Story("Сценарий 5 – Проверка тексового поля 'Страна'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckCountry() {
        String skype = help.generateRandomString(20, GeneratorMode.ALPHA);
        ccp.setSkype(skype);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorSkype());
    }

    @Test
    @DisplayName("Ввод цифр")
    @Description("Ввод страны, содержащий 20 цифр")
    @Feature("Создание кандидата")
    @Story("Сценарий 5 – Проверка тексового поля 'Страна'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckNumberAtCountry() {
        String country = help.generateRandomString(20, GeneratorMode.NUMERIC);
        ccp.setCountry(country);
        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorCountry());
    }

    @Test
    @DisplayName("Ввод спец. символов")
    @Description("Ввод страны, содержащий 20 спец. символов")
    @Feature("Создание кандидата")
    @Story("Сценарий 5 – Проверка тексового поля 'Страна'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckSpecificSymbolsAtCountry() {
        String country = help.generateRandomString(20, GeneratorMode.ANY_CHARACTERS);
        ccp.setCountry(country);
        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorCountry());
    }

    @Test
    @DisplayName("Ввод большой строки")
    @Description("Ввод страны, содержащий 200 спец. символов и букв")
    @Feature("Создание кандидата")
    @Story("Сценарий 5 – Проверка тексового поля 'Страна'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckLenghtOfCountry() {
        String country = help.generateRandomString(200, GeneratorMode.ANY_CHARACTERS);
        ccp.setCountry(country);
        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorCountry());
    }

    @Test
    @DisplayName("Ввод букв")
    @Description("Ввод адреса, содержащий 20 и букв")
    @Feature("Создание кандидата")
    @Story("Сценарий 6 – Проверка тексового поля 'Адрес'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckCity() {
        String city = help.generateRandomString(20, GeneratorMode.ALPHA);
        ccp.setCity(city);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorCity());
    }

    @Test
    @DisplayName("Ввод цир")
    @Description("Ввод адреса, содержащий 20 цифр")
    @Feature("Создание кандидата")
    @Story("Сценарий 6 – Проверка тексового поля 'Адрес'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckNumberAtCity() {
        String city = help.generateRandomString(20, GeneratorMode.NUMERIC);
        ccp.setCity(city);
        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorCity());
    }

    @Test
    @DisplayName("Ввод спецю символов")
    @Description("Ввод адреса, содержащий 20 спец. символов")
    @Feature("Создание кандидата")
    @Story("Сценарий 6 – Проверка тексового поля 'Адрес'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckSpecialSymbolsAtCity() {
        String city = help.generateRandomString(20, GeneratorMode.SPECIAL_SYMBOLS);
        ccp.setCity(city);
        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorCity());
    }

    @Test
    @DisplayName("Ввод большой строки")
    @Description("Ввод адреса, содержащий 200 спец.символов и букв")
    @Feature("Создание кандидата")
    @Story("Сценарий 6 – Проверка тексового поля 'Адрес'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckLenghtOfCity() {
        String city = help.generateRandomString(300, GeneratorMode.ANY_CHARACTERS);
        ccp.setCity(city);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorCity());
    }


    @Test
    @DisplayName("Ввод букв")
    @Description("Ввод желаемой позиции, содержащий 20 букв")
    @Feature("Создание кандидата")
    @Story("Сценарий 7 – Проверка тексового поля 'Желаемая позиция'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckDesiredPosition() {
        String desiredPosition = help.generateRandomString(20, GeneratorMode.ALPHA);
        ccp.setDesiredPosition(desiredPosition);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorDesiredPosition());
    }

    @Test
    @DisplayName("Ввод цифр")
    @Description("Ввод желаемой позиции, содержащий 20 цифр")
    @Feature("Создание кандидата")
    @Story("Сценарий 7 – Проверка тексового поля 'Желаемая позиция'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckNumberAtDesiredPosition() {
        String desiredPosition = help.generateRandomString(20, GeneratorMode.NUMERIC);
        ccp.setDesiredPosition(desiredPosition);
        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorDesiredPosition());
    }

    @Test
    @DisplayName("Ввод спец. символов")
    @Description("Ввод желаемой позиции, содержащий 20 спец.символов")
    @Feature("Создание кандидата")
    @Story("Сценарий 7 – Проверка тексового поля 'Желаемая позиция'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckSpecialSymbolsAtDesiredPosition() {
        String desiredPosition = help.generateRandomString(20, GeneratorMode.SPECIAL_SYMBOLS);
        ccp.setDesiredPosition(desiredPosition);
        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorDesiredPosition());
    }

    @Test
    @DisplayName("Ввод большой строки")
    @Description("Ввод желаемой позиции, содержащий 200 букв и спец. символов")
    @Feature("Создание кандидата")
    @Story("Сценарий 7 – Проверка тексового поля 'Желаемая позиция'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckLenghtOfDesiredPosition() {
        String desiredPosition = help.generateRandomString(60, GeneratorMode.ANY_CHARACTERS);
        ccp.setDesiredPosition(desiredPosition);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorDesiredPosition());
    }

    @Test
    @DisplayName("Ввод букв")
    @Description("Ввод дополнительной информации, содержащий 20 букв")
    @Feature("Создание кандидата")
    @Story("Сценарий 7 – Проверка тексового поля 'Дополнительная информация'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckAdditionalInfo() {
        String additionalInfo = help.generateRandomString(20, GeneratorMode.ALPHA);
        ccp.setAdditionalInfo(additionalInfo);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorAdditionalInfo());
    }

    @Test
    @DisplayName("Ввод цифр")
    @Description("Ввод дополнительной информации, содержащий 20 цифр")
    @Feature("Создание кандидата")
    @Story("Сценарий 7 – Проверка тексового поля 'Дополнительная информация'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckNumberAtAdditionalInfo() {
        String additionalInfo = help.generateRandomString(20, GeneratorMode.NUMERIC);
        ccp.setAdditionalInfo(additionalInfo);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorAdditionalInfo());
    }

    @Test
    @DisplayName("Ввод спец. символов")
    @Description("Ввод дополнительной информации, содержащий 20 спец.символов")
    @Feature("Создание кандидата")
    @Story("Сценарий 7 – Проверка тексового поля 'Дополнительная информация'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckSpecialSymbolsAtAdditionalInfo() {
        String additionalInfo = help.generateRandomString(20, GeneratorMode.SPECIAL_SYMBOLS);
        ccp.setAdditionalInfo(additionalInfo);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorAdditionalInfo());
    }

    @Test
    @DisplayName("Ввод большой строки")
    @Description("Ввод дополнительной информации, содержащий 10020 спец.символов и букв")
    @Feature("Создание кандидата")
    @Story("Сценарий 7 – Проверка тексового поля 'Дополнительная информация'")
    @Severity(SeverityLevel.NORMAL)
    public void сheckLenghtOfAdditionalInfo() {
        String additionalInfo = help.generateRandomString(10020, GeneratorMode.ANY_CHARACTERS);
        ccp.setAdditionalInfo(additionalInfo);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorAdditionalInfo());
    }


    @After
    public void shutDown() throws IOException {
        help.closeBrowser() ;
    }
}