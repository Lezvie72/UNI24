package stepDefinitions.verticals.ipoteka;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import pages.verticals.ipoteka.IpotekaPage;

public class IpotekaPageStepDefinitions {

    private final IpotekaPage ipotekaPage = new IpotekaPage();

    @Дано("^пользователь находится на странице Ипотека$")
    public void onCreditsPage(){
        ipotekaPage.onIpotekaPage();
    }

    @Тогда("^отображается страница Ипотека$")
    public void ipotekaPageIsDisplayed() {
        ipotekaPage.pageIsDisplayed();
        Assert.assertTrue(ipotekaPage.offersOnPageMore0());
        Assert.assertTrue(ipotekaPage.checkH2SeoElements());
    }
}
