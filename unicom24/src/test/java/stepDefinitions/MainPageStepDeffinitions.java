package stepDefinitions;

import base.Base;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import pages.*;
import pages.commonElementsForAllPages.Header;
import pages.verticals.common.CommonMethodsForAllVerticals;
import stepDefinitions.auth.AuthPageStepDefinitions;
import stepDefinitions.commonElementsForAllPagesStepDef.HeaderStepDef;
import stepDefinitions.profile.ProfilePageStepDefinitions;


public class MainPageStepDeffinitions extends Base {

    private final MainPage mainPage = new MainPage();
    private final CommonMethodsForAllVerticals commonMethodsForAllVerticals = new CommonMethodsForAllVerticals();
    private final Header header = new Header();

    //далее нью для одного метода "регистрируется нвоый аккаунт"
    private final HeaderStepDef headerStepDef = new HeaderStepDef();
    private final AuthPageStepDefinitions authPageStepDefinitions = new AuthPageStepDefinitions();
    private final RegistrationPageStepDefinitions registrationPageStepDefinitions = new RegistrationPageStepDefinitions();
    private final ActivationPageStepDefinitions activationPageStepDefinitions = new ActivationPageStepDefinitions();
    private final MockPageStepDefenitions mockPageStepDefenitions = new MockPageStepDefenitions();
    private final ProfilePageStepDefinitions profilePageStepDefinitions = new ProfilePageStepDefinitions();

    @Дано("^пользователь находится на главной странице$")
    public void onMainPage() {
        mainPage.onMainPage();
    }

    @Тогда("^пользователь закрывает вторую вкладку")
    public void userCloseTab() {
        closeSecondTab();
        switchToTheFirstTab();
    }

    @Тогда("^все элементы главной страницы видны$")
    public void mainPageIsDisplayed() {
        mainPage.mainPageIsDisplayed();
    }

    @Когда("^пользователь кликает на вертикаль с именем \"([^\"]*)\"$")
    public void creditCardsClicks(String nameOfVertical) {
        mainPage.verticalsClick(nameOfVertical);
    }


    @Когда("^пользователь кликает получить \"([^\"]*)\"$")
    public void getFinancialHealth(String nameOfRating) {
        mainPage.ratingReportClick(nameOfRating);
    }

    @Тогда("^пользователь авторизован$")
    public void mainPageUserIsAuthorized() {
        header.mainPageUserIsAuthorized();
    }

    @Тогда("^в шапке сайта видно Ваш баланс и Ваш рейтинг$")
    public void checkBalanceAndRating() {
        mainPage.checkBalanceAndRating();
    }

    /*
     *методы футэра
     */

    @Когда("^пользователь кликает \"([^\"]*)\" в средней части футера$")
    public void userInFooterMediumLinksClick(String nameLink){
    mainPage.userInFooterMediumLinkClick(nameLink);
        switchToTheSecondTab();
    }

    @И("^пользователь проверяет страницу \"([^\"]*)\" из средней части футера$")
    public void userInFooterMediumLinksCheck(String nameLink){
        mainPage.userInFooterMediumLinkPageCheck(nameLink);
    }

    @Тогда("^пользователь кликает \"([^\"]*)\" в нижней части футера$")
    public void userInFooterProductsClick(String nameProducts) {
        if (nameProducts.equals("Карта сайта")) {
            mainPage.clickDownProductsInFooter(nameProducts);
        } else {
            mainPage.clickDownProductsInFooter(nameProducts);
            switchToTheSecondTab();
        }

    }

    @Тогда("^пользователь кликает \"([^\"]*)\" в верхней части футера$")
    public void userClickTopLinksInFooter(String nameLinks) {
        mainPage.clickTopLinkInFooter(nameLinks);
    }

    @Тогда("пользователь делает скролл в футэру")
    public void userScrollToFooter() {
        mainPage.scrollToFooter();
    }

    /*
     *методы футэра окончены
     */

    @Тогда("^пользователь обновляет страницу$")
    public void userRefreshPage() {
        Base.refreshPage();
    }

    @Тогда("^отображается панель активации$")
    public void activationPanelIsDisplayed() {
        mainPage.activatePanelIsDisplayed();
    }

    @Тогда("^пользователь нажимает Активировать кабинет$")
    public void activateBtnClick() {
        mainPage.activateBtnClick();
    }

    @Когда("^пользователь кликает Сравнение$")
    public void comparePageClick() {
        mainPage.comparePageClick();
    }

    @И("^пользователь заходит в свой профиль$")
    public void userGoToMyProfile() {
        commonMethodsForAllVerticals.userEnterToProFilePage();
    }

    @И("^регистриуется новый аккаунт$")
    public void makeNewAccount(){
        headerStepDef.logIn();
        authPageStepDefinitions.authPageIsDisplayed();
        authPageStepDefinitions.userClickRegistration();
        registrationPageStepDefinitions.registrationPageIsDisplayed();
        registrationPageStepDefinitions.userTypePhoneAndGetPassword();
        authPageStepDefinitions.hintIsDisplayed("Пароль из смс");
        registrationPageStepDefinitions.userTypeCorrectPasswrodAndLogIn();
    }

    @И("^активируется новый аккаунт$")
    public void activationNewAccount(){
        userGoToMyProfile();
        activationPageStepDefinitions.activationPageIsDisplayed();
        activationPageStepDefinitions.typeAllData();
        activationPageStepDefinitions.userClickActivateBtn();
        activationPageStepDefinitions.messageAboutSendedEmailIsDisplayed();
        mockPageStepDefenitions.registrationActivation();
        profilePageStepDefinitions.userRegistrationComplete();

    }

    @И("^пользователь проверяет файл СОУТ с главной страницы$")
    public void userDownloadAndCheckSOUT(){
        mainPage.checkSOUTFile();
    }
}
