package pages;

import base.Base;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;
import pagesUrls.PagesUrls;

import java.util.Arrays;
import java.util.List;

public class AboutFullCreditHistoryPage extends Base {

    private Header headerPage = new Header();
    private Footer footerPage = new Footer();

    //Заголовок и кнопка
    @FindBy(className = "about")
    private WebElement topBlock;

    @FindBy(xpath = "//button[./span[contains(text(), 'Получить историю')]]")
    private WebElement getHistoryPageBtn;

    @FindBy(css = ".report-photo img")
    private WebElement reportImg;

    @FindBy(className = "report-info-list")
    private WebElement reportList;

    //5 инфоблоков
    @FindBy(className = "report-additional-item__item")
    private List<WebElement>infoItems;

    private final List<WebElement>elements;

    public AboutFullCreditHistoryPage() {
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(topBlock, getHistoryPageBtn, reportImg, reportList);
    }

    public void onPage() {
        driver.get(PagesUrls.aboutFullCreditHistoryPage());
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(elements);
        Assert.assertEquals(5, infoItems.size());
    }

    public void getHistoryPageBtnClick() {
        getHistoryPageBtn.click();
    }
}
