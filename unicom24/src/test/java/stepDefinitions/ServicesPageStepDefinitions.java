package stepDefinitions;

import base.Base;
import cucumber.api.java.uk.Дано;
import pages.ServicesPage;

public class ServicesPageStepDefinitions extends Base {

    private final ServicesPage servicesPage = new ServicesPage();

    @Дано("^отображается страница Сервисы$")
    public void servicesPageIsDisplayed(){
        servicesPage.pageIsDisplayed();
    }
}
