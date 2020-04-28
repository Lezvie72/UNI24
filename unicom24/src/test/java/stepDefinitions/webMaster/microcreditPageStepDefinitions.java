package stepDefinitions.webMaster;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Тогда;
import pages.WebMasterMicrocreditPage;

public class microcreditPageStepDefinitions {
    private final WebMasterMicrocreditPage webMasterMicrocreditPage = new WebMasterMicrocreditPage();

    @Дано("^вебмастер находится на странице Подберем займ на любые цели бесплатно$")
    public void onWebMasterMicrocreditPage(){
        webMasterMicrocreditPage.onWebMasterMicrocreditPage();
    }

    @Тогда("^отображется страница Подберем займ на любые цели бесплатно$")
    public void webMasterMicrocreditIsDisplayed(){
        webMasterMicrocreditPage.pageIsDisplayed();
    }
}
