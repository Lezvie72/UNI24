package pages;

import base.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;
import pages.verticals.common.CommonElementsForAllVerticals;

import java.util.Arrays;
import java.util.List;

public class ComparePage extends Base {
    Header headerPage = new Header();
    Footer footerPage = new Footer();
    CommonElementsForAllVerticals common = new CommonElementsForAllVerticals();

    @FindBy(xpath = "//h1[contains(text(), 'Сравнение предложений')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class='offers-compare-filters-container']//label[contains(text(), 'Показывать только различия ')]")
    private WebElement onlyDifferentCharacteristicsCheckbox;

    @FindBy(xpath = "//div[contains(text(), 'Перейти к выбору')]")
    private WebElement goToChoosing;

    //табы - 6 штук Кридиты, Микрозаймы, Автокредиты, Ипотека, КредКарты, Рефин
    @FindBy(xpath = "//div[contains(@class, 'offers-compare-filters-block')]//li")
    private List<WebElement> tabs;

    private final List<WebElement>elements;

    public ComparePage(){
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, common);
        elements = Arrays.asList(pageTitle, onlyDifferentCharacteristicsCheckbox);
    }

    public void emptyPageIsDisplayed() {
        waitForVisibility(goToChoosing);
    }

    public void pageIsDisplayed(){
        allElementsAreVisible(headerPage.getMainHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footerPage.getFooter());
        Assert.assertEquals(6, tabs.size());
    }

    public void tabClick(String nameOfTab) {
        for (WebElement element : tabs) {
            if (element.getText().contains(nameOfTab)) {
                element.click();
                break;
            } else {
                waitForText(element, nameOfTab);
            }
        }
    }

    public void compareBanksCreditCompareIsDisplayed (String countBanksCreditToCompare){
        Assert.assertEquals(common.btnBankCreditRemoveFromCompare.size(), Integer.parseInt(countBanksCreditToCompare));
    }

    public void removeBanksFromCompareCreditsClick(String countBanksRemoveFromCompare) {
        int CountBanks = Integer.parseInt(countBanksRemoveFromCompare);
        if (CountBanks > common.btnBankCreditRemoveFromCompare.size()) {
            CountBanks = common.btnBankCreditRemoveFromCompare.size();}
        for (int i = 0; i < CountBanks; i++)
            common.btnBankCreditRemoveFromCompare.get(0).click();
    }
}
