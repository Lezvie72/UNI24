package pages.advCabinet;

import testContext.TestContext;
import base.Base;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.advCabinet.Header.HeaderAdvPage;
import pagesUrls.PagesUrls;

import java.util.Arrays;
import java.util.List;

public class AdvPage extends Base {

    private final HeaderAdvPage header = new HeaderAdvPage();

    @FindBy(xpath = "//a[contains(text(), 'Отчеты')]")
    private WebElement reportsTab;

    @FindBy(xpath = "//div[@class='default-layout-view']//a[contains(text(), 'Заявки')]")
    private WebElement applicationsTitle;

    @FindBy(xpath = "//div[contains(text(), 'Все предложения')]")
    private WebElement offersOptions;

    @FindBy(xpath = "//div[contains(text(), 'Период')]")
    private WebElement periodOptions;

    @FindBy(xpath = "//div[contains(text(), 'Тип кредита')]")
    private WebElement typeOfCredit;

    @FindBy(id = "searchById")
    private WebElement searchField;

    @FindBy(xpath = "//button[contains(text(), 'Поиск')]")
    private WebElement searchBtn;

    @FindBy(xpath = "//div[contains(@class, 'requests-view-navigation ')]//a")
    private List<WebElement> tabs;

    private final List<WebElement> elements;

    public AdvPage() {
        PageFactory.initElements(driver, header);
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(applicationsTitle, offersOptions, periodOptions, typeOfCredit, searchField, searchBtn);
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(header.getAdvHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(tabs);
        Assert.assertEquals(tabs.size(), 8);
    }

    public void reportsTabClick() {
        checkReportsTabIsVisible();
        if (TestContext.reportsTabIsVisible == 1) {
            reportsTab.click();}
    }

    public void dropMenuClick() {
        waitForVisibility(header.dropMenu);
        header.dropMenu.click();
    }

    public void dropMenuLogOutClick() {
        waitForVisibility(header.dropMenuLogOut);
        header.dropMenuLogOut.click();
    }

    public void giveMoneyBtnClick(){
        waitForVisibility(header.giveMoneyBtn);
        header.giveMoneyBtn.click();
    }

    public void onCabinetOfBanksAndAdvPage(){
    driver.get(PagesUrls.bankirAuth());}

    public void checkReportsTabIsVisible(){
        if (isElementVisible(reportsTab)) {
        TestContext.reportsTabIsVisible = 1;
    } else TestContext.reportsTabIsVisible = 0;}

}
