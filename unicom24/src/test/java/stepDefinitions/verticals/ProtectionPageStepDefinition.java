package stepDefinitions.verticals;

import base.Base;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Тогда;
import pages.verticals.ProtectionPage;

public class ProtectionPageStepDefinition extends Base {
    private final ProtectionPage protectionPage = new ProtectionPage();

    @Тогда("^отображается страница Защита от мошенников$")
    public void protectionPageIsDisplayed(){
    protectionPage.pageIsDisplayed(); }

    @Дано("^пользователь находится на странице Защита от мошенников$")
    public void onProtectionPage(){
        protectionPage.onProtectionPage();
    }

}
