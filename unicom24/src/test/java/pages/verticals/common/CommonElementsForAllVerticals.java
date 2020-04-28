package pages.verticals.common;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonElementsForAllVerticals extends Base {

    /*
    * Тута будут массивы
     */
    @FindBy(xpath = "//div[@class='button__wrapper']//span[contains(text(), 'Добавить в сравнение')]")
    public List<WebElement> btnBankCreditAddToCompare;

    @FindBy(xpath = "//div[@class='offer-item-new wrapper']")
    public List<WebElement> countOffersOnPage;

    @FindBy(xpath = "//div[@class='offers-compare-table-offer-header-controls-remove']")
    public List<WebElement> btnBankCreditRemoveFromCompare;
    /*
    *Тута уже не будут массивы
     */

    @FindBy(xpath = "//div[@class='rating']")
    public WebElement rating;

    @FindBy(xpath = "//a[@class='font__color-blue nuxt-link-active']")
    public WebElement title;

    @FindBy(xpath = "//div[contains(text(), 'Ставка в год')]")
    public WebElement ratePerYear;

    @FindBy(xpath = "//div[contains(text(), 'Платеж в месяц')]")
    public WebElement payPerMonth;

    @FindBy(xpath = "//div[contains(text(), 'Время рассмотрения')]")
    public WebElement time;

    @FindBy(xpath = "//div[contains(text(), 'Платеж в месяц')]")
    public WebElement neededPaying;

    @FindBy(xpath = "//div[@class='license hide-xxs']")
    public WebElement license;
    /*
    * Кредиты окончены
     */

    /*
    * отдельно для кредитных карт
     */

    @FindBy(xpath = "//div[contains(text(), 'Кредитный лимит')]")
    public WebElement creditLimit;

    @FindBy(xpath = "//div[contains(text(), 'Стоимость обслуживания')]")
    public WebElement cost;

    /*
     * отдельно для кредитных карт окончено
     */

    @FindBy(xpath = "//div[contains(text(), 'Переплата')]")
    public WebElement overpayment;

    @FindBy(xpath = "//div[contains(text(), 'Ставка в день')]")
    public WebElement payPerDay;

    /*
     *Персональный займ
     */
    @FindBy(css = ".container .form-one")
    public WebElement personalOfferContainer;

    //@FindBy(css = "img[src=\"/_nuxt/img/201cb8d.png\"]") - Отсутствует на период 10.01.2020
    //public WebElement giftPic;

    @FindBy(css = ".form-one .ui-input-new input")
    public WebElement personalOfferField;

    @FindBy(css = "div.offers-item-banner button") //- отсутствует на странице на период 10.01.2020, не закоментил, так как задействован еще в каком-то методе
    public WebElement makeOfferBtn;

    //@FindBy(xpath = "//div[contains(text(), 'Нажимая кнопку «Подобрать персональный займ»,  ')]") - тоже самое
    //public WebElement ifYouText;

    //@FindBy(xpath = "//a[@href=\"/media_files/agreement_registration/\" and contains(text(), 'вы соглашаетесь с условиями обработки данных')]") - тоже самое
    //public WebElement agreeLink;
    /*
     *Персональный займ окончен
     */

    // Там где имя пользователя начало
    @FindBy(xpath = "//div[@class='app-header-user-block-info'][./div[contains(@class, auth)]]") //TODO: точно такой же селектор в хэдэре - навести порядок
    public WebElement nameForDropProfileMenuBTN;

    @FindBy(xpath = "//li//a[contains(text(), 'Профиль')]")
    public WebElement enterProfileBTN;

    @FindBy(xpath = "//a//div[contains(text(), 'Баланс')]")
    public WebElement enterScoreProfileBTN;

    @FindBy(xpath = "//li/div[contains(text(), 'Выйти')]")
    public WebElement exitProfileBTN;
    // Там где имя пользователя конец

    /*
    Элементы отвечающий за локакацию пользователя начало
     */
    @FindBy(xpath = "//span[@class='filters-city-selected-info__name']") // Вызывает меню на смену города
    public WebElement spanForSelectLocationCity;

    @FindBy(xpath = "//div[@class='filters-city-content-list-item']/span") // список локаций-городов
    public WebElement spanLocationCity;
    /*
    Элементы отвечающие за локацию пользователя конец
     */

    /*
    Элементы отвечающие за содержимое страницы списка оферов по персональному подбору начало
     */

    @FindBy(xpath = "//div[contains(text(), 'Лучшие предложения')]")
    public WebElement bestOffersTitle;

    @FindBy(xpath = "//div[@class='offers-element element__base']")
    public List<WebElement> bestOffersList;

    @FindBy(xpath = "//div[@class='offers-element element__best']")
    public List<WebElement> bestOffersBestList;

    /*
    Элементы отвечающие за содержимое страницы списка оферов по персональному подбору конец
     */

    public List<WebElement> getElementsForChangeCity() {
        return Arrays.asList(spanForSelectLocationCity, spanLocationCity);
    }
}
