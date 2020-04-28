package pages.profile;

import base.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class CommonVerticalsForProfilePages extends Base {

    String verticalMenuWayForButtons = "//div[@class='menu-buttons']";

    @FindBy(xpath = "//a[@class='balance']")
    public WebElement balanceProfile;

    @FindBy(xpath = "//div[@class='balance__value']")
    public WebElement balanceValueProfile;

    @FindBy(xpath = "//div[@class='menu-buttons']/a")
    private List<WebElement> menuTabs;

    public List<WebElement> commonElements() {
        return Arrays.asList(balanceProfile, balanceValueProfile);
    }

    public void verticalPageClick(String nameVerticalPage){
        String xPathWay = String.format(verticalMenuWayForButtons + "/a[contains(text(), '%s')]",  nameVerticalPage);
        WebElement targetElement = driver.findElement(By.xpath(xPathWay));
        targetElement.click();
    }

    public void compareNumberOfVerticalsOnPage(){
        Assert.assertEquals(3, menuTabs.size()); // увеличить число когда вертикалки заработают
    }

    public List<WebElement> getProfileHeader() {
        return Arrays.asList(balanceProfile, balanceValueProfile);
    }

}
