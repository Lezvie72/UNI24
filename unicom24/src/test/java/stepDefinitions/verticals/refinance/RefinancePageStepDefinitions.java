package stepDefinitions.verticals.refinance;

import base.Base;
import cucumber.api.java.uk.Дано;
import org.junit.Assert;
import pages.verticals.refinance.RefinancePage;

public class RefinancePageStepDefinitions extends Base {

    private final RefinancePage refinancePage = new RefinancePage();

    @cucumber.api.java.ru.Дано("^пользователь находится на странице Рефинансирование$")
    public void onCreditsPage(){
        refinancePage.oneRefinancePage();
    }

    @Дано("^отображается страница Рефинансирование$")
    public void refinancePageIsDisplayed(){
        refinancePage.pageIsDisplayed();
        Assert.assertTrue(refinancePage.offersOnPageMore0());
    }
}
