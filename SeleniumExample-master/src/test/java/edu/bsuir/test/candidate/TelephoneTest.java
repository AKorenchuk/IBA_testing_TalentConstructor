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

public class TelephoneTest {

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
    public void сheckEmptyPhone() {
    }

    @Test
    public void сheckCorrectPhoneNumber() throws InterruptedException {
        ccp.setPhoneNumber("8081561");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertFalse(ccp.isVisibleErrorPhone());
    }

    @Test
    public void сheckPhoneNumberWithLettersAndNumeric() throws InterruptedException {
        ccp.setPhoneNumber("3752980861callme");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorPhone());
    }

    @Test
    public void сheckLetter() throws InterruptedException {
        ccp.setPhoneNumber("my phone number");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorPhone());
    }

    @Test
    public void сheckPhoneNumberWithDash() throws InterruptedException {
        ccp.setPhoneNumber("808-15-61");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertFalse(ccp.isVisibleErrorPhone());
    }

    @Test
    public void сheckPhoneNumberWithCountryCode() throws InterruptedException {
        ccp.setPhoneNumber("+375298081561");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertFalse(ccp.isVisibleErrorPhone());
    }

    @Test
    public void сheckPhoneNumberWithSpace() throws InterruptedException {
        ccp.setPhoneNumber("375 29 808 15 61");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertFalse(ccp.isVisibleErrorPhone());
    }

    @Test
    public void сheckPhoneNumberWithBrackets() throws InterruptedException {
        ccp.setPhoneNumber("375(29)8081561");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertFalse(ccp.isVisibleErrorPhone());
    }

    @Test
    public void сheckPhoneNumberWithInvalidBrackets() throws InterruptedException {
        ccp.setPhoneNumber("375)29()8081561");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorPhone());
    }

    @Test
    public void сheckPhoneNumberWithSpecificSymbolsPart1() throws InterruptedException {
        ccp.setPhoneNumber("*100#");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorPhone());
    }

    @Test
    public void сheckPhoneNumberWithSpecificSymbolsPart2() throws InterruptedException {
        ccp.setPhoneNumber("234&234^2345!6789%");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorPhone());
    }

    @Test
    public void сheckPhoneNumberMinLenght() throws InterruptedException {
        ccp.setPhoneNumber("2");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorPhone());
    }

    @Test
    public void сheckPhoneNumberMaxLenght() throws InterruptedException {
        String phone = help.generateRandomString(60, GeneratorMode.NUMERIC);
        ccp.setPhoneNumber(phone);
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorPhone());
    }

    @After
    public void shutDown() throws IOException {
        help.closeBrowser() ;
    }


}
