package pages.oldCabinetOfBroker;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.oldCabinetOfBroker.footer.FooterOldCabinetOfBrokerPage;
import pages.oldCabinetOfBroker.header.HeaderOldCabinetOfBrokerPage;

import java.util.Arrays;
import java.util.List;

public class OldCabinetOfBrokerPage extends Base {

    private final HeaderOldCabinetOfBrokerPage header = new HeaderOldCabinetOfBrokerPage();
    private final FooterOldCabinetOfBrokerPage footer = new FooterOldCabinetOfBrokerPage();

    @FindBy(css = ".document-status-info")
    private WebElement checkCard;

    @FindBy(css = ".side-navigation-menu")
    private WebElement leftMenu;

    @FindBy(id = "avatar-img")
    private WebElement avatar;

    @FindBy(css = ".i-personal-manager")
    private WebElement personalManagerCard;

    @FindBy(css = "a.mobile_os_banner")
    private WebElement mobileAppBlock;

    private final List<WebElement>headerOldCabinetOfBrokerPage;
    private final List<WebElement>elements;
    private final List<WebElement>footerOldCabinetOfBrokerPage;

    public OldCabinetOfBrokerPage(){
        PageFactory.initElements(driver, header);
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, footer);
        headerOldCabinetOfBrokerPage = Arrays.asList(header.logo, header.logoTitle, header.amount, header.giveMoneyBtn,
                header.onMainPageBtn, header.helpBtn, header.settingsBtn, header.exitBtn, header.callFriendsBtn);
        elements = Arrays.asList(checkCard, leftMenu, avatar, personalManagerCard, mobileAppBlock);
        footerOldCabinetOfBrokerPage = Arrays.asList(footer.blueLogo, footer.businessOfRussiaLogo, footer.ingriaLogo,
                footer.russianUnionLogo, footer.arbLogo);
    }

    public void pageIsDisplayed(){
        allElementsAreVisible(headerOldCabinetOfBrokerPage);
        allElementsAreVisible(elements);
        allElementsAreVisible(footerOldCabinetOfBrokerPage);
    }

}
