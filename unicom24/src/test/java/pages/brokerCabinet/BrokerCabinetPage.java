package pages.brokerCabinet;

import base.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.brokerCabinet.footer.FooterBrokerCabinetPage;
import pages.brokerCabinet.header.HeaderBrokerCabinetPage;
import pagesUrls.PagesUrls;

import java.util.Arrays;
import java.util.List;

public class BrokerCabinetPage extends Base {

    private final HeaderBrokerCabinetPage header = new HeaderBrokerCabinetPage();
    private final FooterBrokerCabinetPage footer = new FooterBrokerCabinetPage();

    @FindBy(css = ".ui-absent-block")
    private WebElement mainBlock;

    @FindBy(css = ".ui-tabs-table-online-wrapper")
    private WebElement rightBlock;

    @FindBy(xpath = "//button[./span[contains(text(), 'Спасибо, я ознакомился')]]")
    private WebElement understandBtn;

    @FindBy(css = ".ui-absent-block-close")
    private WebElement closeBtn;

//    @FindBy(xpath = "//div[contains(text(), 'Рейтинг финансового здоровья')]")
//    private WebElement rfzTitle;
//
//    @FindBy(xpath = "//button[./span[contains(text(), 'Получить')]]")
//    private WebElement getRfz;

    @FindBy(xpath = "//div[@class='yellow-block']/div/div/div[contains(text(), 'Горячие офферы')]")
    private WebElement hotOffersTitle;

    @FindBy(xpath = "//div[@class='grey-block']/div/div/div/div/img[@src=\"/static/dist/b2b_office/img/part1.e8fb163.png\"]")
    private WebElement ingriaTPLogo;

    @FindBy(xpath = "//div[@class='grey-block']/div/div/div/div/img[@src=\"/static/dist/b2b_office/img/part2.27757bf.png\"]")
    private WebElement russianUnionLogo;

    @FindBy(xpath = "//div[@class='grey-block']/div/div/div/div/img[@src=\"/static/dist/b2b_office/img/part3.962e0a8.png\"]")
    private WebElement arbLogo;

    @FindBy(xpath = "//div[@class='grey-block']/div/div/div/div/img[@src=\"/static/dist/b2b_office/img/part4.a1a6e52.png\"]")
    private WebElement russianBusiness;

    @FindBy(xpath = "//div[@class='grey-block']/div/div/div/div/img[@src=\"/static/dist/b2b_office/img/part5.9534336.png\"]")
    private WebElement blueLogo;

    /// Табы на странице брокера 09.01.2020
    @FindBy(xpath = "//a[@href='/partners/office/statistics/total']")
    private WebElement statisticsTotalTab;

    @FindBy(xpath = "//a[@href='/partners/office/offers']")
    private WebElement offersTab;

    @FindBy(xpath = "//a[@href='/partners/office/landings']")
    private  WebElement landingsTab;

    @FindBy(xpath = "//a[@href='/partners/office/cross-reports']")
    private WebElement crossReportsTab;

    @FindBy(xpath = "//a[@href='/partners/office/postback']")
    private WebElement postbackTab;

    @FindBy(xpath = "//a[@href='/partners/office/help']")
    private WebElement helpDocumentsTab;

    @FindBy(xpath = "//a[@href='/partners/office/settings']")
    private WebElement settingsTab;

    private final List<WebElement> elements;

    public BrokerCabinetPage() {
        PageFactory.initElements(driver, header);
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, footer);
        elements = Arrays.asList(mainBlock, rightBlock, understandBtn, closeBtn, hotOffersTitle,
                ingriaTPLogo, russianUnionLogo, arbLogo, russianBusiness, blueLogo);
    }

    public void onPage() {
        driver.get(PagesUrls.brokerCabinetUrl());
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(header.getHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footer.getFooter());
        int countOfOffers = driver.findElements(By.cssSelector(".ui-card-hot_offers-contect__offer")).size();
        Assert.assertEquals(4, countOfOffers);
    }

    public void tabMenuHeaderClick(String nameOfTab) {
        String xPath = String.format("//div[@class='ui-menu']/div[contains(text(), '%s')]", nameOfTab);
        WebElement element = driver.findElement(By.xpath(xPath));
        waitForVisibility(element);
        element.click();
    }

    public void tabMenuHeaderMouseOver(String nameOfTab) {
        String xPath = String.format("//div[@class='ui-menu']/div[contains(text(), '%s')]", nameOfTab);
        WebElement element = driver.findElement(By.xpath(xPath));
        waitForVisibility(element);
        mouseOver(element);
    }


    public void allServicesMenuIsDisplayed() {
        waitForAllAjaxElementIsVisible(header.getSubMenuElements());
        Assert.assertEquals(7, header.getSubMenuElements().size());
    }

    public void finRatingSubMenuIsDisplayed() {
        waitForAllAjaxElementIsVisible(header.getSubMenuElements());
        Assert.assertEquals(4, header.getSubMenuElements().size());

    }

    public void autoSubMenuIsDisplayed() {
        waitForAllAjaxElementIsVisible(header.getSubMenuElements());
        Assert.assertEquals(1, header.getSubMenuElements().size());
    }

    public void scoringMenuIsDisplayed() {
        waitForAllAjaxElementIsVisible(header.getSubMenuElements());
        Assert.assertEquals(2, header.getSubMenuElements().size());
    }

    public void submenuItemClick(String subMenuElement) {
        for (WebElement element : header.getSubMenuElements()) {
            waitForVisibility(element);
            if (element.getText().equals(subMenuElement)) {
                element.click();
            }
        }
    }

    public void logoMouseOver() {
        waitForVisibility(header.logo);
        mouseOver(header.logo);
    }

    public void giveMoneyBtnClick() {
        waitForVisibility(header.giveMoneyBtn);
        header.giveMoneyBtn.click();
    }

    public void giveMoneyPanelIsDisplayed() {
        allElementsAreVisible(header.giveMoneyPanel());
    }

    public void giveMoneyPanelIsNotDisplayed() {
        waitForInvisibilityOfAllElements(header.giveMoneyPanel());
    }

    public void dropMenuClick() {
        waitForVisibility(header.dropMenu);
        header.dropMenu.click();
    }

    public void logOutClick() {
        waitForVisibility(header.logoutBtn);
        header.logoutBtn.click();
    }

    public void profileClick() {
        waitForVisibility(header.profileLink);
        header.profileLink.click();
    }

    //Код от 09.01.2020
    public void brokerStatisticsTotalTabClick(){
        statisticsTotalTab.click();
    }

    public void brokerOffersTabClick(){
        offersTab.click();
    }

    public void brokerLandingsTabClick(){
        landingsTab.click();
    }

    public void brokerCrossReportsTabClick(){
        crossReportsTab.click();
    }

    public void brokerPostbackTabClick(){
        postbackTab.click();
    }

    public void brokerHelpDocumentsTabClick(){
        helpDocumentsTab.click();
    }

    public void brokerSettingsTabClick(){
        settingsTab.click();
    }

    public void brokerStatisticsTotalTabIsDisplayed(){
        //
    }

    public void brokerOffersTabIsDisplayed(){
        //
    }

    public void brokerLandingsTabIsDisplayed(){
        //
    }

    public void brokerCrossReportsTabIsDisplayed(){
        //
    }

    public void brokerPostbackTabIsDisplayed(){
        //
    }

    public void brokerHelpDocsTabIsDisplayed(){
        //
    }

    public void brokerSettingsTabIsDisplayed(){
        //
    }
}
