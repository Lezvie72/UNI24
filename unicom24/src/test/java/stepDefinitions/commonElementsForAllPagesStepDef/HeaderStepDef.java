package stepDefinitions.commonElementsForAllPagesStepDef;

import base.Base;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import pages.commonElementsForAllPages.Header;

public class HeaderStepDef extends Base {

    private final Header header = new Header();

    @И("^пользователь нажимает на кнопку войти$")
    public void logIn() {
        header.entranceInAccountBtnClick();
    }

    @Тогда("^пользователь нажимает на \"([^\"]*)\" в хэдэре$")
    public void userClickItemInHeader(String itemName) {
        header.clickMenuItem(itemName);
    }

    @Тогда("^пользователь нажимает на \"([^\"]*)\" в появившемся меню$")
    public void userClickItemInAppearMenu(String itemName) {
        header.clickHiddenMenuItem(itemName);
    }

    @Тогда("^тест ждет \"(\\d+)\" миллисекунд")
    public void testWait(int itemName) throws InterruptedException {
        header.testWait(itemName);
    }
}
