package edu.bsuir.test;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.test.services.SignIn;
import edu.bsuir.test.services.enums.Role;
import edu.bsuir.web.page.LoginPage;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;


public class LoginTest {

    public static final String INVALID_DATA_MESSAGE = "Ваш запрос завершился с ошибкой.";
    public static final String REQUIRED_FIELD_MESSAGE = "Это обязательное поле.";


    public WebDriver driver;
    public SignIn form = new SignIn();
    public LoginPage lp = new LoginPage();

    @Before
    public void init(){
        driver = WebDriverSingleton.getInstance();
    }

    @Test
    public void сheckPositiveLoginAndPassword() throws SAXException, ParserConfigurationException, XPathExpressionException, IOException {
        form.signIn(Role.CHIEF_RECRUITER);
        WebElement profileInfo = driver.findElement(By.xpath("//*[@id='user-email']"));
        Assert.assertEquals("kabanov@tc.by", profileInfo.getText());
    }


    @Test
    public void сheckNegativeLoginAndPassword() {
        form.signIn("login","password");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }


    @Test
    public void сheckNegativeLogin() {
        form.signIn("login","welcom");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }


    @Test
    public void сheckNegativePassword() {
        form.signIn("kabanov@tc.by","password");
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
        form.signIn("kabanov@tc.by","");
        Assert.assertEquals(REQUIRED_FIELD_MESSAGE, lp.getPasswordErrorMessage());
    }

    @Test
    public void сheckNullLogin() {
        form.signIn("","welcome");
        Assert.assertEquals(REQUIRED_FIELD_MESSAGE, lp.getLoginErrorMessage());
    }


    @Test
    public void сheckChangeOfPlacesOfLoginAndPassword() {
        form.signIn("welcome","kabanov@tc.by");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    public void сheckScriptAtLogin() {
        form.signIn("<script>alert(kabanov@tc.by)</script>","welcome");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    public void сheckScriptAtPassword() {
        form.signIn("kabanov@tc.by","<script>alert(welcome)</script>");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    public void сheckLoginEndsWithSpace() {
        form.signIn("kabanov@tc.by   ","welcome");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    public void сheckLoginStartsWithSpace() {
        form.signIn("   kabanov@tc.by","welcome");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }


    @Test
    public void сheckPasswordEndsWithSpace() {
        form.signIn("kabanov@tc.by","welcome   ");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    public void сheckPasswordStartsWithSpace() {
        form.signIn("kabanov@tc.by","   welcome");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    public void сheckPasswordDifferentCase() {
        form.signIn("kabanov@tc.by","welComE");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    public void сheckPasswordUpperCase() {
        form.signIn("kabanov@tc.by","WELCOME");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    public void сheckLoginDifferentCase() {
        form.signIn("kaBanoV@tc.by","welcome");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    public void сheckLoginUpperCase() {
        form.signIn("KABANOV@TC.BY","welcome");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    public void сheckLoginWithCorner() {
        form.signIn("<kabanov@tc.by>","welcome");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }


    @Test
    public void сheckLoginWithCyrillic() {
        form.signIn("kаbаnоv@tc.bу","welcome");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @Test
    public void сheckPasswordWithCyrillic() {
        form.signIn("kаbаnоv@tc.bу","wеlcоmе");
        Assert.assertEquals(INVALID_DATA_MESSAGE, lp.getErrorMessage());
    }

    @After
    public  void shutDown() {
        driver.close();
        WebDriverSingleton.destroyInstance();
    }

}