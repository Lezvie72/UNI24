package stepDefinitions.webMaster;

import cucumber.api.java.ru.Тогда;
import pages.WebMasterRegistrationPage;

public class WebMasterRegistrationPageStepDefinitions {

    private final WebMasterRegistrationPage webMasterRegistrationPage = new WebMasterRegistrationPage();

    @Тогда("^отображается страница регистрации Вебмастера$")
    public void registerPageOfWebMasterIsDisplayed(){
        webMasterRegistrationPage.pageIsDisplayed();
    }

    @Тогда("^вебмастер кликает на таб Вход$")
    public void webmasterClickEntranceTab(){
        webMasterRegistrationPage.entranceTabClick();
    }
}
