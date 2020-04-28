package pages;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.auth.AuthPage;

public class CommonMethods extends Base {
    public CommonMethods() {
        PageFactory.initElements(driver, this);
    }

    public void logIn(WebElement loginField, WebElement passwordField, WebElement entranceBtn) {
        typeIntoFieldCharByChar(AuthPage.login, loginField);
        typeIntoFieldCharByChar(AuthPage.password, passwordField);
        entranceBtn.click();
    }

    /*
     *Тоже самое что и вверху но принимает данные, возможно останется только один >:-)
     */
    public void logIn(String login,
                      String password,
                      WebElement loginField,
                      WebElement passwordField,
                      WebElement entranceBtn) {
        typeIntoFieldCharByChar(login, loginField);
        typeIntoFieldCharByChar(password, passwordField);
        entranceBtn.click();
    }
}
