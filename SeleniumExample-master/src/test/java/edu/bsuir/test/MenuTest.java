package edu.bsuir.test;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.test.web.page.LoginPage;
import edu.bsuir.test.web.page.MenuPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class MenuTest {

    private WebDriver driver = WebDriverSingleton.getInstance();

    public LoginPage lp = new LoginPage();
    public MenuPage mp = new MenuPage();

    public String ADAPT_PAGE = "Подбор и адаптация - Конструктор Талантов";
    public String DIRECTORIES_PAGE = "Справочники - Конструктор Талантов";
    public String MAIN_PAGE = "Главная - Конструктор Талантов";

    @Test
    public void сheckTransitionToAdaptPageTest() throws InterruptedException {
        lp.openLoginPage();
        lp.enterLogin("kabanov@tc.by");
        lp.enterPassword("welcome");
        lp.clickLoginButton();

        mp.openAdaptPage();

        Assert.assertEquals(ADAPT_PAGE, driver.getTitle());
    }


    @Test
    public void сheckTransitionToDirectoriesPageTest() throws InterruptedException {
        lp.openLoginPage();
        lp.enterLogin("kabanov@tc.by");
        lp.enterPassword("welcome");
        lp.clickLoginButton();

        mp.openDirectoryPage();

        Assert.assertEquals(DIRECTORIES_PAGE, driver.getTitle());
    }

    @Test
    public void сheckTransitionToMainPageTest() throws InterruptedException {
        lp.openLoginPage();
        lp.enterLogin("kabanov@tc.by");
        lp.enterPassword("welcome");
        lp.clickLoginButton();

        mp.openMainPage();

        Assert.assertEquals(MAIN_PAGE, driver.getTitle());
    }

    @Test
    public void сheckTransitionToNotificationPageTest() throws InterruptedException {
        lp.openLoginPage();
        lp.enterLogin("kabanov@tc.by");
        lp.enterPassword("welcome");
        lp.clickLoginButton();

        mp.openNotification();


        Assert.assertTrue( (mp.getNotificationTitle()).contains("Notifications "));
    }

    @After
    public void shutDown() {
        driver.close();
        WebDriverSingleton.destroyInstance();
    }

}
