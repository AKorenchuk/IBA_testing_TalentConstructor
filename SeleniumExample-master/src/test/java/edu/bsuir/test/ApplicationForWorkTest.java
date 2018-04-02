package edu.bsuir.test;


import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.test.web.page.CreatingApplicationPage;
import edu.bsuir.test.web.page.LoginPage;
import edu.bsuir.test.web.page.MenuPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class ApplicationForWorkTest {

    private WebDriver driver = WebDriverSingleton.getInstance();

    public LoginPage lp = new LoginPage();
    public CreatingApplicationPage cap = new CreatingApplicationPage();
    public MenuPage mp = new MenuPage();


    @Test
    public void checkApplicationForWorkTest() {
        lp.openLoginPage();
        lp.enterLogin("kabanov@tc.by");
        lp.enterPassword("welcome");
        lp.clickLoginButton();


        mp.openAdaptPage();
        cap.startCreateApi();

        cap.enterName("programmer");
        cap.enterDate();
        cap.enterPriority();
        cap.enterQuantity("20");
        cap.enterReason("expansion of the department");
        cap.enterContractType();
        cap.enterSalary("800");
        cap.enterEmployees("no");
        cap.enterBusinessTrip("twice a week");
        cap.enterTimetable("5 day a week");
        cap.enterProbationPeriod("1 month");
        cap.enterResponsibilities("bug fixing");
        cap.enterCandidateType();
        cap.enterEducationSpecialization("technical");
        cap.enterPriorityWorkingExperience("IBA,EPAM");
        cap.enterUndesirableWorkingExperience("-");
        cap.setEditRequiredCompetence();
        cap.enterName(" programmer ");


//       driver.findElement(By.xpath("//*[@id='editrequiredCompetence']")).click();
//        element1 = driver.findElement(By.xpath("//span [@class='tree-label unselectable' and text()='Базовые']"));
//        element1.click();
//        WebDriverWait wait = new WebDriverWait(driver, 120);
//       element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span [@class='tree-label unselectable' and text()='Адаптивность по отношению к людям '] ")));
//        element1.click();
//        driver.findElement(By.xpath("//button[@class='btn btn-primary-modal btn-primary-modal-content yui3-widget btn-content btn-focused' and text()='OK']")).click();
//
//        Actions page = new Actions(driver);
//        page.doubleClick(driver.findElement(By.xpath("//*[@id='yui_patched_v3_11_0_3_1522614058495_8254']"))).perform();


//        element1 = driver.findElement(By.xpath("//div[@class='tree-node-content tree-collapsed']//i [@class='tree-hitarea icon-plus'][0]"));
//        element1.click();
//        element1 = driver.findElement(By.xpath("//span [@class='tree-label unselectable' and text()='Адаптивность по отношению к людям '] "));
//        element1.click();

//        element1 = driver.findElement(By.xpath("//*[@id='yui_patched_v3_11_0_3_1522614058495_8254']"));
//        element1.click();
//        element1 = driver.findElement(By.xpath("//*[@id='yui_patched_v3_11_0_3_1522614058495_8619']"));
//        element1.click();
//        driver.findElement(By.xpath("//*[@id='yui_patched_v3_11_0_3_1522609555314_8989']")).click();


//        driver.findElement(By.xpath("//*[@id='editnotRequiredCompetence']")).click();
//        wait = new WebDriverWait(driver, 120);
//        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='yui_patched_v3_11_0_3_1522609555314_8395']")));
//        element.click();
//        wait = new WebDriverWait(driver, 120);
//        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='yui_patched_v3_11_0_3_1522609555314_10517']")));
//        element.click();
//
//        driver.findElement(By.xpath("//button[text()='OK' and @class='btn btn-primary-modal btn-primary-modal-content yui3-widget btn-content btn-focused']")).click();
//
        cap.enterComment("urgently");
        cap.saveApplication();

        Assert.assertEquals("Заявка успешно сохранена", driver.getTitle());
}


    @After
    public void shutDown() {
        driver.close();
        WebDriverSingleton.destroyInstance();
    }

}









