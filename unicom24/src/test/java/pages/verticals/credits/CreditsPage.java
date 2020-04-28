package pages.verticals.credits;

import pages.mock.SmsCatcher;
import testContext.TestContext;
import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.adminka.AdminkaRedirects;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;
import pages.commonElementsForAllPages.UserData;
import pages.verticals.common.CommonElementsForAllVerticals;
import org.junit.Assert;
import pagesUrls.PagesUrls;

import java.util.Arrays;
import java.util.List;

public class CreditsPage extends Base {

    Header headerPage = new Header();
    Footer footerPage = new Footer();
    CommonElementsForAllVerticals common = new CommonElementsForAllVerticals();
    AdminkaRedirects adminkaRedirects = new AdminkaRedirects();
    SmsCatcher smsCatcher = new SmsCatcher();

    @FindBy(xpath = "//div[@class='offers-list-new']")
    private WebElement getCreditList;

    @FindBy(css = ".form-offers-small .form-one")
    private WebElement formOffer;

    @FindBy(xpath = "//div[@class='clear_wrapper']/i[contains(text(), 'close')]")
    private WebElement closeModalBtn;

    @FindBy(xpath = "//div/form/button['.colum__close-button--enpop']")
    private WebElement closeFooterModalBtn;

    @FindBy(xpath = "//button[@class='filters-btns__btn filters-btns__reset default medium']")
    private WebElement btnResetToDefault; // Кнопка Сбросить в боди страницы

    @FindBy(xpath = "//div[@class='title']")
    private WebElement bankName;

    @FindBy(xpath = "//button[contains(text(), 'Подобрать')]")
    private WebElement podobratCredit;

    @FindBy(xpath = "//button[contains(text(), 'Далее')]")
    private WebElement podborCreditNext;

    @FindBy(xpath = "//form[@class='form-offers-step-two']")
    private WebElement podborCreditStep2;

    @FindBy(xpath = "//form[@class='form-confirm']")
    private WebElement podobrCreditFormSmsConfirm;

    @FindBy(xpath = "//button[contains(text(), 'Показать предложения')]")
    private WebElement podborCreditResultsDisplayed;

    @FindBy(xpath = "//div[@class='ui-input-new']/input")
    private WebElement podborCreditInputFon;

    @FindBy(xpath = "//form[@class='form-confirm']")
    private WebElement podborCreditFormForSMSCode;

    @FindBy(xpath = "//label[./div[contains(text(), 'Код из СМС')]]//input")
    private WebElement podborCreditInputForSMSCode;

    @FindBy(xpath = "//label[./div[contains(text(),'Фамилия')]]//input")
    private WebElement podborCreditInputSurName;

    @FindBy(xpath = "//label[./div[contains(text(),'Имя')]]//input")
    private WebElement podborCreditInputName;

    @FindBy(xpath = "//label[./div[contains(text(),'Отчество')]]//input")
    private WebElement podborCreditInputSecondName;

    @FindBy(xpath = "//label[./div[contains(text(),'Дата рождения')]]//input")
    private WebElement podborCreditInputBirthDay;

    @FindBy(xpath = "//label[./div[contains(text(),'Серия и номер')]]//input")
    private WebElement podborCreditInputPassportNumber;

    @FindBy(xpath = "//label[./div[contains(text(),'Дата выдачи')]]//input")
    private WebElement podborCreditInputPassportDate;

    @FindBy(xpath = "//div[@class='ui-selection-step']")
    private WebElement podborLoading;

    @FindBy(xpath = "//div[@class='col-12']/h2")
    private List<WebElement> h2SeoElements;

    public final List<WebElement> elements;

