package edu.bsuir.web.page;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.web.elements.CreatingApplicationElement;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CreatingApplicationPage {


    WebDriver driver = WebDriverSingleton.getInstance();

    public void startCreateApi() {
        CreatingApplicationElement.CREATE_API_BUTTON.click();
    }

    public void enterName(String name) {
        CreatingApplicationElement.NAME.setText(name);
    }

    public void enterDate() {
        SimpleDateFormat formattedDate = new SimpleDateFormat("dd.MM.yyyy");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        String tomorrow = (String)(formattedDate.format(c.getTime()));

        CreatingApplicationElement.DATE.setText(tomorrow);

    }


    public void enterQuantity(String quantity) {
        CreatingApplicationElement.QUANTITY.setText(quantity);
    }

    public void enterPriority() {
        CreatingApplicationElement.PRIORITY.click();
    }

    public void enterSalary(String salary) {
        CreatingApplicationElement.SALARY.setText(salary);
    }


    public void enterContractType() {
        CreatingApplicationElement.CONTRACT_TYPE.click();
    }


    public void enterEmployees(String employees) {
        CreatingApplicationElement.EMPLOYEES.setText(employees);
    }

    public void enterBusinessTrip(String businessTrip) {
        CreatingApplicationElement.BUSINESS_TRIP.setText(businessTrip);
    }

    public void enterTimetable(String timetable) {
        CreatingApplicationElement.TIMETABLE.setText(timetable);
    }

    public void enterProbationPeriod(String probationPeriod) {
        CreatingApplicationElement.PROBATION_PERIOD.setText(probationPeriod);

    }

    public void enterReason(String reason) {
        CreatingApplicationElement.REASON.setText(reason);

    }

    public void enterCandidateType() {
        CreatingApplicationElement.CANDIDATE_TYPE_EXTERNAL.click();
    }

    public void enterEducationSpecialization(String requiredEducation) {
        CreatingApplicationElement.EDUCATION_SPECIALIZATION.setText(requiredEducation);
    }

    public void enterResponsibilities(String responsibilities) {
        CreatingApplicationElement.RESPONSIBILITIES.setText(responsibilities);

    }

    public void enterPriorityWorkingExperience(String priorityWorkingExperience) {
        CreatingApplicationElement.PRIORITY_ORGANISATIONS.setText(priorityWorkingExperience);

    }

    public void enterUndesirableWorkingExperience(String undesirableWorkingExperience) {
        CreatingApplicationElement.UNDESIRABLE_WORKING_EXPERIENCE.setText(undesirableWorkingExperience);

    }

    public void setEditRequiredCompetence() throws InterruptedException {
        CreatingApplicationElement.REQUIRED_COMPETENCE.click();
        CreatingApplicationElement.BASIC.click();
        CreatingApplicationElement.LEARNABILITY.doubleClick();
        Thread.sleep(5000);
        CreatingApplicationElement.OK_BUTTON.click();
    }

    public void setEditNotRequiredCompetence() throws InterruptedException {
        CreatingApplicationElement.NOT_REQUIRED_COMPETENCE.click();
        CreatingApplicationElement.BASIC.click();
        CreatingApplicationElement.LEARNABILITY.doubleClick();
        Thread.sleep(5000);
        CreatingApplicationElement.OK_BUTTON.click();
    }

    public void enterComment(String comment) {
        CreatingApplicationElement.COMMENT.setText(comment);
    }

    public void saveApplication() {
        CreatingApplicationElement.SAVE_BUTTON.click();
    }
}