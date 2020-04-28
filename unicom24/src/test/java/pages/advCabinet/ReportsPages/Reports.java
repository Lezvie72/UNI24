package pages.advCabinet.ReportsPages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.advCabinet.Header.HeaderAdvPage;

import java.util.Arrays;
import java.util.List;

public class Reports extends Base {

    private final HeaderAdvPage header = new HeaderAdvPage();

    String reportsOrderText = "Заявка на отчет «";
    String reportsOrderHistoryText = "История запросов на отчет «";

    @FindBy(xpath = "//div[@class='default-layout-view']")
    private WebElement reportBody;

    @FindBy(xpath = "//button[contains(text(), 'Проверить')]")
    private WebElement reportGetBTN;

    private final List<WebElement> elements;

public Reports(){
    PageFactory.initElements(driver, header);
    PageFactory.initElements(driver, this);
    elements = Arrays.asList(reportBody, reportGetBTN);
}

public void pageIsDisplayed(){
    allElementsAreVisible(header.getAdvHeader());
    allElementsAreVisible(elements);
}

public void reportPageCheck(String nameOfReport){
    String xTitle = String.format("//div[contains(text(), '%s')]", nameOfReport);
    WebElement element1 = driver.findElement(By.xpath(xTitle));
    waitForVisibility(element1);
    String xOrder = String.format("//div[contains(text(), '%s')]", reportsOrderText+nameOfReport+"»");
    WebElement element2 = driver.findElement(By.xpath(xOrder));
    waitForVisibility(element2);
    String xOrderHistory = String.format("//div[contains(text(), '%s')]", reportsOrderHistoryText+nameOfReport+"»");
    WebElement element3 = driver.findElement(By.xpath(xOrderHistory));
    waitForVisibility(element3);
}
}
