package edu.bsuir.web.elements;

import edu.bsuir.entity.Element;
import org.openqa.selenium.By;

public class AgreementElement {

    public static final Element SEND_FOR_AGREEMENT_BUTTON = new Element(
            "send for agreement", By.xpath("//a[@id='sendToApprovalButton']"));

    public static final Element REVIEW = new Element(
            "review", By.xpath("//a[./i[@id='review']]"));

    public static final Element APPROVE = new Element(
            "approve", By.xpath("//a[./i[@id='approve']]"));

    public static final Element SEND_FOR_VIEW = new Element(
            "send for view", By.xpath("//a[@id='send']"));

    public static final Element CHIEF_RECRUITER_SELECTOR = new Element(
            "chief recruiter", By.xpath("//button[@id='participantListPopover' and @prof='ChiefRecruiter'][1]"));

    public static final Element KABANOV_AT_SELECTOR = new Element(
            "kabanov at selector", By.xpath("//label[@class='user-chkbox' and @id='5' and text()='Кабанов Александр']"));

    public static final Element OK = new Element("ok button", By.xpath("//button[text()='Ок']"));

    public static final Element SEND_FOR_APPROVE = new Element( "send for approve", By.xpath("//a[@id='approveButton']"));

    public static final Element WHO_REVIEW = new Element("who review", By.xpath("//div[@class='review']//span[@id='full-name']"));

    public static final Element WHO_APPROVE = new Element("who approve", By.xpath("//div[@class='approve']//span[@id='full-name']"));

    public static final Element WHO_FAMILIARIZE = new Element("who approve", By.xpath("//div[@class='send']//span[@id='full-name']"));


}
