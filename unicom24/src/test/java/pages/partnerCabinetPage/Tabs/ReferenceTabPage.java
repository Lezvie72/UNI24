package pages.partnerCabinetPage.Tabs;

import base.Base;
import hooks.Hooks;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.partnerCabinetPage.Header.HeaderPartnerCabinetPage;
import properties.BaseProperties;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ReferenceTabPage extends Base {

    private final HeaderPartnerCabinetPage header = new HeaderPartnerCabinetPage();

    @FindBy(xpath = "//div[contains(text(), 'Справка')]")
    private WebElement referenceTitle;

    @FindBy(xpath = "//div[@class='content']")
    private WebElement documentsContainer;

    @FindBy(xpath = "//div[contains(text(), 'Информация для разработчиков')]")
    private WebElement forDevelopersTitle;

    @FindBy(xpath = "//a[contains(text(), 'API')]")
    private WebElement apiTitle;

    @FindBy(xpath = "//a[contains(text(), 'Универсальное')]")
    private WebElement universalLink;

    @FindBy(xpath = "//a[contains(text(), 'Единый оффер')]")
    private WebElement uniounOfferLink;

    @FindBy(xpath = "//a[contains(text(), 'Документы')]")
    private WebElement documentsLink;

    @FindBy(xpath = "//a[contains(text(), 'Скачать')]")
    private List<WebElement> docsLinksForDownload;

    private final List<WebElement> elements;
    private final List<WebElement> elementsDocsPage;

    public ReferenceTabPage() {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, header);
        elements = Arrays.asList(referenceTitle, documentsContainer, forDevelopersTitle, apiTitle,
                universalLink, uniounOfferLink, documentsLink);
        elementsDocsPage = Arrays.asList(referenceTitle, documentsLink, apiTitle, uniounOfferLink, universalLink);
    }

    public void pageIsDisplayed() {
        header.headerIsDisplayed();
        allElementsAreVisible(elements);
    }

    public void docPageClick(){
        documentsLink.click();
    }

    public void docsPageIsDisplayed(){
        header.headerIsDisplayed();
        allElementsAreVisible(elementsDocsPage);
        Assert.assertEquals(3, docsLinksForDownload.size());
    }

    public void docsLinksForDownloadClick(){
        for (int i = 0; i < docsLinksForDownload.size(); i++) {
            docsLinksForDownload.get(i).click();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Assert.assertTrue(folderSize(new File(BaseProperties.createDownloadDirURL())) > 60000);
            Assert.assertEquals("pdf", getFileExtension(new File(BaseProperties.createDownloadDirURL())));
            Hooks.deleteAllFilesFolder(BaseProperties.createDownloadDirURL());
        }
    }
}
