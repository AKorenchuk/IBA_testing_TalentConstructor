package edu.bsuir.web.page;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.test.services.LoadingFile;
import edu.bsuir.web.elements.CreateCandidateElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class CreateCandidatePage {

    WebDriver driver = WebDriverSingleton.getInstance();
    LoadingFile file = new LoadingFile();

    @Step(" установка имени кандидата {0} ")
    public void setName(String name){
        CreateCandidateElement.FIRST_NAME.setText(name);
    }


    @Step(" получение имени кандидата после сохранения заявки")
    public String getName(){
        return CreateCandidateElement.FIRST_NAME.getText();
    }

    @Step("наличие ошибки, связаной с  именем")
    public boolean isVisibleErrorName(){
        return CreateCandidateElement.ERROR_NAME.isElementPresent();
    }

    @Step(" установка фамилии кандидата {0}")
    public void setLastName(String name){
        CreateCandidateElement.LAST_NAME.setText(name);
    }

    @Step(" получение фамилии кандидата после сохранения заявки")
    public String getLastName(){
        return CreateCandidateElement.LAST_NAME.getText();
    }

    @Step("наличие ошибки, связаной с  фамилией")
    public boolean isVisibleErrorLastName(){
        return CreateCandidateElement.ERROR_LAST_NAME.isElementPresent();
    }

    @Step(" установка отчества кандидата {0}")
    public void setSecondName(String name){
        CreateCandidateElement.SECOND_NAME.setText(name);
    }

    @Step("наличие ошибки, связаной с  отчеством")
    public boolean isVisibleErrorSecondName(){
        return CreateCandidateElement.ERROR_SECOND_NAME.isElementPresent();
    }

    @Step(" установка skype {0}")
    public void setSkype(String skype){
        CreateCandidateElement.SKYPE.setText(skype);
    }

    @Step("наличие ошибки, связаной со skype")
    public boolean isVisibleErrorSkype(){
        return CreateCandidateElement.ERROR_SKYPE.isElementPresent();
    }

    @Step(" установка страны кандидата {0}")
    public void setCountry(String country){
        CreateCandidateElement.COUNTRY.setText(country);
    }

    @Step("наличие ошибки, связаной со значением страны")
    public boolean isVisibleErrorCountry(){
        return CreateCandidateElement.ERROR_COUNTRY.isElementPresent();
    }

    @Step(" установка адреса кандидата {0}")
    public void setCity(String city){
        CreateCandidateElement.CITY.setText(city);
    }

    @Step("наличие ошибки, связаной со значением адреса")
    public boolean isVisibleErrorCity(){
        return CreateCandidateElement.ERROR_CITY.isElementPresent();
    }

    @Step(" установка дня рождения кандидата {0}")
    public void setDayOfBirthDay(String day){
        CreateCandidateElement.DAY_OF_BIRTH_DAY.setText(day);
    }

    @Step(" установка месяца рождения кандидата {0}")
    public void setDayOfBirthMonth(String month){
        CreateCandidateElement.DAY_OF_BIRTH_MONTH.setText(month);
    }

    @Step(" установка года рождения кандидата {0}")
    public void setDayOfBirthYear(String year){
        CreateCandidateElement.DAY_OF_BIRTH_YEAR.setText(year);
    }

    @Step("наличие ошибки, связаной со значением даты рождения")
    public boolean isVisibleErrorDate(){
        return CreateCandidateElement.ERROR_DATE.isElementPresent();
    }

    @Step(" установка желаемой должности {0}")
    public void setDesiredPosition(String position){
        CreateCandidateElement.DESIRED_POSITION.setText(position);
    }

    @Step("наличие ошибки, связаной со значением желаемой должности")
    public boolean isVisibleErrorDesiredPosition(){
        return CreateCandidateElement.ERROR_DESIRED_POSITION.isElementPresent();
    }

    @Step(" установка дополнительной информации {0}")
    public void setAdditionalInfo(String info){
        CreateCandidateElement.ADDITIONAL_INFO.setText(info);
    }

    @Step("наличие ошибки, связаной со значением дополнительной информации")
    public boolean isVisibleErrorAdditionalInfo(){
        return CreateCandidateElement.ERROR_ADDITIONAL_INFO.isElementPresent();
    }

    @Step("Получение значения ФИО после сохранения кандидата")
    public String getFIO(){
        return CreateCandidateElement.FIO.getText();
    }

    @Step("Получение значения номера телефона после сохранения кандидата")
    public String getPhone(){
        return CreateCandidateElement.TELEPHONE_NUMBER.getText();
    }

    @Step("Получение значения эл.почты после сохранения кандидата")
    public String getMail(){
        return CreateCandidateElement.MAIL.getText();
    }

    @Step("Открытие формы создания кандидата используя кнопку")
    public void openCreateCandidatePageByButton(){
        CreateCandidateElement.CREATE_CANDIDATE_BUTTON.click();
    }

    @Step("Сохранение кандидата")
    public void saveCandidateProfile() {
        CreateCandidateElement.SAVE_BUTTON.click();
    }

    @Step("Получение текста ошибки при созданиии кандидата")
    public String getErrorMessage(){
        return CreateCandidateElement.ERROR_MESSAGE.getText();
    }

    @Step("наличие ошибки связанной с эл.почтой")
    public boolean isVisibleErrorEmail(){
        return CreateCandidateElement.ERROR_EMAIL.isElementPresent();
    }

    @Step(" установка эл.почты {0}")
    public void setEmail(String email){
        CreateCandidateElement.EMAIL.setText(email);
    }

    @Step(" получение значения электронной почты")
    public String getEmail(){
        return CreateCandidateElement.EMAIL.getText();
    }

    @Step("наличие ошибки, связаной со значением моб.телефона")
    public boolean isVisibleErrorPhone(){
        return CreateCandidateElement.ERROR_TELEPHONE.isElementPresent();
    }

    @Step("свободный клик")
    public void doFreeClick() {
        CreateCandidateElement.FREE_SPACE.click();
    }

    @Step(" установка номера телефона кандидата {0}")
    public void setPhoneNumber(String number){
        CreateCandidateElement.TELEPHONE.setText(number);
    }

    @Step(" получение номера телефона")
    public String getPhoneNumber(){
        return CreateCandidateElement.TELEPHONE.getText();
    }

    @Step(" открытие формы создания нового кандидата")
    public void openCreateProfile(){
        driver.get(CreateCandidateElement.URL_CREATE_PROFILE);
    }

    public void openCandidatePage(){
        driver.get(CreateCandidateElement.URL_CANDIDATE_PAGE);
    }

    public void selectEducationByValue(String value) {
        Select select = new Select(CreateCandidateElement.EDUCATION_SELECT.getWebElement());
        select.selectByValue(value);
    }

    @Step(" Отменить создание нового кандидата")
    public void canceledCreateCandidate(){
        CreateCandidateElement.CANCEL.click();
    }

    @Step(" редактировать кандидата")
    public void editCandidateProfile(){
        CreateCandidateElement.EDIT_BUTTON.click();
    }

    @Step(" установка фото через ссылку под фото")
    public void addPhotoByLink() throws InterruptedException {
        CreateCandidateElement.ADD_PHOTO_LINK.click();
        Thread.sleep(3000);
    }

    @Step(" Вызов диалогового окна для добавления документа")
    public void addDocuments() throws InterruptedException {
        CreateCandidateElement.ADD_DOCUMENT.click();
        Thread.sleep(3000);
    }

    @Step(" удаление прикрепленного файла {0}")
    public void removeDocuments(Integer index) throws InterruptedException {
        List<WebElement> currentDocuments = CreateCandidateElement.REMOVE_DOCUMENT.getWebElements();
        currentDocuments.get(index).click();
        Thread.sleep(1000);
    }

    @Step(" получение списка прикрепенных документов")
    public List<String> getListOfDocuments() throws InterruptedException {
        List<String> listOfDocument = new ArrayList<>();
        List<WebElement> currentDocuments = CreateCandidateElement.LIST_OF_DOCUMENT.getWebElements();
        System.out.println(currentDocuments.size());

        for(WebElement i: currentDocuments){
            System.out.println(i);
            listOfDocument.add(i.getText());
        }
        return listOfDocument;
    }

    @Step(" получение ссылки на текущее фото кандидата")
    public String getLinkOfCurrentImg() {
        CreateCandidateElement.CURRENT_IMG.assertPresence();
        return CreateCandidateElement.CURRENT_IMG.getAttribute("src");
    }

    @Step(" наличие ошибки связанной с добавлением фото")
    public boolean isVisibleImageError() {
        return CreateCandidateElement.IMAGE_ERROR.isElementPresent();
    }

    @Step(" загрузка резюме")
    public void loadResume() throws InterruptedException {
        CreateCandidateElement.LOAD_RESUME.click();
        Thread.sleep(2000);
        CreateCandidateElement.AGREE_WITH_LOAD_RESUME.click();
    }

    @Step(" загрузка файла {0} испльзуя selenium")
    public void loadFileSelenium(String path) {
        file.uploadFileUsingSelenium(CreateCandidateElement.IMAGE_INPUT,path);
    }

    @Step(" загрузка файла {0} испльзуя robot")
    public void loadFileRobot(String path) {
        file.uploadFileUsingRobot(path);
    }

    @Step(" загрузка файла {0} испльзуя sikuli")
    public void loadFileSikuli(String path) throws Exception {
        file.uploadFileUsingSikuli(path);
    }

}
