package stepDefinitions;

import base.Base;
import cucumber.api.java.ru.Когда;
import org.junit.Assert;
import pages.AboutFullCreditHistoryPage;

public class AboutFullCreditHistoryPageStepDeffinitions {

    private final AboutFullCreditHistoryPage page = new AboutFullCreditHistoryPage();

    @Когда("^страница о полной кредитной истории отображается$")
    public void aboutFullCreditHistoryPageIsDisplayed() {
        page.pageIsDisplayed();
    }

    @Когда("пользователь нажимает кнопку Получить историю$")
    public void userClickGetHistoryPageBtnClick(){
        page.getHistoryPageBtnClick();
    }
}
