package pages.adminka.admAuth;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.CommonMethods;
import pages.auth.AuthPage;

import java.util.Arrays;
import java.util.List;

public class AdmAuth extends Base {
    CommonMethods commonMethods = new CommonMethods();

    @FindBy(name = "username")
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(css = "input[value=\"Войти\"]")
    private WebElement entranceBtn;

    private final List<WebElement>elements;

    public AdmAuth(){
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(loginField, passwordField, entranceBtn);
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(elements);
    }

    public Boolean isPageDisplayed(){
        return isElementVisible(loginField) && isElementVisible(passwordField) && isElementVisible(entranceBtn);
    }

    public void logIn(){
        commonMethods.logIn(loginField, passwordField, entranceBtn);
    }
}
