package pages.profile;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;
import java.util.Arrays;
import java.util.List;

public class ProfilePage extends Base {
    Header headerPage = new Header();
    Footer footerPage = new Footer();
    CommonVerticalsForProfilePages commonVerticalsForProfilePages = new CommonVerticalsForProfilePages();

    @FindBy (xpath="//div[@class='rating-scale-container']/div[contains(text(), 'Рейтинг FICO')]")
    private WebElement titlePicRatingFICO;

    @FindBy (xpath="//div[@class='rating-scale-container']/div[contains(text(), 'Рейтинг Юником24')]")
    private WebElement titlePicRatingUnicom24;

    private final List<WebElement> elements;

    public ProfilePage(){
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, commonVerticalsForProfilePages);
        elements = Arrays.asList(titlePicRatingFICO, titlePicRatingUnicom24);
    }
    public void pageIsDisplayed(){
        allElementsAreVisible(headerPage.getMainHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footerPage.getFooter());
        allElementsAreVisible(commonVerticalsForProfilePages.getProfileHeader());
        commonVerticalsForProfilePages.compareNumberOfVerticalsOnPage();
    }

    public void profileUserBalanceClick(){
        commonVerticalsForProfilePages.balanceValueProfile.click();
    }

}
