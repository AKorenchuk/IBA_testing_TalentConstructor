package edu.bsuir.web.page;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.web.elements.LoginElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver = WebDriverSingleton.getInstance();

    @Step("Ввод логина {0}")
    public void enterLogin(String userName){
        LoginElement.LOGIN.setText(userName);
    }

    @Step("Ввод пароля {0}")
    public void enterPassword(String userPassword){
        LoginElement.PASSWORD.setText(userPassword);
    }

    @Step("Нажатие на кнопки 'Вход' ")
    public void clickLoginButton(){
        LoginElement.LOGIN_BUTTON.click();
    }

    @Step("Получение текста ошибки при вводе некорректных данных ")
    public String getErrorMessage(){
        return LoginElement.ERROR_INVALID_DATA.getText();

    }

    @Step("Получение текста ошибки при вводе некорректного логина ")
    public String getLoginErrorMessage(){
        return LoginElement.ERROR_LOGIN.getText();
    }

    @Step("Получение текста ошибки при вводе некорректного пароля")
    public String getPasswordErrorMessage(){
        return LoginElement.ERROR_PASSWORD.getText();
    }

    @Step("Открытие страницы логина и пароля")
    public void openLoginPage(){
        driver.get(LoginElement.URL);
    }

}
