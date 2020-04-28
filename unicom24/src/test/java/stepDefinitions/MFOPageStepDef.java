package stepDefinitions;

import cucumber.api.java.ru.Тогда;
import pages.MFOPage;

public class MFOPageStepDef {

    private final MFOPage mfoPage = new MFOPage();

    @Тогда("^отображается страница Микрофинансовые организации$")
    public void cashServicePageIsDisplayed() {
        mfoPage.pageIsDisplayed();
    }
}
