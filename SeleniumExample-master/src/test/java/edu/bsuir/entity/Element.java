package edu.bsuir.entity;

import edu.bsuir.driver.WebDriverSingleton;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Element {

    public String name;
    public By xpath;

    public Element(String name, By xpath) {
        this.name = name;
        this.xpath = xpath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public By getXpath() {
        return xpath;
    }

    public void setXpath(By xpath) {
        this.xpath = xpath;
    }

    public WebElement getWebElement(){
        return WebDriverSingleton.getInstance().findElement(xpath);
    }

    public List<WebElement> getWebElements(){
        return WebDriverSingleton.getInstance().findElements(xpath);
    }

    public WebElement getClickableElement(){
        WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getInstance(), 100);
        return wait.until(ExpectedConditions.elementToBeClickable(xpath));
    }

    public Boolean isElementClickable(){
        try{
            getClickableElement();
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    public void assertClickable(){
        Assert.assertTrue(xpath + " is not clickable. ",isElementClickable());
    }

    public Boolean isElementPresent(){
        try{
            getWebElement();
            return true;
        }catch(Exception ex){
            return false;
        }
    }

    public void assertPresence(){
        Assert.assertTrue(xpath + " is not found. ",isElementPresent());
    }

    public void click(){
        assertPresence();
        assertClickable();
        getWebElement().click();
    }

    public void doubleClick(){
        assertPresence();
        assertClickable();
        Actions actions = new Actions(WebDriverSingleton.getInstance());
        actions.doubleClick(getWebElement());
        actions.perform();
    }

    public void moveToElement(){
        Actions actions = new Actions(WebDriverSingleton.getInstance());
        actions.moveToElement(getWebElement()).build().perform();
    }


    public String getText(){
        assertPresence();
        return getWebElement().getText();
    }

    public void setText(String text){
        assertPresence();
        WebElement element = getWebElement();
        element.clear();
        element.sendKeys(text);

    }

    public String getAttribute(String mean) {
        assertPresence();
        return getWebElement().getAttribute(mean);
    }

    public void sendKeys(String string) {
        getWebElement().sendKeys(string);
    }
}
