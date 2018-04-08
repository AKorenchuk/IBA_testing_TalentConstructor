package edu.bsuir.web.elements;

import edu.bsuir.entity.Element;
import org.openqa.selenium.By;

public class CreateCandidateElement {

    public static final String URL_CANDIDATE_PAGE = "http://testing.cld.iba.by/web/guest/recruiting/candidates";
    public static final String URL_CREATE_PROFILE = "http://testing.cld.iba.by/web/guest/recruiting/candidates/-/candidates/createProfile";


    public static final Element CREATE_CANDIDATE_BUTTON = new Element("create_candidate_button",
            By.xpath("//a[@id='createProfileButton']"));

    public static final Element PHOTO = new Element("photo",By.xpath("//span[@id='changeImgLink']"));

    public static final Element FIRST_NAME = new Element("first_name",By.xpath("//input[@id='name']"));
    public static final Element ERROR_NAME = new Element("error_name",By.xpath("//div[./input[@id='name']]/div"));

    public static final Element LAST_NAME = new Element("last_name",By.xpath("//input[@id='surname']"));
    public static final Element ERROR_LAST_NAME = new Element("error_last_name",By.xpath("//div[./input[@id='surname']]/div"));


    public static final Element SECOND_NAME = new Element("second_name",By.xpath("//input[@id='secondName']"));
    public static final Element ERROR_SECOND_NAME = new Element("error_second_name",By.xpath("//div[./input[@id='secondName']]/div"));


    public static final Element TELEPHONE = new Element("telephone",By.xpath("//input[@id='primaryTelephone']"));
    public static final Element ADDITIONAL_TELEPHONE = new Element("add_telephone",By.xpath("//input[@id='telephone']"));
    public static final Element ADD_TELEPHONE_BUTTON = new Element("add_telephone_button",By.xpath("//i[@id='addTelephoneButton']"));
    public static final Element DELETE_TELEPHONE = new Element("delete_telephone",By.xpath("//i[@id='removeTel']"));
    public static final Element ERROR_TELEPHONE = new Element("error phone",By.xpath("//div[@class='validateTelephone' and text()='Неверный формат номера']"));


    public static final Element EMAIL = new Element("email",By.xpath("//input [@id='primaryEmail']"));
    public static final Element ERROR_EMAIL = new Element("error email",By.xpath("//div[@class='email' and text()='Неверный ввод']"));

    public static final Element ADDITIONAL_EMAIL = new Element("add_email",By.xpath("//input[@id='email']"));
    public static final Element ADD_EMAIL_BUTTON = new Element("add_email_button",By.xpath("//i[@id='addEmailButton']"));
    public static final Element DELETE_EMAIL = new Element("delete_email",By.xpath("//i[@id='removeEmail']"));

    public static final Element SKYPE = new Element("skype",By.xpath("//input[@id='skype']"));
    public static final Element ERROR_SKYPE = new Element("error_skype",By.xpath("//div[./input[@id='skype']]/div"));

    public static final Element COUNTRY = new Element("country",By.xpath("//input[@id='country']"));
    public static final Element ERROR_COUNTRY = new Element("error_country",By.xpath("//div[./input[@id='country']]/div"));

    public static final Element CITY = new Element("city",By.xpath("//input[@id='city']"));
    public static final Element ERROR_CITY = new Element("error_country",By.xpath("//div[./input[@id='city']]/div"));


    public static final Element RELOCATION_CHECKBOX = new Element("city",By.xpath("//input[@id='relocation']"));


    public static final Element DAY_OF_BIRTH_DAY = new Element("dat_of_birth_day",By.xpath("//input[@id='dateOfBirthDay']"));
    public static final Element DAY_OF_BIRTH_MONTH = new Element("dat_of_birth_month",By.xpath("//input[@id='dateOfBirthMonth']"));
    public static final Element DAY_OF_BIRTH_YEAR = new Element("dat_of_birth_year",By.xpath("//input[@id='dateOfBirthYear']"));
    public static final Element ERROR_DATE = new Element("error_date",By.xpath("//div[@class='validateDate']"));


    public static final Element EDUCATION_SELECT = new Element("education select",By.xpath("//select[@id='education']"));

    public static final Element DESIRED_POSITION = new Element("desired_position",By.xpath("//input[@id='desiredPosition']"));
    public static final Element ERROR_DESIRED_POSITION = new Element("error_desired_position",By.xpath("//div[./input[@id='desiredPosition']]/div"));


    public static final Element ADDITIONAL_INFO = new Element("additional_info",By.xpath("//textarea[@id='additionalInfo']"));
    public static final Element ERROR_ADDITIONAL_INFO = new Element("error_additional_info",By.xpath("//div[@id='additionalInfoControls']/div[@class='form-validator-stack help-inline']"));

    public static final Element SAVE_BUTTON = new Element("save",By.xpath("//a[@id='saveButton']"));
    public static final Element CANCEL = new Element("cancel",By.xpath("//a[@id='cancelButton']"));
    public static final Element LOAD_RESUME = new Element("load_resume",By.xpath("//span[@id='loadCVLink']"));

    public static final Element ADD_DOCUMENT = new Element("add_document",By.xpath("//span[./i[@class='fa fa-plus add-attachment']]"));
    public static final Element REMOVE_DOCUMENT = new Element("remove_document",By.xpath("//i[@class='fa fa-remove remove remove-attachment']"));

    public static final Element ERROR_MESSAGE = new Element("error_message",By.xpath("//div[@class='message']/strong[text()='Ошибка!']"));
    public static final Element FREE_SPACE = new Element("free space",By.xpath("//div[@class='tc-theme-page-name']"));

    public static final Element FIO = new Element("FIO",By.xpath("//div[@class='tc-theme-page-name']"));
    public static final Element TELEPHONE_NUMBER = new Element("telephone",By.xpath("//div[@id='primaryTelephone']"));
    public static final Element MAIL = new Element("mail",By.xpath("//div[@id='primaryEmail']\t"));

}
