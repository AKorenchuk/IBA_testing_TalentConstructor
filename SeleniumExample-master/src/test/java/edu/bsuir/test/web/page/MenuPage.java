package edu.bsuir.test.web.page;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.test.web.elements.MenuElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage {
    WebDriver driver = WebDriverSingleton.getInstance();

    public void openAdaptPage(){
        WebDriverWait wait = new WebDriverWait(driver, 120);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(MenuElement.ADAPT_PAGE));
        element.click();
    }

    public void openDirectoryPage(){
        WebDriverWait wait = new WebDriverWait(driver, 120);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(MenuElement.DIRECTORY_PAGE));
        element.click();
    }
    public void openMainPage(){
        WebDriverWait wait = new WebDriverWait(driver, 120);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(MenuElement.MAIN_PAGE));
        element.click();
    }

    public void openNotification(){
        WebElement element = driver.findElement(MenuElement.NOTIFICATION_PAGE);
        element.click();
    }

    public String getNotificationTitle(){
        WebDriverWait wait = new WebDriverWait(driver, 120);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(MenuElement.NOTIFICATION_HEADER));
        return element.getText();
    }
}
