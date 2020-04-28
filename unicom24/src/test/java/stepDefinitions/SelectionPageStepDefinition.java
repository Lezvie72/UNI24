package stepDefinitions;

import base.Base;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import pages.SelectionPage;
import pages.verticals.common.CommonMethodsForAllVerticals;

public class SelectionPageStepDefinition extends Base {
    private final SelectionPage selectionPage = new SelectionPage();
    private final CommonMethodsForAllVerticals commonMethodsForAllVerticals = new CommonMethodsForAllVerticals();

    @Когда("^пользователь переходит на страницу персонального подбора Кредита$")
    public void onSelectionPage(){
        selectionPage.onSelectionPage();
    }

    @Тогда("^отображается страница персонального подбора$")
    public void selectionPageIsDisplayed(){
        selectionPage.pageIsDisplayed();
    }

    @Когда("пользователь кликает на кнопку Подобрать на странице персонального подбора")
    public void selectionBTNClick(){
        selectionPage.selectionBTNClick();
    }

    @Тогда("отображается модальное окно обработки персональных данных на странице персонального подбора")
    public void selectionPagePreloadIsDisplayed(){
        selectionPage.selectionPreloadIsDisplayed();
    }

    @И("отображается страница результатов персонального подбора")
    public void selectionResultsIsDisplayed(){
        commonMethodsForAllVerticals.bestOfferPageIsDisplayed();
    }

    @И("пользователь вводит данные на странице персонального подбора")
    public void userDataTypeOnSelectionPage(){
        selectionPage.userDataTypeToInputs();
    }

    @И("пользователь видит форму ввода кода из смс на странице персонального подбора")
    public void formSMSCodeSelectionIsDisplayed(){
        selectionPage.formForSMSCodeIsDisplayed();
    }

    @И("пользователь вводит код из смс в форму на странице персонального подбора")
    public void formSMSCodeTypeSelection(){
        selectionPage.InputSMSCodeForSelection();
    }

    @Когда("^пользователь кликает далее в форме ввода смс на странице персонального подбора$")
    public void nextBTNSelectionPageClick(){
        selectionPage.selectionNextBTNClick();
    }
}
