package stepDefinitions;

import base.Base;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import pages.FullCreditHistoryPage;
import pages.FullCreditsHistoryNewPage;
import properties.BaseProperties;

import java.io.File;

public class FullCreditHistoryPageStepDefinitions extends Base {

    private final BaseProperties baseProperties = new BaseProperties();
    private final FullCreditHistoryPage fullCreditHistoryPage = new FullCreditHistoryPage();
    private final FullCreditsHistoryNewPage fullCreditsHistoryNewPage = new FullCreditsHistoryNewPage();

    @Тогда("^проверка страницы Полная кредитная история$")
    public void financialHealthPageIsDisplayed(){
        // тут будет проверка что за страница
        try {// это старая страница
            fullCreditHistoryPage.pageIsDisplayed();
            fullCreditHistoryPage.getReportClick();
            fullCreditHistoryPage.seeReportResult();
            fullCreditHistoryPage.historyElementsAreDisplayed();
            Base.refreshPage();
            fullCreditHistoryPage.seeReportResult();
            fullCreditHistoryPage.historyElementsAreDisplayed();
            fullCreditHistoryPage.downloadReport();
            Assert.assertTrue(folderSize(new File(baseProperties.createDownloadDirURL())) > 300000);
            Assert.assertEquals("pdf", getFileExtension(new File(baseProperties.createDownloadDirURL())));

        }//тут новая страница
        catch (NoSuchElementException|TimeoutException| StaleElementReferenceException e) {
            fullCreditsHistoryNewPage.pageIsDisplayed();
            fullCreditsHistoryNewPage.DownloadBlankBtnClick();
            Assert.assertTrue(folderSize(new File(baseProperties.createDownloadDirURL())) > 60000);
            Assert.assertEquals("pdf", getFileExtension(new File(baseProperties.createDownloadDirURL())));

        }
    }
}
