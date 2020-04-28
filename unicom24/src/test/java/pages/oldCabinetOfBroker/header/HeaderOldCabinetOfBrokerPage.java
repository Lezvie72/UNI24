package pages.oldCabinetOfBroker.header;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderOldCabinetOfBrokerPage {

    @FindBy(css = ".header-logo-image")
    public WebElement logo;

    @FindBy(xpath = "//div/span[contains(text(), 'ООО \"Юником\"')]")
    public WebElement logoTitle;

    @FindBy(xpath = "//div/a[contains(text(), 'На счете')]")
    public WebElement amount;

    @FindBy(xpath = "//a/span[contains(text(), 'пополнить счет')]")
    public WebElement giveMoneyBtn;

    @FindBy(xpath = "//a[@href=\"/lk/\"]/span[contains(text(), 'Главная')]")
    public WebElement onMainPageBtn;

    @FindBy(xpath = "//a[@href=\"/help/\"]/span[contains(text(), 'Справка')]")
    public WebElement helpBtn;

    @FindBy(xpath = "//a[@href=\"/lk/accounts/profile/\"]/span[contains(text(), 'Настройки')]")
    public WebElement settingsBtn;

    @FindBy(xpath = "//a[@href=\"#\"]/span[contains(text(), 'Выход')]")
    public WebElement exitBtn;

    @FindBy(xpath = "//a[@href=\"/lk/accounts/profile/#invite-acquaintance\"]/span[contains(text(), 'Пригласить знакомых')]")
    public WebElement callFriendsBtn;
}
