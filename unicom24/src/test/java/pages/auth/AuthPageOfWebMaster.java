package pages.auth;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.CommonMethods;
import pagesUrls.PagesUrls;
import testContext.TestContext;

import java.util.Arrays;
import java.util.List;

public class AuthPageOfWebMaster extends Base {
    private CommonMethods commonMethods = new CommonMethods();

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

    @FindBy(xpath = "//label[contains(text(), 'Запомнить меня')]")
    private WebElement rememberMe;

    private final List<WebElement> elements;

    public AuthPageOfWebMaster(){
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(loginField, passwordField, entranceLink, registerPageLink, forgottenPasswordLink,
                rememberMe);
    }

    public void onAuthPage(){
        driver.get(PagesUrls.webMasterAuth());
    }

    public void pageIsDisplayed(){
        waitForPageLoaded(PagesUrls.webMasterAuth());
        allElementsAreVisible(elements);
    }

    public void logIn(){
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
