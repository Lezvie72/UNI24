package stepDefinitions.auth;

import base.Base;
import cucumber.api.java.ru.Тогда;
import pages.auth.AuthPageOfBankAndAdv;

public class AuthPageOfBankAndAdvPageStepDefinitions extends Base {

    AuthPageOfBankAndAdv authPageOfBankAndAdv = new AuthPageOfBankAndAdv();

    @Тогда("отображается страница авторизации Личный кабинет Банков и Рекламодателей")
    public void AuthPageOfBankAndAdvPageIsDisplayed(){
        authPageOfBankAndAdv.pageIsDisplayed();
    }

    @Тогда("рекламодатель авторизовывается")
    public void advAuth(){
        authPageOfBankAndAdv.advAuth();
    }

    @Тогда("^пользователь пытается авторизоваться в кабинете Рекламодателя$")
    public void userTryAuth() {
        authPageOfBankAndAdv.userLogIn();
        authPageOfBankAndAdv.checkThatUserCannot();
    }
}
