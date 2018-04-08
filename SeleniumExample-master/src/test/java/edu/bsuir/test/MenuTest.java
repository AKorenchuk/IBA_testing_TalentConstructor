package edu.bsuir.test;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.test.services.SignIn;
import edu.bsuir.test.services.enums.Role;
import edu.bsuir.web.page.MenuPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

import static edu.bsuir.web.elements.LoginElement.LOGIN;
import static edu.bsuir.web.elements.LoginElement.PASSWORD;
import static edu.bsuir.web.elements.MenuElement.SETTING_POINT_1_TITLE;
import static edu.bsuir.web.elements.MenuElement.SETTING_POINT_2_MESSAGE;


public class MenuTest {

    private WebDriver driver = WebDriverSingleton.getInstance();

    public MenuPage mp = new MenuPage();
    public SignIn form = new SignIn();


    public String ADAPT_PAGE = "Подбор и адаптация - Конструктор Талантов";
    public String DIRECTORIES_PAGE = "Справочники - Конструктор Талантов";
    public String MAIN_PAGE = "Главная - Конструктор Талантов";
    public String PROFILE_PAGE = "Мой профиль - Конструктор Талантов";
    public String ADD_COMPETENCE_PAGE = "Добавить компетенцию - Конструктор Талантов";
    public String CALENDAR_PAGE = "Календарь - Конструктор Талантов";
    public String HELP_PAGE = "Помощь - Конструктор Талантов";

    @Before
    public void init() throws SAXException, ParserConfigurationException, XPathExpressionException, IOException {
        form.signIn(Role.CHIEF_RECRUITER);
    }

    @Test
    public void сheckTransitionToAdaptPageTest() {
        mp.openAdaptPage();
        Assert.assertEquals(ADAPT_PAGE, driver.getTitle());
    }


    @Test
    public void сheckTransitionToDirectoriesPageTest()  {
        mp.openDirectoryPage();
        Assert.assertEquals(DIRECTORIES_PAGE, driver.getTitle());
    }

    @Test
    public void сheckTransitionToMainPageTest()  {
        mp.openMainPage();
        Assert.assertEquals(MAIN_PAGE, driver.getTitle());
    }

    @Test
    public void сheckTransitionToNotificationPageTest()  {
        mp.openNotification();
        Assert.assertTrue( (mp.getNotificationTitle()).contains("Notifications "));
    }

    @Test
    public void сheckTransitionToProfilePageTest()  {
        mp.openProfileInfo();
        Assert.assertEquals( PROFILE_PAGE, driver.getTitle());
    }

    @Test
    public void сheckTransitionToAddCompetencePageTest()  {
        mp.openAddCompetencePage();
        Assert.assertEquals( ADD_COMPETENCE_PAGE, driver.getTitle());
    }

    @Test
    public void сheckTransitionToCalendarPageTest()  {
        mp.openCalendarPage();
        Assert.assertEquals( CALENDAR_PAGE, driver.getTitle());
    }

    @Test
    public void сheckTransitionToSettingPoint1Test()  {
        mp.openSettingPoint1();
        Assert.assertTrue( SETTING_POINT_1_TITLE.isElementPresent());
    }

    @Test
    public void сheckTransitionToSettingPoint2Test()  {
        mp.openSettingPoint2();
        Assert.assertTrue( SETTING_POINT_2_MESSAGE.isElementPresent());
    }

    @Test
    public void сheckTransitionToHelpPageTest()  {
        mp.openHelpPage();
        Assert.assertEquals( HELP_PAGE, driver.getTitle());
    }

    @Test
    public void сheckTransitionToStartPageTest()  {
        mp.openExitPage();
        Assert.assertTrue( LOGIN.isElementPresent());
        Assert.assertTrue( PASSWORD.isElementPresent());
    }



    @After
    public void shutDown() {
        driver.close();
        WebDriverSingleton.destroyInstance();
    }

}
