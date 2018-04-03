package edu.bsuir.web.elements;

import edu.bsuir.entity.Element;
import org.openqa.selenium.By;

public class LoginElement {

    public static final String URL = "http://testing.cld.iba.by";

    public static final Element LOGIN = new Element("login", By.xpath("//input[@id='_58_login']"));
    public static final Element PASSWORD = new Element("password", By.xpath("//input[@id='_58_password']"));

    public static final Element LOGIN_BUTTON = new Element("login_button",By.xpath("//*[@class='btn btn-primary']"));

    public static final Element ERROR_LOGIN = new Element("error_login",By.xpath("//div[./input[@id='_58_login']]/div[@class='form-validator-stack help-inline']/div"));
    public static final  Element ERROR_PASSWORD = new Element("error_password",By.xpath("//div[./input[@id='_58_password']]/div[@class='form-validator-stack help-inline']/div"));

    public static final  Element ERROR_INVALID_DATA = new Element("error_invalid_data",By.xpath("//div[@class='portlet-body']/div[@class='alert alert-error']"));

    public static By getLoginButton(String buttonName){
        return By.xpath("//button[text()='"+buttonName+"']");
    }
}
