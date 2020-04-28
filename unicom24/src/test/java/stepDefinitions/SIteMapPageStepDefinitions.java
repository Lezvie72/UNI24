package stepDefinitions;

import cucumber.api.java.ru.Тогда;
import pages.SIteMapPage;

public class SIteMapPageStepDefinitions {

    private final SIteMapPage siteMapPage = new SIteMapPage();

    @Тогда("^отображается карта сайта$")
    public void siteMapPageIsDisplayed() {
        siteMapPage.pageIsDisplayed();
    }

    @Тогда("^робот проверяет \"([^\"]*)\"$")
    public void robotCheckSection(String section) {
        siteMapPage.checkSection(section);
    }
}
