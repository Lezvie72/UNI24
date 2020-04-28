package pages.brokerCabinet.profile;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.brokerCabinet.footer.FooterBrokerCabinetPage;
import pages.brokerCabinet.header.HeaderBrokerCabinetPage;

import java.util.Arrays;
import java.util.List;

public class ProfilePage extends Base {

    private final HeaderBrokerCabinetPage header = new HeaderBrokerCabinetPage();
    private final FooterBrokerCabinetPage footer = new FooterBrokerCabinetPage();

    @FindBy(xpath = "//div[contains(@class, 'font__h1') and contains(text(), 'Глушкова Елизавета')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[contains(text(), 'Личные данные')]")
    private WebElement privateDataTitle;

    @FindBy(name = "lastName")
    private WebElement lastNameInput;

    @FindBy(name = "firstName")
    private WebElement firstNameInput;

    @FindBy(name = "middleName")
    private WebElement middleNameInput;

    @FindBy(name = "birthday")
    private WebElement birthdayInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "phone")
    private WebElement phoneInput;

    @FindBy(name = "oldPassword")
    private WebElement oldPasswordInput;

    @FindBy(name = "newPassword1")
    private WebElement newPassword1Input;

    @FindBy(name = "newPassword2")
    private WebElement newPassword2Input;

    @FindBy(xpath = "//button[./span[contains(text(), 'Сменить пароль')]]")
    private WebElement changePasswordBtn;

    private final List<WebElement> elements;

    public ProfilePage() {
        PageFactory.initElements(driver, header);
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, footer);
        elements = Arrays.asList(pageTitle, privateDataTitle, lastNameInput, firstNameInput, middleNameInput,
                birthdayInput, emailInput, phoneInput, oldPasswordInput, newPassword1Input, newPassword2Input,
                changePasswordBtn);
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(header.getHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footer.getFooter());
    }

    public void clickTab(String tab) {
        String xPath = String.format("//a[contains(text(), '%s')]", tab);
        WebElement element = driver.findElement(By.xpath(xPath));
        waitForVisibility(element);
        element.click();
    }
}
