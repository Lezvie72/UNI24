package stepDefinitions;

import base.Base;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import pages.GiveFinancialHealthPage;

public class GiveFinancialHealthPageStepDefinitions extends Base {
    private GiveFinancialHealthPage giveFinancialHealthPage = new GiveFinancialHealthPage();

    @Тогда("^отображается страница информации об отчете Рейтинга финансового здоровья$")
    public void giveFinancialHealthPageIsDisplayed(){
        giveFinancialHealthPage.pageIsDisplayed();
    }

    @Когда("^пользователь кликает Узнать свой рейтинг на странице информации об отчете Рейтинга финансового здоровья$")
    public void giveFinancialHealthPageGiveReportClick(){
        giveFinancialHealthPage.giveFinancialHealthBTN();
    }
}
