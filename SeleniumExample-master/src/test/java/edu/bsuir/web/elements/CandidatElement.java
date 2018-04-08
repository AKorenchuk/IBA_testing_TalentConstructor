package edu.bsuir.web.elements;

import edu.bsuir.entity.Element;
import org.openqa.selenium.By;

public class CandidatElement {

    public static final Element CANDIDATE_PAGE = new Element("candidate_page", By.xpath("//div[@class='tc-theme-navigationFieldText' and text()=' Кандидаты ']"));

}
