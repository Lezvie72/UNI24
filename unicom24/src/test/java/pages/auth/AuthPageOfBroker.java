package pages.auth;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.CommonMethods;
import pagesUrls.PagesUrls;

import java.util.Arrays;
import java.util.List;

public class AuthPageOfBroker extends Base {

    CommonMethods commonMethods = new CommonMethods();

    @FindBy(css = "div.form")
    private WebElement form;

    @FindBy(id = "email")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(), 'Войти')]")
    private WebElement entranceLink;

    @FindBy(xpath = "//a[contains(text(), 'Регистрация')]")
    private WebElement registerPageLink;

    @FindBy(xpath = "//a[contains(text(), 'Забыли пароль')]")
    private WebElement forgottenPasswordLink;

    private final List<WebElement> elements;

    public AuthPageOfBroker() {
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(form, registerPageLink, loginField, passwordField, entranceLink,
                forgottenPasswordLink);
    }

    public void onPage() {
        driver.get(PagesUrls.brokerAuth());
        waitForPageLoaded(PagesUrls.brokerAuth());
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(elements);
    }

    public void brokerLogIn() {
        waitForVisibility(loginField);
        waitForVisibility(passwordField);
        commonMethods.logIn(loginField, passwordField, entranceLink);
    }

}
