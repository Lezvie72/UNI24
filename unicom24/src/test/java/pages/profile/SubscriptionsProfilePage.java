package pages.profile;

import base.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;

import java.util.Arrays;
import java.util.List;

public class SubscriptionsProfilePage extends Base {
    String tariffTabsSubPage = ".office-subscriptions-tabs-header-item-title-text";

    Header headerPage = new Header();
    Footer footerPage = new Footer();
    CommonVerticalsForProfilePages commonVerticalsForProfilePages = new CommonVerticalsForProfilePages();

    @FindBy(css =".office-subscriptions-price-count")
    private WebElement tariffCountSubPage;

    @FindBy(xpath = "//div[@class='office-container']")
    private WebElement containerPage;

    private final List<WebElement> elements;

    public SubscriptionsProfilePage(){
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, commonVerticalsForProfilePages);
        elements = Arrays.asList(tariffCountSubPage, containerPage);
    }
    public void pageIsDisplayed() {
        allElementsAreVisible(headerPage.getMainHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footerPage.getFooter());
        commonVerticalsForProfilePages.compareNumberOfVerticalsOnPage();
        int tariffTabsOnPage = driver.findElements(By.cssSelector(tariffTabsSubPage)).size();
        Assert.assertTrue(tariffTabsOnPage>=2);
    }

}
