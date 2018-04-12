package edu.bsuir.web.page;

import edu.bsuir.web.elements.MenuElement;
import io.qameta.allure.Step;

public class MenuPage {

    @Step("открытие страницы подбора и адаптации")
    public void openAdaptPage(){
        MenuElement.ADAPT_PAGE.click();
    }

    @Step("открытие справочника")
    public void openDirectoryPage(){
        MenuElement.DIRECTORY_PAGE.click();
    }

    @Step("открытие главной страницы")
    public void openMainPage(){
        MenuElement.MAIN_PAGE.click();
    }

    @Step("открытие уведомлений")
    public void openNotification(){
        MenuElement.NOTIFICATION_PAGE.click();
    }


    @Step("открытие профиля пользователя")
    public void openProfileInfo(){
        MenuElement.PROFILE_PAGE.click();
    }

    @Step("открытие страницы для добавления компетенции")
    public void openAddCompetencePage(){
        MenuElement.ADD_COMPETENCE_PAGE.click();
    }

    @Step("открытие календаря")
    public void openCalendarPage(){
        MenuElement.CALENDAR_PAGE.click();
    }


    @Step("открытие настроек пользователя")
    public void openUserSetting(){
        MenuElement.SETTING_PAGE.click();
        MenuElement.USER_SETTING.click();
    }


    @Step("открытие настройки текущей страницы")
    public void openPageSetting(){
        MenuElement.SETTING_PAGE.click();
        MenuElement.PAGE_SETTING.click();
    }

    @Step("открытие страницы помощи")
    public void openHelpPage(){
        MenuElement.HELP_PAGE.click();
    }

    @Step("выход")
    public void openExitPage(){
        MenuElement.EXIT.click();
    }


    @Step("наведение на элемент")
    public void moveToElementAdaptPage()  {
        MenuElement.ADAPT_PAGE.moveToElement();
    }


    @Step("получение заголовка окна с заметками")
    public String getNotificationTitle(){
        return MenuElement.NOTIFICATION_HEADER.getText();
    }
}
