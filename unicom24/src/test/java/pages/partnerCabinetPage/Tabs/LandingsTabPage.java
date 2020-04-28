package pages.partnerCabinetPage.Tabs;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.partnerCabinetPage.Header.HeaderPartnerCabinetPage;

import java.util.Arrays;
import java.util.List;

public class LandingsTabPage extends Base {

    private final HeaderPartnerCabinetPage header = new HeaderPartnerCabinetPage();

    @FindBy(xpath = "//div[contains(text(), 'Лендинги')]")
    private WebElement landingsTitle;

    @FindBy(xpath = "//div[./div[contains(text(), 'Динамический лендинг')]]//button[contains(text(), 'Подключение')]")
    private WebElement dynamicLandingConnectTab;

    @FindBy(xpath = "//div[./div[contains(text(), 'Динамический лендинг')]]//button[contains(text(), 'Описание')]")
    private WebElement dynamicLandingDescriptionTab;

    @FindBy(xpath = "//div[./div[contains(text(), 'Динамический лендинг')]]//button[contains(text(), 'Настройка')]")
    private WebElement dynamicLandingSettingsTab;

    @FindBy(xpath = "//div[./div[contains(text(), 'Рейтинг Финансового Здоровья')]]//button[contains(text(), 'Подключение')]")
    private WebElement rfzConnectTab;

    @FindBy(xpath = "//div[./div[contains(text(), 'Рейтинг Финансового Здоровья')]]//button[contains(text(), 'Описание')]")
    private WebElement rfzDescriptionTab;

    @FindBy(xpath = "//div[./div[contains(text(), 'mfi_iframe_v101')]]//button[contains(text(), 'Подключение')]")
    private WebElement mfiConnectTab;

    @FindBy(xpath = "//div[./div[contains(text(), 'mfi_iframe_v101')]]//button[contains(text(), 'Описание')]")
    private WebElement mfiDescriptionTab;

    private final List<WebElement> elements;

    public LandingsTabPage() {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, header);
        elements = Arrays.asList(landingsTitle, dynamicLandingConnectTab, dynamicLandingDescriptionTab,
                dynamicLandingSettingsTab, rfzConnectTab, rfzDescriptionTab, mfiConnectTab, mfiDescriptionTab);
    }

    public void pageIsDisplayed() {
        header.headerIsDisplayed();
        allElementsAreVisible(elements);
    }
}
