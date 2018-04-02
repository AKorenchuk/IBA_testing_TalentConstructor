package edu.bsuir.test.web.page;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.test.web.elements.CreatingApplicationElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CreatingApplicationPage {


    WebDriver driver = WebDriverSingleton.getInstance();

    public void startCreateApi() {
        driver.findElement(CreatingApplicationElement.CREATE_API_BUTTON).click();
    }

    public void enterName(String name) {
        WebElement element = driver.findElement(CreatingApplicationElement.NAME);
        element.clear();
        element.sendKeys(name);
    }

    public void enterDate() {
        SimpleDateFormat formattedDate = new SimpleDateFormat("dd.MM.yyyy");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        String tomorrow = (String)(formattedDate.format(c.getTime()));

        WebElement element = driver.findElement(CreatingApplicationElement.DATE);
        element.sendKeys(tomorrow);

    }


    public void enterQuantity(String quantity) {
        WebElement element = driver.findElement(CreatingApplicationElement.QUANTITY);
        element.clear();
        element.sendKeys(quantity);
    }

    public void enterPriority() {
        driver.findElement(CreatingApplicationElement.PRIORITY).click();
    }

    public void enterSalary(String salary) {
        WebElement element = driver.findElement(CreatingApplicationElement.SALARY);
        element.clear();
        element.sendKeys(salary);
    }


    public void enterContractType() {
        driver.findElement(CreatingApplicationElement.CONTRACT_TYPE).click();
    }


    public void enterEmployees(String employees) {
        WebElement element = driver.findElement(CreatingApplicationElement.EMPLOYEES);
        element.clear();
        element.sendKeys(employees);
    }

    public void enterBusinessTrip(String businessTrip) {
        WebElement element = driver.findElement(CreatingApplicationElement.BUSINESS_TRIP);
        element.clear();
        element.sendKeys(businessTrip);
    }

    public void enterTimetable(String timetable) {
        WebElement element = driver.findElement(CreatingApplicationElement.TIMETABLE);
        element.clear();
        element.sendKeys(timetable);
    }

    public void enterProbationPeriod(String probationPeriod) {
        WebElement element = driver.findElement(CreatingApplicationElement.PROBATION_PERIOD);
        element.clear();
        element.sendKeys(probationPeriod);

    }

    public void enterReason(String reason) {
        WebElement element = driver.findElement(CreatingApplicationElement.REASON);
        element.clear();
        element.sendKeys(reason);

    }

    public void enterCandidateType() {
        driver.findElement(CreatingApplicationElement.CANDIDATE_TYPE_EXTERNAL).click();
    }

    public void enterEducationSpecialization(String requiredEducation) {
        WebElement element = driver.findElement(CreatingApplicationElement.EDUCATION_SPECIALIZATION);
        element.clear();
        element.sendKeys(requiredEducation);
    }

    public void enterResponsibilities(String responsibilities) {
        WebElement element = driver.findElement(CreatingApplicationElement.RESPONSIBILITIES);
        element.clear();
        element.sendKeys(responsibilities);

    }

    public void enterPriorityWorkingExperience(String priorityWorkingExperience) {
        WebElement element = driver.findElement(CreatingApplicationElement.PRIORITY_ORGANISATIONS);
        element.clear();
        element.sendKeys(priorityWorkingExperience);

    }

    public void enterUndesirableWorkingExperience(String undesirableWorkingExperience) {
        WebElement element = driver.findElement(CreatingApplicationElement.UNDESIRABLE_WORKING_EXPERIENCE);
        element.clear();
        element.sendKeys(undesirableWorkingExperience);

    }

    public void setEditRequiredCompetence() {
        driver.findElement(CreatingApplicationElement.REQUIRED_COMPETENCE).click();
        driver.findElement(CreatingApplicationElement.BASIC).click();
        WebElement element = driver.findElement(CreatingApplicationElement.LEARNABILITY);
        Actions actions = new Actions(driver);
        actions.doubleClick(element);
        actions.perform();
        driver.findElement(CreatingApplicationElement.OK_BUTTON).click();
    }

    public void setEditNotRequiredCompetence() {
        driver.findElement(CreatingApplicationElement.NOT_REQUIRED_COMPETENCE).click();
        driver.findElement(CreatingApplicationElement.BASIC).click();
        WebElement element = driver.findElement(CreatingApplicationElement.LEARNABILITY);
        Actions actions = new Actions(driver);
        actions.doubleClick(element);
        actions.perform();
        driver.findElement(CreatingApplicationElement.OK_BUTTON).click();
    }

    public void enterComment(String comment) {
        WebElement element = driver.findElement(CreatingApplicationElement.COMMENT);
        element.clear();
        element.sendKeys(comment);
    }

    public void saveApplication() {
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(CreatingApplicationElement.SAVE_BUTTON));
        actions.perform();
    }
}