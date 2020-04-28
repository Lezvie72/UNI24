package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pagesUrls.PagesUrls;

import java.util.Arrays;
import java.util.List;

public class WebMasterRegistrationPage extends Base {

    @FindBy(xpath = "//a[contains(text(), 'Вход')]")
    private WebElement entanceTab;

    @FindBy(name = "company")
    private WebElement companyNameField;

    @FindBy(name = "phone")
    private WebElement partnerPhoneField;

    @FindBy(name = "surname")
    private WebElement lastNameField;

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(name = "name")
    private WebElement nameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='inner']")
    private WebElement messangerOptions;

    @FindBy(name = "passwordRepeat")
    private WebElement repeatPassword;

    @FindBy(xpath = "//button[contains(text(),'Зарегистрироваться')]")
    private WebElement registerBtn;

    private final List<WebElement> elements;

    public WebMasterRegistrationPage() {
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(entanceTab, companyNameField, partnerPhoneField, lastNameField, emailField,
                nameField, passwordField, messangerOptions, repeatPassword, registerBtn);
    }

    public void pageIsDisplayed() {
        waitForPageLoaded(PagesUrls.webMasterRegistrationPage());
        allElementsAreVisible(elements);
    }

    public void entranceTabClick() {
        entanceTab.click();
    }
}
