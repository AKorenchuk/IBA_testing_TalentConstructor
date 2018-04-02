package edu.bsuir.test.web.elements;

import org.openqa.selenium.By;

public class CreatingApplicationElement {

        public static final By CREATE_API_BUTTON = By.xpath("//*[@id='addRequest']/div[2]/div[2]/a");

        public static final By NAME = By.xpath("//input[@id='name']");
        public static final By DATE = By.xpath("//*[@id='plannedClosingDate']");
        public static final By PRIORITY = By.xpath("//*[@id='priority-1']");
        public static final By QUANTITY = By.xpath("//*[@id='quantity']");
        public static final By REASON = By.xpath("//*[@id='creationReason']");
        public static final By CONTRACT_TYPE = By.xpath("//*[@id='contractType-0']");
        public static final By SALARY = By.xpath("//*[@id='salary']");
        public static final By EMPLOYEES = By.xpath("//*[@id='employees']");
        public static final By BUSINESS_TRIP = By.xpath("//*[@id='businessTrip']");
        public static final By TIMETABLE = By.xpath("//*[@id='timetable']");
        public static final By PROBATION_PERIOD = By.xpath("//*[@id='probationPeriod']");
        public static final By RESPONSIBILITIES = By.xpath("//*[@id='responsibilities']");

        public static final By CANDIDATE_TYPE_EXTERNAL = By.id("candidateTypeExternal");
        public static final By CANDIDATE_TYPE_INTERNAL = By.id("candidateTypeInternal");


        public static final By EDUCATION_SPECIALIZATION = By.xpath("//*[@id='educationSpecialization']");
        public static final By PRIORITY_ORGANISATIONS = By.xpath("//*[@id='priority.working.experience']");
        public static final By UNDESIRABLE_WORKING_EXPERIENCE = By.xpath("//*[@id='undesirableWorkingExperience']");
        public static final By REQUIRED_COMPETENCE = By.id("editrequiredCompetence");
        public static final By NOT_REQUIRED_COMPETENCE = By.xpath("//*[@id='editnotRequiredCompetence']");
        public static final By COMMENT = By.xpath("//*[@id='comment']");
        public static final By SAVE_BUTTON = By.xpath("//*[@id='name']");
        public static final By OK_BUTTON = By.xpath("//button[text() = 'OK']");

        public static By BASIC = By.xpath("//span[text()='Базовые']");
        public static By LEARNABILITY =  By.xpath("//span[text() = 'Обучаемость']");

    }

