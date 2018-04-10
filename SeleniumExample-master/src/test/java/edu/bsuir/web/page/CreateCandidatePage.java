package edu.bsuir.web.page;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.test.services.LoadingFile;
import edu.bsuir.web.elements.CreateCandidateElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class CreateCandidatePage {

    WebDriver driver = WebDriverSingleton.getInstance();
    LoadingFile file = new LoadingFile();

    public void setName(String name){
        CreateCandidateElement.FIRST_NAME.setText(name);
    }

    public String getName(){
        return CreateCandidateElement.FIRST_NAME.getText();
    }

    public boolean isVisibleErrorName(){
        return CreateCandidateElement.ERROR_NAME.isElementPresent();
    }

    public void setLastName(String name){
        CreateCandidateElement.LAST_NAME.setText(name);
    }

    public String getLastName(){
        return CreateCandidateElement.LAST_NAME.getText();
    }

    public boolean isVisibleErrorLastName(){
        return CreateCandidateElement.ERROR_LAST_NAME.isElementPresent();
    }

    public void setSecondName(String name){
        CreateCandidateElement.SECOND_NAME.setText(name);
    }

    public boolean isVisibleErrorSecondName(){
        return CreateCandidateElement.ERROR_SECOND_NAME.isElementPresent();
    }

    public void setSkype(String skype){
        CreateCandidateElement.SKYPE.setText(skype);
    }

    public boolean isVisibleErrorSkype(){
        return CreateCandidateElement.ERROR_SKYPE.isElementPresent();
    }

    public void setCountry(String country){
        CreateCandidateElement.COUNTRY.setText(country);
    }

    public boolean isVisibleErrorCountry(){
        return CreateCandidateElement.ERROR_COUNTRY.isElementPresent();
    }

    public void setCity(String city){
        CreateCandidateElement.CITY.setText(city);
    }

    public boolean isVisibleErrorCity(){
        return CreateCandidateElement.ERROR_CITY.isElementPresent();
    }

    public void setDayOfBirthDay(String day){
        CreateCandidateElement.DAY_OF_BIRTH_DAY.setText(day);
    }

    public void setDayOfBirthMonth(String month){
        CreateCandidateElement.DAY_OF_BIRTH_MONTH.setText(month);
    }

    public void setDayOfBirthYear(String year){
        CreateCandidateElement.DAY_OF_BIRTH_YEAR.setText(year);
    }

    public boolean isVisibleErrorDate(){
        return CreateCandidateElement.ERROR_DATE.isElementPresent();
    }

    public void setDesiredPosition(String position){
        CreateCandidateElement.DESIRED_POSITION.setText(position);
    }

    public boolean isVisibleErrorDesiredPosition(){
        return CreateCandidateElement.ERROR_DESIRED_POSITION.isElementPresent();
    }


    public void setAdditionalInfo(String info){
        CreateCandidateElement.ADDITIONAL_INFO.setText(info);
    }

    public boolean isVisibleErrorAdditionalInfo(){
        return CreateCandidateElement.ERROR_ADDITIONAL_INFO.isElementPresent();
    }


    public String getFIO(){
        return CreateCandidateElement.FIO.getText();
    }

    public String getPhone(){
        return CreateCandidateElement.TELEPHONE_NUMBER.getText();
    }

    public String getMail(){
        return CreateCandidateElement.MAIL.getText();
    }

    public void openCreateCandidatePageByButton(){
        CreateCandidateElement.CREATE_CANDIDATE_BUTTON.click();
    }

    public void saveCandidateProfile() {
        CreateCandidateElement.SAVE_BUTTON.click();
    }

    public String getErrorMessage(){
        return CreateCandidateElement.ERROR_MESSAGE.getText();
    }

    public boolean isVisibleErrorEmail(){
        return CreateCandidateElement.ERROR_EMAIL.isElementPresent();
    }

    public void setEmail(String email){
        CreateCandidateElement.EMAIL.setText(email);
    }
    public String getEmail(){
        return CreateCandidateElement.EMAIL.getText();
    }


    public boolean isVisibleErrorPhone(){
        return CreateCandidateElement.ERROR_TELEPHONE.isElementPresent();
    }

    public void doFreeClick() {
        CreateCandidateElement.FREE_SPACE.click();
    }

    public void setPhoneNumber(String number){
        CreateCandidateElement.TELEPHONE.setText(number);
    }

    public String getPhoneNumber(){
        return CreateCandidateElement.TELEPHONE.getText();
    }


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

    public void canceledCreateCandidate(){
        CreateCandidateElement.CANCEL.click();
    }

    public void editCandidateProfile(){
        CreateCandidateElement.EDIT_BUTTON.click();
    }

    public void addPhotoByLink() throws InterruptedException {
        CreateCandidateElement.ADD_PHOTO_LINK.click();
        Thread.sleep(3000);
    }

    public void addDocuments() throws InterruptedException {
        CreateCandidateElement.ADD_DOCUMENT.click();
        Thread.sleep(3000);
    }


    public void removeDocuments(Integer index) throws InterruptedException {
        List<WebElement> currentDocuments = CreateCandidateElement.REMOVE_DOCUMENT.getWebElements();
        currentDocuments.get(index).click();
        Thread.sleep(1000);
    }

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

    public String getLinkOfCurrentImg() {
        CreateCandidateElement.CURRENT_IMG.assertPresence();
        return CreateCandidateElement.CURRENT_IMG.getAttribute("src");
    }

    public boolean isVisibleImageError() {
        return CreateCandidateElement.IMAGE_ERROR.isElementPresent();
    }

    public void loadResume() throws InterruptedException {
        CreateCandidateElement.LOAD_RESUME.click();
        Thread.sleep(2000);
        CreateCandidateElement.AGREE_WITH_LOAD_RESUME.click();
    }

    public void loadFileSelenium(String path) {
        file.uploadFileUsingSelenium(CreateCandidateElement.IMAGE_INPUT,path);
    }

    public void loadFileRobot(String path) {
        file.uploadFileUsingRobot(path);
    }

    public void loadFileSikuli(String path) throws Exception {
        file.uploadFileUsingSikuli(path);
    }

}
