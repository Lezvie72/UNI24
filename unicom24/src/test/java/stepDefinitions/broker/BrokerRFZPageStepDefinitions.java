package stepDefinitions.broker;

import base.Base;
import cucumber.api.java.ru.Тогда;
import pages.brokerCabinet.BrokerCabinetPage;
import pages.brokerCabinet.BrokerRFZPage;

public class BrokerRFZPageStepDefinitions extends Base {

    private final BrokerRFZPage brokerRFZPage = new BrokerRFZPage();
    private final BrokerCabinetPage brokerCabinetPage = new BrokerCabinetPage();

    @Тогда("^брокер находится на странице Рейтинг финансового здоровья$")
    public void onBrokerRfzPage() {
        brokerRFZPage.onPage();
    }

    @Тогда("^отображается страница Рейтинг финансового здоровья в кабинете брокера$")
    public void rfzPageIsDisplayed() {
        brokerCabinetPage.logoMouseOver();
        brokerRFZPage.pageIsDisplayed();
    }

    @Тогда("^брокер заполняет заявку на кредитную историю другого человека$")
    public void brokerMakesApplicationForOtherPerson() {
        brokerRFZPage.makingApplication();
    }

    @Тогда("^брокер видит что отчет по полной кредитной истории создался$")
    public void brokerSeeDownloadedReport() {
        brokerRFZPage.reportIsDisplayed();
    }
}


