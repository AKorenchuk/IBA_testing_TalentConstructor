package edu.bsuir.test.candidate;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.test.services.SignIn;
import edu.bsuir.test.services.enums.Role;
import edu.bsuir.web.page.CandidatePage;
import edu.bsuir.web.page.CreateCandidatePage;
import edu.bsuir.web.page.MenuPage;
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

public class EditingCandaidatePage {

    public WebDriver driver;
    public SignIn form = new SignIn();
    public MenuPage mp = new MenuPage();
    public CandidatePage cp = new CandidatePage();
    public CreateCandidatePage ccp = new CreateCandidatePage();


    @Before
    public void init() throws SAXException, ParserConfigurationException, XPathExpressionException, IOException {
        driver = WebDriverSingleton.getInstance();
        form.signIn(Role.CHIEF_RECRUITER);
        ccp.openCreateProfile();
    }



    @Test
    @DisplayName("Редактирование кандидата")
    @Description("Создаем кандидата, нажимаем на кнопку 'Редактировать', изменяем некоторые поля и вновь сохраняем ")
    @Feature("Создание кандидата")
    @Story("Сценарий 11 – Редактирование кандидата")
    @Severity(SeverityLevel.NORMAL)
    public void editCadidateProfile() {
        ccp.setLastName("Korenchuk");
        ccp.setName("Anna");
        ccp.setPhoneNumber("2345678");
        ccp.setEmail("korenchuk@mail.com");
        ccp.saveCandidateProfile();
        Assert.assertEquals("Korenchuk Anna", ccp.getFIO());
        Assert.assertEquals("2345678", ccp.getPhone());
        Assert.assertEquals("korenchuk@mail.com", ccp.getMail());
        ccp.editCandidateProfile();
        Assert.assertEquals("Anna", ccp.getName());
        Assert.assertEquals("Korenchuk", ccp.getLastName());
        Assert.assertEquals("2345678", ccp.getPhoneNumber());
        Assert.assertEquals("korenchuk@mail.com", ccp.getEmail());
        ccp.setPhoneNumber("+345 345 23457");
        ccp.saveCandidateProfile();
        Assert.assertEquals("Korenchuk Anna", ccp.getFIO());
        Assert.assertEquals("+345 345 23457", ccp.getPhone());
        Assert.assertEquals("korenchuk@mail.com", ccp.getMail());
    }


    @After
    public void shutDown() {
        driver.close();
        WebDriverSingleton.destroyInstance();
    }
}
