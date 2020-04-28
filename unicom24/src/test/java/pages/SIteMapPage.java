package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;

import java.util.Arrays;
import java.util.List;

public class SIteMapPage extends Base {

    private final Header header = new Header();
    private final Footer footer = new Footer();

    @FindBy(xpath = "//h1[contains(text(), 'Карта сайта')]")
    private WebElement siteMapTitle;


    public SIteMapPage() {
        PageFactory.initElements(driver, header);
        PageFactory.initElements(driver, this);
        PageFactory.initElements(driver, footer);
    }

    public void pageIsDisplayed() {
        allElementsAreVisible(header.getMainHeader());
        waitForVisibility(siteMapTitle);
        allElementsAreVisible(footer.getFooter());
    }

    public void checkSection(String section) {
        String xPath = String.format("//div[./h2[contains(text(), '%s')]]/ul/li/a", section);
        List<WebElement> elements = driver.findElements(By.xpath(xPath));
        for (WebElement element : elements) {
            try {
                waitForVisibility(element);
                openLinkInTheNewTab(element);
                String xPath1 = "//div[./h2]/ul/li/a";
                waitForVisibility(By.xpath(xPath1));
                closeTab();
                switchToTheFirstTab();
            } catch (Exception e) {
                waitForVisibility(driver.findElement(By.className("ui-list-bank-item")));
                closeTab();
                switchToTheFirstTab();
            }
        }
    }
}
