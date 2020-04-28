package stepDefinitions.broker;

import base.Base;
import cucumber.api.java.ru.Тогда;
import pages.brokerCabinet.BrokerCabinetPage;
import pages.brokerCabinet.BrokerPhoneNumberScoring;

    public class BrokerPhoneNumberScoringStepDefinitions extends Base {

    private final BrokerPhoneNumberScoring brokerPhoneNumberScoring = new BrokerPhoneNumberScoring();
    private final BrokerCabinetPage brokerCabinetPage = new BrokerCabinetPage();

    @Тогда("^отображается страница Скоринг по номеру телефона$")
    public void phoneNumberPageIsDisplayed() {
        brokerCabinetPage.logoMouseOver();
        brokerPhoneNumberScoring.pageIsDisplayed();
    }
}
