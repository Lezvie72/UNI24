package stepDefinitions.broker;

import cucumber.api.java.ru.Тогда;
import pages.brokerCabinet.tabs.CatalogOffersTabPage;

public class CatalogOffersTabPageStepDefinitions {

    private final CatalogOffersTabPage catalogOffersTabPage = new CatalogOffersTabPage();

    @Тогда("^отображается страница каталог офферов$")
    public void catalogOffersPageIsDisplayed() {
        catalogOffersTabPage.pageIsDisplayed();
    }

    @Тогда("^отображаются офферы$")
    public void offersAreDisplayed() {
        catalogOffersTabPage.countOffers();
    }

    @Тогда("^брокер вводит \"([^\"]*)\" в поле ввода поиска$")
    public void brokerFillFieldWithNameOfBank(String nameOfBank) {
        catalogOffersTabPage.searchOffer(nameOfBank);
    }

    @Тогда("^оффер \"([^\"]*)\" отображается в результатах$")
    public void offerIsDisplayed(String nameOfBank) {
        catalogOffersTabPage.isSearchResultIsDisplayed(nameOfBank);
    }

    @Тогда("^брокер кликает на фильтр \"([^\"]*)\"$")
    public void brokerChooseFilter(String nameOfFilter) {
        catalogOffersTabPage.filterClick(nameOfFilter);
    }

    @Тогда("отображаются только офферы \"([^\"]*)\"$")
    public void onlyOffersByStringIsDisplayed(String nameOfOffer) {
        catalogOffersTabPage.checkFiltersWork(nameOfOffer);
    }
}
