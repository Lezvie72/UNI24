package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;
import pagesUrls.PagesUrls;

public class MFOPage extends Base {
    private final Header header = new Header();
    private final Footer footer = new Footer();

    @FindBy(xpath = "//h1[contains(text(), 'Микрофинансовые организации (МФО)')]")
    private WebElement titlePage;

    public MFOPage() {
        PageFactory.initElements(driver, this);
    }

    public void pageIsDisplayed() {
        waitForUrlContains(PagesUrls.mfoPage());
        allElementsAreVisible(header.getMainHeader());
        waitForVisibility(titlePage);
        allElementsAreVisible(footer.getFooter());
    }

}
