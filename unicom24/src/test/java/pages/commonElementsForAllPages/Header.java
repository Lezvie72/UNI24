package pages.commonElementsForAllPages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;

public class Header extends Base {

    @FindBy(css = "header a.app-header-logo ")
    private WebElement logoLink;

    /*менюшки следующие за логотипом сейчас их 4
    *Сервисы, Кредиты, Карты, Ещё
     */
    @FindBy(xpath = "//header//li[.//div[contains(text(), '')]]")
    private List<WebElement>menuItems;
    //менюшки окончены

    @FindBy(xpath = "//div[contains(text(), 'Ваш город')]")
    private WebElement yourCity;

    @FindBy(xpath = "//div[./a[@href='/sravnenie']]")
    public WebElement compareBtn;

    @FindBy(xpath = "//header//button[contains(text(), 'Войти')]")
    public WebElement entranceInAccountBtn;

    /*
    *Скрытые менюшки которые появляются при наведении мышкой
     */
    @FindBy(xpath = "//header//li[contains(@class, 'app-header-nav-list-item-links-item')]/a")
    private List<WebElement>hiddenItems;

    //Когда пользователь авторизован
    @FindBy(xpath = "//div[@class='app-header-user-block-info'][./div[contains(@class, auth)]]")
    private WebElement userAuthedBlock;

    public Header() {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getMainHeader() {
        return Arrays.asList(logoLink, yourCity, compareBtn);
    }

    public void clickMenuItem(String text) {
        for (WebElement element : menuItems) {
            if (element.getText().equals(text)) {
                element.click();
                break;
            }
        }
    }

    public void clickHiddenMenuItem(String text) {
        for (WebElement element : hiddenItems) {
            if (element.getText().equals(text)) {
                click(element);
                break;
            }
        }
    }

    public void testWait(int mSec) throws InterruptedException {
        sleep(mSec);
    }

    public void entranceInAccountBtnClick() {
        click(entranceInAccountBtn);
    }


    public void mainPageUserIsAuthorized() {
        waitForVisibility(userAuthedBlock);
    }

    public static void checkBreadCrumbs(int countOfBreadCrumbs) {
        sa.assertEquals(countOfBreadCrumbs, driver.findElements(By.xpath("//ul[contains(@class, 'ui-breadcrumbs-list')]/li[not(contains(@class, 'ui-breadcrumbs-item-img'))][./*[contains(text(), '')]]")).size());
    }

    //проверка ХК в подробной странице микрозайма
    public static void checkBreadCrumbsMicroCreditsDetailedPage(int countOfBreadCrumbs) {
        sa.assertEquals(countOfBreadCrumbs, driver.findElements(By.cssSelector(".offer-detail-qiwi-breadcrumbs a")).size());
    }
}
