package stepDefinitions.auth;

import cucumber.api.java.ru.Тогда;
import pages.auth.AuthPage;
import pages.commonElementsForAllPages.UserData;
import testContext.TestContext;

public class AuthPageStepDefinitions {

    private final AuthPage authPage = new AuthPage();

    @Тогда("^отображается страница авторизации$")
    public void authPageIsDisplayed() {
        authPage.authPageIsDisplayed();
    }

    @Тогда("^пользователь авторизовывается$")
    public void userLogIn(){
        authPage.logIn();
    }

    @Тогда("^пользователь находится на странице восстановления пароля$")
    public void userOnResetPasswordPage() {
        authPage.userOnResetPasswordPage();
    }

    @Тогда("^пользователь нажимает: забыли пароль$")
    public void userClickForgetPassword() {
        authPage.forgetPasswordClick();
    }

    @Тогда("^открывается форма восстановления пароля$")
    public void resetPasswordFormIsDisplayed() {
        authPage.resetPasswordFormIsDisplayed();
    }

    @Тогда("^пользователь вводит номер несуществующего пользователя и нажимает Отправить$")
    public void userTypePhoneOfUnregisteredUser() {
        authPage.typePhoneOrEmailOfUnregisteredUser(UserData.unRegisteredUserPhone);
    }

    @Тогда("^пользователь вводит почту несуществующего пользователя и нажимает Отправить$")
    public void userTypeUnregisteredMail() {
        authPage.typePhoneOrEmailOfUnregisteredUser(UserData.unregisteredEmail);
    }

    @Тогда("отображается ошибка \"([^\"]*)\"")
    public void errorIsDisplayed(String errorMessage) {
        authPage.messageIsDisplayed(errorMessage);
    }

    @Тогда("отображается уведомление \"([^\"]*)\"")
    public void notificationIsDisplayed(String notificationMessage) {
        authPage.notificationIsDisplayed(notificationMessage);
    }

    @Тогда("^пользователь вводит некорректный номер и нажимает отправить$")
    public void userTypeIncorrectPhoneOfUnregisteredUser() {
        authPage.typePhoneOrEmailOfUnregisteredUser(UserData.incorrectPhoneNumber);
    }

    @Тогда("^пользователь вводит некорректный мэил и нажимает отправить$")
    public void userTypeIncorrectEmail() {
        authPage.typePhoneOrEmailOfUnregisteredUser(UserData.incorrectMail);
    }

    @Тогда("^пользователь вводит телефон зарегистрированного пользователя, нажать \"Отправить\"$")
    public void userTypeCorrectPhoneOfUnregisteredUser() {
        authPage.typePhoneOrEmailOfUnregisteredUser(UserData.phoneForChangePassword);
    }

    @Тогда("^пользователь вводит email зарегистрированного пользователя, нажать Отправить$")
    public void userTypeCorrectEmail() {
        authPage.typePhoneOrEmailOfUnregisteredUser(UserData.correctEmail);
    }

    @Тогда("^пользователь вводит email нового зарегистрированного пользователя, нажать Отправить$")
    public void newUserTypeCorrectEmail() {
        authPage.typePhoneOrEmailOfUnregisteredUser(TestContext.generatedEmail);
    }

    @Тогда("^пользователь вводит номер телефона нового зарегистрированного пользователя, нажать Отправить$")
    public void newUserTypePhoneOfNewUser() {
        authPage.typePhoneOrEmailOfUnregisteredUser(TestContext.correctPhone);
    }

    @Тогда("^в окне восстановления пароля выводится текст \"([^\"]*)\"$")
    public void messageAboutResetPassEmailIsDisplayed(String message) {
        authPage.messageIsDisplayed(message);
    }

    @Тогда("^в поле ввода появится подсказка \"([^\"]*)\"$")
    public void hintIsDisplayed(String hint) {
        authPage.messageIsDisplayed(hint);
    }

    @Тогда("^под полем ввода ссылка \"([^\"]*)\"$")
    public void linkIsDisplayed(String hint) {
        authPage.hintIsDislayed(hint);
    }

    @Тогда("^название кнопки изменится на \"([^\"]*)\"$")
    public void changeBtnText(String textButton) {
        authPage.seeBtnText(textButton);
    }

    @Тогда("^пользователь вводит новый пароль и нажимает Сохранить$")
    public void enterNewPasswordAndClickSave() {
        authPage.enterNewPasswordAndSave();
    }

    @Тогда("^выводится форма восстановления пароля с полем для ввода пароля и полем для повторного ввода пароля$")
    public void newPasswordFieldsAreDisplayed() {
        authPage.newPasswordFieldsAreDisplayed();
    }

    @Тогда("^пользователь нажимает на Регистрация$")
    public void userClickRegistration() {
        authPage.regClick();
    }
}
