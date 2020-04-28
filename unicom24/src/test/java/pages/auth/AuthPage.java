package pages.auth;

import pages.CommonMethods;
import pagesUrls.PagesUrls;
import testContext.TestContext;
import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;
import pages.commonElementsForAllPages.UserData;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class AuthPage extends Base {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    Header headerPage = new Header();
    Footer footerPage = new Footer();
    CommonMethods commonMethods = new CommonMethods();

    public static String login = "glushkova.es@unicom24.ru";
    public static String password = "usertest1";

    @FindBy(className = "ui-authorization-form")
    private WebElement authForm;

    @FindBy(xpath = "//div[contains(text(), 'Войти')]")
    private WebElement entranceLink;

    @FindBy(xpath = "//div[contains(text(), 'Регистрация')]")
    private WebElement registrationTab;

    @FindBy(xpath = "//input[@name='emanresu_htua']")
    private WebElement mailOrTelField;

    @FindBy(xpath = "//input[@name='drowssap_htua']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@name='drowssap_teser']")
    private WebElement newPasswordField;

    @FindBy(xpath = "//input[@name='wen_drowssap_teser']")
    private WebElement repeatNewPasswordField;

    @FindBy(xpath = "//button[@class='ui-btn font__base yellow']")
    private WebElement savePasswordButton;

    @FindBy(xpath = "//button[@class='ui-btn font__base yellow']")
    private WebElement entranceBtn;

    @FindBy(xpath = "//div[contains(text(), 'Зарегистрироваться')]")
    private WebElement registrationLink;

    @FindBy(xpath = "//div[contains(text(), 'Забыли пароль')]")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//div[contains(text(), 'Авторизация через портал Госуслуг')]")
    private WebElement authGosUslugiLink;

    /*
     * Форма восстановления пароля
     */
    @FindBy(xpath = "//div[contains(text(), 'Восстановление пароля')]")
    private WebElement resetPasswordTitle;

    @FindBy(xpath = "//span[contains(text(), 'E-mail или телефон')]")
    private WebElement emailOrPhoneAdvice;

    @FindBy(name = "emanresu_teser")
    private WebElement emailOrPhoneField;

    @FindBy(xpath = "//button[./span[contains(text(), 'Отправить')]]")
    private WebElement sendBtn;

    @FindBy(xpath = "//div[contains(text(), 'Зарегистрироваться')]")
    private WebElement registerLink;
    
    /*
     * Форма восстановления пароля окончена
     */

    private final List<WebElement> elements;

    public AuthPage() {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, headerPage);
        PageFactory.initElements(driver, footerPage);
        elements = Arrays.asList(authForm, entranceLink, registrationTab, mailOrTelField, passwordField,
                entranceBtn, registrationLink, forgotPasswordLink, authGosUslugiLink);
    }

    public void userOnResetPasswordPage() {
        driver.get(PagesUrls.resetPassword());
    }

    public void authPageIsDisplayed() {
        waitForPageLoaded(PagesUrls.authPageUrl());
        allElementsAreVisible(headerPage.getMainHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footerPage.getFooter());
    }

    public void newPasswordFieldsAreDisplayed() {
        switchToTheThirdTab();
        waitForVisibility(newPasswordField);
        waitForVisibility(repeatNewPasswordField);
    }

    public void logIn() {
        commonMethods.logIn(mailOrTelField, passwordField, entranceBtn);
    }

    public void forgetPasswordClick() {
        forgotPasswordLink.click();
    }

    public void resetPasswordFormIsDisplayed() {
        final List<WebElement> elements = Arrays.asList(resetPasswordTitle, emailOrPhoneAdvice, emailOrPhoneField,
                sendBtn, registerLink);
        allElementsAreVisible(elements);
    }

    public void typePhoneOrEmailOfUnregisteredUser(String emailOrPhone) {
        clearField(emailOrPhoneField);
        typeIntoField(emailOrPhone, emailOrPhoneField);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(sendBtn);
        TestContext.NonMainTestUser = 1;
    }

    public void messageIsDisplayed(String errorMessage) {
        String xPath = String.format("//span[contains(text(), '%s')]", errorMessage);
        WebElement element = wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.cssSelector(".input_container .ui-input-label-block"), By.xpath(xPath)));
        waitForAjaxElementIsVisible(element);
    }

    public void notificationIsDisplayed(String notificationMessage) {
        waitForVisibility(By.xpath("//div[contains(text(),'Письмо с дальнейшими инструкциями успешно отправлено!')]"));
        String xPath = String.format("//div[contains(text(), '%s')]", notificationMessage);
        WebElement element = wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.cssSelector(".ui-authorization-form__login"), By.xpath(xPath)));
        waitForAjaxElementIsVisible(element);
    }

    public Boolean hintIsDislayed(String hitn) {
        String xPath = String.format("//div[contains(text(), '%s')]", hitn);
        WebElement element = wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.cssSelector("div .ui-authorization-form-counter-block"), By.xpath(xPath)));
        return isElementVisible(element);
    }

    public Boolean seeBtnText(String textButton) {
        String xPath = String.format("//div[@class='ui-authorization-ui-button-container']/button[./span[contains(text(), '%s')]]", textButton);
        WebElement element = driver.findElement(By.xpath(xPath));
        TestContext.btn = element;
        return isElementVisible(element);
    }

    public void enterNewPasswordAndSave() {
        switchToTheThirdTab();
        typeIntoField(UserData.newCorrectPassword, newPasswordField);
        typeIntoField(UserData.newCorrectPassword, repeatNewPasswordField);
        savePasswordButton.click();
    }

    public void regClick() {
        click(registrationTab);
    }
}
