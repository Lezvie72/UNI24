package stepDefinitions.bankList;

import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import pages.banki.BankList;

public class AllBanksStepDefinitions {

    public final BankList bankList = new BankList();

    @Тогда("^пользователь находится на странице Список банков$")
    public void bankListPage() {
        bankList.onAllBanksPage();
    }

    @Тогда("^отображается страница Все банки$")
    public void allBanksPageAreDisplayed() {
        bankList.pageIsDisplayed();
        Assert.assertTrue(bankList.banksOnPageEqual5());
    }

    @Тогда("^пользователь вводит \"([^\"]*)\" в поле ввода$")
    public void fillFieldWithNameOfBank(String nameOfBank) {
        bankList.fillSearchInput(nameOfBank);
    }

    @И("^пользователь наживает на кнопку поиск$")
    public void searchBtnClicks() {
        bankList.searchBtnClick();
    }

    @Тогда("^на странице появляется ссылка на \"([^\"]*)\"$")
    public void seeBankLink(String bankNameLink) {
        bankList.seeBankNameLink(bankNameLink);
    }

    @Тогда("^пользователь кликает на название банка на странице все банки$")
    public void userClickNameOfBank() {
        bankList.clickNameOfBank();
    }

    @Когда("^пользователь выбирает фильтр \"([^\"]*)\" на странице Все банки$")
    public void userBankListFilterSelect(String nameFilter){
        bankList.bankListFiltersClick(nameFilter);
    }

    @Тогда("^пользователь видит результат по фильтру \"([^\"]*)\" и проверяет список нажав Показать еще$")
    public void userBankListCheckingSelectedFilter(String nameFilter){
        bankList.bankListSelectedFilterChecking(nameFilter);
    }

}
