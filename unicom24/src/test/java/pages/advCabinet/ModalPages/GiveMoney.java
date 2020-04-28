package pages.advCabinet.ModalPages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class GiveMoney extends Base {
    @FindBy(xpath="//div[@class='ds-add-balance-wrapper']")
    private WebElement giveMoneyModalPage;

    @FindBy(xpath="//div[@class='font__introduction']/a")
    private WebElement dogovorOferty;

    @FindBy(xpath="//button[@class='ds-button-self font__base big yellow']")
    private WebElement giveMoneyBTN;

    private final List<WebElement> elements;

    public GiveMoney(){
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(giveMoneyModalPage, dogovorOferty, giveMoneyBTN);
    }

    public void giveMoneyModalPageIsDisplayed(){
        allElementsAreVisible(elements);
    }

    public void giveMoneyModalGiveBTNClick(){
        giveMoneyBTN.click();
        // проверка url
        waitForUrlContains("robokassa");
    }
}