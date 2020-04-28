package stepDefinitions.verticals.microCredits;

import base.Base;
import cucumber.api.java.ru.Дано;
import pages.verticals.microCredits.MicroCreditsDetailedPage;

public class MicroCreditsDetailedStepDefinitions extends Base {

    private final MicroCreditsDetailedPage microCreditsDetailedPage = new MicroCreditsDetailedPage();

    @Дано("отображается подробная страница Микрозайма")
    public void microCreditsDetailedPageIsDisplayed(){
        switchToTheFirstTab();
        microCreditsDetailedPage.pageIsDisplayed();
    }
}
