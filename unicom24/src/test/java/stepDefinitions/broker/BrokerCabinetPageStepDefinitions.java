package stepDefinitions.broker;

import base.Base;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import pages.brokerCabinet.BrokerCabinetPage;

public class BrokerCabinetPageStepDefinitions extends Base {

    private final BrokerCabinetPage brokerCabinetPage = new BrokerCabinetPage();

    @Тогда("^брокер находится в Кабинете брокера$")
    public void onBrokerCabinetPage() {
        brokerCabinetPage.onPage();
    }

    @Тогда("^отображается Личный кабинет Брокера$")
    public void cabinetOfBrokerIsDisplayed() {
        brokerCabinetPage.pageIsDisplayed();
    }

    @Тогда("^брокер кликает на \"([^\"]*)\" в хэдэре$")
    public void brokerClickTabMenuHeader(String nameOfTab) {
        brokerCabinetPage.tabMenuHeaderClick(nameOfTab);
    }

    @Тогда("^брокер наводит мышь на \"([^\"]*)\" в хэдэре$")
    public void brokerMouseOverTabMenuHeader(String nameOfTab) {
        brokerCabinetPage.tabMenuHeaderMouseOver(nameOfTab);
    }

    @Тогда("^отображается меню Все услуги$")
    public void allServicesIsDisplayed() {
        brokerCabinetPage.allServicesMenuIsDisplayed();
    }

    @Тогда("^отображается меню Финансовый рейтинг клиента$")
    public void finRatingSubMenuIsDisplayed() {
        brokerCabinetPage.finRatingSubMenuIsDisplayed();
    }

    @Тогда("^отображается меню Авто$")
    public void autoSubMenuIsDisplayed() {
        brokerCabinetPage.autoSubMenuIsDisplayed();
    }

    @Тогда("^отображается меню Скоринг$")
    public void scoringSubMenuIsDisplayed() {
        brokerCabinetPage.scoringMenuIsDisplayed();
    }

    @Тогда("^брокер нажимает на кнопку Пополнить счет$")
    public void brokerGiveMoneyClick() {
        brokerCabinetPage.giveMoneyBtnClick();
    }

    @Тогда("^отображается панель Пополнить счет$")
    public void addMoneyPanelIsDisplayed() {
        brokerCabinetPage.giveMoneyPanelIsDisplayed();
    }

    @Тогда("^панель Пополнить счет не отображается$")
    public void addMoneyPanelIsNotDisplayed() {
        brokerCabinetPage.giveMoneyPanelIsNotDisplayed();
    }

    @Тогда("^брокер разлогинивается$")
    public void brokerLogOut() {
        brokerCabinetPage.dropMenuClick();
        brokerCabinetPage.logOutClick();
    }

    @Тогда("^брокер заходит в профиль$")
    public void brokerGoToProfile() {
        brokerCabinetPage.dropMenuClick();
        brokerCabinetPage.profileClick();
    }

    @Тогда("^брокер кликает на \"([^\"]*)\" в подменю$")
    public void brokerClickSubmenuElement(String nameOfItem) {
        brokerCabinetPage.submenuItemClick(nameOfItem);
    }

    // код от 09.01.2020
    @Когда("^брокер нажимает таб Отчеты$")
    public void brokerClickStatisticsTotalTab(){
        brokerCabinetPage.brokerStatisticsTotalTabClick();
    }

    @Когда("^брокер нажимает таб Офферы$")
    public void brokerClickOffersTab() {
        brokerCabinetPage.brokerOffersTabClick();
    }

    @Когда("^брокер нажимает таб Лендинги$")
    public void brokerClickLandingsTab() {
        brokerCabinetPage.brokerLandingsTabClick();
    }

    @Когда("^брокер нажимает таб Продукты$")
    public void brokerClickCrossReportsTab() {
        brokerCabinetPage.brokerCrossReportsTabClick();
    }

    @Когда("^брокер нажимает таб Постбек$")
    public void brokerClickPostbackTab() {
        brokerCabinetPage.brokerPostbackTabClick();
    }

    @Когда("^брокер нажимает таб Справка$")
    public void brokerClickHelpDocsTab() {
        brokerCabinetPage.brokerHelpDocumentsTabClick();
    }

    @Когда("^брокер нажимает таб Настройки$")
    public void brokerClickSettingsTab() {
        brokerCabinetPage.brokerSettingsTabClick();
    }

    @Тогда("^отображается брокерская страница Отчеты$")
    public void brokerStatisticsTotalTabIsDisplayed(){
        brokerCabinetPage.brokerStatisticsTotalTabIsDisplayed();
    }

    @Тогда("^отображается брокерская страница Офферы$")
    public void brokerOffersTabIsDisplayed(){
        brokerCabinetPage.brokerOffersTabIsDisplayed();
    }

    @Тогда("^отображается брокерская страница Лендинги$")
    public void brokerLandingsTabIsDisplayed(){
        brokerCabinetPage.brokerLandingsTabIsDisplayed();
    }

    @Тогда("^отображается брокерская страница Продукты$")
    public void brokerCrossReportsTabIsDisplayed(){
        brokerCabinetPage.brokerCrossReportsTabIsDisplayed();
    }

    @Тогда("^отображается брокерская страница Постбек$")
    public void brokerPostbackTabIsDisplayed(){
        brokerCabinetPage.brokerPostbackTabIsDisplayed();
    }

    @Тогда("^отображается брокерская страница Справка$")
    public void brokerHelpDocsTabIsDisplayed(){
        brokerCabinetPage.brokerHelpDocsTabIsDisplayed();
    }

    @Тогда("^отображается брокерская страница Настройки$")
    public void brokerSettingsTabIsDisplayed(){
        brokerCabinetPage.brokerSettingsTabIsDisplayed();
    }
}