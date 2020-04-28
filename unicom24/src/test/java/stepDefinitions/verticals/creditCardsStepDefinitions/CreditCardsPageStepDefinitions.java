package stepDefinitions.verticals.creditCardsStepDefinitions;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import pages.verticals.creditCards.CreditCardsPage;

public class CreditCardsPageStepDefinitions {

    private final CreditCardsPage creditCardsPage = new CreditCardsPage();


    @Дано("^пользователь находится на странице Кредитные карты$")
    public void onCreditsPage(){
        creditCardsPage.onCreditCardsPage();
    }

    @Тогда("^отображается страница Кредитные карты$")
    public void creditCardsPageIsDisplayed() {
        creditCardsPage.pageIsDisplayed();
        Assert.assertTrue(creditCardsPage.offersOnPageMore0());
        Assert.assertTrue(creditCardsPage.checkH2SeoElements());
    }
}
