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
    @DisplayName("Переход на страницу создания кандидата")
    @Description("Переход на страницу создания кандидата")
    @Feature("Создание кандидата")
    @Story("Сценарий 13 – Переход на страницу создания кандидата")
    @Severity(SeverityLevel.NORMAL)
    public void сheckTransitionToCreateCadidatesPageTest() throws InterruptedException {
        ccp.openCreateCandidatePageByButton();
        Assert.assertEquals(CREATE_CANDIDATE_PAGE, driver.getTitle());
    }

    @Test
    @DisplayName("Отменить создания кандидата")
    @Description("Отменить создания кандидата")
    @Feature("Создание кандидата")
    @Story("Сценарий 14 – Отменить создания кандидата")
    @Severity(SeverityLevel.NORMAL)
    public void сheckCancelButtonAtCadidateProfilePageTest() {
        ccp.openCreateProfile();
        ccp.canceledCreateCandidate();
        Assert.assertEquals(CANDIDATE_PAGE, driver.getTitle());
    }

    @Test
    @DisplayName("Пустой профиль")
    @Description("Создания кандидата со всеми пустыми полями")
    @Feature("Создание кандидата")
    @Story("Сценарий 15 – Обязательные поля")
    @Severity(SeverityLevel.NORMAL)
    public void сheckCreateEmptyCadidateProfile() {
        ccp.openCreateProfile();
        ccp.saveCandidateProfile();
        Assert.assertEquals(ERROR, ccp.getErrorMessage());
    }

    @Test
    @DisplayName("Корректные данные ")
    @Description("Создания кандидата со всеми заполнеными полями")
    @Feature("Создание кандидата")
    @Story("Сценарий 15 – Обязательные поля")
    @Severity(SeverityLevel.NORMAL)
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
    @DisplayName("Пустое имя")
    @Description("Создания кандидата без имени")
    @Feature("Создание кандидата")
    @Story("Сценарий 15 – Обязательные поля")
    @Severity(SeverityLevel.NORMAL)
    public void сheckCreateNullFirstName() {
        ccp.openCreateProfile();
        ccp.setLastName("Korenchuk");
        ccp.setPhoneNumber("2345678");
        ccp.setEmail("korenchuk@mail.com");
        ccp.saveCandidateProfile();
        Assert.assertEquals(ERROR, ccp.getErrorMessage());
    }

    @Test
    @DisplayName("Пробелы ")
    @Description("Создания кандидата, где поля  'Имя' содеерит пробелы в начале и конце")
    @Feature("Создание кандидата")
    @Story("Сценарий 15 – Обязательные поля")
    @Severity(SeverityLevel.NORMAL)
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
    @DisplayName("Имя состоит только из пробелов")
    @Description("Создания кандидата с именем, состоящим только из пробелов")
    @Feature("Создание кандидата")
    @Story("Сценарий 15 – Обязательные поля")
    @Severity(SeverityLevel.NORMAL)
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
    @DisplayName("Пустая фамилия")
    @Description("Создания кандидата без фамилии")
    @Feature("Создание кандидата")
    @Story("Сценарий 15 – Обязательные поля")
    @Severity(SeverityLevel.NORMAL)
    public void сheckCreateNullLastName() {
        ccp.openCreateProfile();
        ccp.setName("Anna");
        ccp.setPhoneNumber("2345678");
        ccp.setEmail("korenchuk@mail.com");
        ccp.saveCandidateProfile();
        Assert.assertEquals(ERROR, ccp.getErrorMessage());
    }

    @Test
    @DisplayName("Фамилия с пробелами")
    @Description("Создания кандидата, где  'Фамилия' содеержат пробелы в начале и конце")
    @Feature("Создание кандидата")
    @Story("Сценарий 15 – Обязательные поля")
    @Severity(SeverityLevel.NORMAL)
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
    @DisplayName("Фамилия только из пробелов")
    @Description("Создания кандидата, где  'Фамилия' содеержат только ")
    @Feature("Создание кандидата")
    @Story("Сценарий 15 – Обязательные поля")
    @Severity(SeverityLevel.NORMAL)
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
    @DisplayName("Пустой телефон")
    @Description("Создания кандидата, где   поле 'Телефон' пустое ")
    @Feature("Создание кандидата")
    @Story("Сценарий 15 – Обязательные поля")
    @Severity(SeverityLevel.NORMAL)
    public void сheckCreateNullPhone() {
        ccp.openCreateProfile();
        ccp.setLastName("Korenchuk");
        ccp.setName("Anna");
        ccp.setEmail("korenchuk@mail.com");
        ccp.saveCandidateProfile();
        Assert.assertEquals(ERROR, ccp.getErrorMessage());
    }

    @Test
    @DisplayName("Телефон с пробелами")
    @Description("Создания кандидата, где   поле 'Телефон' содержит пробелы в начале и в конце")
    @Feature("Создание кандидата")
    @Story("Сценарий 15 – Обязательные поля")
    @Severity(SeverityLevel.NORMAL)
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
    @DisplayName("Телефон только с пробелами")
    @Description("Создания кандидата, где   поле 'Телефон' содержит только пробелы ")
    @Feature("Создание кандидата")
    @Story("Сценарий 15 – Обязательные поля")
    @Severity(SeverityLevel.NORMAL)
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
    @DisplayName("Пустая почта")
    @Description("Создания кандидата, где   поле 'Эл.почта' не заполнено ")
    @Feature("Создание кандидата")
    @Story("Сценарий 15 – Обязательные поля")
    @Severity(SeverityLevel.NORMAL)
    public void сheckCreateNullMail() {
        ccp.openCreateProfile();
        ccp.setLastName("Korenchuk");
        ccp.setName("Anna");
        ccp.setPhoneNumber("2345678");
        ccp.saveCandidateProfile();
        Assert.assertEquals(ERROR, ccp.getErrorMessage());
    }

    @Test
    @DisplayName("Почта с пробелами ")
    @Description("Создания кандидата, где   поле 'Эл.почта' содержит пробелы в начале и в конце ")
    @Feature("Создание кандидата")
    @Story("Сценарий 15 – Обязательные поля")
    @Severity(SeverityLevel.NORMAL)
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
    @DisplayName("Почта только из пробелов")
    @Description("Создания кандидата, где   поле 'Эл.почта' содержит только пробелы ")
    @Feature("Создание кандидата")
    @Story("Сценарий 15 – Обязательные поля")
    @Severity(SeverityLevel.NORMAL)
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
