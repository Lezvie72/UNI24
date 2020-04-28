package stepDefinitions.verticals;

import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.support.FindBy;
import pages.verticals.PersonalCreditPage;

public class PersonalCreditStepDefinition {
    private final PersonalCreditPage personalCreditPage = new PersonalCreditPage();

    @Тогда("^отображается страница Персональный подбор кредита$")
    public void personalCreditIsDisplayed() {
        personalCreditPage.pageIsDisplayed();
    }

}
