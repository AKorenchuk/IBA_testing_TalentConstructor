package edu.bsuir.test;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.test.services.SignIn;
import edu.bsuir.test.services.enums.Role;
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

import static edu.bsuir.web.elements.LoginElement.LOGIN;
import static edu.bsuir.web.elements.LoginElement.PASSWORD;
import static edu.bsuir.web.elements.MenuElement.PAGE_SETTING_MESSAGE;
import static edu.bsuir.web.elements.MenuElement.USER_SETTING_TITLE;

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
    @DisplayName("Подбор и адаптация")
    @Description("Переход на страницу подбор и адаптация")
    @Feature("Меню")
    @Story("Сценарий 1 – Переход на страницы по меню")
    @Severity(SeverityLevel.NORMAL)
    public void сheckTransitionToAdaptPageTest() {
        mp.openAdaptPage();
        Assert.assertEquals(ADAPT_PAGE, driver.getTitle());
    }


    @Test
    @DisplayName("Справочник")
    @Description("Переход на страницу справочника")
    @Feature("Меню")
    @Story("Сценарий 1 – Переход на страницы по меню")
    @Severity(SeverityLevel.NORMAL)
    public void сheckTransitionToDirectoriesPageTest()  {
        mp.openDirectoryPage();
        Assert.assertEquals(DIRECTORIES_PAGE, driver.getTitle());
    }

    @Test
    @DisplayName("Главная страница")
    @Description("Переход на главную страницу")
    @Feature("Меню")
    @Story("Сценарий 1 – Переход на страницы по меню")
    @Severity(SeverityLevel.NORMAL)
    public void сheckTransitionToMainPageTest()  {
        mp.openMainPage();
        Assert.assertEquals(MAIN_PAGE, driver.getTitle());
    }

    @Test
    @DisplayName("Заметки")
    @Description("Переход к заметкам")
    @Feature("Меню")
    @Story("Сценарий 1 – Переход на страницы по меню")
    @Severity(SeverityLevel.NORMAL)
    public void сheckTransitionToNotificationPageTest()  {
        mp.openNotification();
        Assert.assertTrue( (mp.getNotificationTitle()).contains("Notifications "));
    }

    @Test
    @DisplayName("Профиль пользователя системы")
    @Description("Переход к профилю пользователя")
    @Feature("Меню")
    @Story("Сценарий 1 – Переход на страницы по меню")
    @Severity(SeverityLevel.NORMAL)
    public void сheckTransitionToProfilePageTest()  {
        mp.openProfileInfo();
        Assert.assertEquals( PROFILE_PAGE, driver.getTitle());
    }

    @Test
    @DisplayName("Добавление компетенции")
    @Description("Переход на страницу для добавления компетенций")
    @Feature("Меню")
    @Story("Сценарий 1 – Переход на страницы по меню")
    @Severity(SeverityLevel.NORMAL)
    public void сheckTransitionToAddCompetencePageTest()  {
        mp.openAddCompetencePage();
        Assert.assertEquals( ADD_COMPETENCE_PAGE, driver.getTitle());
    }

    @Test
    @DisplayName("Календарь")
    @Description("Отображение календаря")
    @Feature("Меню")
    @Story("Сценарий 1 – Переход на страницы по меню")
    @Severity(SeverityLevel.NORMAL)
    public void сheckTransitionToCalendarPageTest()  {
        mp.openCalendarPage();
        Assert.assertEquals( CALENDAR_PAGE, driver.getTitle());
    }

    @Test
    @DisplayName("Настройки пользователя")
    @Description("Переход на страницу настройки пользователя")
    @Feature("Меню")
    @Story("Сценарий 1 – Переход на страницы по меню")
    @Severity(SeverityLevel.NORMAL)
    public void сheckTransitionToUserSetting()  {
        mp.openUserSetting();
        Assert.assertTrue( USER_SETTING_TITLE.isElementPresent());
    }

    @Test
    @DisplayName("Настройки страницы")
    @Description("Переход к настроекам текущей страницы")
    @Feature("Меню")
    @Story("Сценарий 1 – Переход на страницы по меню")
    @Severity(SeverityLevel.NORMAL)
    public void сheckTransitionToPageSetting()  {
        mp.openPageSetting();
        Assert.assertTrue( PAGE_SETTING_MESSAGE.isElementPresent());
    }

    @Test
    @DisplayName("Помощь")
    @Description("Переход на страницу помощи")
    @Feature("Меню")
    @Story("Сценарий 1 – Переход на страницы по меню")
    @Severity(SeverityLevel.NORMAL)
    public void сheckTransitionToHelpPageTest()  {
        mp.openHelpPage();
        Assert.assertEquals( HELP_PAGE, driver.getTitle());
    }

    @Test
    @DisplayName("Выход")
    @Description("Выход из системы")
    @Feature("Меню")
    @Story("Сценарий 1 – Переход на страницы по меню")
    @Severity(SeverityLevel.NORMAL)
    public void сheckTransitionToExitTest()  {
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
