package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.verticals.common.CommonElementsForAllVerticals;
import pages.verticals.microCredits.MicroCreditsPage;

import java.util.Arrays;
import java.util.List;

public class WebMasterOfferFullPage extends Base {
    CommonElementsForAllVerticals commonElementsAll = new CommonElementsForAllVerticals();
    MicroCreditsPage microCreditsPage = new MicroCreditsPage();

    String wayTypeBTNForClick = "//div[@class='link-types']";

    @FindBy(xpath = "//div[@class='ds-offer-card-wrap detail']")
    private WebElement offerWrapper; //основной блок оффера

    @FindBy(xpath = "//div[@class='offers-detail-child']")
    private WebElement offerContainerWrapper; //содержание вкладки

    @FindBy(xpath = "//div[@class='offers-detail-breadcrumbs']")
    private WebElement offerFullPageBreadcrumbs; // хлебные крошки

    @FindBy(xpath = "//div[@class='offers-detail-child']/div[@class='offers-description-view']")
    private WebElement offerContentProfile;

    @FindBy(xpath = "//div[@class='offers-detail-child']//div[@class='offers-description font__base-small']")
    private WebElement offerContentAboutCompany;

    @FindBy(xpath = "//div[@class='offers-connection-referral']")
    private WebElement offerContentConnectREF;

    @FindBy(xpath = "//div[@class='offers-connection-api']")
    private WebElement offerContentConnectAPI;

    @FindBy(xpath = "//div[@class='offers-tariffs-and-changes-view']")
    private WebElement offerContentTariff;

    @FindBy(xpath = "//div[@class='offers-types-of-traffic-view']")
    private WebElement offerContentTraffic;

    @FindBy(xpath = "//div[@class='offers-regions-view']")
    private WebElement offerContentRegions;

    @FindBy(xpath = "//div[@class='offers-reviews-view']")
    private WebElement offerContentFeedback;

    @FindBy(xpath = "//div[@class='fake inset']")
    private WebElement wayForLink;

    @FindBy(xpath = "//div[@class='ds-offer-card-wrap detail']//span[contains(text(), 'REF')]")
    private List<WebElement> offerOfREF;

    @FindBy(xpath = "//div[@class='navigation detail']/a")
    private List<WebElement> tabsOnOfferFullPage;

    //дурацкое окно ваш персональный менеджер, нужно для закрытия - мешает выполнить тест
    @FindBy(css = "div.close em")
    private WebElement yourPersonalManagerClose;

    private final List<WebElement> elements;

    public WebMasterOfferFullPage() {
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(offerWrapper, offerContainerWrapper, offerFullPageBreadcrumbs);
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(elements);
    }

    public void tabOnOffersFullPageClick(String tabName) { // клик по вкладке с названием из переменной
        for (WebElement element : tabsOnOfferFullPage) {
            if (element.getText().equals(tabName)) {
                element.click();
            }
        }
    }

    public void tabContentIsDisplayed(String tabName) { //ожидание отображение вкладки с названием из переменной
        switch (tabName) {
            case ("Об анкете"):
                waitForVisibility(offerContentProfile);
                break;
            case ("О компании"):
                waitForVisibility(offerContentAboutCompany);
                break;
            case ("Подключение"):
                if (offerOfREF.size() > 0) {
                    waitForVisibility(offerContentConnectREF);
                } else {
                    waitForVisibility(offerContentConnectAPI);
                }
                break;
            case ("Тарифы и изменения"):
                waitForVisibility(offerContentTariff);
                break;
            case ("Виды трафика"):
                waitForVisibility(offerContentTraffic);
                break;
            case ("Регионы"):
                waitForVisibility(offerContentRegions);
                break;
            case ("Отзывы"):
                waitForVisibility(offerContentFeedback);
                break;
            default:
                waitForVisibility(offerContainerWrapper);
                break;
        }
    }

    public void checkingTabsOnFullOfferPage() { // проверка вкладок
        String tabName;
        int tabCount = tabsOnOfferFullPage.size();
        for (int i = 1; i < tabCount; i++) {
            if (isElementVisible(yourPersonalManagerClose)) //закрываем окно которое может мешать кликнуть на элемент
                yourPersonalManagerClose.click();

            tabName = tabsOnOfferFullPage.get(i).getText();
            tabsOnOfferFullPage.get(i).click();
            tabContentIsDisplayed(tabName);
        }
    }

    public void checkingLinkOnFullOfferPage(String targetNameLink) {
        WebElement element = driver.findElement(By.xpath("//div[@class='fake inset']"));
        String firstText = element.getText();
        String targetBTN = String.format(wayTypeBTNForClick + "//button[contains(text(), '%s')]", targetNameLink);
        driver.findElement(By.xpath(targetBTN)).click();
        waitForTextChanged(firstText, By.xpath("//div[@class='fake inset']"));
        String wayTextUrl = wayForLink.getText();
        openNewTab();
        switchToTheSecondTab();
        driver.get(wayTextUrl);
        waitForPageLoaded(driver.getCurrentUrl());
        microCreditsPage.locationIsDisplayed();
        closeTab();
        switchToTheFirstTab();
    }

}