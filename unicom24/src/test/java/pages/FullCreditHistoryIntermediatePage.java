package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;

import java.util.Arrays;
import java.util.List;

public class FullCreditHistoryIntermediatePage extends Base {
    Header headerPage = new Header();
    Footer footerPage = new Footer();

    @FindBy(xpath = "//button[./span[contains(text(), 'Получить историю')]]")
    private WebElement giveHistoryBTN;

    @FindBy(xpath = "//span[@class='about-report-block-text-count']")
    private WebElement giveHistoryPrice;

    @FindBy(xpath = "//img[@class='report-photo__img']")
    private WebElement reportHistoryImg;

    @FindBy(xpath = "//div[@class='font__h1 about-title']")
    private WebElement giveHistoryTitle;

    @FindBy(xpath = "//div[@class='font__h4 about-info']")
    private WebElement giveHistoryText;

    @FindBy(xpath = "//div[@class='report-info']")
    private WebElement reportText;

    @FindBy(xpath = "//div[@class='report-additional-items']")
    private WebElement reportAdditional;

    @FindBy(xpath = "//a[contains(text(), 'Пример отчета')]")
    private WebElement reportSample;

    public final List<WebElement> elements;

    public FullCreditHistoryIntermediatePage() {
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(giveHistoryBTN, giveHistoryPrice, reportHistoryImg, giveHistoryTitle, giveHistoryText, reportText, reportAdditional, reportSample);
    }

    public void pageIsDisplayed(){
        allElementsAreVisible(headerPage.getMainHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footerPage.getFooter());
    }

    public void giveHistoryBTNClick(){
        giveHistoryBTN.click();
    }

}
