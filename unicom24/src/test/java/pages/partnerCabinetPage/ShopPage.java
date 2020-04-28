package pages.partnerCabinetPage;

import base.Base;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pagesUrls.PagesUrls;

import java.util.Arrays;
import java.util.List;

public class ShopPage extends Base {

    /*
   Блок Header
    */

    @FindBy(xpath = "//div[@id='nav164114682']")
    private WebElement headerBlock;

    @FindBy(xpath = "//a/img")
    private WebElement unicomImage;

    @FindBy(xpath = "//a[contains(text(), 'FAQ')]")
    private WebElement faq;

    @FindBy(xpath = "//a[contains(text(), 'Доставка')]")
    private WebElement delivery;

      /*
   Блок Header окончен
    */

    /*
 Блок Товары
  */
    @FindBy(xpath = "//div[@id='rec167913378']")
    private WebElement toptext;

    @FindBy(xpath = "//div[@class='t-container t754__container_mobile-grid']")
    private WebElement itemsBlock;

    @FindBy(xpath = "//div[@class='t754__imgwrapper ']//div")
    private List<WebElement> items;

    @FindBy(xpath = "//div[@class='t473']")
    private WebElement deliveryInformationBlock;

    /*
   Блок Товары окончен
    */

    /*
   Блок Social links
    */

    @FindBy(xpath = "//div[@class='t560']")
    private WebElement socialLinksBlock;

    @FindBy(xpath = "//div[@class='t-sociallinks__item']/a")
    private List<WebElement> socialLinks;

    /*
   Блок Social links окончен
    */

    /*
   Блок Footer
    */

    @FindBy(xpath = "//div[@class='t-col t-col_10 t-prefix_1']//a")
    private List<WebElement> links;

    @FindBy(xpath = "//div[@class='t-col t-col_6 t-prefix_3']")
    private WebElement text;

    /*
   Блок Footer окончен
    */

    private final List<WebElement>elements;

    public ShopPage() {
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(headerBlock, unicomImage, faq, delivery, toptext, itemsBlock, deliveryInformationBlock,
                socialLinksBlock, text);
    }

    public void onPage() {
        driver.get(PagesUrls.shopPage());
        waitForPageLoaded(PagesUrls.shopPage());
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(elements);
        Assert.assertTrue(items.size() > 0);
        Assert.assertEquals(4, socialLinks.size());
        Assert.assertEquals(4, links.size());
    }
}
