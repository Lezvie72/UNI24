package pages.brokerCabinet;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.brokerCabinet.footer.FooterBrokerCabinetPage;
import pages.brokerCabinet.header.HeaderBrokerCabinetPage;
import pages.brokerCabinet.tabs.CommonElementsPage;
import pages.commonElementsForAllPages.UserData;
import pagesUrls.PagesUrls;

import java.util.Arrays;
import java.util.List;

/*Что такое "extends Base"?*/
public class BrokerRFZPage extends Base {

    private final HeaderBrokerCabinetPage header = new HeaderBrokerCabinetPage();
    private final FooterBrokerCabinetPage footer = new FooterBrokerCabinetPage();
    private final CommonElementsPage commonElementsPage = new CommonElementsPage();

    @FindBy(xpath = "//h1[contains(text(), 'Рейтинг финансового здоровья')]")
    private WebElement rfzMainTitle;

    @FindBy(xpath = "//div[contains(text(), 'Получите мгновенный отчет по потенциальному заемщику')]")
    private WebElement commentOfRfzMainTitle;

    @FindBy(css = ".ui-financial-health-header_preview-img")
    private WebElement rfzPreview;

    @FindBy(css = "div canvas")
    private WebElement reportPicture;

    @FindBy(xpath = "//button[./span[contains(text(), 'Новый запрос')]]")
    private WebElement newRequest;

    @FindBy(xpath = "//button[./span[contains(text(), 'Распечатать')]]")
    private WebElement printBtn;

    @FindBy(xpath = "//button[./span[contains(text(), 'Скачать отчет')]]")
    private WebElement downloadBtn;

    private final List<WebElement> elements;
    private final List<WebElement> showReport;

    public BrokerRFZPage() {
        PageFactory.initElements(driver, header);
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, footer);
        PageFactory.initElements(driver, commonElementsPage);
        elements = Arrays.asList(rfzMainTitle, commentOfRfzMainTitle, rfzPreview);
        showReport = Arrays.asList(reportPicture, newRequest, printBtn, downloadBtn);
    }

    public void onPage() {
        driver.get(PagesUrls.brokerRFZPageUrl());
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(elements);
        allElementsAreVisible(header.getHeader());
        allElementsAreVisible(footer.getFooter());
        allElementsAreVisible(commonElementsPage.rfzPageBody());
    }

    public void makingApplication() {
        typeIntoField(UserData.nameRU, commonElementsPage.nameInput);
        typeIntoField(UserData.nameRU, commonElementsPage.lastNameInput);
        typeIntoField(UserData.nameRU, commonElementsPage.patronymicNameInput);
        typeIntoField(UserData.birthDay, commonElementsPage.dataInput);
        typeIntoField(UserData.passportNumber, commonElementsPage.passportNumberInput);
        typeIntoField(UserData.dateOfPasport, commonElementsPage.passportDataOfIssueInput);
        commonElementsPage.authorizedAgentAnswer.click();
        commonElementsPage.getReportButton.click();
    }

    public void reportIsDisplayed() {
        allElementsAreVisible(showReport);
    }

}
