package edu.bsuir.web.page;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.web.elements.LoginElement;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver = WebDriverSingleton.getInstance();

    public void enterLogin(String userName){
        LoginElement.LOGIN.setText(userName);
    }

    public void enterPassword(String userPassword){
        LoginElement.PASSWORD.setText(userPassword);
    }

    public void clickLoginButton(){
        LoginElement.LOGIN_BUTTON.click();
    }

    public String getErrorMessage(){
        return LoginElement.ERROR_INVALID_DATA.getText();

    }

    public String getLoginErrorMessage(){
        return LoginElement.ERROR_LOGIN.getText();
    }

    public String getPasswordErrorMessage(){
        return LoginElement.ERROR_PASSWORD.getText();
    }

    public void openLoginPage(){
        driver.get(LoginElement.URL);
    }

}
