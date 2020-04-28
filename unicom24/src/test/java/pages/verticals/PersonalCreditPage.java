package pages.verticals;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;

import java.util.Arrays;
import java.util.List;

public class PersonalCreditPage extends Base {
    Header headerPage = new Header();
    Footer footerPage = new Footer();

    /*Заголовок*/
    @FindBy(css = "h1")
    private WebElement mainTitle;

    /*Надпись под заголовком*/
    @FindBy(css = "div.form-offers-top__detail")
    private WebElement detailsOfMainTitle;

    @FindBy(css = "div.form-offers-small-step-one form")
    private WebElement personalCreditForm;

    /*Селекторы формы*/
    @FindBy(css = "form h2")
    private WebElement formTitle;

    @FindBy(css = "form p")
    private WebElement detailsOfFormTitle;

    @FindBy(xpath = "//label[./div[contains(text(), 'Фамилия')]]//input")
    private WebElement surnameInput;

    @FindBy(xpath = "//label[./div[contains(text(), 'Имя')]]//input")
    private WebElement lastNameInput;

    @FindBy(xpath = "//label[./div[contains(text(), 'Отчество')]]//input")
    private WebElement patronymicNameInput;

    @FindBy(xpath = "//label[./div[contains(text(), 'Дата рождения')]]//input")
    private WebElement birthDateInput;

    @FindBy(xpath = "//label[./div[contains(text(), 'Серия и номер паспорта')]]//input")
    private WebElement passportNumberInput;

    @FindBy(xpath = "//label[./div[contains(text(), 'Дата выдачи паспорта')]]//input")
    private WebElement passportIssueDateInput;

    @FindBy(xpath = "//label[./div[contains(text(), 'Мобильный телефон')]]//input")
    private WebElement phoneInput;

    @FindBy(css = "form button")
    private WebElement formButton;
    /*Форма окончена*/

    private List<WebElement> elements;

    public PersonalCreditPage() {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, headerPage);
        PageFactory.initElements(driver, footerPage);

        elements = Arrays.asList(mainTitle, detailsOfMainTitle, personalCreditForm, formTitle, detailsOfFormTitle, surnameInput,
                lastNameInput, patronymicNameInput, birthDateInput, passportNumberInput, passportIssueDateInput, phoneInput, formButton);
    }

    public void pageIsDisplayed() {
       waitForAllAjaxElementIsVisible(elements);
    }

}
