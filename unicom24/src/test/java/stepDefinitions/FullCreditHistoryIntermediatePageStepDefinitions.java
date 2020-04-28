package stepDefinitions;

import base.Base;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import pages.FullCreditHistoryIntermediatePage;

public class FullCreditHistoryIntermediatePageStepDefinitions extends Base {
    private final FullCreditHistoryIntermediatePage fullCreditHistoryIntermediatePage = new FullCreditHistoryIntermediatePage();

    @Тогда("^отображается промежуточная страница Полной кредитной истории$")
    public void fullCreditHistoryIntermediatePageIsDisplayed(){
        fullCreditHistoryIntermediatePage.pageIsDisplayed();
    }

    @И("^пользователь кликает на кнопку Получить историю на промежуточной странице Полной кредитной истории$")
    public void fullCreditHistoryIntermediatePageGiveHistoryBTN(){
        fullCreditHistoryIntermediatePage.giveHistoryBTNClick();
    }

}
