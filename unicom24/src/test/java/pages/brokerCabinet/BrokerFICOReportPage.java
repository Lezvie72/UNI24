package pages.brokerCabinet;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.brokerCabinet.footer.FooterBrokerCabinetPage;
import pages.brokerCabinet.header.HeaderBrokerCabinetPage;

import java.util.Arrays;
import java.util.List;

public class BrokerFICOReportPage extends Base {

    private final HeaderBrokerCabinetPage header = new HeaderBrokerCabinetPage();
    private final FooterBrokerCabinetPage footer = new FooterBrokerCabinetPage();

    @FindBy (xpath = "//h1[contains(text(), 'Отчет FICO')]")
    private WebElement ficoReportTitle;

    @FindBy (css = ".ui-fico-header_preview-img")
    private WebElement ficoReportPreview;

    @FindBy (xpath = "//div[contains(text(), 'Скоринговая модель FICO формируется по оценке влияния')]")
    private WebElement scoringModelBlock;

    @FindBy (xpath = "//div[contains(text(), 'Качество кредитной истории ')]")
    private WebElement credirHistoryQuality;

    @FindBy (xpath = "//div[contains(text(), 'Cвоевременность выплат по кредитам')]")
    private WebElement onTimeLoanRepayment;

    @FindBy (xpath = "//div[contains(text(), 'Анализ раннее выданных кредитов.')]")
    private WebElement creditAnalysis;

    @FindBy (xpath = "//div[contains(text(), 'Уровень текущей задолженности клиента.')]")
    private WebElement actualDebtLevel;

    @FindBy (xpath = "//div[contains(text(), 'Количественный анализ кредитной истории')]")
    private WebElement quantifiedAnalysisOfCreditHistory;

    @FindBy (xpath = "//div[contains(text(), 'Соотношение поданных кредитных заявок')]")
    private WebElement proportionOfCreditApplication;

    private final List<WebElement>elements;

    public BrokerFICOReportPage() {
        PageFactory.initElements(driver, header);
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, footer);
        elements = Arrays.asList(ficoReportTitle, ficoReportPreview, scoringModelBlock, credirHistoryQuality, onTimeLoanRepayment,
                creditAnalysis, actualDebtLevel, quantifiedAnalysisOfCreditHistory, proportionOfCreditApplication);
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(elements);
        allElementsAreVisible(header.getHeader());
        allElementsAreVisible(footer.getFooter());
    }
}
