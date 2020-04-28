package stepDefinitions.broker;

import base.Base;
import cucumber.api.java.ru.Тогда;
import pages.brokerCabinet.BrokerCabinetPage;
import pages.brokerCabinet.BrokerCreditReportPage;

public class BrokerCreditReportPageStepDefinitions extends Base {

    private final BrokerCreditReportPage brokerCreditReportPage = new BrokerCreditReportPage();
    private final BrokerCabinetPage brokerCabinetPage = new BrokerCabinetPage();

    @Тогда("^отображается страница Кредитный отчет$")
    public void creditReportPageIsDisplayed() {
        brokerCabinetPage.logoMouseOver();
        brokerCreditReportPage.pageIsDisplayed();
    }

}
