package edu.bsuir.web.page;

import edu.bsuir.web.elements.MenuElement;

public class MenuPage {

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

    public void openSettingPoint1(){
        MenuElement.SETTING_PAGE.click();
        MenuElement.SETTING_POINT_1.click();
    }

    public void openSettingPoint2(){
        MenuElement.SETTING_PAGE.click();
        MenuElement.SETTING_POINT_2.click();
    }

    public void openHelpPage(){
        MenuElement.HELP_PAGE.click();
    }

    public void openExitPage(){
        MenuElement.EXIT.click();
    }


    public void moveToElementAdaptPage()  {
        MenuElement.ADAPT_PAGE.moveToElement();
    }

    public String getNotificationTitle(){
        return MenuElement.NOTIFICATION_HEADER.getText();
    }
}
