package edu.bsuir.test;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.test.web.page.LoginPage;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginTest {

    public static final String INVALID_DATA_MESSAGE = "Ваш запрос завершился с ошибкой.";
    public static final String REQUIRED_FIELD_MESSAGE = "Это обязательное поле.";


    public WebDriver driver;
    public LoginPage lp = new LoginPage();


    @Before
    public void init(){
        driver = WebDriverSingleton.getInstance();
    }

    @Test
    public void сheckPositiveLoginAndPassword()  {
        lp.openLoginPage();
        lp.enterLogin("kabanov@tc.by");
        lp.enterPassword("welcome");
        lp.clickLoginButton();
        WebElement profileInfo = driver.findElement(By.xpath("//*[@id='user-email']"));
        Assert.assertEquals("kabanov@tc.by", profileInfo.getText());
    }


    @Test
    public void сheckNegativeLoginAndPassword() {
        lp.openLoginPage();
        lp.enterLogin("login");
        lp.enterPassword("password");
        lp.clickLoginButton();

        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }


    @Test
    public void сheckNegativeLogin() {
        lp.openLoginPage();
        lp.enterLogin("login");
        lp.enterPassword("welcome");
        lp.clickLoginButton();

        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }


    @Test
    public void сheckNegativePassword() {
        lp.openLoginPage();
        lp.enterLogin("kabanov@tc.by");
        lp.enterPassword("password");
        lp.clickLoginButton();

        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }


    @Test
    public void сheckNullLoginAndPassword() {
        lp.openLoginPage();
        lp.clickLoginButton();
        Assert.assertEquals(REQUIRED_FIELD_MESSAGE, lp.getLoginErrorMessage());
        Assert.assertEquals(REQUIRED_FIELD_MESSAGE, lp.getPasswordErrorMessage());
    }

    @Test
    public void сheckNullPassword() {
        lp.openLoginPage();
        lp.enterLogin("kabanov@tc.by");
        lp.clickLoginButton();
        Assert.assertEquals(REQUIRED_FIELD_MESSAGE, lp.getPasswordErrorMessage());
    }

    @Test
    public void сheckNullLogin() {
        lp.openLoginPage();
        lp.enterPassword("password");
        lp.clickLoginButton();
        Assert.assertEquals(REQUIRED_FIELD_MESSAGE, lp.getLoginErrorMessage());
    }


    @Test
    public void сheckChangeOfPlacesOfLoginAndPassword() {
        lp.openLoginPage();
        lp.enterLogin("password");
        lp.enterPassword("kabanov@tc.by");
        lp.clickLoginButton();

        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    public void сheckScriptAtLogin() {
        lp.openLoginPage();
        lp.enterLogin("<script>alert(123)</script>");
        lp.enterPassword("welcome");
        lp.clickLoginButton();

        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    public void сheckScriptAtPassword() {

        lp.openLoginPage();
        lp.enterLogin("kabanov@tc.by");
        lp.enterPassword("<script>alert(123)</script>");
        lp.clickLoginButton();

        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    public void сheckLoginEndsWithSpace() {
        lp.openLoginPage();
        lp.enterLogin("kabanov@tc.by   ");
        lp.enterPassword("welcome");
        lp.clickLoginButton();

        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    public void сheckLoginStartsWithSpace() {
        lp.openLoginPage();
        lp.enterLogin("   kabanov@tc.by");
        lp.enterPassword("welcome");
        lp.clickLoginButton();

        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }


    @Test
    public void сheckPasswordEndsWithSpace() {
        lp.openLoginPage();
        lp.enterLogin("kabanov@tc.by");
        lp.enterPassword("welcome   ");
        lp.clickLoginButton();

        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    public void сheckPasswordStartsWithSpace() {
        lp.openLoginPage();
        lp.enterLogin("kabanov@tc.by");
        lp.enterPassword("   welcome");
        lp.clickLoginButton();

        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    public void сheckPasswordDifferentCase() {
        lp.openLoginPage();
        lp.enterLogin("kabanov@tc.by");
        lp.enterPassword("welComE");
        lp.clickLoginButton();

        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    public void сheckPasswordUpperCase() {
        lp.openLoginPage();
        lp.enterLogin("kabanov@tc.by");
        lp.enterPassword("WELCOME");
        lp.clickLoginButton();

        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    public void сheckLoginDifferentCase() {
        lp.openLoginPage();
        lp.enterLogin("kaBanoV@tc.by");
        lp.enterPassword("welcome");
        lp.clickLoginButton();

        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    public void сheckLoginUpperCase() {
        lp.openLoginPage();
        lp.enterLogin("KABANOV@TC.BY");
        lp.enterPassword("welcome");
        lp.clickLoginButton();

        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    public void сheckLoginWithCorner() {
        lp.openLoginPage();
        lp.enterLogin("<kabanov@tc.by>");
        lp.enterPassword("welcome");
        lp.clickLoginButton();

        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }


    @Test
    public void сheckLoginWithCyrillic() {
        lp.openLoginPage();
        lp.enterLogin("kаbаnоv@tc.bу");
        lp.enterPassword("welcome");
        lp.clickLoginButton();

        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    public void сheckPasswordWithCyrillic() {

        lp.openLoginPage();
        lp.enterLogin("kаbаnоv@tc.bу");
        lp.enterPassword("wеlcоmе");
        lp.clickLoginButton();

        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @After
    public  void shutDown() {
        driver.close();
        WebDriverSingleton.destroyInstance();
    }

}