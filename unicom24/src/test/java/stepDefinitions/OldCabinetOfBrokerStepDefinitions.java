package stepDefinitions;

import base.Base;
import cucumber.api.java.ru.Тогда;
import pages.oldCabinetOfBroker.OldCabinetOfBrokerPage;

public class OldCabinetOfBrokerStepDefinitions extends Base {

    private final OldCabinetOfBrokerPage oldCabinetOfBrokerPage = new OldCabinetOfBrokerPage();

    @Тогда("^отображается старый кабинет брокера$")
    public void oldCabinetOfBrokerIsDisplayed(){
        oldCabinetOfBrokerPage.pageIsDisplayed();
    }
}
