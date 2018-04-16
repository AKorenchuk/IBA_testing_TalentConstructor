package edu.bsuir.web.page;

import edu.bsuir.web.elements.AgreementElement;
import io.qameta.allure.Step;

public class AgreementPage {

    @Step(" отправление заявки на согласование")
    public void sendForAgreement() {
        AgreementElement.SEND_FOR_AGREEMENT_BUTTON.click();
    }


    @Step(" выбор соотрудников, которые должны рассмотреть заявку ")
    public void sendForReview() throws InterruptedException {
        AgreementElement.REVIEW.click();
        Thread.sleep(5000);
        AgreementElement.CHIEF_RECRUITER_SELECTOR.click();
        AgreementElement.KABANOV_AT_SELECTOR.click();
        AgreementElement.OK.click();
    }

    @Step(" выбор соотрудников, которые должны cогласовать заявку ")
    public void sendForApprove() throws InterruptedException {
        AgreementElement.APPROVE.click();
        Thread.sleep(5000);
        AgreementElement.CHIEF_RECRUITER_SELECTOR.click();
        AgreementElement.KABANOV_AT_SELECTOR.click();
        AgreementElement.OK.click();
    }

    @Step(" выбор соотрудников, которые должны ознакомиться с заявкой ")
    public void sendForAcquaintance() throws InterruptedException {
        AgreementElement.SEND_FOR_VIEW.click();
        Thread.sleep(5000);
        AgreementElement.CHIEF_RECRUITER_SELECTOR.click();
        AgreementElement.KABANOV_AT_SELECTOR.click();
        AgreementElement.OK.click();
    }

    @Step(" соотрудники, которые должны рассмотреть заявку ")
    public String listOfReview() {
        return AgreementElement.WHO_REVIEW.getText();
    }

    @Step(" соотрудники, которые должны cогласовать заявку ")
    public String listOfApprove() {
        return AgreementElement.WHO_APPROVE.getText();
    }

    @Step(" соотрудники, которые должны ознакомиться с заявкой ")
    public String listOfAcquaintance() {
        return AgreementElement.WHO_FAMILIARIZE.getText();
    }

    @Step(" отправить заявку на ознакомление, согласование и рассмотрение соотрудникам")
    public void send() {
        AgreementElement.SEND_FOR_APPROVE.click();
    }



}
