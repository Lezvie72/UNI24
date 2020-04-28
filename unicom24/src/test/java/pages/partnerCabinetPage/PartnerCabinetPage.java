package pages.partnerCabinetPage;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.partnerCabinetPage.Header.HeaderPartnerCabinetPage;
import pages.partnerCabinetPage.Tabs.*;
import pages.partnerCabinetPage.Tabs.ReportsTab.ReportsTabPage;
import pagesUrls.PagesUrls;

import java.util.Arrays;
import java.util.List;

public class PartnerCabinetPage extends Base {

    private final HeaderPartnerCabinetPage header = new HeaderPartnerCabinetPage();
    private final SettingsTabPage settingsTabPage = new SettingsTabPage();
    private final ReferenceTabPage referenceTabPage = new ReferenceTabPage();
    private final PostbackTabPage postbackTabPage = new PostbackTabPage();
    private final ProductsTabPage productsTabPage = new ProductsTabPage();
    private final LandingsTabPage landingsTabPage = new LandingsTabPage();
    private final OffersTabPage offersTabPage = new OffersTabPage();
    private final ReportsTabPage reportsTabPage = new ReportsTabPage();
    private final MyClientsTabPage myClientsTabPage = new MyClientsTabPage();

    /*
     * Верхний блок
     */
    //@FindBy(xpath = "//div[contains(@class, 'ui-app-main-header')][./div[contains(text(), 'Статистика')]]")
    //private WebElement statisticTitle; вроде как выпилили, так как на старых скринах есть, а сейчас нету

    // Анкеты походу выпилили
    //@FindBy(xpath = "//div[contains(@class, 'left')]/div[contains(text(), 'Анкеты')]")
    //private WebElement anketyTitle;

    //@FindBy(xpath = "//div[./div[contains(text(), 'от')]]//input")
    //private WebElement anketyDateFrom;

    //@FindBy(xpath = "//div[./div[contains(text(), 'до')]]//input")
    //private WebElement anketyDateTo;

    //@FindBy(xpath = "//div[contains(text(), 'Кол-во сконвертившихся анкет')]")
    //private WebElement countOfAnket;

    //@FindBy(xpath = "//div[contains(text(), 'Средняя доходность анкеты')]")
    //private WebElement middleSaldo;
    /*
    * Статистика окончена
     */


    //@FindBy(xpath = "//div[@class='home-left']")
    //private WebElement leftBlock;

    //@FindBy(xpath = "//div[contains(text(), 'Входящие')]")
    //private WebElement inputTitle;

    //@FindBy(xpath = "//div[@class='home-right']")
    //private WebElement rightBlock;

    //@FindBy(xpath = "//div[contains(text(), 'Конверсия за текущий месяц')]")
    //private WebElement currentYearTitle;

    //@FindBy(xpath = "//button[contains(text(), 'Доход')]")
    //private WebElement incomeTab;

    //@FindBy(xpath = "//button[contains(text(), 'Заявки')]")
    //private WebElement applicationsTab;


    //Новый блок на странице
    //реклама подбора кредита
    @FindBy(xpath = "//div[@class='banner']")
    private WebElement bannedOnPage;

    //Новости и акции
    @FindBy(xpath = "//div[contains(text(), 'Новости и акции')]")
    private WebElement h2TitleText;

    @FindBy(xpath = "//div[@class='ds-news']")
    private WebElement leftNewsBlock;

    @FindBy(xpath = "//div[@class='youtube-videos-wrapper']")
    private WebElement rightNewsBlock;
    //Конец нового блока с новостями и акциями

    @FindBy(xpath = "//div[contains(text(), 'Топ офферов месяца')]")
    private WebElement recomendOffer;

    @FindBy(xpath = "//a[@href=\"/partners/office/offers\"][contains(text(), 'Все офферы')]")
    private WebElement allOffersLink;

    @FindBy(xpath = "//div[contains(text(), 'Рекомендуемые лендинги')]")
    private WebElement recomendLandings;

    @FindBy(xpath = "//a[@href=\"/partners/office/landings\"][contains(text(), 'Все лендинги')]")
    private WebElement allLandingsLink;

    @FindBy(xpath = "//div[./div[contains(text(), 'Динамический лендинг')]]//button[contains(text(), 'Подключение')]")
    private WebElement connectLanding;

    @FindBy(xpath = "//div[./div[contains(text(), 'Динамический лендинг')]]//button[contains(text(), 'Описание')]")
    private WebElement landingDescriptionTab;

    @FindBy(xpath = "//div[./div[contains(text(), 'Динамический лендинг')]]//button[contains(text(), 'Настройка')]")
    private WebElement landingSettingsTab;

    @FindBy(xpath = "//div[@class='connection-wrap']")
    private WebElement landingParametersLink;

    @FindBy(xpath = "//button[contains(text(), 'Привязать')]")
    private WebElement connectLandingTab;

    @FindBy(xpath = "//div[@class='ds-offer-card']")
    private List<WebElement> offer;

    private final List<WebElement>elements;

    public PartnerCabinetPage(){
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(//statisticTitle,
                //anketyTitle, anketyDateFrom, anketyDateTo, countOfAnket, middleSaldo, //анкеты
                bannedOnPage, h2TitleText, leftNewsBlock, rightNewsBlock,
                //leftBlock, inputTitle, rightBlock, currentYearTitle, incomeTab, applicationsTab, //анкеты
                recomendOffer,
                allOffersLink, recomendLandings, allLandingsLink, connectLanding, landingDescriptionTab,
                landingSettingsTab, connectLandingTab, landingParametersLink);
    }

    public void pageIsDisplayed(){
        waitForPageLoaded(PagesUrls.webMasterPage());
        header.headerIsDisplayed();
        allElementsAreVisible(elements);
    }

    public void logOutBtnClick() {
        waitForVisibility(header.logOutBtn);
        header.logOutBtn.click();
    }

    public void giveMoneyModalClick(){
        waitForVisibility(header.getMoney);
        header.getMoney.click();
    }

    public void tabClick(String tabName){
        for (WebElement element : header.returnDownHeader()) {
            if (element.getText().equals(tabName)) {
                waitForVisibility(element);
                element.click();
            }
        }
    }

    public void tabIsDisplayed(String tabName){
        switch (tabName){
            case ("Настройки"):
                settingsTabPage.pageIsDisplayed();
                break;
            case ("Справка"):
                referenceTabPage.pageIsDisplayed();
                break;
            case ("Постбек"):
                postbackTabPage.pageIsDisplayed();
                break;
            case ("Продукты"):
                productsTabPage.pageIsDisplayed();
                break;
            case ("Лендинги"):
                landingsTabPage.pageIsDisplayed();
                break;
            case ("Офферы"):
                offersTabPage.pageIsDisplayed();
                offersTabPage.checkCountFilters();
                break;
            case ("Отчеты"):
                reportsTabPage.pageIsDisplayed();
                break;
            case ("Мои клиенты"):
                myClientsTabPage.pageIsDisplayed();
                break;
            case ("Подбор Кредита"):
                pageIsDisplayed();
                break;
        }
    }
}
