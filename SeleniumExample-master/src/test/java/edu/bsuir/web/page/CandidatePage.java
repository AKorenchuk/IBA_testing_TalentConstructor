package edu.bsuir.web.page;

import edu.bsuir.web.elements.CandidatElement;
import io.qameta.allure.Step;

public class CandidatePage {

    @Step(" открытие страницы кандидатов")
    public void openCandidatesPage(){
        CandidatElement.CANDIDATE_PAGE.click();
    }


}
