package stepDefinitions;

import cucumber.api.java.ru.Тогда;
import pages.AboutCompany;

public class AboutCompanyStepDefinitions {

    private final AboutCompany aboutCompany = new AboutCompany();

    @Тогда("отображается страница О компании")
    public void aboutCompanyPageIsDisplayed() {
        aboutCompany.pageIsDisplayed();
    }
}
