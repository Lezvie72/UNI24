package stepDefinitions.verticals.refinance;

import cucumber.api.java.ru.Дано;
import pages.verticals.refinance.RefinanceDetailedPage;

public class RefinanceDetailedStepDefinitions {

    private final RefinanceDetailedPage refinanceDetailedPage = new RefinanceDetailedPage();

    @Дано("отображается подробная страница рефинансирования")
    public void refinanceDetailedPageIsDisplayed(){
        refinanceDetailedPage.pageIsDisplayed();
    }
}
