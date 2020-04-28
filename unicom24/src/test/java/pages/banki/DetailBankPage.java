package pages.banki;

import base.Base;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;
import pages.commonElementsForAllPages.UserData;
import pagesUrls.PagesUrls;
import util.DbUtil;

import java.util.Arrays;
import java.util.List;

public class DetailBankPage extends Base {

    Header headerPage = new Header();
    Footer footerPage = new Footer();

    @FindBy(xpath = "//div[@class='ui-forms-bank-detail-header-top']")
    private WebElement headerOfBank;

    @FindBy(xpath = "//section[@class='info']")
    private WebElement headerOfBankFullView;

    @FindBy(xpath = "//div[@class='ui-forms-bank-detail-header-bottom font__h4 font__color-blue']/a[contains(text(), 'Отзывы')]")
    public WebElement feedBackBtn;

    @FindBy(xpath = "//section[@class='menu__wrapper']/a[contains(text(), 'Отзывы')]")
    public WebElement feedBackBtnFullView;

    @FindBy(xpath = "//div[@class='ui-forms-bank-detail-review__header']")
    private WebElement feedBackHeader;

    @FindBy(xpath = "//div[contains(text(), 'Нет отзывов')]")
    private WebElement thereIsNoFeedbackTitle;

    @FindBy(xpath = "//button[@class='reviews-tab__btn ui-btn font__base yellow']")
    private WebElement leaveCommentButton;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement nameInputField;

    @FindBy(xpath = "//div[@name='text']/textarea")
    private WebElement textInputArea;

    @FindBy(xpath = "//div[contains(text(), 'Ваша оценка')]/following-sibling::div//span[5]")
    private WebElement fiveStarRating;

    @FindBy(xpath = "//button[@disabled='disabled']")
    private WebElement disabledPublishCommentButton;

    @FindBy(xpath = "//span[contains(text(), 'Опубликовать отзыв')]/ancestor::button")
    private WebElement enabledPublishCommentButton;

    @FindBy(xpath = "//div[contains(text(), 'Отзыв отправлен. Дождитесь проверки модератора.')]")
    private WebElement commentSuccessfullySentMessage;

    public final List<WebElement> elements;
    public final List<WebElement> commentFormElements;

    public DetailBankPage() {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, headerPage);
        PageFactory.initElements(driver, footerPage);
        elements = Arrays.asList(headerOfBank, feedBackBtn);
        commentFormElements = Arrays.asList(nameInputField, textInputArea, fiveStarRating, disabledPublishCommentButton);
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(headerPage.getMainHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footerPage.getFooter());
    }

    public void commentFormIsDisplayed() {
        allElementsAreVisible(commentFormElements);
    }

    public void fillCommentForm() {
        typeIntoField(UserData.nameRU, nameInputField);
        typeIntoField(UserData.commentText, textInputArea);
        click(fiveStarRating);
        click(enabledPublishCommentButton);
    }

    public void clickFeedBack() {
        click(feedBackBtn);
    }

    public void clickFeedBackOffer() {
        click(feedBackBtnFullView);
    }

    public void leaveCommentButtonClick() {
        click(leaveCommentButton);
    }

    public void commentSuccessfullySentMessageIsDisplayed() {
        waitForVisibility(commentSuccessfullySentMessage);
    }

    public void checkCommentInDb() {
        switch (PagesUrls.base) {
            case "release-01.vuaro.ru":
                System.out.println("На релизном сервере не проводится проверка записи коментария в БД");
                break;
            case "release-02.vuaro.ru":
                System.out.println("На релизном сервере не проводится проверка записи коментария в БД");
                break;
            case "pre-prod.vuaro.ru":
                System.out.println("На препроде не проводится проверка записи коментария в БД");
                break;
            default:
                String commentTextFromDb = DbUtil.getLastCommentText();
                Assert.assertEquals(commentTextFromDb, UserData.commentText);
                break;
        }
    }

    public void checkCountOfFeedBack() {
        try {
            waitForAjaxElementIsVisible(feedBackHeader);
        } catch (Exception e) {
            waitForVisibility(thereIsNoFeedbackTitle);
        }
    }
}
