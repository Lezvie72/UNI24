package pages.brokerCabinet;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.brokerCabinet.footer.FooterBrokerCabinetPage;
import pages.brokerCabinet.header.HeaderBrokerCabinetPage;

import java.util.Arrays;
import java.util.List;

public class BrokerVehicleVerificationPage extends Base {

    /*Зачем это писать?*/
    private final HeaderBrokerCabinetPage header = new HeaderBrokerCabinetPage();
    private final FooterBrokerCabinetPage footer = new FooterBrokerCabinetPage();

    @FindBy (xpath = "//h1[contains(text(), 'Проверка автомобиля')]")
    private WebElement vehicleVerificationTitle;

    @FindBy (xpath = "//div[contains(text(), 'Всего за ')]")
    private WebElement commentOfVehicleVerificationTitle;

    @FindBy (css = ".ui-auto-header_preview-img")
    private WebElement vehicleVerificationPreview;

    @FindBy (xpath = "//div[./div/span[contains(text(), 'VIN номер')]]/div/input")
    private WebElement vinInput;

    @FindBy (xpath = "//div[./div/span[contains(text(), 'Гос. номер')]]/div/input")
    private WebElement numberPlateInput;

    private final List<WebElement>elements;

    public BrokerVehicleVerificationPage() {
        PageFactory.initElements(driver, header);
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, footer);
        elements = Arrays.asList(vehicleVerificationTitle, commentOfVehicleVerificationTitle, vehicleVerificationPreview,
                vinInput, numberPlateInput);
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(elements);
        allElementsAreVisible(header.getHeader());
        allElementsAreVisible(footer.getFooter());
    }
}
