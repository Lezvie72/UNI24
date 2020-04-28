package pages.partnerCabinetPage.Tabs.ReportsTab.Trafic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class Summary extends TotalReport {


    @FindBy(css = ".reports-toolbar-filters")
    private WebElement filtersToolBarFilters;

    @FindBy (css = ".ui-report-total-period-lable")
    private WebElement filterPeriod;


    @FindBy(css = ".ui-report-total")
    private WebElement trafficTotalTable;


    private final List<WebElement> elementsForCheckMainFilterTotal;

    public Summary() {
        PageFactory.initElements(driver, this);
        elementsForCheckMainFilterTotal = Arrays.asList(filtersToolBarFilters, trafficTotalTable, filterPeriod);
    }

    public void pageIsDisplayed() {
        super.pageIsDisplayed();
        allElementsAreVisible(elementsForCheckMainFilterTotal);
    }
}
