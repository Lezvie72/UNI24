package stepDefinitions;

import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import pages.reg.ActivationPage;

public class ActivationPageStepDefinitions {

    private final ActivationPage activationPage = new ActivationPage();

    @Тогда("^отображается страница активации аккаунта$")
    public void activationPageIsDisplayed() {
        activationPage.pageIsDisplayed();
    }

    @Когда("^пользователь заполняет все данные на странице активации$")
    public void typeAllData() {
        activationPage.typeCity();
        activationPage.typeNames();
        activationPage.typePassport();
        activationPage.typeBirth();
        activationPage.typeEmail();
    }

    @Когда("^пользователь нажимает на кнопку Активировать$")
    public void userClickActivateBtn() {
        activationPage.activateBtnClick();
    }

    @Когда("^отображается собщение про отправленное на почту письмо активации$")
    public void messageAboutSendedEmailIsDisplayed() {
        activationPage.messageAboutSendedEmailIsDisplayed();
    }
}
