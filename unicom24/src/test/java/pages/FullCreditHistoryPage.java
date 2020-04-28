package pages;

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

public class FullCreditHistoryPage extends Base {

    Header headerPage = new Header();
    Footer footerPage = new Footer();

    String dateValue;
    long dateIntValue;

    @FindBy(css = ".row .ui-credit-report-header__price-round")
    private WebElement prive;

    @FindBy(xpath = "//button[./span[contains(text(), 'Получить отчет')]]")
    private WebElement getReport;

    @FindBy(xpath = "//h1[contains(text(), 'Полная кредитная история')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[contains(text(), 'История запросов на кредитный отчет')]")
    private WebElement historyTitle;

    @FindBy(css = ".ui-form-requests-history-credit_report__data-wrapper")
    private WebElement history;

    @FindBy(css = ".ui-report-default-content-block .ui-main-loader__container ")
    private WebElement reportImg;

    @FindBy(css = "a .ui-btn.font__base.yellow")
    private WebElement downLoadReportBtn;

    @FindBy(xpath = "//span[contains(text(), 'Новый запрос')]")
    private WebElement newReportCreate;

    public final List<WebElement> elements;
    public final List<WebElement> elementsHistory;

    public FullCreditHistoryPage() {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, headerPage);
        PageFactory.initElements(driver, footerPage);
        elements = Arrays.asList(getReport, pageTitle);
        elementsHistory = Arrays.asList(historyTitle, history);
    }

    public void pageIsDisplayed(){
        allElementsAreVisible(headerPage.getMainHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footerPage.getFooter());
    }

    public void getReportClick(){
        getReport.click();
    }

    public void seeReportResult() {
        waitUntilElementRemove(By.xpath("//button[./span[contains(text(), 'Получить отчет')]]"));
        waitForVisibility(historyTitle);
        waitForTextChanged(dateValue,  By.cssSelector(".ui-form-requests-history-credit_report__data-item-date"));
        String date = driver.findElement(By.cssSelector(".ui-form-requests-history-credit_report__data-item-date")).getText();
        String dateValue = date.replaceAll("\\D+","");
        Assert.assertTrue(dateIntValue < Long.parseLong(dateValue));
    }

    public void historyElementsAreDisplayed(){
        allElementsAreVisible(elementsHistory);
    }

    public void downloadReport(){
        downLoadReportBtn.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
