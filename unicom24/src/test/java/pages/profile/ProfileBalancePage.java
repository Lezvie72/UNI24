package pages.profile;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;

import java.util.Arrays;
import java.util.List;

public class ProfileBalancePage extends Base {
    private final CommonVerticalsForProfilePages commonVerticalsForProfilePages = new CommonVerticalsForProfilePages();
    Header headerPage = new Header();
    Footer footerPage = new Footer();

    @FindBy(css = ".ui-user-settings-content")
    private WebElement contentPage;

    @FindBy(xpath = "//div[contains(text(), 'Счет')]")
    private WebElement scoreTab;

    @FindBy(xpath = "//div[contains(text(), 'Настройки')]")
    private WebElement settingsTab;

    @FindBy(xpath = "//button[./span[contains(text(), 'Пополнить счет')]]")
    private WebElement addMoneyBTN;

    @FindBy(xpath = "//div[@class='ui-user-settings-tab-score-selector']")
    private WebElement dateFilter;

    @FindBy(xpath = "//button[./span[contains(text(), 'Показать')]]")
    private WebElement resultFilterShowBTN;

    private final List<WebElement> elements;

    public ProfileBalancePage() {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, commonVerticalsForProfilePages);
        elements = Arrays.asList(contentPage, scoreTab, settingsTab, addMoneyBTN, dateFilter, resultFilterShowBTN);
    }

    public void pageIsDisplayed(){
        allElementsAreVisible(headerPage.getMainHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footerPage.getFooter());
    }
}
