package pages.brokerCabinet.profile;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.brokerCabinet.footer.FooterBrokerCabinetPage;
import pages.brokerCabinet.header.HeaderBrokerCabinetPage;

import java.util.Arrays;
import java.util.List;

public class CountPage extends Base {

    private final HeaderBrokerCabinetPage header = new HeaderBrokerCabinetPage();
    private final FooterBrokerCabinetPage footer = new FooterBrokerCabinetPage();

    @FindBy(xpath = "//div[./div[contains(text(), 'Счет №')]]/div/div[contains(text(), 'На счете')]")
    private WebElement countPanel;

    @FindBy(xpath = "//div[@class='balance-btn']/button[./span[contains(text(), 'Пополнить счет')]]")
    private WebElement addMoneyBtn;

    @FindBy(xpath = "//div[./div[contains(text(), 'Период')]]/div[contains(text(), 'За все время')]")
    private WebElement allTimeInput;

    @FindBy(xpath = "//div[contains(@class, 'ui-input-new-datepicker')]/div[@class='vdp-datepicker'][1]")
    private WebElement dateFromInput;

    @FindBy(xpath = "//div[contains(@class, 'ui-input-new-datepicker')]/div[@class='vdp-datepicker'][2]")
    private WebElement dateToInput;

    @FindBy(xpath = "//button[./span[contains(text(), 'Скачать')]]")
    private WebElement downLoadBtn;

    @FindBy(xpath = "//button[./span[contains(text(), 'Показать')]]")
    private WebElement showBtn;

    private final List<WebElement> elements;

    public CountPage() {
        PageFactory.initElements(driver, header);
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, footer);
        elements = Arrays.asList(countPanel, addMoneyBtn, allTimeInput, dateFromInput, dateToInput, downLoadBtn, showBtn);
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(header.getHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footer.getFooter());
    }
}
