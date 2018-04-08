package edu.bsuir.test.candidate;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.entity.GeneratorMode;
import edu.bsuir.entity.Helper;
import edu.bsuir.test.services.SignIn;
import edu.bsuir.test.services.enums.Role;
import edu.bsuir.web.page.CreateCandidatePage;
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
    public void сheckFirstName() {
        String firstName = help.generateRandomString(20, GeneratorMode.ALPHA);
        ccp.setName(firstName);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorName());
    }

    @Test
    public void сheckSpecificSymbolsAtFirstName() {
        String firstName = help.generateRandomString(20, GeneratorMode.ANY_CHARACTERS);
        ccp.setName(firstName);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorName());
    }

    @Test
    public void сheckLenghtOfFirstName() {
        String firstName = help.generateRandomString(200, GeneratorMode.ANY_CHARACTERS);
        ccp.setName(firstName);
        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorName());
    }


    @Test
    public void сheckLastName() {
        String lastName = help.generateRandomString(20, GeneratorMode.ALPHA);
        ccp.setLastName(lastName);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorLastName());
    }

    @Test
    public void сheckSpecificSymbolsAtLastName() {
        String lastName = help.generateRandomString(20, GeneratorMode.ANY_CHARACTERS);
        ccp.setLastName(lastName);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorLastName());
    }

    @Test
    public void сheckLenghtOfLastName() {
        String lastName = help.generateRandomString(200, GeneratorMode.ANY_CHARACTERS);
        ccp.setLastName(lastName);
        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorLastName());
    }

    @Test
    public void сheckSecondName() {
        String secondName = help.generateRandomString(20, GeneratorMode.ALPHA);
        ccp.setSecondName(secondName);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorSecondName());
    }

    @Test
    public void сheckSpecificSymbolsAtSecondName() {
        String secondName = help.generateRandomString(20, GeneratorMode.ANY_CHARACTERS);
        ccp.setSecondName(secondName);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorSecondName());
    }

    @Test
    public void сheckLenghtOfSecondName() {
        String secondName = help.generateRandomString(200, GeneratorMode.ANY_CHARACTERS);
        ccp.setSecondName(secondName);
        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorSecondName());
    }

    @Test
    public void сheckSkype() {
        String skype = help.generateRandomString(20, GeneratorMode.ALPHA);
        ccp.setSkype(skype);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorSkype());
    }

    @Test
    public void сheckSpecificSymbolsAtSkype() {
        String skype = help.generateRandomString(20, GeneratorMode.ANY_CHARACTERS);
        ccp.setSkype(skype);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorSkype());
    }

    @Test
    public void сheckLenghtOfSkype() {
        String skype = help.generateRandomString(200, GeneratorMode.ANY_CHARACTERS);
        ccp.setSkype(skype);
        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorSkype());
    }

    @Test
    public void сheckCountry() {
        String skype = help.generateRandomString(20, GeneratorMode.ALPHA);
        ccp.setSkype(skype);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorSkype());
    }

    @Test
    public void сheckNumberAtCountry() {
        String country = help.generateRandomString(20, GeneratorMode.NUMERIC);
        ccp.setCountry(country);
        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorCountry());
    }

    @Test
    public void сheckSpecificSymbolsAtCountry() {
        String country = help.generateRandomString(20, GeneratorMode.ANY_CHARACTERS);
        ccp.setCountry(country);
        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorCountry());
    }

    @Test
    public void сheckLenghtOfCountry() {
        String country = help.generateRandomString(200, GeneratorMode.ANY_CHARACTERS);
        ccp.setCountry(country);
        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorCountry());
    }

    @Test
    public void сheckCity() {
        String city = help.generateRandomString(20, GeneratorMode.ALPHA);
        ccp.setCity(city);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorCity());
    }

    @Test
    public void сheckNumberAtCity() {
        String city = help.generateRandomString(20, GeneratorMode.NUMERIC);
        ccp.setCity(city);
        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorCity());
    }

    @Test
    public void сheckSpecialSymbolsAtCity() {
        String city = help.generateRandomString(20, GeneratorMode.SPECIAL_SYMBOLS);
        ccp.setCity(city);
        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorCity());
    }

    @Test
    public void сheckLenghtOfCity() {
        String city = help.generateRandomString(300, GeneratorMode.ANY_CHARACTERS);
        ccp.setCity(city);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorCity());
    }


    @Test
    public void сheckDesiredPosition() {
        String desiredPosition = help.generateRandomString(20, GeneratorMode.ALPHA);
        ccp.setDesiredPosition(desiredPosition);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorDesiredPosition());
    }

    @Test
    public void сheckNumberAtDesiredPosition() {
        String desiredPosition = help.generateRandomString(20, GeneratorMode.NUMERIC);
        ccp.setDesiredPosition(desiredPosition);
        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorDesiredPosition());
    }

    @Test
    public void сheckSpecialSymbolsAtDesiredPosition() {
        String desiredPosition = help.generateRandomString(20, GeneratorMode.SPECIAL_SYMBOLS);
        ccp.setDesiredPosition(desiredPosition);
        ccp.doFreeClick();
        Assert.assertTrue(ccp.isVisibleErrorDesiredPosition());
    }

    @Test
    public void сheckLenghtOfDesiredPosition() {
        String desiredPosition = help.generateRandomString(60, GeneratorMode.ANY_CHARACTERS);
        ccp.setDesiredPosition(desiredPosition);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorDesiredPosition());
    }

    @Test
    public void сheckAdditionalInfo() {
        String additionalInfo = help.generateRandomString(20, GeneratorMode.ALPHA);
        ccp.setAdditionalInfo(additionalInfo);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorAdditionalInfo());
    }

    @Test
    public void сheckNumberAtAdditionalInfo() {
        String additionalInfo = help.generateRandomString(20, GeneratorMode.NUMERIC);
        ccp.setAdditionalInfo(additionalInfo);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorAdditionalInfo());
    }

    @Test
    public void сheckSpecialSymbolsAtAdditionalInfo() {
        String additionalInfo = help.generateRandomString(20, GeneratorMode.SPECIAL_SYMBOLS);
        ccp.setAdditionalInfo(additionalInfo);
        ccp.doFreeClick();
        Assert.assertFalse(ccp.isVisibleErrorAdditionalInfo());
    }

    @Test
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