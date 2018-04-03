package edu.bsuir.web.elements;

import edu.bsuir.entity.Element;
import org.openqa.selenium.By;

public class MenuElement {

    public static final Element MAIN_PAGE = new Element("main_page",By.xpath("//*[@id='layout_1']/a"));
    public static final Element ADAPT_PAGE = new Element("adapt_page",By.xpath("//*[@id='layout_2']/a"));
    public static final Element DIRECTORY_PAGE = new Element("directory_page",By.xpath("//*[@id='layout_9']/a"));
    public static final Element NOTIFICATION_PAGE = new Element("notification_page",By.xpath("//a[@class='dropdown-toggle user-notification-link']"));
    public static final Element NOTIFICATION_HEADER = new Element("notification_header",By.xpath("//div[@class='user-notifications-header']//a"));
    public static final Element PROFILE_PAGE = new Element("profile_page",By.xpath("//div[@class='tc-theme-user-info']"));
    public static final Element ADD_COMPETENCE_PAGE = new Element("add_competence_page",By.xpath("//div[./a[@class='top-menu-add-competence top-menu-add-competence-link']]"));
    public static final Element CALENDAR_PAGE = new Element("calendar_page",By.xpath("//li[./a[@href='/calendar']]"));

    public static final Element SETTING_PAGE = new Element("setting",By.xpath("//div[@class='dropdown go-dropdown']"));

    public static final Element SETTING_POINT_1 = new Element("setting_1",By.xpath("//li[./a[text()=' Настройка пользователя ']]"));
    public static final Element SETTING_POINT_1_TITLE = new Element("setting_1_title",By.xpath("//h3[text()='My Account']"));

    public static final Element SETTING_POINT_2 = new Element("setting_2",By.xpath("//li[./a[text()='Настройка текущей страницы']]"));
    public static final Element SETTING_POINT_2_MESSAGE = new Element("setting_2_message",By.xpath("//span[@id='infoMessage']"));


    public static final Element HELP_PAGE = new Element("help",By.xpath("//li[./a[@href='/help']]"));
    public static final Element EXIT = new Element("exit",By.xpath("//li[./a[@href='/c/portal/logout']]"));



    public static By getLoginButton(String buttonName){
        return By.xpath("//button[text()='"+buttonName+"']");
    }
}

