package edu.bsuir.test.services;

import edu.bsuir.test.services.enums.Role;
import edu.bsuir.web.page.LoginPage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

public class SignIn {

    public final String ROLE_XML_PATH = "src/test/java/edu/bsuir/test/services/xml/roles.xml";

    public LoginPage lp = new LoginPage();

    public void signIn(String login,String password) {
        lp.openLoginPage();
        lp.enterLogin(login);
        lp.enterPassword(password);
        lp.clickLoginButton();
    }


    public void signIn(Role role) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = docBuilder.parse(new File(ROLE_XML_PATH));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        String expressoin = "//*[@id='" + role.name() + "']";
        Element element = (Element) xpath.evaluate(expressoin, document, XPathConstants.NODE);

        String login = element.getElementsByTagName("mail").item(0).getTextContent();
        String password = element.getElementsByTagName("password").item(0).getTextContent();

        signIn(login,password);
    }


}
