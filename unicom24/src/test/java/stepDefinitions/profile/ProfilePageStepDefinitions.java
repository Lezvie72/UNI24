package stepDefinitions.profile;

import base.Base;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import cucumber.api.java.ru.Когда;
import pages.profile.*;
import pages.verticals.common.CommonElementsForAllVerticals;
import pages.verticals.common.CommonMethodsForAllVerticals;

public class ProfilePageStepDefinitions extends Base {
    private final ProfilePage profilePage = new ProfilePage();
    private final PersonalDataProfilePage personalDataProfilePage = new PersonalDataProfilePage();
    private final SubscriptionsProfilePage subscriptionsProfilePage = new SubscriptionsProfilePage();
    private final CommonVerticalsForProfilePages commonVerticalsForProfilePages = new CommonVerticalsForProfilePages();
    private final CommonMethodsForAllVerticals commonMethodsForAllVerticals = new CommonMethodsForAllVerticals();
    private final ProfileBalancePage profileBalancePage = new ProfileBalancePage();
    private final ActivatePage activatePage = new ActivatePage();

    @Тогда ("^отображается главная страница Профиля$")
    public void profilePageIsDisplayed() {
        profilePage.pageIsDisplayed();
    }

    @Когда("^пользователь кликает по вкладке \"([^\"]*)\" в профиле")
    public void removeBanksCreditsRemoveFromCompare(String nameVerticalPage) {
        commonVerticalsForProfilePages.verticalPageClick(nameVerticalPage);
    }

    @Тогда("^отображается личные данные на странице Профиль")
    public void personalDataProfilePage(){
       personalDataProfilePage.pageIsDisplayed();
    }

    @Тогда("^отображается страница Подписки в профиле")
    public void subscriptionsProfilePage(){
        subscriptionsProfilePage.pageIsDisplayed();
    }

    @Когда("^пользователь нажимает на Баланс на странице профиля$")
    public void userProfileBalanceClick(){
        profilePage.profileUserBalanceClick();
    }

    @Тогда("^отображается страница Баланс в профиле$")
    public void userBalancePageIsDisplayed(){
        profileBalancePage.pageIsDisplayed();
    }

    @Когда("^пользователь нажимает Баланс в раскрываемом списке профиля$")
    public void userBalanceClickInList(){
        commonMethodsForAllVerticals.userEnterToProfileScorePage();
    }

    @Тогда("^отображается страница успешной активации аккаунта$")
    public void userRegistrationComplete(){
        activatePage.pageIsDisplayed();
    }

    @И("^пользователь разлогинивается$")
    public void userLeaveProfile(){
        commonMethodsForAllVerticals.userQuitFromProfilePage();
    }
}
