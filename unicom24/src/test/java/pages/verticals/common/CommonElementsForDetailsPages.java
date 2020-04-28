package pages.verticals.common;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;

public class CommonElementsForDetailsPages extends Base {
    Header headerPage = new Header();
    Footer footerPage = new Footer();
    CommonElements commonElements = new CommonElements();

    String verticalsForDetailsPages = "//section[@class='menu__wrapper']";
    //@FindBy (xpath = "//section[@class='menu__wrapper']/a[contains(text(), 'Предложения'")
    //private WebElement verticalsForDetailsPages;

    @FindBy (xpath = "//div[@class='offer-full-info-wrapper']")
    private WebElement infoOfBankOffer; // блок боди Предложения

    @FindBy (xpath = "//section[@class='conditions-wrapper font__base']")
    private WebElement infoOfIfBankOffer; // блок боди условия

    @FindBy (xpath = "//section[@class='menu__wrapper']/..//div[@class='font__base']")
    private WebElement docsOfBankOffers; // блок боди документы

    @FindBy (xpath = "//button[@class='reviews-tab__btn ui-btn font__base yellow']")
    private WebElement commentOfBankOffer; // блок боди отзывы

    @FindBy (xpath = "//section[@class='info']")
    private WebElement aboutOfBankOffer; // блок боди Об организации

    @FindBy(xpath = "//div[contains(text(), 'Лицезния ЦБ')]")
    public WebElement licenseOfCB;

    public CommonElementsForDetailsPages() {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, headerPage);
        PageFactory.initElements(driver, footerPage);
        PageFactory.initElements(driver, commonElements);
    }

    public void pageIsDisplayed(String nameOfVerticalFullIfoBankOffer){
        allElementsAreVisible(headerPage.getMainHeader());
        allElementsAreVisible(footerPage.getFooter());
        switch (nameOfVerticalFullIfoBankOffer) {
            case ("Условия"):
                waitForVisibility(infoOfIfBankOffer);
                break;
            case ("Документы"):
                waitForVisibility(docsOfBankOffers);
                break;
            case ("Отзывы"):
                waitForVisibility(commentOfBankOffer);
                break;
            case ("Об организации"):
                waitForVisibility(aboutOfBankOffer);
                break;
            default:
                waitForVisibility(infoOfBankOffer); // Предложения
                break;
        }
    }

    public void verticalsFullInfoBankOfferClick (String nameOfVerticalFullInfoBankOffer){
        String xPath = String.format(verticalsForDetailsPages+ "/a[contains(text(), '%s')]", nameOfVerticalFullInfoBankOffer);
        WebElement verticalClick = driver.findElement(By.xpath(xPath));
        verticalClick.click();
    }


}