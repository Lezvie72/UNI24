package stepDefinitions;

import base.Base;
import cucumber.api.java.ru.Тогда;
import pages.BecomeAgentPage;

public class BecomeAgentPageStapDefinitions extends Base {

    private final BecomeAgentPage becomeAgentPage = new BecomeAgentPage();

    @Тогда("^отображается страница Стать агентом$")
    public void becomeAgentPageIsDisplayed(){
        becomeAgentPage.pageIsDisplayed();
    }
}
