package pages.brokerCabinet.header;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class HeaderBrokerCabinetPage extends Base {

    @FindBy(xpath = "//img[@src=\"/static/dist/b2b_office/img/logo.f7de1b6.png\"]")
    public WebElement logo;

    @FindBy(xpath = "//a[@href=\"/b2b_office/\"]/div[contains(text(), 'Кабинет агента')]")
    public WebElement logoTitle;

    @FindBy(xpath = "//div[contains(text(), 'Текущий баланс')]")
    public WebElement currentMoney;

    @FindBy(xpath = "//div[@class='ui-app-header-block']/button[./span[contains(text(), 'Пополнить счет')]]")
    public WebElement giveMoneyBtn;

    @FindBy(css = ".ui-dropdown-menu__head-name")
    public WebElement dropMenu;

    public List<WebElement> getHeader() {
        return Arrays.asList(logo, logoTitle, currentMoney, giveMoneyBtn, dropMenu);
    }

    /*
     * Раскрывающееся меню справа вверху
     */
    @FindBy(xpath = "//span[contains(text(), 'Выход')]")
    public WebElement logoutBtn;

    @FindBy(xpath = "//a[@href=\"/b2b_office/user/profile\" and contains(text(), 'Профиль')]")
    public WebElement profileLink;

    /*
     * Панель пополнить счет
     */
    @FindBy(xpath = "//div[contains(text(), 'Пополнение счета')]")
    public WebElement giveMoneyTitle;

    @FindBy(xpath = "//div[./div[contains(text(), 'Глушкова Елизавета Электроновна')]]/a[contains(text(), 'Договор оферты')]")
    public WebElement contractBtn;

    @FindBy(xpath = "//div[./div[contains(text(), 'Способ пополнения:')]]/label[./div[contains(text(), 'Оплата через Robokassa')]]")
    public WebElement robokassaPaymentInput;

    @FindBy(xpath = "//div[./div[contains(text(), 'Способ пополнения:')]]/label[./div[contains(text(), 'Оплата через PayTure')]]")
    public WebElement payTurePaymentInput;

    @FindBy(name = "sum")
    public WebElement sumInput;

    @FindBy(xpath = "//button[not(contains(@class, 'btn-middle-with-border'))]/span[contains(text(), 'Пополнить счет')]")
    public WebElement giveMoneyPanelBtn;

    public List<WebElement> giveMoneyPanel() {
        return Arrays.asList(giveMoneyTitle, contractBtn, robokassaPaymentInput,
                payTurePaymentInput, sumInput, giveMoneyPanelBtn);
    }
    /*
     * Панель пополнить счет окончена
     */

    /*
     * Подменю хэдэра
     */
    @FindBy(xpath = "//div[contains(@class, 'ui-sub-menu-item-text')]")
    private List<WebElement> elements;

    public List<WebElement> getSubMenuElements() {
        return elements;
    }
    /*
     * Подменю хэдэра окончено
     */

}
