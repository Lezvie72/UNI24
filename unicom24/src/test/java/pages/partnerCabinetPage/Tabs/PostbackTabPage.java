package pages.partnerCabinetPage.Tabs;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.partnerCabinetPage.Header.HeaderPartnerCabinetPage;
import pages.partnerCabinetPage.RequestBinPage;

import java.util.Arrays;
import java.util.List;

public class PostbackTabPage extends Base {

    private final HeaderPartnerCabinetPage header = new HeaderPartnerCabinetPage();
    private final RequestBinPage requestBinPage = new RequestBinPage();

    /*
     * Тестовые данные
     */
    private String offerId = "OfferIdTest";
    private String offerName = "OfferNameTest";
    private String clickId = "ClickIdTest";

    private String offerIdValue = "22547";
    private String offerNameValue = "TestName";
    private String clickIdValue = "888";
    /*
     * Тестовые данные окончены
     */

    @FindBy(xpath = "//div[contains(text(), 'Постбек')]")
    private WebElement postBackTitle;

    @FindBy(xpath = "//div[@class='table-wrap']")
    private WebElement postbackTable;

    @FindBy(xpath = "//div[contains(text(), 'У вас пока нет ни одной записи')]")
    private WebElement youDontHavePostbackTitle;

    @FindBy(xpath = "//button[contains(text(), 'Создать')]")
    private WebElement createPostBackBtn;

    @FindBy(xpath = "//div[@class='form']")
    private WebElement uiPostBackForm;

    @FindBy(xpath = "//div[./div[contains(text(), 'Название')]]//input")
    private WebElement nameOfPostbackInput;

    @FindBy(xpath = "//button[contains(text(), 'POST')]")
    private WebElement typePostBtn;

    @FindBy(xpath = "//button[contains(text(), 'GET')]")
    private WebElement typeGetBtn;

    @FindBy(xpath = "//label[contains(text(), 'В работе')]")
    private WebElement inProgressCheck;

    @FindBy(xpath = "//label[contains(text(), 'Подтвержден')]")
    private WebElement approvedCheck;

    @FindBy(xpath = "//label[contains(text(), 'Отклонен')]")
    private WebElement deniedCheck;

    @FindBy(xpath = "//label[contains(text(), 'Выдача')]")
    private WebElement extraditionCheck;

    @FindBy(xpath = "//label[contains(text(), 'Заявка')]")
    private WebElement issueCheck;

    @FindBy(xpath = "//label[contains(text(), 'Одобрение')]")
    private WebElement approvalCheck;

    @FindBy(xpath = "//label[contains(text(), 'Повторная выдача')]")
    private WebElement secondExtradition;

    @FindBy(xpath = "//div[./div[contains(text(), 'Базовая ссылка')]]//input")
    private WebElement baseUrlInput;

    //@FindBy(id = "offer_id")
    @FindBy(xpath = "//div[@class=\'row params\'][1]//div[@class=\'ds-input-default-wrap\'][1]//input")
    private WebElement offerIdNameOfParametrInput;

    //@FindBy(id = "{offer_id}")
    @FindBy(xpath = "//div[@class=\'row params\'][1]//div[@class=\'ds-input-default-wrap\'][2]//input")
    private WebElement offerIdValueOfParametrInput;

    //@FindBy(id = "offer_name")
    @FindBy(xpath = "//div[@class=\'row params\'][2]//div[@class=\'ds-input-default-wrap\'][1]//input")
    private WebElement offerNameNameOfParametrInput;

    //@FindBy(id = "{offer_name}")
    @FindBy(xpath = "//div[@class=\'row params\'][2]//div[@class=\'ds-input-default-wrap\'][2]//input")
    private WebElement offerNameValueOfParametrInput;

    //@FindBy(id = "click_id")
    @FindBy(xpath = "//div[@class=\'row params\'][3]//div[@class=\'ds-input-default-wrap\'][1]//input")
    private WebElement clickIdNameOfParametrInput;

