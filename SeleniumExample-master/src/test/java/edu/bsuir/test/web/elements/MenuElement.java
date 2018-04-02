package edu.bsuir.test.web.elements;

import org.openqa.selenium.By;

public class MenuElement {

    public static final By MAIN_PAGE = By.xpath("//*[@id='layout_1']/a");
    public static final By ADAPT_PAGE = By.xpath("//*[@id='layout_2']/a");
    public static final By DIRECTORY_PAGE = By.xpath("//*[@id='layout_9']/a");
    public static final By NOTIFICATION_PAGE = By.xpath("//a[@class='dropdown-toggle user-notification-link']");
    public static final By NOTIFICATION_HEADER = By.xpath("//div[@class='user-notifications-header']//a");

    public static final By ERROR_LOGIN =By.xpath("//div[./input[@id='_58_login']]/div[@class='form-validator-stack help-inline']/div");
    public static final By ERROR_PASSWORD =By.xpath("//div[./input[@id='_58_password']]/div[@class='form-validator-stack help-inline']/div");

    public static final By ERROR_INVALID_DATA =By.xpath("//div[@class='portlet-body']/div[@class='alert alert-error']");



    public static By getLoginButton(String buttonName){
        return By.xpath("//button[text()='"+buttonName+"']");
    }
}

