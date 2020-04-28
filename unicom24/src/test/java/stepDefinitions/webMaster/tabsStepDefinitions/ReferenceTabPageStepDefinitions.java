package stepDefinitions.webMaster.tabsStepDefinitions;

import base.Base;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import pages.partnerCabinetPage.Tabs.ReferenceTabPage;
import properties.BaseProperties;

import java.io.File;

public class ReferenceTabPageStepDefinitions extends Base {
    ReferenceTabPage referenceTabPage = new ReferenceTabPage();

    @Когда("^вебмастер кликает на Документы$")
    public void docsPageClick(){
        referenceTabPage.docPageClick();
    }

    @Тогда("^вебмастеру отображается страница Документы$")
    public void docsPageIsDisplayed(){
        referenceTabPage.docsPageIsDisplayed();
    }

    @И("^вебмастер скачивает файл из документов$")
    public void docsPageDocDownloadClick(){
        referenceTabPage.docsLinksForDownloadClick();
    }
}
