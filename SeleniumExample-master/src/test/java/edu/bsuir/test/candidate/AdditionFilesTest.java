package edu.bsuir.test.candidate;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.entity.Helper;
import edu.bsuir.test.services.SignIn;
import edu.bsuir.test.services.enums.Role;
import edu.bsuir.web.page.CreateCandidatePage;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdditionFilesTest {

    public WebDriver driver ;
    public SignIn form = new SignIn();
    public CreateCandidatePage ccp = new CreateCandidatePage();
    public Helper help = new Helper();


    @Before
    public void init() throws SAXException, ParserConfigurationException, XPathExpressionException, IOException {
        driver = WebDriverSingleton.getInstance();
        form.signIn(Role.CHIEF_RECRUITER);
        ccp.openCreateProfile();
        ccp.setLastName("Korenchuk");
        ccp.setName("Anna");
        ccp.setPhoneNumber("2345678");
        ccp.setEmail("korenchuk@mail.com");
    }

    @Test
    @DisplayName("Загрузка DOC")
    @Description("Загрузка файлов с расширением DOC")
    @Feature("Создание кандидата")
    @Story("Сценарий 18 – Прикрепление файлов")
    @Severity(SeverityLevel.NORMAL)
    public void addFileDOC() throws InterruptedException {
        ccp.addDocuments();
        ccp.loadFileRobot("resources/sql.docx");
        Thread.sleep(3000);
        List<String> fileNames = new ArrayList<>();
        fileNames.add("sql.docx");
        Assert.assertEquals(fileNames , ccp.getListOfDocuments());
    }

    @Test
    @DisplayName("Загрузка PDF")
    @Description("Загрузка файлов с расширением PDF")
    @Feature("Создание кандидата")
    @Story("Сценарий 18 – Прикрепление файлов")
    @Severity(SeverityLevel.BLOCKER)
    public void addFilePDF() throws InterruptedException {
        ccp.addDocuments();
        ccp.loadFileRobot("resources/sql.pdf");
        Thread.sleep(3000);
        List<String> fileNames = new ArrayList<>();
        fileNames.add("sql.pdf");
        Assert.assertEquals(fileNames , ccp.getListOfDocuments());
        // но при попытке сохранения заявки с "тяжелым" pdf приложение зависает
    }

    @Test
    @DisplayName("Загрузка MP4")
    @Description("Загрузка файлов с расширением MP4")
    @Feature("Создание кандидата")
    @Story("Сценарий 18 – Прикрепление файлов")
    @Severity(SeverityLevel.BLOCKER)
    public void addFileMP4() throws InterruptedException {
        ccp.addDocuments();
        ccp.loadFileRobot("resources/video.mp4");
        Thread.sleep(3000);
        List<String> fileNames = new ArrayList<>();
        fileNames.add("video.mp4");
        Assert.assertEquals(fileNames , ccp.getListOfDocuments());
        // но при попытке сохранения заявки с видео приложение зависает
    }

    @Test
    @DisplayName("Загрузка XLS")
    @Description("Загрузка файлов с расширением XLS")
    @Feature("Создание кандидата")
    @Story("Сценарий 18 – Прикрепление файлов")
    @Severity(SeverityLevel.NORMAL)
    public void addFileXLS() throws InterruptedException {
        ccp.addDocuments();
        ccp.loadFileRobot("resources/BigData.xls");
        Thread.sleep(3000);
        List<String> fileNames = new ArrayList<>();
        fileNames.add("BigData.xls");
        Assert.assertEquals(fileNames , ccp.getListOfDocuments());
    }

    @Test
    @DisplayName("Загрузка большого кол-ва докуметов")
    @Description("Загрузка большого кол-ва докуметов")
    @Feature("Создание кандидата")
    @Story("Сценарий 18 – Прикрепление файлов")
    @Severity(SeverityLevel.NORMAL)
    public void checkCountOfDocuments() throws InterruptedException {
        for(int i=0;i<50;i++) {
            ccp.addDocuments();
            ccp.loadFileRobot("resources/BigData.xls");
        }
        Thread.sleep(3000);
        List<String> fileNames = new ArrayList<>();
        for(int i=0;i<50;i++) {
            fileNames.add("BigData.xls");
        }
        Assert.assertEquals(fileNames , ccp.getListOfDocuments());
        // не понятно, максимальное-кол-во загружаемых файлов
    }

    @Test
    @DisplayName("Удаление докуметов")
    @Description("Удаление файла")
    @Feature("Создание кандидата")
    @Story("Сценарий 18 – Прикрепление файлов")
    @Severity(SeverityLevel.NORMAL)
    public void removeDocuments() throws InterruptedException {
        ccp.addDocuments();
        ccp.loadFileRobot("resources/BigData.xls");
        ccp.addDocuments();
        ccp.loadFileRobot("resources/sql.docx");
        Thread.sleep(3000);
        List<String> fileNames = new ArrayList<>();
        fileNames.add("BigData.xls");
        fileNames.add("sql.docx");
        Assert.assertEquals(fileNames , ccp.getListOfDocuments());
        ccp.removeDocuments(0);
        fileNames.remove(0);
        Assert.assertEquals(fileNames , ccp.getListOfDocuments());
    }


    @After
    public void shutDown() throws IOException {
        help.closeBrowser() ;
    }
}
