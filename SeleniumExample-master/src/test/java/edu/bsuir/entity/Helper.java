package edu.bsuir.entity;


import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.entity.enums.GeneratorMode;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Helper {

    public static void waitForTime(int timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForTimeInMilliseconds(long timeout) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String generateRandomString(int length, GeneratorMode mode) {
        StringBuffer buffer = new StringBuffer();
        String characters = "";
        switch (mode) {
            case ALPHA:
                characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                break;
            case ALPHANUMERIC:
                characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
                break;
            case NUMERIC:
                characters = "1234567890";
                break;
            case SPECIAL_SYMBOLS :
                characters = "“[|]’~<!--@/*$%^&#*/()?>,.*/\\àáâãäåçèéêëìíîðñòôõöö♣ ☺ ♂";
                break;
            case ANY_CHARACTERS:
                characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890~!@#$%^&*()_+=-<>?/.,|}{][";
                break;
        }
        int charactersLength = characters.length();
        for (int i = 0; i < length; i++) {
            double index = Math.random() * charactersLength;
            buffer.append(characters.charAt((int) index));
        }
        return buffer.toString();
    }

    public static void closeBrowser() throws IOException {
        WebDriverSingleton.getInstance().close();
        WebDriverSingleton.destroyInstance();
    }

    public static void setAttributeValue(String webElementId, String attr, String value){
        JavascriptExecutor js = (JavascriptExecutor) WebDriverSingleton.getInstance();
        js.executeScript("document.getElementById('" + webElementId + "').setAttribute('" + attr + "', '" + value + "')");
    }
}
