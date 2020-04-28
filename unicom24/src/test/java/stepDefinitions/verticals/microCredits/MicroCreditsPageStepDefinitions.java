package stepDefinitions.verticals.microCredits;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import pages.verticals.microCredits.MicroCreditsPage;

public class MicroCreditsPageStepDefinitions {

    private final MicroCreditsPage microCreditsPage = new MicroCreditsPage();

    @Дано("^пользователь находится на странице Микрозаймы$")
    public void onCreditsPage(){
        microCreditsPage.onMicroCreditsPage();
    }

    @Тогда("^отображается страница Микрозаймы$")
    public void microCreditsIsDisplayed() {
        microCreditsPage.pageIsDisplyed();
        Assert.assertTrue(microCreditsPage.offersOnPageMore0());
        Assert.assertTrue(microCreditsPage.checkH2SeoElements());
    }

    @И("^отображается сообщение: Поле обязательно для заполнения$")
    public void userSeeErrorText() {
        microCreditsPage.seeErrorText();
    }

    @Тогда("^пользователь вводит неккоректный номер и отправляет форму$")
    public void userTypeIncorrectNumber() {
        microCreditsPage.typeIncorrectNumber();
    }

    @Когда("^пользователь вводит корректный номер и отправляет форму$")
    public void userSendFormWithCorrectNumber() {
        microCreditsPage.sendFormWithCorrectNumber();
    }

    @Когда("^отображается сообщение об отправленном смс$")
    public void smsHasBeenSentMessageIsDisplayed() {
        microCreditsPage.smsHasBeenSent();
    }

    @Когда("^пользователь запрашивает код повторно$")
    public void userAskCodeAgain() {
        microCreditsPage.askCodeAgain();
    }

    @Когда("^пользователь вводит смс из первого сообщения$")
    public void userTypePreviousCode() {
        microCreditsPage.typePreviousCode();
    }

    @Тогда("^отображается форма для определения вероятности выдачи$")
    public void approvedSmsFormIsDisplayed() {
        microCreditsPage.approvedSmsFormIsDisplayed();
    }

    @Когда("^пользователь нажимает кнопку Персональный займ$")
    public void userClicksPersonalCreditBtn() {
        microCreditsPage.personalCreditsBtnClick();
    }
}
