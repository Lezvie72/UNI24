package pages.mock;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.commonElementsForAllPages.UserData;
import pagesUrls.PagesUrls;
import testContext.TestContext;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class SmsCatcher extends Base {
    @FindBy(name = "nekot_teser")
    private WebElement passwordFromSmsField;
    /*
     * Форма восстановления пароля окончена
     */

    public SmsCatcher() {
        PageFactory.initElements(driver, this);
    }
    public void typeCodeFromSmsServer(String btn) {
        openNewTab();
        switchToTheSecondTab();
        TestContext.smsServerValueUrl = smsServerLink().get("smsServer");
        driver.get(TestContext.smsServerValueUrl);
        waitForPageLoaded(TestContext.smsServerValueUrl);
        try {
            getCodeFromSmsMock(UserData.phoneForChangePassword);
            switchToTheFirstTab();
            waitForVisibility(passwordFromSmsField);
            typeIntoField(TestContext.smsCode, passwordFromSmsField);
            click(TestContext.btn);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.urlToBe(PagesUrls.mainPage + "/"));
        } catch (Exception e) {
            switchToTheSecondTab();
            refreshPage();
            getCodeFromSmsMock(TestContext.correctPhone);
            switchToTheFirstTab();
            waitForVisibility(passwordFromSmsField);
            typeIntoField(TestContext.smsCode, passwordFromSmsField);
            click(TestContext.btn);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.urlToBe(PagesUrls.mainPage + "/"));
        }
    }

    public static Map<String, String> smsServerLink() {
        Map<String, String> smsServer = new HashMap<String, String>();
        if (PagesUrls.base.equals("pre-prod.vuaro.ru")) {
            smsServer.put("smsServer", "http://pre-prod-01.vuaro.ru:13003/channel/dev_channel/queue");
            return smsServer;
        } else {
            smsServer.put("smsServer", "http://" + PagesUrls.base + ":13003/channel/dev_channel/queue");
            return smsServer;
        }
    }

    private void getCodeFromSmsMock(String phoneNumber) {
        WebElement element;
        String xPath1 = String.format("(//tr[./td[contains(text(), '%s')]]/td[contains(text(), 'Пароль для входа в личный кабинет:')])[1]", phoneNumber);
        element = driver.findElement(By.xpath(xPath1));
        waitForVisibility(element);
        String smsCode = element.getText();
        smsCode = smsCode.replaceAll("[^0-9]", "");
        smsCode = smsCode.substring(0, smsCode.length() - 2);
        TestContext.smsCode = smsCode;
    }

    public void getPasswordSMSFromServer(String url) {
        openNewTab();
        switchToTheSecondTab();
        driver.get(url);
        String xPath = String.format("//tr[./td[contains(text(), '%s')]]/td[contains(text(), 'Код')]", UserData.getFormatNumber());
        TestContext.passwordFromSms = driver.findElement(By.xpath(xPath)).getText();
        TestContext.passwordFromSms = TestContext.passwordFromSms.replaceAll("[^0-9]", "");
        TestContext.passwordFromSms = TestContext.passwordFromSms.substring(0, TestContext.passwordFromSms.length() - 2);
        TestContext.smsServerValueUrl = driver.getCurrentUrl();
    }
}