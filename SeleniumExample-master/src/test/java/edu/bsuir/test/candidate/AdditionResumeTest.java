package edu.bsuir.test.candidate;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.entity.Helper;
import edu.bsuir.test.services.SignIn;
import edu.bsuir.test.services.enums.Role;
import edu.bsuir.web.page.CreateCandidatePage;
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

public class AdditionResumeTest {

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
    public void addFileDOC() throws InterruptedException {
        ccp.addDocuments();
        ccp.loadFileRobot("resources/sql.docx");
        Thread.sleep(3000);
        List<String> fileNames = new ArrayList<>();
        fileNames.add("sql.docx");
        Assert.assertEquals(fileNames , ccp.getListOfDocuments());
    }

    @Test
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
    public void addFileXLS() throws InterruptedException {
        ccp.addDocuments();
        ccp.loadFileRobot("resources/BigData.xls");
        Thread.sleep(3000);
        List<String> fileNames = new ArrayList<>();
        fileNames.add("BigData.xls");
        Assert.assertEquals(fileNames , ccp.getListOfDocuments());
    }

    @Test
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
