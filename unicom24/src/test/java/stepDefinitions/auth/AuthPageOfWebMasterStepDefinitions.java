package stepDefinitions.auth;

import base.Base;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Тогда;
import pages.auth.AuthPageOfWebMaster;
import pagesUrls.PagesUrls;

public class AuthPageOfWebMasterStepDefinitions extends Base {

    private final AuthPageOfWebMaster authPageOfWebMaster = new AuthPageOfWebMaster();

    @Дано("пользователь находится на странице авторизации Вебмастера")
    public void onAuthPageOfWebmaster(){
        authPageOfWebMaster.onAuthPage();
    }

    @Тогда("страница авторизации Вебмастера отображается")
    public void authPageOfWebMasterIsDisplayed(){
        authPageOfWebMaster.pageIsDisplayed();
    }

    @Тогда("вебМастер авторизовывается")
    public void webMasterLogIn(){
        authPageOfWebMaster.logIn();
        waitForUrlContains(PagesUrls.webMasterPage());
    }

    @Тогда("^пользователь пытается авторизоваться в кабинете вебмастера$")
    public void userTryAuthInWebmasterAcc() {
        authPageOfWebMaster.userLogIn();
        authPageOfWebMaster.checkThatUserCannot();
    }
}
