package pages.profile;

import base.Base;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;

import java.util.Arrays;
import java.util.List;

public class ActivatePage extends Base {
    Header headerPage = new Header();
    Footer footerPage = new Footer();

    @FindBy(css = ".modal-panel")
    private WebElement congratulationsPanel;

    @FindBy(css = ".balance__wrapper")
    private WebElement balancePanel;

    @FindBy(css = ".raiting__wrapper")
    private WebElement raitingPanel;

    @FindBy (xpath = "//div[@class='ui-list-useful-services-block']")
    private List<WebElement> recommendedReports;

    public final List<WebElement> elements;

    public ActivatePage() {
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(congratulationsPanel, balancePanel, raitingPanel);
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(headerPage.getMainHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footerPage.getFooter());
        Assert.assertEquals(recommendedReports.size(), 2);
    }


}
