package pages.partnerCabinetPage.Header;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class HeaderPartnerCabinetPage extends Base {

    /*
     *Верхний хэдэр
     */


    /* Если после 19,04,2020 все еще закомментировано - удалить
    @FindBy(xpath = "//div[@class='ds-header-wrap']")
    public WebElement headerContainer;*/

    @FindBy(xpath = "//div[@class='ds-header-info-logo']")
    public WebElement logo;

    @FindBy(xpath = "//span[contains(text(), 'Кабинет Агента')]")
    public WebElement logoTitle;

    @FindBy(xpath = "//div[contains(text(), 'Текущий баланс')]")
    public WebElement balance;

    @FindBy(xpath = "//div[@class='ds-header-info-balance']/div[contains(text(), 'Вывести деньги')]")
    public WebElement getMoney;

    @FindBy(xpath = "//div[@class='ds-header-info-max-income']/div[contains(text(), 'Возможный максимальный доход')]")
    public WebElement patentialMoney;

    @FindBy(xpath = "//div[@class='ds-header-info-income']/div[contains(text(), 'Заработано за все время')]")
    public WebElement moneyOfAllTime;

    @FindBy(xpath = "//div[@class='ds-header-info-withdrawn']/div[contains(text(), 'Выведено за все время')]")
    public WebElement getMoneyForAllTime;

    @FindBy(xpath = "//div[contains(@class,'ds-header-info-user')]/div[contains(text(), 'Выход')]")
    public WebElement logOutBtn;

    @FindBy(xpath = "//div[@class='icon-bell']")
    public WebElement bellBtn;
    /*
     *Верхний хэдэр окончен
     */

    @FindBy(xpath = "//div[@class='url']/a")
    private List<WebElement>downHeader;

    @FindBy(xpath = "//div[@class='ds-menu-navigation-list']/a")
    private List<WebElement>downHeaderShop;

    private final List<WebElement>elements;

    public HeaderPartnerCabinetPage() {
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(logo, logoTitle, balance,
                getMoney, patentialMoney, moneyOfAllTime, getMoneyForAllTime,
                logOutBtn, bellBtn);
    }

    public void headerIsDisplayed() {
        waitForAllAjaxElementIsVisible(elements);
        Assert.assertEquals(10, downHeader.size()); //16 04 2020 число изменил 10
        Assert.assertEquals(1, downHeaderShop.size());
    }

    public List<WebElement> returnDownHeader() {
        return downHeader;
    }

}
