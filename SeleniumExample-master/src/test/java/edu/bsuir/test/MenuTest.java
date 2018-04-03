package edu.bsuir.test;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.test.services.SignIn;
import edu.bsuir.test.services.enums.Role;
import edu.bsuir.web.page.MenuPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;


public class MenuTest {

    private WebDriver driver = WebDriverSingleton.getInstance();

    public MenuPage mp = new MenuPage();
    public SignIn form = new SignIn();

    public String ADAPT_PAGE = "Подбор и адаптация - Конструктор Талантов";
    public String DIRECTORIES_PAGE = "Справочники - Конструктор Талантов";
    public String MAIN_PAGE = "Главная - Конструктор Талантов";

    @Test
    public void сheckTransitionToAdaptPageTest() throws InterruptedException, SAXException, ParserConfigurationException, XPathExpressionException, IOException {
        form.signIn(Role.CHIEF_RECRUITER);
        mp.openAdaptPage();
        Assert.assertEquals(ADAPT_PAGE, driver.getTitle());
    }


    @Test
    public void сheckTransitionToDirectoriesPageTest() throws InterruptedException, SAXException, ParserConfigurationException, XPathExpressionException, IOException {
        form.signIn(Role.CHIEF_RECRUITER);
        mp.openDirectoryPage();
        Assert.assertEquals(DIRECTORIES_PAGE, driver.getTitle());
    }

    @Test
    public void сheckTransitionToMainPageTest() throws InterruptedException, SAXException, ParserConfigurationException, XPathExpressionException, IOException {
        form.signIn(Role.CHIEF_RECRUITER);
        mp.openMainPage();
        Assert.assertEquals(MAIN_PAGE, driver.getTitle());
    }

    @Test
    public void сheckTransitionToNotificationPageTest() throws InterruptedException, SAXException, ParserConfigurationException, XPathExpressionException, IOException {
        form.signIn(Role.CHIEF_RECRUITER);
        mp.openNotification();
        Assert.assertTrue( (mp.getNotificationTitle()).contains("Notifications "));
    }

    @After
    public void shutDown() {
        driver.close();
        WebDriverSingleton.destroyInstance();
    }

}
