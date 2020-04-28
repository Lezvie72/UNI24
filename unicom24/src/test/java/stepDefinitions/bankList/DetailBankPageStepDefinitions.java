package stepDefinitions.bankList;

import cucumber.api.java.ru.Дано;
import pages.banki.DetailBankPage;

public class DetailBankPageStepDefinitions {

    private final DetailBankPage detailBankPage = new DetailBankPage();

    @Дано("^отображается страница банка с предложениями$")
    public void detailPageIsDisplayed() {
        detailBankPage.pageIsDisplayed();
    }

    @Дано("^пользователь кликает на отзывы$")
    public void userClickFeedback() {
        detailBankPage.clickFeedBack();
    }

    @Дано("^пользователь кликает на отзывы предложения$")
    public void userClickFeedbackOffer() {
        detailBankPage.clickFeedBackOffer();
    }

    @Дано("^отображаются отзывы$")
    public void feedBackAreDisplayed() {
        detailBankPage.checkCountOfFeedBack();
    }

    @Дано("^пользователь кликает на кнопку Написать отзыв$")
    public void userClickLeaveCommentButton() {
        detailBankPage.leaveCommentButtonClick();
    }

    @Дано("^пользователь видит форму оставления коментария$")
    public void commentFormIsDisplayed() {
        detailBankPage.commentFormIsDisplayed();
    }

    @Дано("^пользователь заполняет форму оставления коментария$")
    public void fillCommentForm() {
        detailBankPage.fillCommentForm();
    }

    @Дано("^пользователь видет сообщение об успешной отправке коментария$")
    public void commentSuccessfullySentMessageIsDisplayed() {
        detailBankPage.commentSuccessfullySentMessageIsDisplayed();
    }

    @Дано("^проверка создания отзыва в базе данных$")
    public void commentIsInDb() {
        detailBankPage.checkCommentInDb();
    }
}
