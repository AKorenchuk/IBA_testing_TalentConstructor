package edu.bsuir.web.elements;

import edu.bsuir.entity.Element;
import org.openqa.selenium.By;

public class CreatingApplicationElement {

        public static final Element CREATE_API_BUTTON = new Element("button _create_api",By.xpath("//a[@class='btn btn-primary' and text()='Новая заявка']"));

        public static final Element NAME = new Element("name",By.xpath("//*[@id='name']"));
        public static final Element DATE = new Element("date",By.xpath("//*[@id='plannedClosingDate']"));
        public static final Element PRIORITY = new Element("priority",By.xpath("//div[./input[@id='priority-1']]"));
        public static final Element QUANTITY = new Element("quantity",By.xpath("//*[@id='quantity']"));
        public static final Element REASON = new Element("reasone",By.xpath("//*[@id='creationReason']"));
        public static final Element CONTRACT_TYPE = new Element("contract_type",By.xpath("//*[@id='contractType-0']"));
        public static final Element SALARY = new Element("salary",By.xpath("//*[@id='salary']"));
        public static final Element EMPLOYEES = new Element("employees",By.xpath("//*[@id='employees']"));
        public static final Element BUSINESS_TRIP = new Element("business_trip",By.xpath("//*[@id='businessTrip']"));
        public static final Element TIMETABLE = new Element("timetable",By.xpath("//*[@id='timetable']"));
        public static final Element PROBATION_PERIOD = new Element("probation_period",By.xpath("//*[@id='probationPeriod']"));
        public static final Element RESPONSIBILITIES = new Element("responsibilities",By.xpath("//*[@id='responsibilities']"));

        public static final Element CANDIDATE_TYPE_EXTERNAL = new Element("external_type",By.id("candidateTypeExternal"));
        public static final Element CANDIDATE_TYPE_INTERNAL = new Element("internal_type",By.id("candidateTypeInternal"));


        public static final Element EDUCATION_SPECIALIZATION = new Element("education_specialization",By.xpath("//*[@id='educationSpecialization']"));
        public static final Element PRIORITY_ORGANISATIONS = new Element("priority_organization",By.xpath("//*[@id='priority.working.experience']"));
        public static final Element UNDESIRABLE_WORKING_EXPERIENCE = new Element("undesirable_working_experience",By.xpath("//*[@id='undesirableWorkingExperience']"));
        public static final Element REQUIRED_COMPETENCE = new Element("required_competence",By.id("editrequiredCompetence"));
        public static final Element NOT_REQUIRED_COMPETENCE = new Element("not_required_competence",By.xpath("//*[@id='editnotRequiredCompetence']"));
        public static final Element COMMENT = new Element("comment",By.xpath("//*[@id='comment']"));

        public static final Element SAVE_BUTTON = new Element("save_button",By.xpath("//button[@class='btn btn-primary pull-right' and @id='save']"));
        public static final Element OK_BUTTON = new Element("ok_button",By.xpath("//button[text() = 'OK']"));

        public static Element BASIC = new Element("Basic",By.xpath("//span[text()='Базовые']"));
        public static Element LEARNABILITY =  new Element("Learnability",By.xpath("//span[text() = 'Обучаемость']"));

    }

