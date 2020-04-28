package stepDefinitions;

import cucumber.api.java.ru.То;
import pages.reg.RegistrationPage;

public class RegistrationPageStepDefinitions {

    private final RegistrationPage registrationPage = new RegistrationPage();

    @То("^контент сменится на форму регистрации в поле url путь изменится на /registration$")
    public void registrationPageIsDisplayed() {
        registrationPage.pageIsDisplayed();
    }

    @То("^пользователь вводит некорректный пароль$")
    public void userTypeIncorrectPassword() {
        registrationPage.typeIncorrectPassword();
    }

    @То("^пользователь вводит новый номер и нажимает Получить пароль$")
    public void userTypePhoneAndGetPassword() {
        registrationPage.typePhone();
        registrationPage.getPasswordClick();
    }

    @То("^пользоваетль вводит корректный код подтверждения и нажимает Войти$")
    public void userTypeCorrectPasswrodAndLogIn() {
        registrationPage.typeCorrectCode();
    }
}
