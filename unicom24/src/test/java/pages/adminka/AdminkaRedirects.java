package pages.adminka;

import testContext.TestContext;
import base.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pagesUrls.PagesUrls;

import java.util.Arrays;
import java.util.List;

public class AdminkaRedirects extends Base {

    TestContext testContext = new TestContext();
    public String offerId;

    @FindBy(id = "searchbar")
    private WebElement searchInput;

    @FindBy(css = "#changelist-search input[value=\"Найти\"]")
    private WebElement searchBtn;

    @FindBy(xpath = "//a[contains(text(), 'ID')]")
    private WebElement idTableTitle;

    @FindBy(xpath = "//a[contains(text(), 'Создан')]")
    private WebElement createdTableTitle;

    @FindBy(xpath = "//a[contains(text(), 'Обновлен')]")
    private WebElement updatedTableTitle;

    @FindBy(xpath = "//a[contains(text(), 'Получено')]")
    private WebElement gottenTableTitle;

    @FindBy(xpath = "//a[contains(text(), 'Хеш')]")
    private WebElement hashTableTitle;

    @FindBy(xpath = "//span[contains(text(), 'Предложение')]")
    private WebElement offerTableTitle;

    @FindBy(xpath = "//span[contains(text(), 'Анкета')]")
    private WebElement anketaTableTitle;

    @FindBy(xpath = "//span[contains(text(), 'Партнер')]")
    private WebElement partnerTableTitle;

    @FindBy(xpath = "//span[contains(text(), 'Рекламная кампания')]")
    private WebElement advCampTableTitle;

    @FindBy(xpath = "//a[contains(text(), 'Статус')]")
    private WebElement statusTableTitle;

    @FindBy(xpath = "//a[contains(text(), 'Оплачен?')]")
    private WebElement paidTableTitle;

    @FindBy(xpath = "//a[contains(text(), 'Уникальный?')]")
    private WebElement unicTableTitle;

    @FindBy(xpath = "//span[contains(text(), 'С трафика из СМС')]")
    private WebElement smsTableTitle;

    @FindBy(xpath = "//a[contains(text(), 'Источник')]")
    private WebElement sourceTableTitle;

    private final List<WebElement> elements;

    public AdminkaRedirects() {
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(searchInput, searchBtn, idTableTitle, createdTableTitle, updatedTableTitle,
                gottenTableTitle, hashTableTitle, offerTableTitle, anketaTableTitle, partnerTableTitle, advCampTableTitle,
                statusTableTitle, paidTableTitle, unicTableTitle, smsTableTitle, sourceTableTitle);
    }

    public void onAdminkaRedirectsPage() {
        driver.get(PagesUrls.adminRedirectsPage());
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(elements);
    }

    public void checkVerticalsRedirect() {
        Assert.assertTrue(checkId());
        Assert.assertTrue(checkDate());
        Assert.assertTrue(checkHash());
        String xPath = String.format("//tr[@class='row1'][1]/td/a[contains(text(), '%s')]", offerId);
        WebElement element = driver.findElement(By.xpath(xPath));
        waitForVisibility(element);
        waitForVisibility(driver.findElement(By.xpath("//tr[@class='row1'][1]/td/a[contains(text(), 'Unicom24')]")));
        waitForVisibility(driver.findElement(By.xpath("//tr[@class='row1'][1]/td[contains(text(), 'Новый')] ")));
        String sourceXpath = String.format("//tr[@class='row1'][1]/td[contains(text(), '%s')]", TestContext.checkRedirectUrl);
        waitForVisibility(driver.findElement(By.xpath(sourceXpath)));
    }

    private Boolean checkId() {
        WebElement firstId = driver.findElement(By.cssSelector(".row1 .field-id a"));
        WebElement secondId = driver.findElement(By.cssSelector(".row2 .field-id a"));
        waitForVisibility(firstId);
        waitForVisibility(secondId);
        String firstIdText = firstId.getText();
        int firstIdCount = Integer.parseInt(firstIdText);
        String secondIdText = secondId.getText();
        int secondIdCount = Integer.parseInt(secondIdText);

        return firstIdCount - secondIdCount == 1;
    }

    private Boolean checkDate() {
        WebElement creationDate = driver.findElement(By.cssSelector(".field-created.nowrap a"));
        WebElement updatedDate = driver.findElement((By.cssSelector(".field-updated.nowrap a")));
        waitForVisibility(creationDate);
        waitForVisibility(updatedDate);
        String creationDateText = creationDate.getText();
        String updatedDateText = updatedDate.getText();

        return creationDateText.equals(updatedDateText);
    }

    private Boolean checkHash() {
        WebElement hash = driver.findElement(By.cssSelector(".field-hash_str"));
        waitForVisibility(hash);
        String hashText = hash.getText();
        typeIntoField(hashText, searchInput);
        searchBtn.click();
        waitForPageLoaded(PagesUrls.adminRedirectsPage() + hashText);
        List<WebElement> elements = driver.findElements(By.cssSelector(".row1"));
        allElementsAreVisible(elements);
        if(elements.size() == 1) {
            onAdminkaRedirectsPage();
            return true;
        } else return false;
    }
}
