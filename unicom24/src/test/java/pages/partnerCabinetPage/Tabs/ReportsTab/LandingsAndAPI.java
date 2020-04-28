package pages.partnerCabinetPage.Tabs.ReportsTab;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.partnerCabinetPage.Header.HeaderPartnerCabinetPage;

import java.util.List;

public class LandingsAndAPI extends ReportsTabPage {
    private final HeaderPartnerCabinetPage header = new HeaderPartnerCabinetPage();
    private final CommonElementsForAllReportsTabs commonElementsForAllReportsTabs = new CommonElementsForAllReportsTabs();

    @FindBy(xpath = "//div[@class='ds-button-group']//button")
    private List<WebElement> statsBTNs;

    public LandingsAndAPI() {

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, commonElementsForAllReportsTabs);
    }

    public void pageIsDisplayed() {
        super.pageIsDisplayed();
        allElementsAreVisible(commonElementsForAllReportsTabs.getHeaderReportsTabsMax());
        waitForCountOfAjaxElementsMoreThan(By.xpath("//div[@class='ds-button-group']//button"), 4);
        Assert.assertEquals(4, statsBTNs.size());
    }
}
