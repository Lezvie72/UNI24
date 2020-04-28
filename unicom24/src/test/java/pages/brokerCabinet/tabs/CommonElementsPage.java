package pages.brokerCabinet.tabs;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class CommonElementsPage extends Base {

    @FindBy(css = ".ui-financial-health-header_price-round")
    public WebElement price;

    @FindBy (xpath = "//a[contains(text(), 'Скачать пример отчета')]")
    public WebElement downloadReport;

    @FindBy (xpath = "//div[contains(text(), 'Заявка')]")
    public WebElement formTitle;

    /*Есть на всех стр., кроме Скоринг по социальным сетям и Проверка автомобиля*/
    @FindBy (xpath = "//div[./div/span[contains(text(), 'Фамилия')]]/div/input")
    public WebElement lastNameInput;

    /*Есть на всех стр., кроме Скоринг по социальным сетям и Проверка автомобиля*/
    @FindBy (xpath = "//div[./div/span[contains(text(), 'Имя')]]/div/input")
    public WebElement nameInput;

    /*Есть на всех стр., кроме Скоринг по социальным сетям и Проверка автомобиля*/
    @FindBy (xpath = "//div[./div/span[contains(text(), 'Отчество')]]/div/input")
    public WebElement patronymicNameInput;

    /*Есть на всех стр., кроме Скоринг по социальным сетям, Скоринг по номеру телефона и Проверка автомобиля*/
    @FindBy (xpath = "//div[./div/span[contains(text(), 'Дата рождения')]]/div/input")
    public WebElement dataInput;

    /*Есть на всех стр., кроме Скоринг по социальным сетям и Проверка автомобиля*/
    @FindBy (xpath = "//div[./div/span[contains(text(), 'Номер и серия паспорта')]]/div/input")
    public WebElement passportNumberInput;

    /*Есть на всех стр., кроме Скоринг по социальным сетям, Скоринг по номеру телефона и Проверка автомобиля*/
    @FindBy (xpath = "//div[./div/span[contains(text(), 'Дата выдачи паспорта')]]/div/input")
    public WebElement passportDataOfIssueInput;

    /*Есть страницах Скоринг по номеру телефона и Скоринг по социальным сетям*/
    @FindBy (xpath = "//div[./div/span[contains(text(), 'E-mail')]]/div/input")
    public WebElement emailInput;

    /*Есть страницах Скоринг по номеру телефона и Скоринг по социальным сетям*/
    @FindBy (xpath = "//div[./div/span[contains(text(), 'Номер телефона')]]/div/input")
    public WebElement phoneNumberInput;

    /*Есть на всех стр., кроме Проверка автомобиля*/
    @FindBy (xpath = "//label[./div[contains(text(), 'Я проверяю кредитную историю другого человека')]]")
    public WebElement authorizedAgentAnswer;

    /*Есть на всех стр., кроме Проверка автомобиля*/
    @FindBy (xpath = "//label[./div[contains(text(), 'Я проверяю свою кредитную историю')]]")
    public WebElement userAnswer;

    /*Есть на всех стр., кроме Проверка автомобиля*/
    @FindBy (xpath = "//div[contains(text(), 'Для проведения проверки требуется предоставить подписанный бланк запроса')]")
    public  WebElement importantNote;

    /*Есть на всех стр., кроме Проверка автомобиля*/
    @FindBy (xpath = "//a[contains(text(), 'Скачать бланк')]")
    public  WebElement downloadForm;

    @FindBy (xpath = "//p[contains(text(), 'Оплата')]")
    public  WebElement paymentTitle;

    @FindBy (xpath = "//label[./div/div/div[contains(text(), 'Счет Юником24')]]")
    public  WebElement userWalletDot;

    @FindBy (xpath = "//div[contains(text(), 'Счет Юником24')]")
    public WebElement userWalletTitle;

    @FindBy (xpath = "//label[./div/div/div[contains (text(), 'Робокасса')]]")
    public  WebElement robokassaDot;

    @FindBy (xpath = "//div[contains (text(), 'Робокасса')]")
    public WebElement robokassaTitle;

    @FindBy (xpath = "//label[./div/div/div[contains (text(), 'Payture')]]")
    public WebElement paytureDot;

    @FindBy (xpath = "//div[contains (text(), 'Payture')]")
    public WebElement paytureTitle;

    @FindBy (xpath = "//button[./span[contains (text(), 'Получить отчет')]]")
    public WebElement getReportButton;

    @FindBy (css = "div .ui-form-requests_history_credit_report")
    public WebElement requestHistory;

    @FindBy (xpath = "//div[contains (text(), 'История запросов')]")
    public  WebElement requestHistoryTitle;

    @FindBy (xpath = "//div[./div/div[contains (text(), 'Период')]]")
    public WebElement periodTab;

    @FindBy (css = ".ui-form-requests-history-credit_report__filter-search-form-input")
    public WebElement searchInput;

    @FindBy (xpath = "//button[./span[contains(text(), 'Поиск')]]")
    public WebElement searchButton;

    @FindBy(xpath = "//span[contains(text(), 'Поиск')]")
    public WebElement searchButtonTitle;

    public List<WebElement> commonElements() {
        return Arrays.asList(price, downloadReport, formTitle, lastNameInput, nameInput, patronymicNameInput, dataInput,
                passportNumberInput, passportDataOfIssueInput, authorizedAgentAnswer, userAnswer,
                importantNote, downloadForm, paymentTitle, userWalletDot, userWalletTitle, robokassaDot, robokassaTitle,
                paytureDot, paytureTitle, getReportButton, requestHistory, requestHistoryTitle, periodTab, searchInput,
                searchButton, searchButtonTitle, emailInput, phoneNumberInput);
    }

    public List<WebElement> rfzPageBody() {
        return Arrays.asList(price, downloadReport, formTitle, lastNameInput, nameInput, patronymicNameInput, dataInput,
                passportNumberInput, passportDataOfIssueInput, authorizedAgentAnswer, userAnswer,
                importantNote, downloadForm, paymentTitle, userWalletDot, userWalletTitle, robokassaDot, robokassaTitle,
                paytureDot, paytureTitle, getReportButton, requestHistory, requestHistoryTitle, periodTab, searchInput,
                searchButton, searchButtonTitle);
    }
}
