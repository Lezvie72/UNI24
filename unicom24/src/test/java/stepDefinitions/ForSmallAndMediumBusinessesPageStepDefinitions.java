package stepDefinitions;

import base.Base;
import cucumber.api.java.ru.Дано;
import pages.ForSmallAndMediumBusinessesPage;

public class ForSmallAndMediumBusinessesPageStepDefinitions extends Base {

    private final ForSmallAndMediumBusinessesPage forSmallAndMediumBusinessesPage = new ForSmallAndMediumBusinessesPage();

    @Дано("отображается страница Малому и среднему бизнесу")
    public void forSmallAndMediumBusinessesPageIsDisplayed(){
        forSmallAndMediumBusinessesPage.pageIsDisplayed();
    }
}