    public CreditsPage() {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, headerPage);
        PageFactory.initElements(driver, footerPage);
        PageFactory.initElements(driver, common);
        PageFactory.initElements(driver, adminkaRedirects);
        elements = Arrays.asList(getCreditList, formOffer, common.title, btnResetToDefault
        );
    }

    public void onCreditsPage() {
        driver.get(PagesUrls.privateCreditsPageUrl());
        TestContext.checkRedirectUrl = PagesUrls.privateCreditsPageUrl();
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(headerPage.getMainHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footerPage.getFooter());
        Header.checkBreadCrumbs(2);
        Assert.assertEquals(common.countOffersOnPage.size(), common.btnBankCreditAddToCompare.size());
    }

    public Boolean offersOnPageMore0() {
        return driver.findElements(By.xpath("//div[@class='offer-item-new wrapper']")).size() > 0;
    }

    public void titleOfBankClick() {
        bankName.click();
    }

    public Boolean checkRedirects() {
        List<WebElement> elements = driver.findElements(By.xpath("//button[./span[contains(text(), 'Онлайн заявка')]]"));
        for (int i = 0; i < elements.size(); i++) {
            if (isElementVisible(closeModalBtn)) {
                closeModalBtn.click();
            }
            if (isElementVisible(closeFooterModalBtn)) {
                closeFooterModalBtn.click();
            }
            scrollTo(elements.get(i));
            waitForVisibility(elements.get(i));
            if (i == 0) {
                System.out.println(driver.findElement(By.xpath("(//div[@class='title']/span)")).getText());
            } else {
                int k = i + 1;
                System.out.println(driver.findElement(By.xpath("(//div[@class='title']/span)[" + k + "]")).getText());
            }
            getIdOfOffer(elements.get(i));
            elements.get(i).click();
            switchToTheSecondTab();
            for (int j = 0; j < 10; j++) {
                if (driver.getCurrentUrl().contains(PagesUrls.mainPage)) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (driver.getCurrentUrl().contains(PagesUrls.mainPage))
                return false;
            closeTab();
            switchToTheFirstTab();
        }
        return true;
    }

    private void getIdOfOffer(WebElement element) {
        adminkaRedirects.offerId = element.getAttribute("id");
        adminkaRedirects.offerId = adminkaRedirects.offerId.replaceAll("[^0-9]", "");
    }

    public void banksForAddToCompareCreditsClick(String numberOfBanksForAddToCompare) {
        int CountBanks = Integer.parseInt(numberOfBanksForAddToCompare);
        if (CountBanks > common.countOffersOnPage.size()) {
            CountBanks = common.countOffersOnPage.size();}
        for (int i = 0; i < CountBanks; i++)
            common.btnBankCreditAddToCompare.get(i).click();
    }

    public Boolean checkH2SeoElements(){
        return h2SeoElements.size() == 7;
    }

    public void podobratCreditClick(){
        podobratCredit.click();
    }

    public void podobrCreditFormSmsConfirmIsDisplayed(){
        waitForAjaxElementIsVisible(podobrCreditFormSmsConfirm);
    }

    public void podborCreditFormStep2IsDisplayed(){
        waitForAjaxElementIsVisible(podborCreditStep2);
    }

    public void podborCreditNextClick(){
        podborCreditNext.click();
    }

    public void podborCreditFormStep3IsDisplayed(){
        waitForAjaxElementIsVisible(podborCreditResultsDisplayed);
    }

    public void podborCreditResultsDisplayedClick(){
        podborCreditResultsDisplayed.click();
    }

    public void podborCreditInputFonField() {
        podborCreditInputFon.clear();
        typeIntoField(UserData.correctPhoneNumber, podborCreditInputFon);

    }

    public void podborCreditFormForSMSCodeIsDisplayed(){
        waitForAjaxElementIsVisible(podborCreditFormForSMSCode);
    }

    public void InputSMSCodeForPodborCredit() {
        smsCatcher.getPasswordSMSFromServer(SmsCatcher.smsServerLink().get("smsServer"));
//        for (int i = 0; i < 4; i++) {
//            if (TestContext.passwordFromSms == null) {
//                    getPasswordSMSFromServer(SmsCatcher.smsServerLink().get("smsServer"));
//            } else break;
//        }
//        убрать этот блок примерно в мае, если не пригодится
        driver.close();
        switchToTheFirstTab();
        clearField(podborCreditInputForSMSCode);
        //typeIntoField(TestContext.passwordFromSms, passwordField); иногда теряет 1 символ
        // Повторение не ведомой хрени, заставляем селениум писать в поле ящик до тех пор пока не напишет правильно
        while (!podborCreditInputForSMSCode.getAttribute("value").equals(TestContext.passwordFromSms)) {
            clearField(podborCreditInputForSMSCode);
            typeIntoField(TestContext.passwordFromSms, podborCreditInputForSMSCode);
        }
        podborCreditNextClick();
        //waitForUrlContains(PagesUrls.baseUrl() + "/");
    }

    public void nonUserPodborCreditTypeTextStep2(){
        typeIntoField(UserData.names, podborCreditInputName);
        typeIntoField(UserData.names, podborCreditInputSurName);
        typeIntoField(UserData.names, podborCreditInputSecondName);
    }

    public void nonUserPodborCreditInputTextStep3(){
        typeIntoField(UserData.birthDay, podborCreditInputBirthDay);
        typeIntoField(UserData.passportNumber, podborCreditInputPassportNumber);
        typeIntoField(UserData.dateOfPasport, podborCreditInputPassportDate);
    }

    public void userWaitingResultsPodborCredits(){
        waitForAjaxElementIsVisible(podborLoading);
    }
}
