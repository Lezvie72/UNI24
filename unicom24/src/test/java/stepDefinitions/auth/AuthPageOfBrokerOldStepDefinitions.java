package stepDefinitions.auth;

import base.Base;
import cucumber.api.java.ru.Тогда;
import pages.auth.AuthPageOfBrokerOld;

public class AuthPageOfBrokerOldStepDefinitions extends Base {

    private final AuthPageOfBrokerOld authPageOfBrokerOld = new AuthPageOfBrokerOld();

    @Тогда("^отображается страница авторизации Старый кабинет брокера и агента$")
    public void oldCabinetOfBrokerAuthPageIsDisplayed(){
        authPageOfBrokerOld.pageIsDisplayed();
    }

    @Тогда("^брокер авторизовывается в старом кабинете$")
    public void brokerLogInInOldCabinet(){
        authPageOfBrokerOld.logIn();
    }
}
