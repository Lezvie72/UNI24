package stepDefinitions.verticals.creditCardsStepDefinitions;

import cucumber.api.java.ru.Дано;
import pages.verticals.creditCards.CreditCardsDetailedPage;
import pages.verticals.credits.CreditsDetailsPage;

public class CreditCardsDetailedStepDefinitions {

    private final CreditCardsDetailedPage creditCardsDetailedPage = new CreditCardsDetailedPage();

    @Дано("отображается подробная страница Кредитной карты")
    public void creditsDetailsPageIsDisplayed(){
        creditCardsDetailedPage.pageIsDisplayed();
    }
}
