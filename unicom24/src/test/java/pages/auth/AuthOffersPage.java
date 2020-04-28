package pages.auth;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class AuthOffersPage extends Base {
    @FindBy (xpath = "//div[@class='ui-offers-header-title']")
    private WebElement offersTitle;

    @FindBy (xpath = "//div[@class='ui-offers-header-offerwall-access-button']")
    private  WebElement btnEnter;

    @FindBy (xpath = "//div[@class='ui-offers-header-offerwall-access-button']")
    private WebElement btnRegistration;

    @FindBy (xpath = "//input[@class='ng-pristine ng-untouched ng-valid ng-empty']")
    private WebElement inputFieldSearchNameOffer;

    private final List<WebElement> elements;

    public AuthOffersPage () {
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(offersTitle, btnEnter, btnRegistration, inputFieldSearchNameOffer);
    }

    public void pageIsDisplayed(){
        allElementsAreVisible(elements);
    }


}
