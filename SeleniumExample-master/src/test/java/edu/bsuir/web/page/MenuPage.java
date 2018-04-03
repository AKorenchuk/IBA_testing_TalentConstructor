package edu.bsuir.web.page;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.web.elements.MenuElement;
import org.openqa.selenium.WebDriver;

public class MenuPage {

    WebDriver driver = WebDriverSingleton.getInstance();

    public void openAdaptPage(){
        MenuElement.ADAPT_PAGE.click();
    }

    public void openDirectoryPage(){
        MenuElement.DIRECTORY_PAGE.click();
    }
    public void openMainPage(){
        MenuElement.MAIN_PAGE.click();
    }

    public void openNotification(){
        MenuElement.NOTIFICATION_PAGE.click();
    }

    public void openProfileInfo(){
        MenuElement.PROFILE_PAGE.click();
    }

    public void openAddCompetencePage(){
        MenuElement.ADD_COMPETENCE_PAGE.click();
    }

    public void openCalendarPage(){
        MenuElement.CALENDAR_PAGE.click();
    }

    public void openSettingPage(){
        MenuElement.SETTING_PAGE.click();
    }

    public String getNotificationTitle(){
        return MenuElement.NOTIFICATION_HEADER.getText();
    }
}
