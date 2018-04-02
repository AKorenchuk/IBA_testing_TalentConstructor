package edu.bsuir.test.web.page;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.test.web.elements.LoginElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {

    WebDriver driver = WebDriverSingleton.getInstance();

    public void enterLogin(String userName){
        WebElement login = driver.findElement(LoginElement.LOGIN);
        login.clear();
        login.sendKeys(userName);
    }

    public void enterPassword(String userPassword){
        WebElement password = driver.findElement(LoginElement.PASSWORD);
        password.clear();
        password.sendKeys(userPassword);
    }

    public void clickLoginButton(){
        WebElement button = driver.findElement(LoginElement.LOGIN_BUTTON);
        button.click();
    }

    public String getErrorMessage(){
        WebElement error = driver.findElement(LoginElement.ERROR_INVALID_DATA);
        return error.getText();

    }

    public String getLoginErrorMessage(){
        WebElement error = driver.findElement(LoginElement.ERROR_LOGIN);
        return error.getText();

    }

    public String getPasswordErrorMessage(){
        WebElement error = driver.findElement(LoginElement.ERROR_PASSWORD);
        return error.getText();

    }

    public void openLoginPage(){
        driver.get(LoginElement.URL);
    }

}
