package pages.verticals.common;

import base.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import pages.SelectionPage;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;
import pagesUrls.PagesUrls;

import java.util.Arrays;


public class CommonMethodsForAllVerticals extends Base{
    CommonElements commonElements = new CommonElements();
    CommonElementsForAllVerticals commonElementsAll = new CommonElementsForAllVerticals();
    CommonElementsForDetailsPages commonElementsForDetailsPages = new CommonElementsForDetailsPages();
    Header headerPage = new Header();
    Footer footerPage = new Footer();
    SelectionPage selectionPage = new SelectionPage();

    public CommonMethodsForAllVerticals() {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, commonElementsAll);
        commonElementsAll.getElementsForChangeCity();
    }

    public void userChangeLocationCity(String selectCity){ // Метод выбора на странице дефолтного (Москва) город
        commonElementsAll.spanForSelectLocationCity.click();
        waitForVisibility(commonElementsAll.spanLocationCity);
        String xPathWay = String.format("//span[contains(text(), '%s')]",  selectCity);
        commonElementsAll.spanLocationCity.findElement(By.xpath(xPathWay)).click();
        // Заплатка на ожидание обновления страницы и изменения оферов
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void userEnterToProFilePage(){
        waitForVisibility(commonElementsAll.nameForDropProfileMenuBTN);
        commonElementsAll.nameForDropProfileMenuBTN.click();
        waitForVisibility(commonElementsAll.enterProfileBTN);
        commonElementsAll.enterProfileBTN.click();
        commonElementsAll.nameForDropProfileMenuBTN.click();
    }

    public void userEnterToProfileScorePage(){
        waitForVisibility(commonElementsAll.nameForDropProfileMenuBTN);
        commonElementsAll.nameForDropProfileMenuBTN.click();
        waitForVisibility(commonElementsAll.enterScoreProfileBTN);
        commonElementsAll.enterScoreProfileBTN.click();
        commonElementsAll.nameForDropProfileMenuBTN.click();
    }

    public void userQuitFromProfilePage(){
        click(commonElementsAll.nameForDropProfileMenuBTN);
        click(commonElementsAll.exitProfileBTN);
        waitForVisibility(headerPage.entranceInAccountBtn);
    }

    public boolean licenseOfBankDisplayed(){
        try {
            waitForVisibility(commonElementsForDetailsPages.licenseOfCB);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    public void clickShowMoreBtn() {
        waitForVisibility(commonElements.showMoreBtn);
        commonElements.showMoreBtn.click();
    }

    public void addInfoIsDisplayed() {
        waitForAjaxElementIsVisible(commonElements.additionalInfo);
    }

    public void gotoAddInfoLinkClick() {
        clickOnAjaxElement(commonElements.gotoAddInfoLink);
    }

    public void bestOfferPageIsDisplayed(){
         if (isElementVisible(selectionPage.selectionPreload)){
        waitForUrlContains(PagesUrls.baseUrl() + "/private/consumer/");
        allElementsAreVisible(headerPage.getMainHeader());
        allElementsAreVisible(footerPage.getFooter());
        waitForVisibility(commonElementsAll.bestOffersTitle);
        waitForCountOfAjaxElementsMoreThan(By.xpath("//div[@class='offers-element element__base']"),1); //элемент commonElementsAll.bestOffersList
        waitForCountOfAjaxElementsMoreThan(By.xpath("//div[@class='offers-element element__best']"),1); //элемент commonElementsAll.bestOffersBestList
        Assert.assertTrue(commonElementsAll.bestOffersList.size()>0);
        Assert.assertTrue(commonElementsAll.bestOffersBestList.size()>0);}
    }
}
