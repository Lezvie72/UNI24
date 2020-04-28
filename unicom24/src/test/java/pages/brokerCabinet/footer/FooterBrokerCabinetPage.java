package pages.brokerCabinet.footer;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class FooterBrokerCabinetPage extends Base {

    @FindBy(css = ".ui-footer")
    public WebElement footerContainer;

    @FindBy(xpath = "//div[contains(@class, 'ui-footer')]/div/div[contains(text(), 'Финансовый рейтинг клиента')]")
    public WebElement footerTitle;

    @FindBy(xpath = "//li/a[@href=\"/b2b_office/financial-health\" and contains(text(), 'Рейтинг финансового здоровья')]")
    public WebElement rfzLink;

    @FindBy(xpath = "//li/a[@href=\"/b2b_office/credit-rating\" and contains(text(), 'Кредитный рейтинг')]")
    public WebElement creditRatingLink;

    @FindBy(xpath = "//li/a[@href=\"/b2b_office/credit-report\" and contains(text(), 'Кредитный отчет')]")
    public WebElement creditReportLink;

//    @FindBy(xpath = "//li/a[@href=\"/b2b_office/advanced-credit-rating\" and contains(text(), 'Расширенный кредитный рейтинг')]")
//    public WebElement bigCreditRatingLink;

    @FindBy(xpath = "//li/a[@href=\"/b2b_office/fico\" and contains(text(), 'FICO')]")
    public WebElement ficioLink;

    @FindBy(xpath = "//div[@class='footer-links-right']/div/div/div/div[contains(text(), 'Скоринг')]")
    public WebElement middleSideOfFooterTitle;

    @FindBy(xpath = "//li/a[@href=\"/b2b_office/phone-scoring\" and contains(text(), 'Скоринг по номеру телефона')]")
    public WebElement scoringTelephoneNumberLink;

    @FindBy(xpath = "//li/a[@href=\"/b2b_office/social-scoring\" and contains(text(), 'Скоринг по соцсетям')]")
    public WebElement scoringSocialMediaLink;

    @FindBy(xpath = "//div[@class='footer-links-right']/div/div/div/div[contains(text(), 'Авто')]")
    public WebElement rightSideOfFooterTitle;

    @FindBy(xpath = "//li/a[@href=\"/b2b_office/auto\" and contains(text(), 'Проверка автомобиля')]")
    public WebElement checkAutoLink;

    @FindBy(xpath = "//div[@class='ui-footer-connect-us'][./div[contains(text(), 'Остались вопросы? Свяжитесь с нами.')]]")
    public WebElement supportTitle;

    @FindBy(xpath = "//div[@class='ui-footer-connect-us-bottom'][./a[@href=\"mailto:agentsupport@unicom24.ru\" and contains(text(), 'agentsupport@unicom24.ru')]]")
    public WebElement supportLink;

    @FindBy(css = ".footer-bottom-icons")
    public WebElement footerIcons;

    @FindBy(xpath = "//div[contains(text(), 'Copyright © ООО «Юником24» 2010–2019. Все права защищены')]")
    public WebElement copyRight;

    @FindBy(xpath = "//span[contains(text(), 'Сделано в компании VUARO.')]")
    public WebElement doneBy;

    @FindBy(xpath = "//span[contains(text(), 'Ваши данные надежно защищены THAWTE')]")
    public WebElement dataProtectedBy;

    public List<WebElement> getFooter() {
        return Arrays.asList(footerContainer, footerTitle, rfzLink,
                creditRatingLink, creditReportLink, ficioLink,
                middleSideOfFooterTitle, scoringTelephoneNumberLink, scoringSocialMediaLink,
                rightSideOfFooterTitle, checkAutoLink, supportTitle, supportLink,
                footerIcons, copyRight, doneBy, dataProtectedBy);
    }

}
