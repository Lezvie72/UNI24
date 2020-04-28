package pages.partnerCabinetPage.Tabs;

import base.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.partnerCabinetPage.Header.HeaderPartnerCabinetPage;

import java.util.Arrays;
import java.util.List;

public class ProductsTabPage extends Base {

    private final HeaderPartnerCabinetPage header = new HeaderPartnerCabinetPage();

    @FindBy(xpath = "//div[contains(text(), 'Продукты')]")
    private WebElement productsTitle;

    @FindBy(xpath = "//div[@class='ng-scope']")
    private WebElement productsBoard;

    @FindBy(xpath = "//div[./div[./div[./div[contains(text(), 'Экспертиза')]]]]/div[2]/div[@href=\"/partners/office/cross-reports/expertise\" and contains(text(), 'Получить отчет')]")
    private WebElement expertizeGetReportBtn;

    @FindBy(xpath = "//div[./div[./div[./div[contains(text(), 'ОКБ')]]]]/div[2]/div[@href=\"/partners/office/cross-reports/okb\" and contains(text(), 'Получить отчет')]")
    private WebElement okbGetReportBtn;

    @FindBy(xpath = "//div[./div[./div[./div[contains(text(), 'ФССП')]]]]/div[2]/div[@href=\"/partners/office/cross-reports/fssp\" and contains(text(), 'Получить отчет')]")
    private WebElement fsspGetReportBtn;

    @FindBy(xpath = "//div[./div[./div[./div[contains(text(), 'ФМС')]]]]/div[2]/div[@href=\"/partners/office/cross-reports/fms\" and contains(text(), 'Получить отчет')]")
    private WebElement fmsGetReportBtn;

    @FindBy(xpath = "//div[./div[./div[./div[contains(text(), 'Рейтинг финансового здоровья')]]]]/div[2]/div[@href=\"/partners/office/cross-reports/financial-health\" and contains(text(), 'Получить отчет')]")
    private WebElement rfzGetReportBtn;

//    @FindBy(xpath = "//div[./div[./div[./div[contains(text(), 'Расширенный кредитный рейтинг')]]]]/div[2]/div[@href=\"/partners/office/cross-reports/advanced-credit-rating\" and contains(text(), 'Получить отчет')]")
//    private WebElement wideCreditRatingGetReportBtn;

    @FindBy(xpath = "//div[./div[./div[./div[contains(text(), 'Кредитный отчет')]]]]/div[2]/div[@href=\"/partners/office/cross-reports/credit-report\" and contains(text(), 'Получить отчет')]")
    private WebElement creditReportGetBtn;

    @FindBy(xpath = "//div[./div[./div[./div[contains(text(), 'Кредитный рейтинг')]]]]/div[2]/div[@href=\"/partners/office/cross-reports/credit-rating\" and contains(text(), 'Получить отчет')]")
    private WebElement creditRatingGetBtn;

    @FindBy(xpath = "//div[./div[./div[./div[contains(text(), 'Отчет FICO')]]]]/div[2]/div[@href=\"/partners/office/cross-reports/fico\" and contains(text(), 'Получить отчет')]")
    private WebElement ficoGetReportBtn;

    @FindBy(xpath = "//div[./div[./div[./div[contains(text(), 'Проверка автомобиля')]]]]/div[2]/div[@href=\"/partners/office/cross-reports/auto\" and contains(text(), 'Получить отчет')]")
    private WebElement checkAutoGetReportBtn;

    @FindBy(xpath = "//div[./div[./div[./div[contains(text(), 'Скоринг по номеру телефона')]]]]/div[2]/div[@href=\"/partners/office/cross-reports/phone-scoring\" and contains(text(), 'Получить отчет')]")
    private WebElement scorePhoneNumberGetReportBtn;

    @FindBy(xpath = "//div[./div[./div[./div[contains(text(), 'Скоринг по социальным сетям')]]]]/div[2]/div[@href=\"/partners/office/cross-reports/social-scoring\" and contains(text(), 'Получить отчет')]")
    private WebElement socialMediaScoringGetReportBtn;

//    @FindBy(xpath = "//div[./div[./div[./div[contains(text(), 'Кредитный отчет Unicom24')]]]]/div[2]/div[@href=\"/partners/office/cross-reports/credit-report-u24\" and contains(text(), 'Получить отчет')]")
//    private WebElement creditReportUnicom24GetReportBtn;

    private final List<WebElement> elements;

    public ProductsTabPage() {
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(productsTitle, productsBoard/*expertizeGetReportBtn, okbGetReportBtn, fsspGetReportBtn,
                fmsGetReportBtn, rfzGetReportBtn, creditReportGetBtn, creditRatingGetBtn,
                ficoGetReportBtn, checkAutoGetReportBtn, scorePhoneNumberGetReportBtn, socialMediaScoringGetReportBtn */);
    }

    public void pageIsDisplayed() {
        header.headerIsDisplayed();
        allElementsAreVisible(elements);
        int countButtonsGiveReport = driver.findElements(By.cssSelector(".reports-target-action-button")).size();
        Assert.assertTrue(countButtonsGiveReport>2);
        int countBoardsProducts = driver.findElements(By.cssSelector(".reports-target")).size();
        Assert.assertTrue(countBoardsProducts>2);
    }
}
