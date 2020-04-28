package stepDefinitions.verticals.credits;

import base.Base;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import pages.verticals.common.CommonMethodsForAllVerticals;
import pages.verticals.credits.CreditsPage;

public class CreditsPageStepDefinitions extends Base {

    private final CreditsPage creditsPage = new CreditsPage();
    private final CommonMethodsForAllVerticals commonMethods = new CommonMethodsForAllVerticals();

    @Тогда("^отображается страница Кредиты$")
    public void creditsPageIsDisplayed() {
        creditsPage.pageIsDisplayed();
        Assert.assertTrue(creditsPage.offersOnPageMore0());
        Assert.assertTrue(creditsPage.checkH2SeoElements());
    }

    @Тогда("^пользователь кликает на название банка$")
    public void userClickTitleOfBankClick(){
        creditsPage.titleOfBankClick();
    }

    @Когда("^пользователь нажимает Подробнее в оффере$")
    public void userClickDetailedInOffer() {
        commonMethods.clickShowMoreBtn();
    }

    @Тогда("^открывается дополнительная информация об оффере$")
    public void addInfoOpened() {
        commonMethods.addInfoIsDisplayed();
    }

    @Тогда("^пользователь нажимает Перейти$")
    public void userClickGotoAddInfoLink() {
        commonMethods.gotoAddInfoLinkClick();
    }


    @Дано("^пользователь находится на странице Кредиты$")
    public void onCreditsPage(){
        creditsPage.onCreditsPage();
    }

    @Тогда("^пользователь проверяет что переходы работают$")
    public void userTestRedirects(){
        Assert.assertTrue(driver.getCurrentUrl(), creditsPage.checkRedirects());
    }

    @И("^пользователь добавляет \"([^\"]*)\" банков в сравнение")
    public void userAddToCompareFirstBank(String numberOfBanksForAddToCompare){
        creditsPage.banksForAddToCompareCreditsClick(numberOfBanksForAddToCompare);
    }
    @И("^пользователь выбирает локацию \"([^\"]*)\"")
    public void userChangeLocation(String selectCity){
        commonMethods.userChangeLocationCity(selectCity);
    };

    @И("^пользователь кликает на Подобрать на странице Кредиты$")
    public void userPodobratClick(){
        creditsPage.podobratCreditClick();
    }

    @Тогда("^пользователь видит форму ввода кода из смс в подборе кредита$")
    public void nonUserPodborCreditFormSmsConfirmIsDisplayed(){
        creditsPage.podobrCreditFormSmsConfirmIsDisplayed();
    }

    @Когда("^пользователь видит форму с персональными данными зарегистрированного пользователя в подборе кредита$")
    public void userPodborCreditFormStep2IsDisplayed(){
        creditsPage.podborCreditFormStep2IsDisplayed();
    }

    @Тогда("^пользователь кликает Далее в форме с персональными данными зарегистрированного пользователя в подборе кредита$")
    public void userPodborCreditNextClick(){
        creditsPage.podborCreditNextClick();
    }

    @Когда("^пользователь видит форму с паспортными данными зарегистрированного пользователя в подборе кредита$")
    public void userPodborCreditFormStep3IsDisplayed(){
        creditsPage.podborCreditFormStep3IsDisplayed();
    }

    @Тогда("^пользователь кликает Показать предложения в форме с паспортными данными зарегистрированного пользователя в подборе кредита$")
    public void userPodborCreditStep3Click(){
        creditsPage.podborCreditResultsDisplayedClick();
    }

    @Когда("^пользователь вводит номер телефона в форме подбора кредита$")
    public void userPodborCreditNumberFonInput(){
        creditsPage.podborCreditInputFonField();
    }

    @И("^пользователь кликает Далее в форме подбора кредита для не зарегистрованного пользователя$")
    public void userPodborCreditFonNext(){
        creditsPage.podborCreditNextClick();
    }

    @Когда("^пользователь видит форму ввода кода из смс для не зарегистрированного пользователя в подборе кредита$")
    public void nonUserPodborCreditFormForSMSCodeIsDisplayed(){
        creditsPage.podborCreditFormForSMSCodeIsDisplayed();
    }

    @Тогда("^пользователь вводит код из смс в форму для не зарегистрированного пользователя в подборе кредита$")
    public void nonUserPodborCreditInputSMSToForm(){
        creditsPage.InputSMSCodeForPodborCredit();
    }

    @Когда("^пользователь видит форму заполнения персональных данных для не зарегистрированного пользователя в подборе кредита$")
    public void nonUserPodborCreditStep2IsDisplayed(){
        creditsPage.podborCreditFormStep2IsDisplayed();
    }

    @Тогда("^пользователь заполняет персональные данные для не зарегистрированного пользователя в подборе кредита$")
    public void nonUserPodborCreditInputTextToFieldsOnStep2(){
        creditsPage.nonUserPodborCreditTypeTextStep2();
    }

    @Когда("^пользователь видит форму с паспортными данными для не зарегистрированного пользователя в подборе кредита$")
    public void nonUserPodborCreditFormStep3IsDisplayed(){
        creditsPage.podborCreditFormStep3IsDisplayed();
    }

    @Тогда("^пользователь вводит данные в форму с паспортными данными для не зарегистрированного пользователя в подборе кредита$")
    public void nonUserPodborCreditInputTextToFieldsOnStep3(){
        creditsPage.nonUserPodborCreditInputTextStep3();
    }

    @И("^пользователь кликает Показать предложения в форме с паспортными данными для не зарегистрированного пользователя в подборе кредита$")
    public void nonUserPodborCreditFormStep3NextClick(){
        creditsPage.podborCreditResultsDisplayedClick();
    }

    @И("^пользователь ожидает отображения результатов подбора кредитов$")
    public void userWaitingResultsOfPodborCredit(){
        creditsPage.userWaitingResultsPodborCredits();
    }

}
