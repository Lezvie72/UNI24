package pages.advCabinet.Header;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class HeaderAdvPage {

    @FindBy(css = "div.ds-header-logo")
    public WebElement logo;

    @FindBy(xpath = "//div[contains(text(), 'Кабинет банков и рекламодателей')]")
    private WebElement logoTitle;

    @FindBy(xpath = "//div[contains(text(), 'Текущий баланс')]")
    private WebElement currentMoney;

    @FindBy(xpath = "//button[contains(text(), 'Пополнить счет')]")
    public WebElement giveMoneyBtn;

    //@FindBy(css = "div.ds-impersonalization-inner")
    //private WebElement peopleIcon;

    @FindBy(css = "div.ds-header-user")
    public WebElement dropMenu;


    // Раскрывающийся список при нажатии на фио пользователя
    @FindBy(xpath = "//a[@href=\"/advertiser_office/user/profile\" and contains(text(), 'Профиль')]")
    public WebElement dropMenuUserProfile;

    @FindBy(xpath = "//a[@href=\"/advertiser_office/user/profile\" and contains(text(), 'Счет')]")
    public WebElement dropMenuScore;

    @FindBy(xpath = "//a[@href=\"/advertiser_office/user/profile\" and contains(text(), 'Настройки')]")
    public WebElement dropMenuSettings;

    @FindBy(xpath = "//div[contains(text(), 'Выход')]")
    public WebElement dropMenuLogOut;

    public List<WebElement> getAdvHeader() {
        return Arrays.asList(logo, logoTitle, currentMoney, giveMoneyBtn, dropMenu);
    }

}
