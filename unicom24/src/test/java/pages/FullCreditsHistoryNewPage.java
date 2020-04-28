package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;

import java.util.Arrays;
import java.util.List;

public class FullCreditsHistoryNewPage extends Base {
    Header headerPage = new Header();
    Footer footerPage = new Footer();

    @FindBy(css = ".row .ui-credit-report-header__price-round")
    private WebElement prive;

    @FindBy(css = ".ui-credit-report-header__price-money")
    private WebElement priceCost;

    @FindBy(css = ".ui-credit-report-application")
    private WebElement creditReportApplication;
    //@FindBy(xpath = "//div[contains(text(), 'История запросов на кредитный отчет')]")
    //private WebElement historyTitle;

    //@FindBy(css = ".ui-credit-report-history-credit .ui-form-requests-history-credit_report__data-wrapper")
    //private WebElement history;

    @FindBy(xpath = "//button[@class='btn-middle-with-border ui-btn font__base yellow']")
    private WebElement downloadBlankBtn;


    public final List<WebElement> elements;

    public FullCreditsHistoryNewPage() {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, headerPage);
        PageFactory.initElements(driver, footerPage);
        elements = Arrays.asList(/*historyTitle, history*/ priceCost, creditReportApplication);
    }

    public void pageIsDisplayed(){
        allElementsAreVisible(headerPage.getMainHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footerPage.getFooter());
    }

    public void DownloadBlankBtnClick(){
        downloadBlankBtn.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
