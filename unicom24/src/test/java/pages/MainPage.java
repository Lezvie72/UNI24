package pages;

import api.AdminBalance;
import base.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;
import pagesUrls.PagesUrls;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MainPage extends Base {

    private final Header headerPage = new Header();
    private final Footer footerPage = new Footer();

    public WebElement ajaxEl(By xPath) {
        return driver.findElement(xPath);
    }

    public By selectorForAjax() {
        return By.xpath("//div");
    }

    //Главный баннер вверху
    @FindBy(css = ".app-main-fold  .glide__slide.glide__slide--active")
    private WebElement banner;

    @FindBy(className = "app-main-fold-glide-button__left")
    private WebElement leftScrollBannerBtn;

    @FindBy(className = "app-main-fold-glide-button__right")
    private WebElement rightScrollBannerBtn;

    @FindBy(css = ".app-main-fold  .glide__slide.glide__slide--active button")
    private WebElement yellowBannerBtn;

    @FindBy(xpath = "//a[@class=\"main-fold-link\"]/div")
    private List<WebElement> mainOffersBtns;

    @FindBy(css = ".ui-app-content h2")
    private List<WebElement> h2;

    @FindBy(css = ".app-tabs-list a")
    private List<WebElement> bestOffersTabs;

    @FindBy(xpath = "//a[@class='app-tab active']")
    private WebElement bestOffersFirstElement;

    //карточки лучших предложений
    @FindBy(xpath = "//li[contains(@class, 'glide__slide')]/a") // исправил, так как определял не точно
    private List<WebElement> bestOffersCards;

    //Блок инструкции
    @FindBy(css = ".app-instructions")
    private WebElement instructionsBlock;

    //4 кружочка в инструкциях
    @FindBy(css = ".app-instructions .app-instructions-block-number__number")
    private List<WebElement> instructionsRounds;

    //Кнопка подобрать кредит в инструкциях
    @FindBy(css = ".app-instructions button")
    private WebElement instructionBtn;

    //4 блока с жетлытми кнопками каждый ниже
    @FindBy(css = ".app-landing-cards-item")
    private List<WebElement> blocks;

    //Блок Блог
    @FindBy(css = ".app-blog")
    private WebElement blog;

    //4 карточки блога
    @FindBy(css = ".app-blog a.app-blog-list-item")
    private List<WebElement> blogCards;

    //Кнопка в блоге
    @FindBy(css = ".app-blog button")
    private WebElement blogBtn;

    //блок скачайте приложение
    @FindBy(css = ".app-mobile-apps-wrapper")
    private WebElement mobileApp;

    //сео блок
    @FindBy(css = ".app-seo-links a")
    private List<WebElement> seoLinks;

    @FindBy(css = ".app-seo-links-list-title")
    private List<WebElement> seoTitles;

    @FindBy(xpath = "//div[contains(text(), 'Ваш баланс')]")
    private WebElement yourBalanceField;

    @FindBy(xpath = "//header//div[contains(text(), 'Рейтинг')]")
    private WebElement ratingField;

    @FindBy(xpath = "//div[contains(text(), 'Рейтинг бесплатно')]")
    private WebElement ratingFreeLink;

    //Количетсов денег на счету в хедере
    @FindBy(css = ".ui-dropdown-rating-data-balance-value__value.font__base-small")
    private WebElement moneyValue;

    /*
     *Панель активации
     */
    @FindBy(css = "section.activate-panel")
    private WebElement activatePanelContainer;

    @FindBy(xpath = "//div[contains(text(), 'Чтобы пользоваться всеми функциями сервиса, активируйте личный кабинет')]")
    private WebElement activateText;

    @FindBy(xpath = "//button[./span[contains(text(), 'Активировать кабинет')]]")
    private WebElement activateBtn;
    /*
     *Панель активации окончена
     */

    private final List<WebElement> elements;
    private List<WebElement> activatePanel;

    public MainPage() {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, headerPage);
        PageFactory.initElements(driver, footerPage);
        elements = Arrays.asList(banner, leftScrollBannerBtn, rightScrollBannerBtn, yellowBannerBtn, instructionsBlock,
                instructionBtn, bestOffersFirstElement, blog, blogBtn, mobileApp);
    }

    public void onMainPage() {
        driver.get(PagesUrls.mainPage);
    }

    public void mainPageIsDisplayed() {
        allElementsAreVisible(headerPage.getMainHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footerPage.getFooter());
        Assert.assertEquals(4, mainOffersBtns.size());
        Assert.assertEquals(8, h2.size());
        Assert.assertEquals(4, bestOffersTabs.size());
        Assert.assertTrue(bestOffersCards.size() > 0);
        Assert.assertEquals(4, instructionsRounds.size());
        Assert.assertEquals(4, blocks.size());
        Assert.assertEquals(4, blogCards.size());
        Assert.assertTrue(seoLinks.size() >= 20);
        Assert.assertTrue(seoTitles.size() >= 7);
    }

    /*
     *клики по вертикалям
     */
    public void verticalsClick(String nameOfVertical) {
        int i = 0;
        for (WebElement element : mainOffersBtns) {
            if (element.getText().equals(nameOfVertical)) {
                element.click();
                break;
            }
            i++;
            if (i == mainOffersBtns.size())
                waitForText(element, nameOfVertical);
        }
    }

    public void ratingReportClick(String nameOfRating) {
        String xPath = String.format("//div[./h2[contains(text(), '%s')]]//button", nameOfRating);
        WebElement element = driver.findElement(By.xpath(xPath));
        waitForVisibility(element);
        element.click();
    }

    //TODO: настроить нормальную проверку
    public void checkBalanceAndRating() {
        try {
            waitForVisibility(ratingField);
        } catch (Exception E) {
            waitForVisibility(ratingFreeLink);
        }

//        String valueMoney = moneyValue.getText();
//        valueMoney = valueMoney.replaceAll("\\s", "");
//        if (Integer.parseInt(valueMoney) < 5000) {
//            try {
//                AdminBalance.runClass();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public void userInFooterMediumLinkClick(String linkName){
        scrollTo(footerPage.becomePartnerLink);
        waitForVisibility(footerPage.becomePartnerLink);
        switch (linkName) {
            case ("IOS"):
                footerPage.appsSocialLinks.get(0).click();
                break;
            case ("Android"):
                footerPage.appsSocialLinks.get(1).click();
                break;
            case ("facebook"):
                footerPage.socialBtn.get(0).click();
                break;
            case ("vk"):
                footerPage.socialBtn.get(1).click();
                break;
            case ("instagram"):
                footerPage.socialBtn.get(2).click();
                break;
            case ("yandex"):
                footerPage.socialBtn.get(3).click();
                break;
            case ("Стать партнером"):
                footerPage.becomePartnerLink.click();
                break;
            case ("Стать агентом"):
                footerPage.becomeAgentLink.click();
                break;
        }
    }

    public void userInFooterMediumLinkPageCheck(String linkName){
        switch (linkName) {
            case ("facebook"):
            case ("vk"):
            case ("instagram"):
            case ("yandex"):
                Assert.assertTrue(checkingUrlSocialLinks(linkName));
                break;
            default:
                Assert.assertTrue(checkingUrlLinks());
                break;
        }
    }

    public Boolean checkingUrlLinks(){
        return !driver.getCurrentUrl().contains(PagesUrls.mainPage);
    }

    public Boolean checkingUrlSocialLinks(String linkName){
        return driver.getCurrentUrl().contains(linkName);
    }

    public void activatePanelIsDisplayed() {
        activatePanel = Arrays.asList(activatePanelContainer, activateText, activateBtn);
        allElementsAreVisible(activatePanel);
    }

    public void activateBtnClick() {
        activateBtn.click();
    }

    public void clickTopLinkInFooter(String nameOfLink) {
        for (WebElement element : footerPage.footerLinks) {
            if (element.getText().equals(nameOfLink))
                element.click();
        }
    }

    public void clickDownProductsInFooter(String nameOfLink) {
        int i = 0;
        for (WebElement element : footerPage.downLinks) {
            if (element.getText().equals(nameOfLink)) {
                element.click();
                break;
            }
            i++;
            //Если перебрали все линки ждем текст -> недожидаемся -> падаем
            if (i == footerPage.downLinks.size())
                waitForText(element, nameOfLink);
        }
    }

    public void comparePageClick() {
        scrollToTop();
        click(headerPage.compareBtn);
    }

    public void scrollToFooter() {
        waitForVisibility(footerPage.downLinks.get(1));
        scrollTo(footerPage.downLinks.get(1));
    }

    public void clickSOUTInFooter(String nameOfLink) {
        for (WebElement element : footerPage.downLinks) {
            if (element.getText().equals(nameOfLink)) {
                element.click();
                break;
            }
        }
        switchToTheSecondTab();
        Assert.assertTrue(checkSOUTFile());
    }


    public Boolean checkSOUTFile(){
        return driver.getCurrentUrl().contains("pdf");
    }
}
