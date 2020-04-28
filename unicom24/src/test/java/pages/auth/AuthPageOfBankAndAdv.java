package pages.auth;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.CommonMethods;
import testContext.TestContext;

import java.util.Arrays;
import java.util.List;

public class AuthPageOfBankAndAdv extends Base {
    CommonMethods commonMethods = new CommonMethods();

    @FindBy(css = "div.auth-layout-form")
    private WebElement authForm;

    @FindBy(id = "email")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(), 'Войти')]")
    private WebElement entranceLink;

    @FindBy(xpath = "//label[contains(text(), 'Запомнить меня')]")
    private WebElement rememberMeTitle;

    @FindBy(xpath = "//a[contains(text(), 'Забыли пароль')]")
    private WebElement forgottenPasswordLink;

    private final List<WebElement> elements;

    public AuthPageOfBankAndAdv(){
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(authForm, passwordField, entranceLink, rememberMeTitle, forgottenPasswordLink);
    }

    public void pageIsDisplayed(){
        allElementsAreVisible(elements);
    }

    public void advAuth(){
        commonMethods.logIn(loginField, passwordField, entranceLink);
    }

    /*
     *два метода внизу не разделять другими методами для удобства
     *Это метод для регистрации пользователя как физлица в кабинете вебмастера. Данные берутся из ЛК физика.
     * Конечная цель проверить что пользователь не сможет залогиниться
     */
    public void userLogIn(){
        commonMethods.logIn(TestContext.generatedEmail, TestContext.smsCode, loginField, passwordField, entranceLink);
    }

    public void checkThatUserCannot() {
        String xPath = "//div[contains(text(), 'Неверное имя пользователя или пароль')]";
        waitForAjaxElementIsVisible(By.xpath(xPath));
    }
}
