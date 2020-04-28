package pages.verticals.refinance;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;
import pages.verticals.common.CommonElements;

import java.util.Arrays;
import java.util.List;

public class RefinanceDetailedPage extends Base {

    Header headerPage = new Header();
    Footer footerPage = new Footer();
    CommonElements commonElements = new CommonElements();

    //@FindBy(xpath = "//a[contains(text(), 'Частным клиентам')]")
    //private WebElement privateClientsBread;

    //@FindBy(xpath = "//li/span[contains(text(), 'Рефинансирование')]")
    //private WebElement privateClientsRefinanceBread;

    public final List<WebElement> elements;

    public RefinanceDetailedPage() {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, headerPage);
        PageFactory.initElements(driver, footerPage);
        PageFactory.initElements(driver, commonElements);
        elements = Arrays.asList( // privateClientsBread, privateClientsRefinanceBread,
                commonElements.bankBlock,
                commonElements.headerOfBank, commonElements.rating, commonElements.bet, commonElements.sum,
                commonElements.time, commonElements.age, commonElements.beforeApproved);
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(headerPage.getMainHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footerPage.getFooter());
        Header.checkBreadCrumbs(2);
    }
}
