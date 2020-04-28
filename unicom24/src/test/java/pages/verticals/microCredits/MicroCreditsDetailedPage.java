package pages.verticals.microCredits;

import base.Base;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;
import pages.verticals.common.CommonElements;
import pages.verticals.common.CommonMethodsForAllVerticals;

import java.util.Arrays;
import java.util.List;

public class MicroCreditsDetailedPage extends Base {

    Header headerPage = new Header();
    Footer footerPage = new Footer();
    CommonElements commonElements = new CommonElements();
    CommonMethodsForAllVerticals commonMethodsForAllVerticals = new CommonMethodsForAllVerticals();


    //Синий баннер
    @FindBy(css = ".offer-detail-qiwi-header")
    private WebElement banner;

    //Заголовок в баннере
    @FindBy(css = ".offer-detail-qiwi-header h1")
    private WebElement titleH1;

    //заголовки h2
    @FindBy(css = ".content h2")
    private List<WebElement> h2Titles;

    //Все блоки на странице в теле под баннером 6 единиц
    @FindBy(css = ".scroll-to-component")
    private List<WebElement>blocksInBody;

    //меню справа 6 линков
    @FindBy(css = ".menu a")
    private List<WebElement>menuLinks;

    private final List<WebElement> elements;


    public MicroCreditsDetailedPage() {
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, headerPage);
        PageFactory.initElements(driver, footerPage);
        PageFactory.initElements(driver, commonElements);
        elements = Arrays.asList(banner, titleH1);
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(elements);
        allElementsAreVisible(headerPage.getMainHeader());
        allElementsAreVisible(footerPage.getFooter());
        allElementsAreVisible(h2Titles);
        allElementsAreVisible(blocksInBody);
        Header.checkBreadCrumbsMicroCreditsDetailedPage(3);
        Assert.assertEquals(2, h2Titles.size());
        Assert.assertEquals(8, blocksInBody.size());
        Assert.assertEquals(7, menuLinks.size());
    }
}
