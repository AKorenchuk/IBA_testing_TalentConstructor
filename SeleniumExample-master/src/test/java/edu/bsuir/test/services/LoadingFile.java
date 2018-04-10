package edu.bsuir.test.services;


import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.entity.Element;
import edu.bsuir.entity.Helper;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LoadingFile {

    public WebDriver driver = WebDriverSingleton.getInstance();


    public void uploadFileUsingSelenium(Element inputFile, String  path) {
        inputFile.sendKeys(getAbsolutePath(path));
    }


    public void uploadFileUsingRobot(String path) {
        sendFile(getAbsolutePath( path));
    }

    private void sendFile(String path) {
        try {
            setClipboardData(path);
            Robot robot = new Robot();
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(1000);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public String getAbsolutePath(String file) {
        Path path = Paths.get(file);
        return path.toAbsolutePath().toString();
    }

    private void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    }

    public void uploadFileUsingSikuli(String path) throws Exception {

        Pattern filePath = new Pattern("resources/sikuli/FilePath.JPG");
        Pattern openButton = new Pattern("resources/sikuli/OpenButton.JPG");

        Screen screen = new Screen();
        screen.wait(filePath, 20);
        screen.type(filePath, getAbsolutePath(path));
        screen.click(openButton);
        Helper.waitForTime(3);

    }

}
