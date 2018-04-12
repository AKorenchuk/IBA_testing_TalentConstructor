package edu.bsuir.test.candidate;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.test.services.SignIn;
import edu.bsuir.test.services.enums.Role;
import edu.bsuir.web.page.CandidatePage;
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

public class CandidatePageTest {

    public WebDriver driver ;
    public SignIn form = new SignIn();
    public MenuPage mp = new MenuPage();
    public CandidatePage cp = new CandidatePage();


    public String CANDIDATE_PAGE = "Кандидаты - Конструктор Талантов";

    @Before
    public void init() throws SAXException, ParserConfigurationException, XPathExpressionException, IOException {
        driver = WebDriverSingleton.getInstance();
        form.signIn(Role.CHIEF_RECRUITER);
    }

    @Test
    @DisplayName("Кандидаты")
    @Description("Переход н страницу, где содержится информация о кандидатах")
    @Feature("Создание кандидата")
    @Story("Сценарий 16 – Переход на страницу с кандидатами")
    @Severity(SeverityLevel.NORMAL)
    public void сheckTransitionToCadidatesPageTest() {
        mp.moveToElementAdaptPage();
        cp.openCandidatesPage();
        Assert.assertEquals(CANDIDATE_PAGE, driver.getTitle());
    }

    @After
    public void shutDown() {
        driver.close();
        WebDriverSingleton.destroyInstance();
    }
}
