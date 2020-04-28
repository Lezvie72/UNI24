package pages.partnerCabinetPage.Tabs.ReportsTab;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.partnerCabinetPage.Header.HeaderPartnerCabinetPage;

import java.util.List;

public class DinamicLandingTabPage extends ReportsTabPage {
    private final HeaderPartnerCabinetPage header = new HeaderPartnerCabinetPage();
    private final CommonElementsForAllReportsTabs commonElementsForAllReportsTabs = new CommonElementsForAllReportsTabs();

    @FindBy(xpath = "//div[@class='stats']")
    private WebElement statsBlock;

    @FindBy(xpath = "//div[@class='ds-button-group']//button")
    private List<WebElement> statsBTNs;

    public DinamicLandingTabPage() {

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, commonElementsForAllReportsTabs);;
    }

    public void  pageIsDisplayed() {
        super.pageIsDisplayed();
        waitForAllAjaxElementIsVisible(commonElementsForAllReportsTabs.getHeaderReportsTabsMax());
        waitForVisibility(statsBlock);
        Assert.assertEquals(2, statsBTNs.size());
    }
}
