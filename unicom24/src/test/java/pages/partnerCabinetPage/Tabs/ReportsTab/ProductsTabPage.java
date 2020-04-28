package pages.partnerCabinetPage.Tabs.ReportsTab;

import org.openqa.selenium.support.PageFactory;
import pages.partnerCabinetPage.Header.HeaderPartnerCabinetPage;

public class ProductsTabPage extends ReportsTabPage {
    private final HeaderPartnerCabinetPage header = new HeaderPartnerCabinetPage();
    private final CommonElementsForAllReportsTabs commonElementsForAllReportsTabs = new CommonElementsForAllReportsTabs();

    public ProductsTabPage() {

        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, commonElementsForAllReportsTabs);
    }

    public void pageIsDisplayed() {
        super.pageIsDisplayed();
        allElementsAreVisible(commonElementsForAllReportsTabs.getHeaderReportsTabsMax());
    }
}
