package edu.bsuir.web.page;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.web.elements.CreatingApplicationElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CreatingApplicationPage {


    WebDriver driver = WebDriverSingleton.getInstance();
    @Step("нажатие на кнопку создания заявки")
    public void startCreateApi() {
        CreatingApplicationElement.CREATE_API_BUTTON.click();
    }

    @Step("ввод должности : {0}")
    public void enterName(String name) {
        CreatingApplicationElement.NAME.setText(name);
    }

    @Step("ввод даты(затрашее число) ")
    public void enterDate() {
        SimpleDateFormat formattedDate = new SimpleDateFormat("dd.MM.yyyy");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        String tomorrow = (String)(formattedDate.format(c.getTime()));

        CreatingApplicationElement.DATE.setText(tomorrow);

    }

    @Step("ввод кол-ва соотрудников : {0}")
    public void enterQuantity(String quantity) {
        CreatingApplicationElement.QUANTITY.setText(quantity);
    }

    @Step("установка приоритета ")
    public void enterPriority() {
        CreatingApplicationElement.PRIORITY.click();
    }

    @Step("установка зарплаты: {0} ")
    public void enterSalary(String salary) {
        CreatingApplicationElement.SALARY.setText(salary);
    }

    @Step("установка типа еонтракта ")
    public void enterContractType() {
        CreatingApplicationElement.CONTRACT_TYPE.click();
    }

    @Step("установка кол-ва подчиненных {0} ")
    public void enterEmployees(String employees) {
        CreatingApplicationElement.EMPLOYEES.setText(employees);
    }

    @Step(" установка графика командировок")
    public void enterBusinessTrip(String businessTrip) {
        CreatingApplicationElement.BUSINESS_TRIP.setText(businessTrip);
    }

    @Step(" установка графика работы ")
    public void enterTimetable(String timetable) {
        CreatingApplicationElement.TIMETABLE.setText(timetable);
    }

    @Step(" установка испытательного периода")
    public void enterProbationPeriod(String probationPeriod) {
        CreatingApplicationElement.PROBATION_PERIOD.setText(probationPeriod);

    }

    @Step(" установка обязанности")
    public void enterReason(String reason) {
        CreatingApplicationElement.REASON.setText(reason);
    }

    @Step(" установка импа кондидата ")
    public void enterCandidateType() {
        CreatingApplicationElement.CANDIDATE_TYPE_INTERNAL.click();
    }

    @Step(" установка специальности {10} ")
    public void enterEducationSpecialization(String requiredEducation) {
        CreatingApplicationElement.EDUCATION_SPECIALIZATION.setText(requiredEducation);
    }

    @Step(" установка специальности {10} ")
    public void enterResponsibilities(String responsibilities) {
        CreatingApplicationElement.RESPONSIBILITIES.setText(responsibilities);

    }

    @Step(" установка опыта работы в престижных компаниях: {0} ")
    public void enterPriorityWorkingExperience(String priorityWorkingExperience) {
        CreatingApplicationElement.PRIORITY_ORGANISATIONS.setText(priorityWorkingExperience);

    }

    @Step(" установка опыта работы в отсталой  компаниии: {0} ")
    public void enterUndesirableWorkingExperience(String undesirableWorkingExperience) {
        CreatingApplicationElement.UNDESIRABLE_WORKING_EXPERIENCE.setText(undesirableWorkingExperience);

    }

    @Step(" установка обязательных компетенций ")
    public void setEditRequiredCompetence() throws InterruptedException {
        CreatingApplicationElement.REQUIRED_COMPETENCE.click();
        CreatingApplicationElement.BASIC.click();
        CreatingApplicationElement.LEARNABILITY.doubleClick();
        Thread.sleep(5000);
        CreatingApplicationElement.OK_BUTTON.click();
    }

    @Step(" установка необязательных компетенций ")
    public void setEditNotRequiredCompetence() throws InterruptedException {
        CreatingApplicationElement.NOT_REQUIRED_COMPETENCE.click();
        CreatingApplicationElement.BASIC.click();
        CreatingApplicationElement.LEARNABILITY.doubleClick();
        Thread.sleep(5000);
        CreatingApplicationElement.OK_BUTTON.click();
    }

    @Step(" запись комментария : {0} ")
    public void enterComment(String comment) {
        CreatingApplicationElement.COMMENT.setText(comment);
    }

    @Step(" сохранение заявки ")
    public void saveApplication() {
        CreatingApplicationElement.SAVE_BUTTON.click();
    }
}