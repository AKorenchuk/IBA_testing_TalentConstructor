package edu.bsuir.test.candidate;

import edu.bsuir.driver.WebDriverSingleton;
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

public class InjectionsAtTextField {

    public WebDriver driver ;
    public SignIn form = new SignIn();
    public CreateCandidatePage ccp = new CreateCandidatePage();


    @Before
    public void init() throws SAXException, ParserConfigurationException, XPathExpressionException, IOException {
        driver = WebDriverSingleton.getInstance();
        form.signIn(Role.CHIEF_RECRUITER);
        ccp.openCreateProfile();
    }

    @Test
    @DisplayName("Инъекция XSS в поле 'имя' ")
    @Description("Сохранения пользователя с инъекцией в 'иммени'")
    @Feature("Создание кандидата")
    @Story("Сценарий 9 – Инъекции")
    @Severity(SeverityLevel.NORMAL)
    public void сheckInjectionXSSAtFirstName() throws InterruptedException {
        ccp.setLastName("Korenchuk");
        ccp.setName("http://ha.ckers.org/xss.html");
        ccp.setPhoneNumber("2345678");
        ccp.setEmail("korenchuk@mail.com");
        ccp.saveCandidateProfile();
        Thread.sleep(2000);
        Assert.assertEquals("Korenchuk http://ha.ckers.org/xss.html", ccp.getFIO());
    }


    @Test
    @DisplayName("Инъекция XSS в поле 'фамилия' ")
    @Description("Сохранения пользователя с инъекцией в 'фамилии'")
    @Feature("Создание кандидата")
    @Story("Сценарий 9 – Инъекции")
    @Severity(SeverityLevel.NORMAL)
    public void сheckInjectionXSSAtLastName() throws InterruptedException {
        ccp.setLastName("<script>alert(\"xss!\")</script>");
        ccp.setName("Anna");
        ccp.setPhoneNumber("2345678");
        ccp.setEmail("korenchuk@mail.com");
        ccp.saveCandidateProfile();
        Thread.sleep(2000);
        Assert.assertEquals("<script>alert(\"xss!\")</script> Anna", ccp.getFIO());
    }

    @Test
    @DisplayName("Инъекция в поле 'фамилия' ")
    @Description("Сохранения пользователя с инъекцией в 'фамилии'")
    @Feature("Создание кандидата")
    @Story("Сценарий 9 – Инъекции")
    @Severity(SeverityLevel.NORMAL)
    public void сheckInjectionAtLastName() throws InterruptedException {
        ccp.setLastName("\"${code}\";");
        ccp.setName("Anna");
        ccp.setPhoneNumber("2345678");
        ccp.setEmail("korenchuk@mail.com");
        ccp.saveCandidateProfile();
        Thread.sleep(2000);
        Assert.assertEquals("\"${code}\"; Anna", ccp.getFIO());
    }



    @After
    public void shutDown() {
        driver.close();
        WebDriverSingleton.destroyInstance();
    }
}


