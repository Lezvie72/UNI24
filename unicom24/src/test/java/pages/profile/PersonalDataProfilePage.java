package pages.profile;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;
import java.util.Arrays;
import java.util.List;

public class PersonalDataProfilePage extends Base {
    Header headerPage = new Header();
    Footer footerPage = new Footer();
    CommonVerticalsForProfilePages commonVerticalsForProfilePages = new CommonVerticalsForProfilePages();

    @FindBy (xpath="//div[@class='office-profile-personal-details-title']")
    private WebElement personalDataTitle;

    @FindBy (xpath = "//div[@class='office-profile-verification-status-list-wrapper']")
    private WebElement statusVerifyProfileTitle;

    private final List<WebElement> elements;

    public PersonalDataProfilePage(){
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, commonVerticalsForProfilePages);
        elements = Arrays.asList(personalDataTitle, statusVerifyProfileTitle);
    }
    public void pageIsDisplayed(){
        allElementsAreVisible(headerPage.getMainHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footerPage.getFooter());
        commonVerticalsForProfilePages.compareNumberOfVerticalsOnPage();
    }
}
