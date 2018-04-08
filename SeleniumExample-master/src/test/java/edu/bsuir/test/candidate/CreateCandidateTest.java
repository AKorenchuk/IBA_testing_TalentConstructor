package edu.bsuir.test.candidate;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.test.services.SignIn;
import edu.bsuir.test.services.enums.Role;
import edu.bsuir.web.page.CandidatePage;
import edu.bsuir.web.page.CreateCandidatePage;
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

public class CreateCandidateTest {

    public WebDriver driver ;
    public SignIn form = new SignIn();
    public MenuPage mp = new MenuPage();
    public CandidatePage cp = new CandidatePage();
    public CreateCandidatePage ccp = new CreateCandidatePage();


    public String CANDIDATE_PAGE = "Кандидаты - Конструктор Талантов";
    public String CREATE_CANDIDATE_PAGE = "Создание резюме - Конструктор Талантов";
    public String ERROR = "Ошибка!";


    @Before
    public void init() throws SAXException, ParserConfigurationException, XPathExpressionException, IOException {
        driver = WebDriverSingleton.getInstance();
        form.signIn(Role.CHIEF_RECRUITER);
        mp.moveToElementAdaptPage();
        cp.openCandidatesPage();
    }

    @Test
    public void сheckTransitionToCreateCadidatesPageTest() throws InterruptedException {
        ccp.openCreateCandidatePageByButton();
        Assert.assertEquals(CREATE_CANDIDATE_PAGE, driver.getTitle());
    }

    @Test
    public void сheckCancelButtonAtCadidateProfilePageTest() {
        ccp.openCreateProfile();
        ccp.canceledCreateCandidate();
        Assert.assertEquals(CANDIDATE_PAGE, driver.getTitle());
    }

    @Test
    public void сheckCreateEmptyCadidateProfile() {
        ccp.openCreateProfile();
        ccp.saveCandidateProfile();
        Assert.assertEquals(ERROR, ccp.getErrorMessage());
    }

    @Test
    public void сheckCreateCadidateProfile() {
        ccp.openCreateProfile();
        ccp.setLastName("Korenchuk");
        ccp.setName("Anna");
        ccp.setPhoneNumber("2345678");
        ccp.setEmail("korenchuk@mail.com");
        ccp.saveCandidateProfile();
        Assert.assertEquals("Korenchuk Anna", ccp.getFIO());
        Assert.assertEquals("2345678", ccp.getPhone());
        Assert.assertEquals("korenchuk@mail.com", ccp.getMail());
    }

    @Test
    public void сheckCreateIdenticalCadidateProfile() {
        // создать заявку,полностью совпадающую с какой-либо из уже имеющихся в списке( что будет? )
    }

    @Test
    public void сheckCreateNullFirstName() {
        ccp.openCreateProfile();
        ccp.setLastName("Korenchuk");
        ccp.setPhoneNumber("2345678");
        ccp.setEmail("korenchuk@mail.com");
        ccp.saveCandidateProfile();
        Assert.assertEquals(ERROR, ccp.getErrorMessage());
    }

    @Test
    public void сheckCreateFirstNameStartAndEndWithSpace() {
        ccp.openCreateProfile();
        ccp.setLastName("Korenchuk");
        ccp.setName("  Anna   ");
        ccp.setPhoneNumber("2345678");
        ccp.setEmail("korenchuk@mail.com");
        ccp.saveCandidateProfile();
        Assert.assertEquals("Korenchuk Anna", ccp.getFIO());
    }

    @Test
    public void сheckCreateFirstNameWithSpace() {
        ccp.openCreateProfile();
        ccp.setLastName("Korenchuk");
        ccp.setName("      ");
        ccp.setPhoneNumber("2345678");
        ccp.setEmail("korenchuk@mail.com");
        ccp.saveCandidateProfile();
        Assert.assertEquals(ERROR, ccp.getErrorMessage());
    }


    @Test
    public void сheckCreateNullLastName() {
        ccp.openCreateProfile();
        ccp.setName("Anna");
        ccp.setPhoneNumber("2345678");
        ccp.setEmail("korenchuk@mail.com");
        ccp.saveCandidateProfile();
        Assert.assertEquals(ERROR, ccp.getErrorMessage());
    }

    @Test
    public void сheckCreateLastNameStartAndEndWithSpace() {
        ccp.openCreateProfile();
        ccp.setLastName("   Korenchuk   ");
        ccp.setName("Anna");
        ccp.setPhoneNumber("2345678");
        ccp.setEmail("korenchuk@mail.com");
        ccp.saveCandidateProfile();
        Assert.assertEquals("Korenchuk Anna", ccp.getFIO());
    }

    @Test
    public void сheckCreateLastNameWithSpace() {
        ccp.openCreateProfile();
        ccp.setLastName("    ");
        ccp.setName("Anna");
        ccp.setPhoneNumber("2345678");
        ccp.setEmail("korenchuk@mail.com");
        ccp.saveCandidateProfile();
        Assert.assertEquals(ERROR, ccp.getErrorMessage());
    }


    @Test
    public void сheckCreateNullPhone() {
        ccp.openCreateProfile();
        ccp.setLastName("Korenchuk");
        ccp.setName("Anna");
        ccp.setEmail("korenchuk@mail.com");
        ccp.saveCandidateProfile();
        Assert.assertEquals(ERROR, ccp.getErrorMessage());
    }

    @Test
    public void сheckCreatePhoneStartAndEndWithSpace() {
        ccp.openCreateProfile();
        ccp.setLastName("Korenchuk");
        ccp.setName("Anna");
        ccp.setPhoneNumber("  2345678   ");
        ccp.setEmail("korenchuk@mail.com");
        ccp.saveCandidateProfile();
        Assert.assertEquals("2345678", ccp.getPhone());
    }

    @Test
    public void сheckCreatePhoneWithSpace() {
        ccp.openCreateProfile();
        ccp.setLastName("Korenchuk");
        ccp.setName("Anna");
        ccp.setPhoneNumber("     ");
        ccp.setEmail("korenchuk@mail.com");
        ccp.saveCandidateProfile();
        Assert.assertEquals(ERROR, ccp.getErrorMessage());
    }

    @Test
    public void сheckCreateNullMail() {
        ccp.openCreateProfile();
        ccp.setLastName("Korenchuk");
        ccp.setName("Anna");
        ccp.setPhoneNumber("2345678");
        ccp.saveCandidateProfile();
        Assert.assertEquals(ERROR, ccp.getErrorMessage());
    }

    @Test
    public void сheckCreateMailStartAndEndWithSpace() {
        ccp.openCreateProfile();
        ccp.setLastName("Korenchuk");
        ccp.setName("Anna");
        ccp.setPhoneNumber("2345678");
        ccp.setEmail("   korenchuk@mail.com   ");
        ccp.saveCandidateProfile();
        Assert.assertEquals("korenchuk@mail.com", ccp.getMail());
    }

    @Test
    public void сheckCreateMailWithSpace() {
        ccp.openCreateProfile();
        ccp.setLastName("Korenchuk");
        ccp.setName("Anna");
        ccp.setPhoneNumber("2345678");
        ccp.setEmail("    ");
        ccp.saveCandidateProfile();
        Assert.assertEquals(ERROR, ccp.getErrorMessage());
    }

    @After
    public void shutDown() {
        driver.close();
        WebDriverSingleton.destroyInstance();
    }
}
