package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;

import java.util.Arrays;
import java.util.List;

public class GiveFinancialHealthPage extends Base {
    Header headerPage = new Header();
    Footer footerPage = new Footer();

    @FindBy(xpath = "//button[./span[contains(text(), 'Узнать свой рейтинг')]]")
    private WebElement getReport;

    @FindBy(xpath = "//h1[@class='font__h1']")
    private WebElement pageTitle;

    @FindBy(xpath = "//a[contains(text(), 'Пример отчета')]")
    private WebElement reportSample;

    @FindBy(xpath = "//div[@class='report-info']")
    private WebElement reportTextInfo;

    @FindBy(xpath = "//div[@class='advantages-block']")
    private List<WebElement> reportBlocks;

    public final List<WebElement> elements;

    public GiveFinancialHealthPage() {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, headerPage);
        PageFactory.initElements(driver, footerPage);
        elements = Arrays.asList(getReport, pageTitle, reportSample, reportTextInfo);
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(headerPage.getMainHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footerPage.getFooter());
        Assert.assertEquals(3, reportBlocks.size());
    }

    public void giveFinancialHealthBTN(){
        getReport.click();
    }
}
