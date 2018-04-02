package edu.bsuir.test.web.elements;

import org.openqa.selenium.By;

public class LoginElement {

    public static final String URL = "http://testing.cld.iba.by";

    public static final By LOGIN = By.xpath("//input[@id='_58_login']");
    public static final By PASSWORD = By.xpath("//input[@id='_58_password']");

    public static final By LOGIN_BUTTON = By.xpath("//*[@class='btn btn-primary']");

    public static final By ERROR_LOGIN =By.xpath("//div[./input[@id='_58_login']]/div[@class='form-validator-stack help-inline']/div");
    public static final By ERROR_PASSWORD =By.xpath("//div[./input[@id='_58_password']]/div[@class='form-validator-stack help-inline']/div");

    public static final By ERROR_INVALID_DATA =By.xpath("//div[@class='portlet-body']/div[@class='alert alert-error']");



    public static By getLoginButton(String buttonName){
        return By.xpath("//button[text()='"+buttonName+"']");
    }
}
