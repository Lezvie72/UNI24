package pages.brokerCabinet;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.brokerCabinet.footer.FooterBrokerCabinetPage;
import pages.brokerCabinet.header.HeaderBrokerCabinetPage;

import java.util.Arrays;
import java.util.List;

public class BrokerCreditReportPage extends Base {

    private final HeaderBrokerCabinetPage header = new HeaderBrokerCabinetPage();
    private final FooterBrokerCabinetPage footer = new FooterBrokerCabinetPage();

    @FindBy (xpath = "//h1[contains(text(), 'Кредитный отчет')]")
    private WebElement creditReportTitle;

    @FindBy (xpath = "//h1[contains(text(), 'Получите мгновенный отчет по потенциальному заемщику')]")
    private WebElement commentOfCreditReportTitle;

    @FindBy (xpath = "//div[./div[contains(text(), 'В отчете вы найдете')]]")
    private  WebElement reportBlock;

    @FindBy (xpath = "//div[contains(text(), 'Список кредитных счетов клиента в каждом банке')]")
    private WebElement listOfCreditAccount;

    @FindBy (xpath = "//div[contains(text(), 'Отчет не содержит информации о кредитах в банках')]")
    private WebElement listOfBanks;

    @FindBy (xpath = "//div[contains(text(), 'Факты рассмотрения судом споров по договору займа')]")
    private WebElement ligitationOfLoanAgreement;

    @FindBy (xpath = "//div[contains(text(), 'Суммы займов, сумму просрочек, своевременность платежей')]")
    private WebElement loanSum;

    @FindBy (xpath = "//div[contains(text(), 'Список запросов по клиенту')]")
    private WebElement requesrList;

    @FindBy (css = ".ui-credit-report-info-report__data-image")
    private WebElement creditReportPreview;

    @FindBy (xpath = "//button[./span[contains(text(), 'Загрузить подписанный бланк')]]")
    private WebElement downloadFormButton;

    @FindBy (xpath = "//span[contains(text(), 'Загрузить подписанный бланк')]")
    private WebElement getDownloadFormButtonTitle;

    @FindBy (xpath = "//div[contains(text(), 'Загрузка файла обязательна')]")
    private WebElement noteUnderDownloadFormButton;

    private final List<WebElement>elements;

    public BrokerCreditReportPage() {
        PageFactory.initElements(driver, header);
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, footer);
        elements = Arrays.asList(creditReportTitle, commentOfCreditReportTitle, reportBlock, listOfCreditAccount, listOfBanks,
                ligitationOfLoanAgreement, loanSum, requesrList, creditReportPreview, downloadFormButton, getDownloadFormButtonTitle,
                noteUnderDownloadFormButton);
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(elements);
        allElementsAreVisible(header.getHeader());
        allElementsAreVisible(footer.getFooter());
    }
}
