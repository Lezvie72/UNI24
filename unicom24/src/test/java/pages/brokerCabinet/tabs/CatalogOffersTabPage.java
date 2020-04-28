package pages.brokerCabinet.tabs;

import base.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.brokerCabinet.footer.FooterBrokerCabinetPage;
import pages.brokerCabinet.header.HeaderBrokerCabinetPage;

import java.util.Arrays;
import java.util.List;

public class CatalogOffersTabPage extends Base {

    private final HeaderBrokerCabinetPage header = new HeaderBrokerCabinetPage();
    private final FooterBrokerCabinetPage footer = new FooterBrokerCabinetPage();

    @FindBy(xpath = "//div[contains(text(), 'Офферы')]")
    private WebElement offersTitle;

    @FindBy(xpath = "//input[@placeholder=\"Поиск по названию компании\"]")
    private WebElement searchField;

    @FindBy(xpath = "//span[contains(text(),'Скрыть фильтры')]")
    private WebElement hideFilters;

    @FindBy(xpath = "//div[./div[contains(text(), 'Тип продукта')]]/div/div[contains(text(), 'Микрозаймы')]")
    private WebElement microcreditsType;

    @FindBy(xpath = "//div[./div[contains(text(), 'Тип продукта')]]/div/div[contains(text(), 'Кредиты')]")
    private WebElement creditsType;

    @FindBy(xpath = "//div[./div[contains(text(), 'Тип продукта')]]/div/div[contains(text(), 'Кредитные карты')]")
    private WebElement creditCardsType;

    @FindBy(xpath = "//div[./div[contains(text(), 'Тип продукта')]]/div/div[contains(text(), 'Автокредиты')]")
    private WebElement autocreditsType;

    @FindBy(xpath = "//div[./div[contains(text(), 'Тип продукта')]]/div/div[contains(text(), 'Ипотека')]")
    private WebElement ipotekaType;

    private final List<WebElement> elements;

    public CatalogOffersTabPage() {
        PageFactory.initElements(driver, header);
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, footer);
        elements = Arrays.asList(offersTitle, searchField, hideFilters, microcreditsType, creditsType, creditCardsType,
                autocreditsType, ipotekaType);
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(header.getHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footer.getFooter());
    }

    public void countOffers() {
        int countOfOffers = driver.findElements(By.cssSelector(".wrapper.application-item")).size();
        Assert.assertTrue(countOfOffers > 10);
    }

    public void searchOffer(String nameOfBank) {
        waitForVisibility(searchField);
        typeIntoField(nameOfBank, searchField);
    }

    public void isSearchResultIsDisplayed(String nameOfBank) {
        String xPath = String.format("//div[contains(@class, 'application-item')]/div/div[2]/div[contains(text(), '%s')]", nameOfBank);
        waitForAjaxElementIsVisible(By.xpath(xPath));
    }

    public void filterClick(String nameOfBtn) {
        String xpath = String.format("//div[./div[contains(text(), 'Тип продукта')]]/div/div[contains(text(), '%s')]", nameOfBtn);
        waitForVisibility(By.xpath(xpath));
        waitForAjaxElementIsVisible(By.xpath(xpath)).click();
        waitToBeClickable(By.xpath(xpath));
    }

    public void checkFiltersWork(String nameOfFilter) {
        String xpathForTrueElement = String.format("//div[contains(@class, 'hide-s')]/div/span[contains(text(), '%s')]", nameOfFilter);
        waitForVisibility(By.xpath(xpathForTrueElement));
        String[] filtersForCheck = {"МФО", "Потреб", "Кредитная карта", "Автокредит", "Ипотека"};
        for (String filter : filtersForCheck) {
            if (!nameOfFilter.equals(filter)) {
                String xpath = String.format("//div[contains(@class, 'hide-s')]/div/span[contains(text(), '%s')]", filter);
                try {
                    driver.findElement(By.xpath(xpath));
                } catch (NoSuchElementException e) {
                }
                ;
            }
        }
    }
}
