package edu.bsuir.test.candidate;


import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.entity.enums.GeneratorMode;
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
    public void сheckEmailInLowerCase() throws InterruptedException {
        ccp.setEmail("korenchuk@gmail.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertFalse(ccp.isVisibleErrorEmail());
    }

    @Test
    public void сheckEmailInUpperCase() throws InterruptedException {
        ccp.setEmail("KORENCHUK@GMAIL.COM");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertFalse(ccp.isVisibleErrorEmail());
    }

    @Test
    public void сheckEmailWithNumericInAccountNAme() throws InterruptedException {
        ccp.setEmail("kore2nchuk123@gmail.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertFalse(ccp.isVisibleErrorEmail());
    }

    @Test
    public void сheckEmailWithNumericInDomen() throws InterruptedException {
        ccp.setEmail("korenchuk@g6mai78l.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertFalse(ccp.isVisibleErrorEmail());
    }

    @Test
    public void сheckEmailWithDashInAccountNAme() throws InterruptedException {
        ccp.setEmail("ko-ren-chuk@gmail.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertFalse(ccp.isVisibleErrorEmail());
    }

    @Test
    public void сheckEmailWithDashInDomen() throws InterruptedException {
        ccp.setEmail("korenchuk@g-mai-l.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertFalse(ccp.isVisibleErrorEmail());
    }

    @Test
    public void сheckEmailWithUnderscoreInAccountNAme() throws InterruptedException {
        ccp.setEmail("ko_ren_chuk@gmail.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertFalse(ccp.isVisibleErrorEmail());
    }

    @Test
    public void сheckEmailWithUnderscoreInDomen() throws InterruptedException {
        ccp.setEmail("korenchuk@g_ma_il.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertFalse(ccp.isVisibleErrorEmail());
    }

    @Test
    public void сheckEmailWithDotInAccountNAme() throws InterruptedException {
        ccp.setEmail("kore.nchuk@gmail.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertFalse(ccp.isVisibleErrorEmail());
    }

    @Test
    public void сheckEmailWithSomeDotsInDomen() throws InterruptedException {
        ccp.setEmail("korenchuk@gmail.mail.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertFalse(ccp.isVisibleErrorEmail());
    }

    @Test
    public void сheckEmailWithoutDotsInDomen() throws InterruptedException {
        ccp.setEmail("korenchuk@gmailcom");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
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
    public void сheckEmailDifferentSymbols() throws InterruptedException {
        String email = help.generateRandomString(1000, GeneratorMode.ANY_CHARACTERS);
        ccp.setEmail(email+"@gmail.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    public void сheckEmailWithoutAt() throws InterruptedException {
        ccp.setEmail("korenchukgmail.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    public void сheckEmailWithSomeAt() throws InterruptedException {
        ccp.setEmail("kore@nchuk@gmail.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    public void сheckEmailWithSpaceInAccountName() throws InterruptedException {
        ccp.setEmail("kore nchuk@gmail.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    public void сheckEmailWithSpaceDotsInDomen() throws InterruptedException {
        ccp.setEmail("korenchuk@gmail .com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    public void сheckEmailWithoutAccountNameAndDomen() throws InterruptedException {
        ccp.setEmail("@.");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    public void сheckEmailWithoutAccountName() throws InterruptedException {
        ccp.setEmail("@gmail.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    public void сheckEmailWithoutDomen() throws InterruptedException {
        ccp.setEmail("korenchuk@.");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    public void сheckIncorrectDomen() throws InterruptedException {
        ccp.setEmail("korenchuk@gmail.russianfederation");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    public void сheckEmailWithSpecificSymbolsInAccountName() throws InterruptedException {
        ccp.setEmail("k+or};<en!chuk@gmail.com");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    public void сheckEmailWithSpecificSymbolsInDomen() throws InterruptedException {
        ccp.setEmail("korenchuk@gmail.c+om");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
    public void сheckEmailWithOneLetterInDomen() throws InterruptedException {
        ccp.setEmail("korenchuk@gmail.c");
        ccp.doFreeClick();
        Thread.sleep(2000);
        Assert.assertTrue(ccp.isVisibleErrorEmail());
    }

    @Test
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