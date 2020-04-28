package stepDefinitions.auth;

import base.Base;
import cucumber.api.java.ru.Тогда;
import pages.auth.AuthPageOfBroker;
import pages.auth.AuthOffersPage;

public class AuthPageOfBrokerStepDefinitions extends Base {

    private final AuthPageOfBroker authPageOfBroker = new AuthPageOfBroker();
    private final AuthOffersPage authOffersPage = new AuthOffersPage();

    @Тогда("^пользователь находится на странице авторизации Брокера$")
    public void onBrokerAuthPage() {
        authPageOfBroker.onPage();
    }

    @Тогда("^отображается страница авторизации Личный кабинет Брокера и Агента$")
    public void authPageOfBrokerIsDisplayed(){
        authPageOfBroker.pageIsDisplayed();
    }

    @Тогда("^отображается страница поиска офферов со входом$")
    public void authPageOfficeOffers(){
        authOffersPage.pageIsDisplayed();
    }

    @Тогда("^брокер авторизовывается$")
    public void brokerLogIn(){
        authPageOfBroker.brokerLogIn();
    }
}
