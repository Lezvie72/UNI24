package pages.partnerCabinetPage.Tabs.ReportsTab.Trafic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class Detailed extends TotalReport {


    @FindBy(css = ".ui-detail-report-table-forms")
    private WebElement trafficDetailedTable;


    private final List<WebElement> elements;

    public Detailed() {
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(clearBtn, trafficDetailedTable);
    }

    public void pageIsDisplayed() {
        super.pageIsDisplayed();
        allElementsAreVisible(elements);
    }
}
