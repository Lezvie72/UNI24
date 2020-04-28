package pages.partnerCabinetPage.Tabs.ReportsTab;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class CommonElementsForAllReportsTabs extends Base {
    @FindBy(xpath = "//div[./div[contains(text(), 'от')]]//input")
    private WebElement dateFrom;

    @FindBy(xpath = "//div[./div[contains(text(), 'до')]]//input")
    private WebElement dateTo;

    @FindBy(xpath = "//div[@class='buttons']//button[contains(text(), 'Показать')]")
    private WebElement displayBTN;

    @FindBy(xpath = "//div[@class='buttons']//button[contains(text(), 'Очистить')]")
    private WebElement clearBTN;

    public List<WebElement> getHeaderReportsTabsMin() {
        return Arrays.asList(dateFrom, dateTo, displayBTN);
    }

    public List<WebElement> getHeaderReportsTabsMax() {
        return Arrays.asList(dateFrom, dateTo, displayBTN, clearBTN);
    }
}
