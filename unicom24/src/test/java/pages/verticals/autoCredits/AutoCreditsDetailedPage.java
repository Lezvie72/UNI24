package pages.verticals.autoCredits;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;
import pages.verticals.common.CommonElements;
import pages.verticals.common.CommonMethodsForAllVerticals;

import java.util.Arrays;
import java.util.List;

public class AutoCreditsDetailedPage extends Base {

    Header headerPage = new Header();
    Footer footerPage = new Footer();
    CommonElements commonElements = new CommonElements();
    CommonMethodsForAllVerticals commonMethodsForAllVerticals = new CommonMethodsForAllVerticals();

    @FindBy(xpath = "//div[contains(text(), 'Лицезния ЦБ')]")
    private WebElement licenseOfCB;

    @FindBy(xpath = "//span[contains(text(), 'Расчет кредита')]")
    private WebElement countCreditTitle;

    @FindBy(xpath = "//div[contains(text(), 'Какая сумма вам нужна')]")
    private WebElement howMuchMoneyYouNeed;

    @FindBy(xpath = "//label[./div[contains(text(), 'Какая сумма вам нужна')]]/div/input")
    private WebElement howMuchYouNeedInput;

    @FindBy(xpath = "//div[contains(text(), 'На какой срок')]")
    private WebElement howMuchTimeYouNeed;

    @FindBy(xpath = "//label[./div[contains(text(), 'На какой срок')]]/div/input")
    private WebElement howMuchTimeInput;

    @FindBy(xpath = "//div[@class='rate']/div[contains(text(), 'Ставка')]")
    private WebElement percent;

    @FindBy(xpath = "//div[contains(text(), 'Ежемесячный платеж')]")
    private WebElement paymentPerMonth;

    @FindBy(xpath = "//button[./span[contains(text(), 'Получить кредит')]]")
    private WebElement getCreditBtn;

    //@FindBy(xpath = "//a[contains(text(), 'График платежей')]") //тут отрубал
    //private WebElement schedualOfPayment;

    //@FindBy(xpath = "//a[contains(text(), 'Частным клиентам')]")
    //private WebElement privateClientsBread;

    //@FindBy(xpath = "//li/span[contains(text(), 'Автокредиты')]")
    //private WebElement privateClientsAutoBread;

    public final List<WebElement> elements;

    public AutoCreditsDetailedPage(){
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, headerPage);
        PageFactory.initElements(driver, footerPage);
        PageFactory.initElements(driver, commonElements);
        elements = Arrays.asList( // privateClientsAutoBread, privateClientsBread,
                commonElements.bankBlock, commonElements.headerOfBank, commonElements.rating,
                countCreditTitle, howMuchMoneyYouNeed,
                howMuchYouNeedInput, howMuchTimeYouNeed, howMuchTimeInput, percent, paymentPerMonth, getCreditBtn
                //, schedualOfPayment, commonElements.bet, commonElements.sum, commonElements.time, commonElements.age, commonElements.beforeApproved // тут отрубал
                );
    }

    public void pageIsDisplayed(){
        sa.assertTrue(commonMethodsForAllVerticals.licenseOfBankDisplayed());
        allElementsAreVisible(headerPage.getMainHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footerPage.getFooter());
        Header.checkBreadCrumbs(2);
    }
}
