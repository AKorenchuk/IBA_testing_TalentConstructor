package edu.bsuir.web.page;


import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.entity.Element;
import edu.bsuir.web.elements.ApplicationElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApplicationPage {

    WebDriver driver = WebDriverSingleton.getInstance();

    @Step("Открытие страницы c заявками")
    public void openApplicationPage(){
        driver.get(ApplicationElement.URL_APPLICATION);
    }

    @Step("Поиск заявки")
    public void findApplication(String appName) throws InterruptedException {
        ApplicationElement.SEARCH.setText(appName);
        Thread.sleep(2000);
        Element searchApp = new Element("searching app", By.xpath("//a[text()='"+appName+"']"));
        searchApp.click();
    }


    @Step("рассмотреть заявку")
    public void reviewApplication(){
        ApplicationElement.REVIEW_BUTTON.click();
        ApplicationElement.REVIEW_COMMENT.setText("то, что нужно");
        ApplicationElement.AGREE_REVIEW.click();

    }

    @Step("результат рассмотрения заявки")
    public String getReviewMessage() throws InterruptedException {
        return ApplicationElement.REVIEW_SUCCESS_MESSAGE.getText();
    }

    @Step("cогласовать заявку")
    public void approveApplication(){
        ApplicationElement.APPROVE_BUTTON.click();

    }

    @Step("результат согласования  заявки")
    public String getApproveMessage() {
        return ApplicationElement.APPROVE_SUCCESS_MESSAGE.getText();
    }

    @Step("Cоздание вакансии")
    public void createVacancy()  {
        ApplicationElement.CREATE_VACANCY_BUTTON.click();
    }

    @Step("Cохранение вакансии")
    public void saveVacancy()  {
        ApplicationElement.SAVE_VACANCY.click();
    }

    @Step("Сообщение о создании вакансии")
    public String getCreateVacancyMessage() {
        return ApplicationElement.CREATE_VACANCY_SUCCESS_MESSAGE.getText();
    }

    @Step("открыть вакансию")
    public void openVacancy() {
        ApplicationElement.OPEN_VACANCY_BUTTON.click();
    }

    @Step("Сообщение об открытии заявки")
    public String getOpenVacancyMessage() {
        return ApplicationElement.OPEN_VACANCY_SUCCESS_MESSAGE.getText();
    }

    @Step("Аннулирование заявки")
    public void annulApp() throws InterruptedException {
        ApplicationElement.DELETE_APP.click();
        Thread.sleep(2000);
        ApplicationElement.ANNUL_BUTTON.click();
        Thread.sleep(2000);
    }

    @Step("Сообщение об аннулировании заявки")
    public String getAnnulAppMessage() {
        return ApplicationElement.ANNUL_SUCCESS_MESSAGE.getText();
    }
}
