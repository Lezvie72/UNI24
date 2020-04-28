package pages.brokerCabinet.tabs;

import base.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.brokerCabinet.footer.FooterBrokerCabinetPage;
import pages.brokerCabinet.header.HeaderBrokerCabinetPage;

import java.util.Arrays;
import java.util.List;

public class MyClientsTabPage extends Base {

    private final HeaderBrokerCabinetPage header = new HeaderBrokerCabinetPage();
    private final FooterBrokerCabinetPage footer = new FooterBrokerCabinetPage();

    @FindBy(xpath = "//div[./div[contains(text(), 'Мои клиенты')]]/div[2]/label/div/input")
    private WebElement searchField;

    @FindBy(xpath = "//div[./div[contains(text(), 'Дата отправки')]]/div[2]/div[contains(text(), 'Вчера')]")
    private WebElement yesterdayBtn;

    @FindBy(xpath = "//div[./div[contains(text(), 'Дата отправки')]]/div[2]/div[contains(text(), 'Последняя неделя')]")
    private WebElement lastWeekBtn;

    @FindBy(xpath = "//div[./div[contains(text(), 'Дата отправки')]]/div[2]/div[contains(text(), 'Месяц')]")
    private WebElement monthBtn;

    @FindBy(xpath = "//div[./div[contains(text(), 'Дата отправки')]]/div[2]/div[contains(text(), 'Полгода')]")
    private WebElement halfYear;

    @FindBy(xpath = "//div[./div[contains(text(), 'Дата отправки')]]/div[2]/div[contains(text(), 'Диапазон дат')]")
    private WebElement dates;

    @FindBy(xpath = "//input[@class=\"datepicker-style\"]")
    private WebElement dateOne;

    @FindBy(xpath = "(//input[@class=\"datepicker-style\"])[2]")
    private WebElement dateTwo;

    @FindBy(xpath = "//span[contains(text(), 'ID заявки / перехода')]")
    private WebElement idApplicationTitle;

    @FindBy(xpath = "//span[contains(text(), 'Дата / время')]")
    private WebElement dateAndTimeTitle;

    @FindBy(xpath = "//span[contains(text(), 'ФИО')]")
    private WebElement fioTitle;

    @FindBy(xpath = "//span[contains(text(), 'Предложение')]")
    private WebElement offerTitle;

    @FindBy(xpath = "//span[contains(text(), 'Статус')]")
    private WebElement statusTitle;

    private final List<WebElement> elements;

    public MyClientsTabPage() {
        PageFactory.initElements(driver, header);
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, footer);
        elements = Arrays.asList(searchField, yesterdayBtn, lastWeekBtn, monthBtn, halfYear, dates, dateOne, dateTwo,
                idApplicationTitle, dateAndTimeTitle, fioTitle, offerTitle, statusTitle);
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(header.getHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footer.getFooter());
        int countOfOffers = driver.findElements(By.cssSelector(".wrapper.application-item")).size();
        Assert.assertTrue(countOfOffers > 3);
    }
}
