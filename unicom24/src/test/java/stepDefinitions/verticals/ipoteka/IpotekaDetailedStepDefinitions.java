package stepDefinitions.verticals.ipoteka;

import cucumber.api.java.ru.Дано;
import pages.verticals.ipoteka.IpotekaDetailedPage;

public class IpotekaDetailedStepDefinitions {

    private final IpotekaDetailedPage ipotekaDetailedPage = new IpotekaDetailedPage();

    @Дано("отображается подробная страница Ипотеки")
    public void ipotekaDetailedPagePageIsDisplayed(){
        ipotekaDetailedPage.pageIsDisplayed();
    }
}
