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

/**
 * загрузка фото
 * - максимальный объем
 * - расширение
 * -удаление фото(не работает почему-то. если один раз добавил что-то, то ее уже не удалить)
 *
 *
 * Загрузка резюме
 * не ясно, в каком формате должен быть корректный файл для занрузки
 * ну и если тестировать,то
 * - максимальный объем
 * - расширение
 * -кодировка
 * - два раза загрузить (что будет? можно ли вообще?)
 *
 *
 * прикрепленные файлы
 *
 * прикрепление одного и того же файла несколько раз
 * максимальное кол-во прикрепляемых файлов
 * формат, размер
 * удаление
 */
public class PhotoTest {

    public WebDriver driver ;
    public SignIn form = new SignIn();
    public CreateCandidatePage ccp = new CreateCandidatePage();
    public Helper help = new Helper();

    final String noAvatar = "http://testing.cld.iba.by/TC-RecruitingAndOnboarding-portlet/common/css/images/no-avatar.jpg";


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
    public void сheckAddPhotoJPG() throws InterruptedException {
        ccp.loadFileSelenium("resources/photo.JPG");
        Assert.assertNotEquals(ccp.getLinkOfCurrentImg(), noAvatar);
    }

    @Test
    public void сheckAddPhotoPNG() throws InterruptedException {
        ccp.loadFileSelenium("resources/girl.png");
        Assert.assertNotEquals(ccp.getLinkOfCurrentImg(), noAvatar);
    }

    @Test
    public void сheckAddPhotoPDF() throws InterruptedException {
        ccp.loadFileSelenium("resources/Korenchuk.pdf");
        Assert.assertEquals(ccp.getLinkOfCurrentImg(), noAvatar);
    }

    @Test
    public void сheckAddPhotoTXT() throws InterruptedException {
        ccp.loadFileSelenium("resources/photo.txt");
        Assert.assertEquals(ccp.getLinkOfCurrentImg(), noAvatar);
    }

    @Test
    public void сheckAddPhotoGIF() throws InterruptedException {
        ccp.loadFileSelenium("resources/dancer.gif");
        Assert.assertNotEquals(ccp.getLinkOfCurrentImg(), noAvatar);
    }

    @Test
    public void сheckDoubleChangePhoto() throws InterruptedException {
        ccp.loadFileSelenium("resources/dancer.gif");
        String gif = "http://testing.cld.iba.by/TC-RecruitingAndOnboarding-portlet/common/css/images/dancer.gif";
        Assert.assertEquals(ccp.getLinkOfCurrentImg(), gif);
        ccp.loadFileSelenium("resources/girl.png");
        String png = "http://testing.cld.iba.by/TC-RecruitingAndOnboarding-portlet/common/css/images/girl.png";
        Assert.assertEquals(ccp.getLinkOfCurrentImg(), png);
    }

    @Test
    public void сheckSizePhoto() throws InterruptedException {
        ccp.loadFileSelenium("resources/big_size.JPG");
        Assert.assertTrue(ccp.isVisibleImageError());
    }

    @Test
    public void сheckParametersPhoto() throws InterruptedException {
        ccp.loadFileSelenium("resources/big_parameters.JPG");
        String png = "http://testing.cld.iba.by/TC-RecruitingAndOnboarding-portlet/common/css/images/big_parameters.JPG";
        Assert.assertEquals(ccp.getLinkOfCurrentImg(), png);
        //фото сохраняется но очень сильно обрезается и не прокручивается
    }

    @After
    public void shutDown() throws IOException {
        help.closeBrowser() ;
    }
}
