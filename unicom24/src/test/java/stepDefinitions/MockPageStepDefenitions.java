package stepDefinitions;

import cucumber.api.java.ru.Тогда;
import pages.mock.MailCatcher;
import pages.mock.SmsCatcher;

public class MockPageStepDefenitions {

    private final MailCatcher mailCatcher = new MailCatcher();
    private final SmsCatcher smsCatcher = new SmsCatcher();

    @Тогда("^пользователь переходит по ссылке из письма для смены пароля$")
    public void getEmailAndOpenLink() {
        mailCatcher.changePasswordByEmail();
        mailCatcher.latestEmailByToAndSubjectClick();
    }

    @Тогда("^новый пользователь переходит по ссылке из письма для смены пароля$")
    public void newUserGetEmailAndOpenLink() {
        mailCatcher.changePasswordByEmail();
        mailCatcher.latestEmailByToAndSubjectClickForNewUser();
    }

    @Тогда("^пользователь вводит пароль из смс и нажимает на \"([^\"]*)\"$")
    public void typePasswordAndClickBtn(String btn) {
        smsCatcher.typeCodeFromSmsServer(btn);
    }

    @Тогда("^пользователь переходит по ссылке для подтверждения регистрации$")
    public void registrationActivation(){
        mailCatcher.changePasswordByEmail();
        mailCatcher.registrationActivation();
    }
}
