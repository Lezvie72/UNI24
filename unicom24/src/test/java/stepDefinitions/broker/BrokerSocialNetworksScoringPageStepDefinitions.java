package stepDefinitions.broker;

import base.Base;
import cucumber.api.java.ru.Тогда;
import pages.brokerCabinet.BrokerCabinetPage;
import pages.brokerCabinet.BrokerSocialNetworksScoringPage;

public class BrokerSocialNetworksScoringPageStepDefinitions extends Base {

    private final BrokerSocialNetworksScoringPage brokerSocialNetworksScoringPage = new BrokerSocialNetworksScoringPage();
    private final BrokerCabinetPage brokerCabinetPage = new BrokerCabinetPage();

    @Тогда("^отображается меню Скоринг по соц.сетям$")
    public void socialNetworksScoringPageIsDisplayed() {
        brokerCabinetPage.logoMouseOver();
        brokerSocialNetworksScoringPage.pageIsDisplayed();
    }
}
