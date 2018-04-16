package edu.bsuir.test;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.test.services.SignIn;
import edu.bsuir.test.services.enums.Role;
import edu.bsuir.web.page.AgreementPage;
import edu.bsuir.web.page.ApplicationPage;
import edu.bsuir.web.page.CreatingApplicationPage;
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


public class ApplicationForWorkTest {

    private WebDriver driver = WebDriverSingleton.getInstance();

    public CreatingApplicationPage cap = new CreatingApplicationPage();
    public MenuPage mp = new MenuPage();
    public SignIn form = new SignIn();
    public AgreementPage ap = new AgreementPage();
    public ApplicationPage app = new ApplicationPage();


    @Before
    public void init() throws SAXException, ParserConfigurationException, XPathExpressionException, IOException {
        form.signIn(Role.CHIEF_RECRUITER);
        mp.openAdaptPage();
    }

    @Test
    @DisplayName("Создание заявки")
    @Description("Создание заявки с корректными данными")
    @Feature("Создание заявки")
    @Story("Сценарий 1 – Создание заявки")
    @Severity(SeverityLevel.NORMAL)
    public void checkApplicationForWorkTest() throws Exception {

        cap.startCreateApi();

        cap.enterName("programmer");
        cap.enterDate();
        cap.enterPriority();
        cap.enterQuantity("20");
        cap.enterReason("expansion of the department");
        cap.enterContractType();
        cap.enterSalary("800");
        cap.enterEmployees("no");
        cap.enterBusinessTrip("twice a week");
        cap.enterTimetable("5 day a week");
        cap.enterProbationPeriod("1 month");
        cap.enterResponsibilities("bug fixing");
        cap.enterCandidateType();
        cap.enterEducationSpecialization("technical");
        cap.enterPriorityWorkingExperience("IBA,EPAM");
        cap.enterUndesirableWorkingExperience("-");
        cap.setEditRequiredCompetence();
        cap.enterComment("urgently");

        Thread.sleep(5000);
        cap.saveApplication();
        Thread.sleep(5000);


        Assert.assertEquals("programmer - Конструктор Талантов", driver.getTitle());
}


    @Test
    @DisplayName("Согласование созданной заявки")
    @Description("Проверка кнопки 'Отправить на согласование' после создания заявки ")
    @Feature("Создание заявки")
    @Story("Сценарий 2 – Согласование заявки ")
    @Severity(SeverityLevel.NORMAL)
    public void checkSendForAgreement() throws Exception {


        cap.startCreateApi();

        cap.enterName("programmer");
        cap.enterContractType();
        cap.enterCandidateType();
        cap.setEditRequiredCompetence();

        Thread.sleep(5000);
        cap.saveApplication();
        Thread.sleep(5000);

        Assert.assertEquals("programmer - Конструктор Талантов", driver.getTitle());

        ap.sendForAgreement();

        Assert.assertEquals("Отправка на согласование - Конструктор Талантов", driver.getTitle());
        ap.sendForReview();
        Thread.sleep(2000);
        ap.sendForApprove();
        Thread.sleep(2000);
        ap.sendForAcquaintance();
        Thread.sleep(2000);

        Assert.assertEquals("Кабанов Александр", ap.listOfReview());
        Assert.assertEquals("Кабанов Александр", ap.listOfApprove());
        Assert.assertEquals("Кабанов Александр", ap.listOfAcquaintance());

        ap.send();
        Thread.sleep(5000);
        Assert.assertEquals("programmer - Конструктор Талантов", driver.getTitle());
    }

    @Test
    @DisplayName("Рассмотрение заявки ")
    @Description("Рассмотерние заявки после ее создания ")
    @Feature("Создание заявки")
    @Story("Сценарий 3 – Рассмотрение заявки ")
    @Severity(SeverityLevel.NORMAL)
    public void checkReview() throws Exception {

        cap.startCreateApi();

        cap.enterName("programmer");
        cap.enterContractType();
        cap.enterCandidateType();
        cap.setEditRequiredCompetence();

        Thread.sleep(5000);
        cap.saveApplication();
        Thread.sleep(5000);

        Assert.assertEquals("programmer - Конструктор Талантов", driver.getTitle());

        ap.sendForAgreement();

        Assert.assertEquals("Отправка на согласование - Конструктор Талантов", driver.getTitle());
        ap.sendForReview();
        Thread.sleep(2000);
        ap.sendForApprove();
        Thread.sleep(2000);
        ap.sendForAcquaintance();
        Thread.sleep(2000);

        Assert.assertEquals("Кабанов Александр", ap.listOfReview());
        Assert.assertEquals("Кабанов Александр", ap.listOfApprove());
        Assert.assertEquals("Кабанов Александр", ap.listOfAcquaintance());

        ap.send();
        Thread.sleep(5000);
        Assert.assertEquals("programmer - Конструктор Талантов", driver.getTitle());

        app.openApplicationPage();
        app.findApplication("programmer");
        app.reviewApplication();
        Thread.sleep(5000);
        Assert.assertEquals("Заявка была рассмотрена", app.getReviewMessage());

    }

