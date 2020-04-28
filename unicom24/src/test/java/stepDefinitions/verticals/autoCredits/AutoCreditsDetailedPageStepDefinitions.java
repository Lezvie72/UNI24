package stepDefinitions.verticals.autoCredits;

import cucumber.api.java.ru.Тогда;
import pages.verticals.autoCredits.AutoCreditsDetailedPage;

public class AutoCreditsDetailedPageStepDefinitions {

    private final AutoCreditsDetailedPage autoCreditsDetailedPage = new AutoCreditsDetailedPage();

    @Тогда("отображается подробная страница Автокредита")
    public void autoCreditsDetailedPagePageIsDisplayed(){
        autoCreditsDetailedPage.pageIsDisplayed();
    }
}
