package pages.auth;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.CommonMethods;

import java.util.Arrays;
import java.util.List;

public class AuthPageOfBrokerOld extends Base {

    CommonMethods commonMethods = new CommonMethods();

    @FindBy(css = ".account__logo")
    private WebElement logo;

    @FindBy(xpath = "//h1[contains(text(), 'Финансовый маркет')]")
    private WebElement finMarketTitle;

    @FindBy(xpath = "//h3[contains(text(), 'Войти в Личный Кабинет')]")
    private WebElement entanceInAccountTitle;

    @FindBy(id = "username")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "remember_me")
    private WebElement rememberMeCheckbox;

    @FindBy(xpath = "//a[contains(text(), 'Забыли пароль?')]")
    private WebElement forgottenPasswordLink;

    @FindBy(xpath = "//button[./span[contains(text(), 'Войти')]]")
    private WebElement entranceLink;

    @FindBy(xpath = "//a[contains(text(), 'Зарегистрироваться')]")
    private WebElement registerLink;

    private final List<WebElement> elements;

    public AuthPageOfBrokerOld(){
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(logo, finMarketTitle, entanceInAccountTitle, loginField, passwordField,
                rememberMeCheckbox, forgottenPasswordLink, entranceLink, registerLink);
    }

    public void pageIsDisplayed(){
        allElementsAreVisible(elements);
    }

    public void logIn(){
        commonMethods.logIn(loginField, passwordField, entranceLink);
    }
}