    @Test
    @DisplayName("Согласование заявки ")
    @Description("Согласование  заявки после ее рассмотрение")
    @Feature("Создание заявки")
    @Story("Сценарий 4 – Согласование заявки ")
    @Severity(SeverityLevel.NORMAL)
    public void checkApprove() throws Exception {

        cap.startCreateApi();

        cap.enterName("programmer");
        cap.enterContractType();
        cap.enterCandidateType();
        cap.setEditRequiredCompetence();

        Thread.sleep(5000);
        cap.saveApplication();
        Thread.sleep(5000);

        Assert.assertEquals("programmer - Конструктор Талантов", driver.getTitle());

        ap.sendForAgreement();

        Assert.assertEquals("Отправка на согласование - Конструктор Талантов", driver.getTitle());
        ap.sendForReview();
        Thread.sleep(2000);
        ap.sendForApprove();
        Thread.sleep(2000);
        ap.sendForAcquaintance();
        Thread.sleep(2000);

        Assert.assertEquals("Кабанов Александр", ap.listOfReview());
        Assert.assertEquals("Кабанов Александр", ap.listOfApprove());
        Assert.assertEquals("Кабанов Александр", ap.listOfAcquaintance());

        ap.send();
        Thread.sleep(5000);
        Assert.assertEquals("programmer - Конструктор Талантов", driver.getTitle());

        app.openApplicationPage();
        app.findApplication("programmer");
        app.reviewApplication();
        Thread.sleep(5000);
        Assert.assertEquals("Заявка была рассмотрена", app.getReviewMessage());

        app.openApplicationPage();
        app.findApplication("programmer");
        app.approveApplication();
        Thread.sleep(5000);
        Assert.assertEquals("Заявка была согласована", app.getApproveMessage());
    }

    @Test
    @DisplayName("Создание вакансии")
    @Description("Согласование вакансии после согласования заявки")
    @Feature("Создание заявки")
    @Story("Сценарий 5 – Создание вакансии ")
    @Severity(SeverityLevel.NORMAL)
    public void checkCreateVacancy() throws Exception {

        cap.startCreateApi();

        cap.enterName("programmer");
        cap.enterDate();
        cap.enterQuantity("20");
        cap.enterContractType();
        cap.enterCandidateType();
        cap.setEditRequiredCompetence();

        Thread.sleep(5000);
        cap.saveApplication();
        Thread.sleep(5000);

        Assert.assertEquals("programmer - Конструктор Талантов", driver.getTitle());

        ap.sendForAgreement();

        Assert.assertEquals("Отправка на согласование - Конструктор Талантов", driver.getTitle());
        ap.sendForReview();
        Thread.sleep(2000);
        ap.sendForApprove();
        Thread.sleep(2000);
        ap.sendForAcquaintance();
        Thread.sleep(2000);

        Assert.assertEquals("Кабанов Александр", ap.listOfReview());
        Assert.assertEquals("Кабанов Александр", ap.listOfApprove());
        Assert.assertEquals("Кабанов Александр", ap.listOfAcquaintance());

        ap.send();
        Thread.sleep(5000);
        Assert.assertEquals("programmer - Конструктор Талантов", driver.getTitle());

        app.openApplicationPage();
        app.findApplication("programmer");
        app.reviewApplication();
        Thread.sleep(5000);
        Assert.assertEquals("Заявка была рассмотрена", app.getReviewMessage());

        app.openApplicationPage();
        app.findApplication("programmer");
        app.approveApplication();
        Thread.sleep(5000);
        Assert.assertEquals("Заявка была согласована", app.getApproveMessage());

        app.createVacancy();

        Assert.assertEquals("Создание вакансии - Конструктор Талантов", driver.getTitle());
        app.saveVacancy();
        Thread.sleep(2000);
        Assert.assertEquals("Вакансия успешно создана", app.getCreateVacancyMessage());
        app.openVacancy();
        Thread.sleep(2000);
        Assert.assertEquals("Вакансия была успешно открыта", app.getOpenVacancyMessage());

    }

    @Test
    @DisplayName("Аннулирование")
    @Description("Аннулирование заявки")
    @Feature("Создание заявки")
    @Story("Сценарий 6 – Аннулирование ")
    @Severity(SeverityLevel.NORMAL)
    public void checkAnnulApp() throws Exception {

        cap.startCreateApi();

        cap.enterName("programmer");
        cap.enterContractType();
        cap.enterCandidateType();
        cap.setEditRequiredCompetence();

        Thread.sleep(5000);
        cap.saveApplication();
        Thread.sleep(5000);

        Assert.assertEquals("programmer - Конструктор Талантов", driver.getTitle());

        ap.sendForAgreement();

        Assert.assertEquals("Отправка на согласование - Конструктор Талантов", driver.getTitle());
        ap.sendForReview();
        Thread.sleep(2000);
        ap.sendForApprove();
        Thread.sleep(2000);
        ap.sendForAcquaintance();
        Thread.sleep(2000);

        Assert.assertEquals("Кабанов Александр", ap.listOfReview());
        Assert.assertEquals("Кабанов Александр", ap.listOfApprove());
        Assert.assertEquals("Кабанов Александр", ap.listOfAcquaintance());

        ap.send();
        Thread.sleep(5000);
        Assert.assertEquals("programmer - Конструктор Талантов", driver.getTitle());

        app.openApplicationPage();
        app.findApplication("programmer");
        app.reviewApplication();
        Thread.sleep(5000);
        Assert.assertEquals("Заявка была рассмотрена", app.getReviewMessage());

        app.openApplicationPage();
        app.findApplication("programmer");
        app.approveApplication();
        Thread.sleep(5000);
        Assert.assertEquals("Заявка была согласована", app.getApproveMessage());
        app.openApplicationPage();
        app.findApplication("programmer");
        app.annulApp();
        Assert.assertEquals("Заявка была успешно аннулирована", app.getAnnulAppMessage());
    }

    @After
    public void shutDown() {
        driver.close();
        WebDriverSingleton.destroyInstance();
    }

}









