package stepDefinitions.advPage;

import base.Base;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import pages.advCabinet.AdvPage;
import pages.advCabinet.ModalPages.GiveMoney;

public class AdvPageStepDefinitions extends Base {

    private final AdvPage advPage = new AdvPage();
    private final GiveMoney giveMoneyModalPage = new GiveMoney();

    @Дано("отображается личный кабинет Банков и Рекламодателей")
    public void cabinetOfBanksAndAdvIsDisplayed(){
        advPage.pageIsDisplayed();
    }

    @Тогда("^банкир нажимает на вкладку Отчеты$")
    public void bankirReportsClick() {
        advPage.reportsTabClick();
    }

    @Когда("^банкир разлогинивается$")
    public void userDropMenuClick(){
        advPage.dropMenuClick();
        advPage.dropMenuLogOutClick();
    }

    @Когда("^банкир кликает на Пополнить счет$")
    public void userGiveMoneyClick(){
        advPage.giveMoneyBtnClick();
    }
    @Тогда("^отображается модальное окно пополение счета у банкира$")
    public void giveMoneyModalPageIsDisplayed(){
        giveMoneyModalPage.giveMoneyModalPageIsDisplayed();
    }

    @И("^банкир нажимает пополнить счет в модальном окне$")
    public void giveMoneyModalPageGiveBTNClick(){
        giveMoneyModalPage.giveMoneyModalGiveBTNClick();
    }

    @Дано("^пользователь находится на странице авторизации Личный кабинет Банков и Рекламодателей$")
    public void onCabinetOfBanksAndAdvPage(){
        advPage.onCabinetOfBanksAndAdvPage();
    }

}
