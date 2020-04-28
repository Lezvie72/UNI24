package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;

import java.util.Arrays;
import java.util.List;

public class ServicesPage extends Base {

    Header headerPage = new Header();
    Footer footerPage = new Footer();

    @FindBy(xpath = "//div[contains(text(), 'Полная кредитная история')]")
    private WebElement creditHistoryTitle;

    @FindBy(xpath = "//div[contains(text(), 'Рейтинг финансового здоровья')]")
    private WebElement financialHealthRatingTitle;

    @FindBy(xpath = "//div[./div[./div[./div[contains(text(), 'Полная кредитная история')]]]]/div[2]/div/div/button")
    private WebElement getFullCreditHistoryBtn;

    @FindBy(xpath = "//div[./div[./div[./div[contains(text(), 'Рейтинг финансового здоровья')]]]]/div[2]/div/div/button")
    private WebElement getFinancialHealthRatingBtn;

    public final List<WebElement> elements;

    public ServicesPage(){
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, headerPage);
        PageFactory.initElements(driver, footerPage);
        elements = Arrays.asList(creditHistoryTitle, financialHealthRatingTitle,
                getFullCreditHistoryBtn, getFinancialHealthRatingBtn);
    }

    public void pageIsDisplayed(){
        allElementsAreVisible(headerPage.getMainHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footerPage.getFooter());
    }
}
