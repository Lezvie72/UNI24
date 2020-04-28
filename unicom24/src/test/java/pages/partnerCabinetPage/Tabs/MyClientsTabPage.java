package pages.partnerCabinetPage.Tabs;

import base.Base;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.partnerCabinetPage.Header.HeaderPartnerCabinetPage;

import java.util.Arrays;
import java.util.List;

public class MyClientsTabPage extends Base {
    private final HeaderPartnerCabinetPage header = new HeaderPartnerCabinetPage();

    @FindBy(xpath = "//div[contains(text(), 'Мои клиенты')]")
    private WebElement myClientsTitle;

    @FindBy(xpath = "//div[@class='menu']")
    private WebElement panelWithTabs;

    @FindBy(xpath = "//div[@class='table']")
    private WebElement listOfTab;

    @FindBy(xpath = "//div[@class='ds-input-search']//input")
    private WebElement inputFieldTab;

    @FindBy(xpath = "//div[@class='filter-button ds-button-wrapper']")
    private List<WebElement> buttonsTabs;

    private final List<WebElement> elements;

    public MyClientsTabPage() {
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(myClientsTitle, panelWithTabs, listOfTab, inputFieldTab);
    }

    public void pageIsDisplayed() {
        header.headerIsDisplayed();
        allElementsAreVisible(elements);
        Assert.assertEquals(buttonsTabs.size(),6);
    }
}
