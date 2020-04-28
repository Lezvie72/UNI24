package pages.partnerCabinetPage.modalPages;

import testContext.TestContext;
import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class GiveMoney extends Base {

    @FindBy(xpath = "//div[@class='ds-modal-inner']//div[contains(text(), '+')]")
    private WebElement modalPagePlusBTN;

    @FindBy(xpath = "//div[@class='ds-modal-inner']//div[contains(text(), '−')]")
    private WebElement modalPageMinusBTN;

    @FindBy(xpath = "//div[@class='ds-modal-inner']//button[contains(text(), 'Далее')]")
    private WebElement modalPageNextStepBTN;

    @FindBy(xpath= "//div[@class='ds-modal-inner']//button[contains(text(), 'Расчетный счет')]")
    private WebElement modalPageFirstMethodBTN;

    @FindBy(xpath = "//div[@class='ds-modal-inner']//button[contains(text(), 'Вывести')]")
    private WebElement modalPageGiveMoneyBTN;

    @FindBy(xpath = "//div[@class='send-money font__base-small']")
    private WebElement modalPageSuccessfulText;

    @FindBy(xpath = "//div[@class='ds-modal-inner']//button[contains(text(), 'Закрыть')]")
    private WebElement modalPageExitBTN;

    @FindBy(xpath ="//div[@class='message font__base']")
    private WebElement alertBlock;

    private final List<WebElement> elements;

    public GiveMoney(){
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(modalPagePlusBTN, modalPageMinusBTN, modalPageNextStepBTN);
    }

    public void modalPageIsDisplayed(){
        allElementsAreVisible(elements);
    }

    public void modalPagePlusBTNClick(){
        modalPagePlusBTN.click();
    }

    public void modalPageNextStepBTNClick(){
        modalPageNextStepBTN.click();
    }

    public void modalPageNextStepIsDisplayed(){
        waitForAjaxElementIsVisible(modalPageFirstMethodBTN);
    }

    public void modalPageFirstMethodBTNClick(){
        modalPageFirstMethodBTN.click();
    }

    public void modalPageGiveMoneyBTNClick(){
        modalPageGiveMoneyBTN.click();
    }

    public void modalPageSuccessfulTextIsDisplayed(){
        waitForVisibility(modalPageSuccessfulText);
        waitForVisibility(modalPageExitBTN);
            }

    public void modalPageClose(){
            modalPageExitBTN.click();
    }

    public void checkAlert(){
        try {
            waitForAjaxElementIsVisible(alertBlock);
            TestContext.messageBlockToGiveMoney = 1;
        } catch (Exception e){
            TestContext.messageBlockToGiveMoney = 0;
        }
    }

}