    //@FindBy(id = "{click_id}")
    @FindBy(xpath = "//div[@class=\'row params\'][3]//div[@class=\'ds-input-default-wrap\'][2]//input")
    private WebElement clickIdValueOfParametrInput;

    @FindBy(xpath = "//div[@class='fake']/div[@class='value']")
    private WebElement mainTextArea;

    @FindBy(xpath = "//button[contains(text(), 'Протестировать')]")
    private WebElement checkBtn;

    @FindBy(xpath = "//button[contains(text(), 'Сохранить')]")
    private WebElement saveBtn;

    @FindBy(xpath = "//div[contains(text(), 'filter_none')]")
    private WebElement copyBtn;

    ////// окно после тестирования постбэка начало
    @FindBy(xpath = "//div[@class='ds-modal-inner']")
    private WebElement formAfterTestPostBack;

    @FindBy(xpath = "//div[@class='ds-modal-inner']//div[@class='close']")
    private WebElement closeFormAfterTestPostBack;
    /// окно после тестирования постбэка конец

    @FindBy(xpath = "//div[@class='row font__base-small']")
    private List<WebElement> listPostBacks;

    private final List<WebElement> elements;

    public PostbackTabPage() {
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(postBackTitle, createPostBackBtn, uiPostBackForm, nameOfPostbackInput,
                typePostBtn, typeGetBtn, inProgressCheck, approvedCheck, deniedCheck, extraditionCheck, issueCheck,
                approvalCheck, secondExtradition, baseUrlInput, offerIdNameOfParametrInput,
                offerIdValueOfParametrInput, offerNameNameOfParametrInput, offerNameValueOfParametrInput,
                clickIdNameOfParametrInput, clickIdValueOfParametrInput, mainTextArea, copyBtn);
    }

    public void pageIsDisplayed() {
        header.headerIsDisplayed();
        allElementsAreVisible(elements);
        if (!isElementVisible(postbackTable)) {
            waitForVisibility(youDontHavePostbackTitle);
        }
    }


    public void fillFields() {
        String baseUrl = requestBinPage.getRequestBinUrl();
        switchToTheFirstTab();
        typeIntoField(offerId, offerIdNameOfParametrInput);
        typeIntoField(offerIdValue, offerIdValueOfParametrInput);
        typeIntoField(offerName, offerNameNameOfParametrInput);
        typeIntoField(offerNameValue, offerNameValueOfParametrInput);
        typeIntoField(clickId, clickIdNameOfParametrInput);
        typeIntoField(clickIdValue, clickIdValueOfParametrInput);
        typeIntoField(baseUrl, baseUrlInput);
        typeIntoField("AutoTestPostBack1", nameOfPostbackInput);
        inProgressCheck.click();
        extraditionCheck.click();
        checkBtn.click();
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element = driver.findElement(By.xpath("//div[contains(text(), 'успешно')]"));
        waitForVisibility(element);
    }

    public void checkIsPostbackDone() {
        switchToTheSecondTab();
        refreshPage();
        String xpathClickID = String.format("//p[./strong[contains(text(), '%s')]][contains(text(), '%s')]", this.clickId, this.clickIdValue);
        waitForVisibility(driver.findElement(By.xpath(xpathClickID)));
        String xpathName = String.format("//p[./strong[contains(text(), '%s')]][contains(text(), '%s')]", this.offerName, this.offerNameValue);
        waitForVisibility(driver.findElement(By.xpath(xpathName)));
        String xpathId = String.format("//p[./strong[contains(text(), '%s')]][contains(text(), '%s')]", this.offerId, this.offerIdValue);
        waitForVisibility(driver.findElement(By.xpath(xpathId)));
        switchToTheFirstTab();
    }

    public void saveAndCheckSavedPostBack(){
        waitForAjaxElementIsVisible(formAfterTestPostBack);
        closeFormAfterTestPostBack.click();
        int countPostBacks = listPostBacks.size();
        saveBtn.click();
        waitForCountOfAjaxElementsMoreThan(By.xpath("//div[@class='row font__base-small']"), countPostBacks);
    }

}
