package pages;

import base.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pagesUrls.PagesUrls;

import java.util.Arrays;
import java.util.List;

public class WebMasterMicrocreditPage extends Base {

    @FindBy (css =  ".range-with-label-label")
    private List<WebElement> rangeToForm;
    @FindBy (css = ".ui-input-new-unit")
    private List<WebElement> valueFieldToForm;
    @FindBy (css = ".advantages-list-item")
    private List<WebElement> argumentsOfFastCredits;
    @FindBy (css= ".ways-list-item")
    private List<WebElement> waysOfFastCredits;

    @FindBy(xpath = "//span[contains(text(),'Подберем займ на любые цели')]")
    private WebElement titleTextSpan;

    @FindBy(xpath = "//span[contains(text(),'бесплатно')]")
    private WebElement subTitleTextSpan;

    @FindBy(xpath = "//div[@class='form-offers-small step_1']")
    private WebElement formOffersSmall;

    @FindBy(xpath = "//button[@class='form-btn default medium']")
    private WebElement btnToForm;

    @FindBy(xpath = "//div[contains(text(),'Быстрые и безопасные кредиты')]")
    private WebElement titleFastCredits;

    @FindBy(xpath = "//div[contains(text(), 'Удобные способы получения')]")
    private WebElement titleWays;

    @FindBy(xpath = "//div[@class='top-header pd']")
    private WebElement topHeader;

    @FindBy(xpath = "//div[@class='footer pd']")
    private WebElement footer;

    private final List<WebElement> elements;

    public WebMasterMicrocreditPage() {
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(titleTextSpan, subTitleTextSpan, formOffersSmall, btnToForm, titleFastCredits, titleWays, topHeader, footer);
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(elements);
        Assert.assertEquals(2, rangeToForm.size()); // два ползунка на странице
        Assert.assertEquals(2, valueFieldToForm.size()); // два поля с цифрами на странице
        Assert.assertEquals(3, argumentsOfFastCredits.size()); // три аргумента на странице
        Assert.assertEquals(5, waysOfFastCredits.size()); // пять способом получения на странице
    }

    public void onWebMasterMicrocreditPage() {
        driver.get(PagesUrls.webMasterMicrocreditPage());
    }
}
