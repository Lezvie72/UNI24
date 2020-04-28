package stepDefinitions;

import cucumber.api.java.ru.Тогда;
import pages.CashService;

public class CashServiceStepDef {

    private final CashService cashService = new CashService();

    @Тогда("^отображается страница Расчетно-кассовое обслуживание$")
    public void cashServicePageIsDisplayed() {
        cashService.pageIsDisplayed();
    }
}
