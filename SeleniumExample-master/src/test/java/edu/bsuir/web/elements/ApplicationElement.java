package edu.bsuir.web.elements;

import edu.bsuir.entity.Element;
import org.openqa.selenium.By;

public class ApplicationElement {

    public static final String URL_APPLICATION = "http://testing.cld.iba.by/web/guest/recruiting/applications";

    public static final Element SEARCH = new Element("search", By.xpath("//input[@id='searchAppInput']"));

    public static final Element REVIEW_BUTTON = new Element("review", By.xpath("//a[@id='reviewButton']"));

    public static final Element REVIEW_COMMENT = new Element("review comment", By.xpath("//div[@class='controls control-comment-text']/textarea[@name='comment'][1]"));

    public static final Element AGREE_REVIEW = new Element(" agree review ", By.xpath("//button[text()='Рассмотреть']"));

    public static final Element REVIEW_SUCCESS_MESSAGE = new Element("review success message", By.xpath("//span[@id='successMessage']"));

    public static final Element APPROVE_BUTTON = new Element("approve", By.xpath("//a[@id='approveButton']"));

    public static final Element APPROVE_SUCCESS_MESSAGE = new Element("approve success message", By.xpath("//span[@id='successMessage']"));

    public static final Element CREATE_VACANCY_BUTTON = new Element("create vacancy", By.xpath("//a[@id='createVacancyButton']"));

    public static final Element DELETE_APP = new Element("delete application", By.xpath("//a[@id='annulAppButton']"));
    public static final Element ANNUL_BUTTON = new Element("agree with delete application", By.xpath("//button[text()='Аннулировать']"));
    public static final Element ANNUL_SUCCESS_MESSAGE = new Element("annul success message", By.xpath("//span[@id='successMessage']"));


    public static final Element SAVE_VACANCY = new Element("save vacancy", By.xpath("//a[@id='saveButton']"));
    public static final Element CREATE_VACANCY_SUCCESS_MESSAGE = new Element(
            "create vacancy success message", By.xpath("//span[@id='successMessage']"));

    public static final Element OPEN_VACANCY_BUTTON = new Element("open vacancy", By.xpath("//a[@id='openButton']"));
    public static final Element OPEN_VACANCY_SUCCESS_MESSAGE = new Element(
            "open vacancy success message", By.xpath("//span[@id='successMessage']"));
}

