package pages.oldCabinetOfBroker.footer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterOldCabinetOfBrokerPage {

    @FindBy(xpath = "//img[@src=\"/static/dist/common/img/partner-logos/diplomant-2013.png\"]")
    public WebElement blueLogo;

    @FindBy(xpath = "//img[@src=\"/static/img/partner_logos/bus_rus.jpg\"]")
    public WebElement businessOfRussiaLogo;

    @FindBy(xpath = "//img[@src=\"/static/img/partner_logos/technopark.png\"]")
    public WebElement ingriaLogo;

    @FindBy(xpath = "//img[@src=\"/static/img/partner_logos/RSPP.png\"]")
    public WebElement russianUnionLogo;

    @FindBy(xpath = "//img[@src=\"/static/img/partner_logos/arb_logo.png\"]")
    public WebElement arbLogo;
}
