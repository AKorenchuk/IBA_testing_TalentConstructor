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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

public class AdditionResumeTest {

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
    @DisplayName("Загрузка DOC")
    @Description("Загрузка файлов с расширением DOC")
    @Feature("Создание кандидата")
    @Story("Сценарий 17 – Загрузка резюме")
    @Severity(SeverityLevel.NORMAL)
    public void loadResumeDOC() throws Exception {
        ccp.loadResume();
        ccp.loadFileSikuli("resources/Trush_Konstantin.doc");
        Thread.sleep(3000);
        Assert.assertEquals("Konstantin", ccp.getName());
        Assert.assertEquals("Trush", ccp.getLastName());
        Assert.assertEquals("+375 (29) 5238413", ccp.getPhone());
        Assert.assertEquals("kostyatrush98@mail.ru ", ccp.getMail());
    }

    @Test
    public void loadOtherResumeDOC() throws Exception {
        ccp.loadResume();
        ccp.loadFileSikuli("resources/Tochilo.doc");
        Thread.sleep(5000);
        WebElement el = driver.findElement(By.xpath("//input[@id='name']"));
        Assert.assertEquals("Анна", el.getText());
        //Assert.assertEquals("Точило", ccp.getLastName());
        //Assert.assertEquals("+375 29 8285183", ccp.getPhone());
       // Assert.assertEquals("ankabrest@mail.ru ", ccp.getMail());
    }

    @Test
    @DisplayName("Загрузка PDF")
    @Description("Загрузка файлов с расширением PDF")
    @Feature("Создание кандидата")
    @Story("Сценарий 17 – Загрузка резюме")
    @Severity(SeverityLevel.NORMAL)
    public void loadResumePDF() throws Exception {
        ccp.loadResume();
        ccp.loadFileSikuli("resources/Trush_Konstantin.pdf");
        Thread.sleep(3000);
        Assert.assertEquals("Konstantin", ccp.getName());
        Assert.assertEquals("Trush", ccp.getLastName());
        Assert.assertEquals("+375 (29) 5238413", ccp.getPhone());
        Assert.assertEquals("kostyatrush98@mail.ru ", ccp.getMail());
    }


    @After
    public void shutDown() throws IOException {
        help.closeBrowser() ;
    }
}
