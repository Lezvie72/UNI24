package stepDefinitions;

import base.Base;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Тогда;
import pages.BecomePartnerPage;

public class BecomePartnerStepDefinitions extends Base {

    private final BecomePartnerPage becomePartner = new BecomePartnerPage();

    @Дано("^пользователь находится на странице Стать партнером$")
    public void onBecomePartnerPage(){
        becomePartner.onBecomePartnerPage();
    }

    @Тогда("^отображается страница Стать партнером$")
    public void becomePartnerPageIsDisplayed(){
        becomePartner.pageIsDisplayed();
    }

    @Тогда("^пользователь нажимает Зарабатывать сейчас$")
    public void userClickEarnNow() {
        becomePartner.getMoneyNowClick();
    }

    @Тогда("^пользователь нажимает Получать заявки$")
    public void userClickGetApp() {
        becomePartner.clickApplications();
    }
}
