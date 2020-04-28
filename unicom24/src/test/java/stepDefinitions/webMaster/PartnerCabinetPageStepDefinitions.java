package stepDefinitions.webMaster;

import testContext.TestContext;
import base.Base;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.То;
import cucumber.api.java.ru.Тогда;
import cucumber.api.java.ru.И;
import pages.partnerCabinetPage.Header.HeaderPartnerCabinetPage;
import pages.partnerCabinetPage.PartnerCabinetPage;
import pages.partnerCabinetPage.Tabs.PostbackTabPage;
import pages.partnerCabinetPage.modalPages.GiveMoney;

public class PartnerCabinetPageStepDefinitions extends Base {

    private final PartnerCabinetPage partnerCabinetPage = new PartnerCabinetPage();
    private final PostbackTabPage postbackTabPage = new PostbackTabPage();
    private final HeaderPartnerCabinetPage headerPartnerCabinetPage = new HeaderPartnerCabinetPage();
    private final GiveMoney giveMoneyModal = new GiveMoney();

    @Тогда("^отображается личный кабинет Вебмастера$")
    public void cabinetOfWebMasterIsDisplayed(){
        partnerCabinetPage.pageIsDisplayed();
    }

    @То("^вебмастер подготавливает параметры для постбека$")
    public void prepareParameters(){
            postbackTabPage.fillFields();
    }

    @То("на странице постбека отображаются данные из параметров")
    public void checkPostBackData() {
        postbackTabPage.checkIsPostbackDone();
    }

    @И("^вебмастер сохраняет новый постбэк$")
    public void webMasterSaveNewPostBack(){
        postbackTabPage.saveAndCheckSavedPostBack();
    }

    @Тогда("^вебмастер разлогинивается$")
    public void webMasterLogOut() {
        partnerCabinetPage.logOutBtnClick();
    }

    @Когда("^вебмастер кликает на Вывести деньги$")
    public void webMasterWithdrawMoneyClick(){
        partnerCabinetPage.giveMoneyModalClick();
    }

    @Тогда("^отображается модальное окно вывода денег$")
    public void webMasterGiveMoneyModalPageIsDisplayed(){
        giveMoneyModal.modalPageIsDisplayed();
    }

    @И("^вебмастер увеличивает сумму вывода в модальном окне$")
    public void webMasterGiveMoneyModalPagePlusClick(){
        giveMoneyModal.modalPagePlusBTNClick();
    }
    @Когда("^вебмастер кликает далее в модальном окне$")
    public void webMasterGiveMoneyModalPageNextStepClick(){
        giveMoneyModal.modalPageNextStepBTNClick();
    }

    @Тогда("^отображается вторая часть модального окна$")
    public void webMasterGiveMoneyModalPageNextStepIsDisplayed(){
        giveMoneyModal.modalPageNextStepIsDisplayed();
    }
    @И("^вебмастер выбирает расчетный способ вывода в модальном окне$")
    public void webMasterGiveMoneyModalPageFirstMethodClick(){
        giveMoneyModal.modalPageFirstMethodBTNClick();
    }
    @Когда("^вебмастер кликает вывести деньги в модальном окне$")
    public void webMasterGiveMoneyModalPageGiveClick(){
        giveMoneyModal.modalPageGiveMoneyBTNClick();
    }

    @Тогда("^отображается оповещение об успешном выводе денег в модальном окне либо было сообщение о 24 часах$")
    public void webMasterGiveMoneyModalPageSuccessfulIsDisplayed(){
        giveMoneyModal.checkAlert();
        if (TestContext.messageBlockToGiveMoney == 0)
        giveMoneyModal.modalPageSuccessfulTextIsDisplayed();
    }

    @И("^вебмастер закрывает модальное окно вывода денег либо было сообщение о 24 часах$")
    public void webMasterGiveMoneyModalPageCloseClick(){
        if (TestContext.messageBlockToGiveMoney == 0)
        giveMoneyModal.modalPageClose();
    }

    @Когда("^вебмастер кликает на вкладку \"([^\"]*)\"$")
    public void webMasterSelectTabClick(String tabName){
        partnerCabinetPage.tabClick(tabName);
    }

    @Тогда("^вебмастеру отображается страница \"([^\"]*)\"$")
    public void webMasterIsDisplayed(String tabName){
        partnerCabinetPage.tabIsDisplayed(tabName);
    }
}
