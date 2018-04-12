package edu.bsuir.test;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.test.services.SignIn;
import edu.bsuir.test.services.enums.Role;
import edu.bsuir.web.page.CreatingApplicationPage;
import edu.bsuir.web.page.MenuPage;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class ApplicationForWorkTest {

    private WebDriver driver = WebDriverSingleton.getInstance();

    public CreatingApplicationPage cap = new CreatingApplicationPage();
    public MenuPage mp = new MenuPage();
    public SignIn form = new SignIn();


    @Test
    @DisplayName("Создание заявки")
    @Description("Создание заявки с корректными данными")
    @Feature("Создание заявки")
    @Story("Сценарий 1 – Логирование")
    @Severity(SeverityLevel.NORMAL)
    public void checkApplicationForWorkTest() throws Exception {
        form.signIn(Role.CHIEF_RECRUITER);
        mp.openAdaptPage();

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


    @After
    public void shutDown() {
        driver.close();
        WebDriverSingleton.destroyInstance();
    }

}









