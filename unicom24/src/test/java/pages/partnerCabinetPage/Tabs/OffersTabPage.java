package pages.partnerCabinetPage.Tabs;

import base.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.partnerCabinetPage.Header.HeaderPartnerCabinetPage;

import java.util.Arrays;
import java.util.List;

public class OffersTabPage extends Base {

    private final HeaderPartnerCabinetPage header = new HeaderPartnerCabinetPage();

    String nameOfTypeProductTitle = "//div[./div[contains(text(), 'Тип продукта')]]";
    String nameOfTargetActionTitle = "//div[./div[contains(text(), 'Целевое действие')]]";
    String anyButton = "//button";

    String nameOfTypeOffer= "//div[./div[contains(text(), 'Тип оффера')]]//button";
    String wayForTargetOffer = "//div[@class='ds-offer-card-wrap']//a";


    @FindBy(xpath = "//div[contains(text(), 'Офферы')]")
    private WebElement offersTitle;

    @FindBy(xpath = "//div[@class='search']//input[@placeholder=\"Поиск по названию оффера\"]")
    private WebElement searchInputField;

    @FindBy(xpath = "//div[contains(text(), 'Скрыть фильтры')]")
    private WebElement hideFiltersBtn;

    @FindBy(xpath = "//div[contains(text(), 'Сбросить фильтры')]")
    private WebElement resetFilters;

    @FindBy(xpath = "//div[./div[contains(text(), 'Сортировать')]]//div[contains(text(), 'По вознаграждению (больше — меньше)')]")
    private WebElement sortField;

    @FindBy(xpath = "//div[@class='ds-offer-card-wrap']")
    private List <WebElement>  countForAllNonUniversalOffer; // число всех блоков с офферами на странице

    @FindBy(xpath = "//div[@class='ds-offer-card-wrap']//div[@class='name']/a")
    private List <WebElement> titleForAllNonUniversalOffer; // названия всех (титульники) всех офферов (организаций)

    @FindBy(xpath = "//div[@class='ds-offer-card']")
    private List <WebElement> countAllOffersOnPage;

    @FindBy(xpath = "//div[./div[contains(text(), 'Тип оффера')]]//button") // кнопки для манипуляций в коде Тип оффера фильтр
    private List<WebElement> nameTypeOfferOfButtonsWay;

    @FindBy(xpath = "//div[./div[contains(text(), 'Тип оффера')]]//button[contains(text(), 'API')]")
    private WebElement typeOfferFilterApiButton;    //кнопка фильтра типа оффера

    @FindBy(xpath = "//div[./div[contains(text(), 'Тип оффера')]]//button[contains(text(), 'Реферальные ссылки')]")
    private WebElement typeOfferFilterREFButton; //кнопка фильтра типа оффера

    @FindBy(xpath = "//div[./div[contains(text(), 'Тип оффера')]]//button[contains(@class, 'active')]")
    private List<WebElement> listWayForActiveButtonOfTypeOffer; // массив активных кнопок типа оффера фильтр

    @FindBy(xpath = "//div[@class='type']/span[contains(text(), 'API')]") // значок типа у оффера
    private List<WebElement> typeAPIOfferToTable;

    @FindBy(xpath = "//div[@class='type']/span[contains(text(), 'REF')]") // значок типа у оффера
    private List<WebElement> typeREFOfferToTable;

    private final List<WebElement> elements;

    public OffersTabPage() {
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(offersTitle, searchInputField, hideFiltersBtn, resetFilters,
                sortField);
    }

    public void pageIsDisplayed() {
        header.headerIsDisplayed();
        allElementsAreVisible(elements);
        waitForCountOfAjaxElementsMoreThan(By.xpath("//div[@class='ds-offer-card']"), 0);
    }

    public void checkCountFilters(){
        Assert.assertEquals(9, driver.findElements(By.xpath(nameOfTypeProductTitle+anyButton)).size()); // внезапно снова стало 5 кнопок вместо 7 а теперь снова 7, затем выросло до 9
        Assert.assertEquals(4, driver.findElements(By.xpath(nameOfTargetActionTitle+anyButton)).size());
        Assert.assertEquals(2, driver.findElements(By.xpath(nameOfTypeOffer)).size());
    }

    public void filterOfTypeClick(String nameFilter){
        String nameOfFilter = String.format(nameOfTypeProductTitle+"//button[contains(text(), '%s')]", nameFilter);
        driver.findElement(By.xpath(nameOfFilter)).click();
    }

    public void filterOfTargetActionClick(String nameFilter){
        String nameOfFilter = String.format(nameOfTargetActionTitle+"//button[contains(text(), '%s')]", nameFilter);
        driver.findElement(By.xpath(nameOfFilter)).click();
    }

    public void filterOfOfferClick(String nameFilter) {    /// API Рефы
        for (WebElement element : nameTypeOfferOfButtonsWay) {
            if (element.getText().contains(nameFilter)){
                element.click();
                break;
            }
        }

        if (nameFilter.equals("API")) {
            for (WebElement element : nameTypeOfferOfButtonsWay) {
                    if ( (listWayForActiveButtonOfTypeOffer.size()) > 1) {
                        typeOfferFilterREFButton.click();
                        break;
                    }
            }
        }

        if (nameFilter.equals("Реферальные ссылки")) {
            for (WebElement element : nameTypeOfferOfButtonsWay) {
                if ((listWayForActiveButtonOfTypeOffer.size()) > 1){
                    typeOfferFilterApiButton.click();
                    break;
                }
            }
        }
    }

    public void checkFilterOfOffersType(String nameFilter){
                if (nameFilter.equals("API")) {
                    waitForCountOfAjaxElementsMoreThan(By.xpath("//div[@class='type']/span[contains(text(), 'API')]"), 1);
                    Assert.assertTrue(typeAPIOfferToTable.size() > 0 );
                    Assert.assertTrue(typeREFOfferToTable.size() == 0);
                }
                if (nameFilter.equals("Реферальные ссылки")) {
                    waitForCountOfAjaxElementsMoreThan(By.xpath("//div[@class='type']/span[contains(text(), 'REF')]"), 1);
                    Assert.assertTrue(typeAPIOfferToTable.size() == 1 );
                    Assert.assertTrue(typeREFOfferToTable.size() > 0);
                }
    }

    public void offerFullPageClick(){ // клик по офферу
        titleForAllNonUniversalOffer.get(1).click();
    }

    public void targetNameOfferClick(String targetNameOffer){  /// клик на наиманованию конкретного оффера для перехода на страницу подробной инфы о нем
        String targetOffer = String.format(wayForTargetOffer+"[contains(text(), '%s')]", targetNameOffer);
        driver.findElement(By.xpath(targetOffer)).click();
    }

    public void searchOffer(String targetNameOffer){   /// поиск конкретного офера с помощью поля поиска
        typeIntoField(targetNameOffer, searchInputField);
        String targetOffer = String.format(wayForTargetOffer+"[contains(text(), '%s')]", targetNameOffer);
        WebElement element = waitForAjaxElementIsVisible(By.xpath(targetOffer));
        waitForVisibility(element);


    }
}
