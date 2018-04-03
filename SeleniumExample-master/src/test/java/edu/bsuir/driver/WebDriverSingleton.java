package edu.bsuir.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSingleton {

    private static WebDriver webDriver;

    public static WebDriver getInstance() {
//        if (webDriver == null) {
//            System.setProperty("webdriver.gecko.driver", "lib/drivers/geckodriver.exe");
//            webDriver = new FirefoxDriver();
//            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // таймер для findElement
//            webDriver.manage().window().maximize();
//            webDriver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
//            webDriver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
//        }
//        return webDriver;

        if (webDriver == null) {
            System.setProperty("webdriver.chrome.driver", "lib/drivers/chromedriver.exe");
            webDriver = new ChromeDriver();
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // таймер для findElement
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
            webDriver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        }
        return webDriver;
    }

    public static void destroyInstance() {
        webDriver = null;
    }
}
