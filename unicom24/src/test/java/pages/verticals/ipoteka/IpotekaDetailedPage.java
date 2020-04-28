package pages.verticals.ipoteka;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;
import pages.verticals.common.CommonElements;
import pages.verticals.common.CommonMethodsForAllVerticals;

import java.util.Arrays;
import java.util.List;

public class IpotekaDetailedPage extends Base {

    Header headerPage = new Header();
    Footer footerPage = new Footer();
    CommonElements commonElements = new CommonElements();
    CommonMethodsForAllVerticals commonMethodsForAllVerticals = new CommonMethodsForAllVerticals();

    @FindBy(xpath = "//div[contains(text(), 'Лицезния ЦБ')]")
    private WebElement licenseOfCB;

    @FindBy(xpath = "//div[contains(text(), 'Стоимость недвижимости')]")
    private WebElement priceOfRealty;

    @FindBy(xpath = "//label[./div[contains(text(), 'Стоимость недвижимости')]]/div/input")
    private WebElement priceOfRealtyInput;

    @FindBy(xpath = "//div[contains(text(), 'Первоначальный взнос')]")
    private WebElement firstDonation;

    @FindBy(xpath = "//label[./div[contains(text(), 'Первоначальный взнос')]]/div/input")
    private WebElement firstDonationInput;

    @FindBy(xpath = "//div[contains(text(), 'Срок ипотеки')]")
    private WebElement durationOfIpoteka;

    @FindBy(xpath = "//label[./div[contains(text(), 'Срок ипотеки')]]/div/input")
    private WebElement durationOfIpotekaInput;

    @FindBy(xpath = "//div[@class='font__base-small_grey' and contains(text(), 'Ставка')]")
    private WebElement percent;

    @FindBy(xpath = "//div[@class='font__base-small_grey' and contains(text(), 'Ежемесячный платеж')]")
    private WebElement paymentPerMonth;

    @FindBy(xpath = "//div[@class='font__base-small_grey' and contains(text(), 'Переплата')]")
    private WebElement moreThanNeed;

    @FindBy(xpath = "//div[@class='font__base-small_grey' and contains(text(), 'Общая сумма выплат')]")
    private WebElement commonSum;

    @FindBy(xpath = "//button[./span[contains(text(), 'Получить ипотеку')]]")
    private WebElement getIpotekaBtn;

    @FindBy(xpath = "//a[contains(text(), 'График платежей')]")
    private WebElement schedualOfPayment;

    //@FindBy(xpath = "//a[contains(text(), 'Частным клиентам')]")
    //private WebElement privateClientsBread;

    //@FindBy(xpath = "//li/span[contains(text(), 'Ипотека')]")
    //private WebElement privateClientsIpotekaBread;

    public final List<WebElement> elements;

    public IpotekaDetailedPage(){
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, headerPage);
        PageFactory.initElements(driver, footerPage);
        PageFactory.initElements(driver, commonElements);
        elements = Arrays.asList( //privateClientsBread, privateClientsIpotekaBread ,
                commonElements.bankBlock, commonElements.headerOfBank, commonElements.rating,
                priceOfRealty, priceOfRealtyInput, firstDonation, firstDonationInput, durationOfIpoteka,
                durationOfIpotekaInput, percent, paymentPerMonth, commonSum, getIpotekaBtn, schedualOfPayment,
                moreThanNeed, commonElements.bet, commonElements.sum,
                commonElements.time, commonElements.age, commonElements.beforeApproved);
    }

    public void pageIsDisplayed(){
        sa.assertTrue(commonMethodsForAllVerticals.licenseOfBankDisplayed(), "Лицензия банка");
        allElementsAreVisible(elements);
        allElementsAreVisible(headerPage.getMainHeader());
        allElementsAreVisible(footerPage.getFooter());
        Header.checkBreadCrumbs(2);
    }
}
