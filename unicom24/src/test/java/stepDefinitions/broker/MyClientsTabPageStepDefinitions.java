package stepDefinitions.broker;

import cucumber.api.java.ru.Тогда;
import pages.brokerCabinet.tabs.MyClientsTabPage;

public class MyClientsTabPageStepDefinitions {

    private final MyClientsTabPage myClientsTabPage = new MyClientsTabPage();

    @Тогда("^отображается страница Мои клиенты в кабинете брокера$")
    public void myClientsPageIsDisplayed() {
        myClientsTabPage.pageIsDisplayed();
    }
}
