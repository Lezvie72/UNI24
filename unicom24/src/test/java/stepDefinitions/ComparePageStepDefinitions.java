package stepDefinitions;

import base.Base;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import pages.ComparePage;

public class ComparePageStepDefinitions extends Base {
    private final ComparePage comparePage = new ComparePage();

    @Тогда("^отображается страница Сравнение$")
    public void comparePageIsDisplayed() {
        comparePage.pageIsDisplayed();
    }

    @Тогда("^отображается пустая страница сравнение$")
    public void emptyComparePageIsDisplayed() {
        comparePage.emptyPageIsDisplayed();
    }

    @И("^отображается \"([^\"]*)\" банков в сравнении")
    public void compareBanksCreditIsDisplayed(String countBanksCreditToCompare){
        comparePage.compareBanksCreditCompareIsDisplayed(countBanksCreditToCompare);
    }

    @Когда("^пользователь удаляет \"([^\"]*)\" банков из сравнения")
    public void removeBanksCreditsRemoveFromCompare(String countBanksRemoveFromCompare){
        comparePage.removeBanksFromCompareCreditsClick(countBanksRemoveFromCompare);
    }

    @Тогда("^пользователь выбирает \"([^\"]*)\" таб в сравнении$")
    public void userChooseTab(String nameOfTab) {
        comparePage.tabClick(nameOfTab);
    }

}
