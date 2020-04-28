package stepDefinitions.verticals;

import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import pages.verticals.common.CommonElementsForDetailsPages;

public class CommonVerticalsForAllDetailsPages {
    private final CommonElementsForDetailsPages commonElementsForDetailsPages = new CommonElementsForDetailsPages();

    @Когда("^пользователь кликает на подробной странице на вкладку \"([^\"]*)\"")
    public void userVerticalClick(String nameOfVerticalFullInfoBankOffer) {
        commonElementsForDetailsPages.verticalsFullInfoBankOfferClick(nameOfVerticalFullInfoBankOffer);
    }

    @Тогда("^отображается на подробной странице вкладка \"([^\"]*)\"")
    public void userVerticalIsDisplayed(String nameOfVerticalFullInfoBankOffer) {
        commonElementsForDetailsPages.pageIsDisplayed(nameOfVerticalFullInfoBankOffer);
    }

}