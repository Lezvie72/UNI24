package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;
import pagesUrls.PagesUrls;

import java.util.Arrays;
import java.util.List;

public class BecomePartnerPage extends Base {

    private Header headerPage = new Header();
    private Footer footerPage = new Footer();

    @FindBy(css = ".container .become-partner-top")
    private WebElement bannerPage;

    @FindBy(css = ".for-block.become-partner-for-web")
    private WebElement leftSideOfPage;

    @FindBy(css = ".become-partner-for-web .for-footer__button")
    private WebElement leftSidePageBtn;

    @FindBy(css = ".for-block.become-partner-for-advertiser")
    private WebElement rightSideOfPage;

    @FindBy(css = ".for-block.become-partner-for-advertiser .for-footer__button")
    private WebElement rightSideOfPageBtn;

    @FindBy(xpath = "//div[@class='contacts__wrapper'][./div[contains(text(), 'Служба поддержки:')]]")
    private WebElement supportBlock;

    @FindBy(css = ".font__base .about__wrapper")
    private WebElement aboutText;

    @FindBy(css = ".font__base .become-partner-partners")
    private WebElement ourPartnersBlock;

    @FindBy(css = ".container .footer-contact__wrapper")
    private WebElement supportEmailBlock;

    private final List<WebElement> elements;

    public BecomePartnerPage() {
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(bannerPage, leftSideOfPage, leftSidePageBtn, rightSideOfPage, rightSideOfPageBtn,
                supportBlock, aboutText, ourPartnersBlock, supportEmailBlock);
    }

    public void onBecomePartnerPage(){
        driver.get(PagesUrls.becomePartnerPage());
    }

    public void pageIsDisplayed(){
        allElementsAreVisible(headerPage.getMainHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footerPage.getFooter());
    }

    public void getMoneyNowClick(){
        scrollTo(leftSidePageBtn);
        waitForVisibility(leftSidePageBtn);
        waitToBeClickable(leftSideOfPage);
        leftSidePageBtn.click();
        switchToTheSecondTab();
    }

    public void clickApplications(){
        rightSideOfPageBtn.click();
        switchToTheSecondTab();
    }
}
