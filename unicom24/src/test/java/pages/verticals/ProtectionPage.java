package pages.verticals;

import base.Base;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;
import pagesUrls.PagesUrls;

import java.util.Arrays;
import java.util.List;

public class ProtectionPage extends Base {
    Header headerPage = new Header();
    Footer footerPage = new Footer();

    // хедер
    @FindBy(xpath = "//div[@class='subscribe-header__item subscribe-button subscribe-button--active']/div[contains(text(), 'Подписка на сигналы')]")
    private WebElement subHeaderSignals;

    @FindBy(xpath = "//div[@class='subscribe-header__item subscribe-button']/div[contains(text(), 'Финансовое здоровье')]")
    private WebElement subHeaderFinHealth;

    @FindBy(xpath = "//div[@class='subscribe-header__item subscribe-button']/div[contains(text(), 'Полная кредитная история')]")
    private WebElement subHeaderFullCreditHistory;

    //боди блок №1
    @FindBy(xpath = "//h3[@class='subscribe-service__title']")
    private WebElement block1Title;

    @FindBy(xpath = "//div[@class='subscribe-service__wrapper']")
    private WebElement block1Contains;

    @FindBy(xpath = "//img[@class='subscribe-service__image']")
    private WebElement block1Img;

    @FindBy(xpath = "//div[@class='subscribe-form']")
    private WebElement block1Form;

    @FindBy(xpath = "//div[@class='subscribe-form']//input")
    private List<WebElement> block1Inputs;

    @FindBy(xpath = "//div[contains(text(), 'Фамилия')]/..//input")
    private WebElement inputFamily;

    @FindBy(xpath = "//div[contains(text(), 'Имя')]/..//input")
    private WebElement inputName;

    @FindBy(xpath = "//div[contains(text(), 'Отчество')]/..//input")
    private WebElement inputSurname;

    @FindBy(xpath = "//div[contains(text(), 'Дата рождения')]/..//input")
    private WebElement inputDOB;

    @FindBy(xpath = "//div[contains(text(), 'Серия и номер паспорта')]/..//input")
    private WebElement inputNumberPassport;

    @FindBy(xpath = "//div[contains(text(), 'Дата выдачи паспорта')]/..//input")
    private WebElement inputDatePassport;

    @FindBy(xpath = "//div[contains(text(), 'Мобильный телефон')]/..//input")
    private WebElement inputMobile;

    @FindBy(xpath = "//div[contains(text(), 'E-mail')]/..//input")
    private WebElement inputEmail;

    @FindBy(xpath = "//button[@class='subscribe-form-data__button material large']")
    private WebElement block1ButtonSubNow;

    //боди блок №2
    @FindBy(xpath = "//div[@class='subscribe-service__title-small']")
    private WebElement block2Title1;

    @FindBy(xpath = "//li[@class='subscribe-service__protect-item']")
    private List<WebElement> block2LIList1;

    @FindBy(xpath = "//h6[@class='subscribe-card__title']")
    private WebElement block2Title2;

    @FindBy(xpath = "//li[@class='subscribe-card__item']")
    private List<WebElement> block2LIList2;

    //боди блок 3
    @FindBy(xpath = "//div[@class='subscribe-service__signal-title']/h6")
    private WebElement block3Title;

    @FindBy(xpath = "//ul[@class='subscribe-service__signal-items subscribe-service__signal-items--big']")
    private WebElement block3Text;

    @FindBy(xpath = "//ul[@class='subscribe-service__signal-items subscribe-service__signal-items--big']/img")
    private WebElement block3Img;

    @FindBy(xpath = "//div[@class='subscribe-service__holder']//button")
    private WebElement block3Button;

    //боди блок 4
    @FindBy(xpath = "//div[@class='subscribe-news__title']")
    private WebElement block4Title;

    @FindBy(xpath = "//div[@class='subscribe-news__text']")
    private WebElement block4Text;

    @FindBy(xpath = "//div[@class='subscribe-news__wrapper']//input")
    private WebElement block4EmailInput;

    @FindBy(xpath = "//div[@class='subscribe-news__wrapper']/button")
    private WebElement block4Button;

    @FindBy(xpath = "//div[@class='subscribe-rate subscribe-promotions__rate']")
    private List<WebElement> block4Promos;

    //боди блок 5
    @FindBy(xpath = "//div[@class='subscribe-security__title']")
    private WebElement block5Title1;

    @FindBy(xpath = "//div[@class='subscribe-security__img']/img")
    private WebElement block5Img;

    @FindBy(xpath = "//div[@class='subscribe-security__card']")
    private WebElement block5Text;

    @FindBy(xpath = "//div[@class='subscribe-security__wrapper']/button")
    private WebElement block5Button;

    @FindBy(xpath = "//div[@class='subscribe-security__subtitle']")
    private WebElement block5Title2;

    @FindBy(xpath = "//div[@class='subscribe-security__block']")
    private List<WebElement> block5BlockText;

    //футер
    @FindBy(xpath = "//div[@class='subscribe-footer']")
    private WebElement footerBlock;

    @FindBy(xpath = "//div[@class='subscribe-footer__text']")
    private WebElement footerText;

    @FindBy(xpath = "//div[@class='subscribe-footer']/button")
    private WebElement footerButton;

    public final List<WebElement> elements;

    public ProtectionPage() {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, headerPage);
        PageFactory.initElements(driver, footerPage);
        elements = Arrays.asList(subHeaderFinHealth, subHeaderFullCreditHistory, subHeaderSignals,
                block1Form, block1Contains, block1Title, block1Img, block1ButtonSubNow,
                inputFamily, inputName, inputSurname, inputDOB, inputDatePassport, inputNumberPassport, inputMobile, inputEmail,
                block2Title1, block2Title2,
                block3Title, block3Text, block3Img, block3Button,
                block4Title, block4Text, block4EmailInput, block4Button,
                block5Title1, block5Title2, block5Text, block5Img, block5Button,
                footerText, footerBlock, footerButton);
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(headerPage.getMainHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footerPage.getFooter());
        Assert.assertEquals(block1Inputs.size(), 8);
        Assert.assertEquals(block2LIList1.size(), 3);
        Assert.assertEquals(block2LIList2.size(), 3);
        Assert.assertEquals(block4Promos.size(), 2);
        Assert.assertEquals(block5BlockText.size(), 2);
    }

    public void onProtectionPage() {
        driver.get(PagesUrls.protectionPageUrl());
        waitForPageLoaded(PagesUrls.protectionPageUrl());
    }
}
