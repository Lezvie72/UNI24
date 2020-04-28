package stepDefinitions.verticals.credits;

import cucumber.api.java.ru.Тогда;
import pages.verticals.credits.CreditsDetailsPage;

public class CreditsDetailsPageStepDefinitions {

    private final CreditsDetailsPage creditsDetailsPage = new CreditsDetailsPage();

    @Тогда("отображается подробная страница банка")
    public void creditsDetailsPageIsDisplayed(){
        creditsDetailsPage.pageIsDisplayed();
    }
}
