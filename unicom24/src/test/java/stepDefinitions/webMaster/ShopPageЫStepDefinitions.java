package stepDefinitions.webMaster;

import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import pages.partnerCabinetPage.ShopPage;

public class ShopPageЫStepDefinitions {

    private final ShopPage shopPage = new ShopPage();

    @Когда("^пользователь нахожится на странице магазин$")
    public void onShopPage() {
        shopPage.onPage();
    }

    @Тогда("^страница магазин отображается$")
    public void shopPageIsDisplayed() {
        shopPage.pageIsDisplayed();
    }
}
