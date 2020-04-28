package pages.brokerCabinet.profile;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.brokerCabinet.footer.FooterBrokerCabinetPage;
import pages.brokerCabinet.header.HeaderBrokerCabinetPage;

import java.util.Arrays;
import java.util.List;

public class SettingsPage extends Base {

    private final HeaderBrokerCabinetPage header = new HeaderBrokerCabinetPage();
    private final FooterBrokerCabinetPage footer = new FooterBrokerCabinetPage();

    @FindBy(xpath = "//div[contains(text(), 'Оповещения по электронной почте')]")
    private WebElement settingsTitle;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(xpath = "//div[contains(text(), 'Подписка на рассылку')]")
    private WebElement subscriptionText;

    @FindBy(className = "switch")
    private WebElement switcher;

    @FindBy(xpath = "//button[./span[contains(text(), 'Сохранить')]]")
    private WebElement saveBtn;

    private final List<WebElement> elements;

    public SettingsPage() {
        PageFactory.initElements(driver, header);
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, footer);
        elements = Arrays.asList(settingsTitle, emailInput, subscriptionText, switcher, saveBtn);
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(header.getHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footer.getFooter());
    }
}
