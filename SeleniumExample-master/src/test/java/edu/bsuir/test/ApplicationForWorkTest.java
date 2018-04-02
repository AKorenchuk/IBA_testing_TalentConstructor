package edu.bsuir.test;


import edu.bsuir.driver.WebDriverSingleton;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class ApplicationForWorkTest {

    private WebDriver driver = WebDriverSingleton.getInstance();

    private  Map < String, String> dataField = new HashMap< String, String>();
    {
        dataField.put("name", " programmer ");

        SimpleDateFormat formattedDate = new SimpleDateFormat("dd.MM.yyyy");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);  // number of days to add
        String tomorrow = (String)(formattedDate.format(c.getTime()));
        dataField.put("date", tomorrow);

        dataField.put("count", "10");
        dataField.put("reasone", "expansion of the department");
        dataField.put("salary", "800");
        dataField.put("employees", "no");
        dataField.put("businessTrip", "twice a week");
        dataField.put("timetablep", "5 day a week");
        dataField.put("probationPeriod", "1 month");
        dataField.put("responsibilities", "bug fixing");
        dataField.put("educationSpecialization", "technical");
        dataField.put("priorityWorkingExperience", "IBA,EPAM");
        dataField.put("undesirableWorkingExperience", "-");
        dataField.put("comment", "urgently");

    }

    @Test
    public void checkApplicationForWorkTest() {
        driver.get("http://testing.cld.iba.by");
        WebElement login = driver.findElement(By.xpath("//input[@id='_58_login']"));
        login.sendKeys("kabanov@tc.by");
        WebElement password = driver.findElement(By.xpath("//input[@id='_58_password']"));
        password.sendKeys("welcome");
        password.sendKeys(Keys.RETURN);

        WebDriverWait wait1 = new WebDriverWait(driver, 120);
        WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='layout_2']/a")));
        element1.click();

        driver.findElement(By.xpath("//*[@id='addRequest']/div[2]/div[2]/a")).click();

        WebElement position = driver.findElement(By.xpath("//*[@id='name']"));
        position.sendKeys(dataField.get("name"));

        WebElement date = driver.findElement(By.xpath("//*[@id='plannedClosingDate']"));
        date.sendKeys(dataField.get("date"));

        driver.findElement(By.xpath("//*[@id='priority-1']")).click();

        WebElement count = driver.findElement(By.xpath("//*[@id='quantity']"));
        count.sendKeys(dataField.get("count"));

        WebElement reasone = driver.findElement(By.xpath("//*[@id='creationReason']"));
        reasone.sendKeys(dataField.get("reasone"));

        driver.findElement(By.xpath("//*[@id='contractType-0']")).click();

        WebElement salary = driver.findElement(By.xpath("//*[@id='salary']"));
        salary.sendKeys(dataField.get("salary"));

        WebElement employees = driver.findElement(By.xpath("//*[@id='employees']"));
        employees.sendKeys(dataField.get("employees"));

        WebElement businessTrip = driver.findElement(By.xpath("//*[@id='businessTrip']"));
        businessTrip.sendKeys(dataField.get("businessTrip"));

        WebElement timetable = driver.findElement(By.xpath("//*[@id='timetable']"));
        timetable.sendKeys(dataField.get("timetable"));

        WebElement probationPeriod = driver.findElement(By.xpath("//*[@id='probationPeriod']"));
        probationPeriod.sendKeys(dataField.get("probationPeriod"));

        WebElement responsibilities = driver.findElement(By.xpath("//*[@id='responsibilities']"));
        responsibilities.sendKeys(dataField.get("responsibilities"));

        driver.findElement(By.xpath("//*[@id='candidateTypeExternal']")).click();

        WebElement educationSpecialization = driver.findElement(By.xpath("//*[@id='educationSpecialization']"));
        educationSpecialization.sendKeys(dataField.get("educationSpecialization"));

        WebElement priorityWorkingExperience = driver.findElement(By.xpath("//*[@id='priority.working.experience']"));
        priorityWorkingExperience.sendKeys(dataField.get("priorityWorkingExperience"));

        WebElement undesirableWorkingExperience = driver.findElement(By.xpath("//*[@id='undesirableWorkingExperience']"));
        undesirableWorkingExperience.sendKeys(dataField.get("undesirableWorkingExperience"));

//        driver.findElement(By.xpath("//*[@id='editrequiredCompetence']")).click();
//        Actions page = new Actions(driver);
//        page.doubleClick(driver.findElement(By.xpath("//*[@id='yui_patched_v3_11_0_3_1522614058495_8254']"))).perform();


//        element1 = driver.findElement(By.xpath("//*[@id='yui_patched_v3_11_0_3_1522614058495_8254']"));
//        element1.click();
        Assert.assertEquals("Редактировать компетенции", driver.findElement(By.xpath("//*[@id='yui_patched_v3_11_0_3_1522614058495_8415']")).getText());

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
//        driver.findElement(By.xpath("//*[@id='yui_patched_v3_11_0_3_1522609555314_8989']")).click();

//        WebElement comment = driver.findElement(By.xpath("//*[@id='comment']"));
//        comment.sendKeys(dataField.get("comment"));
//
//        driver.findElement(By.xpath("//*[@id='save']")).click();
//        Assert.assertEquals("Заявка успешно сохранена", driver.findElement(By.xpath("//*[@id='successMessage']")).getText());
}


    @After
    public void shutDown() {
        driver.close();
    }

}
