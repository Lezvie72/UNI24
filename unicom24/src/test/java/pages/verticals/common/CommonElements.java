package pages.verticals.common;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonElements extends Base {

    @FindBy(css = ".wrapper-vertical")
    public WebElement bankBlock;

    @FindBy(css = "section.header")
    public WebElement headerOfBank;

    @FindBy(css = ".header-reviews .rating-stars")
    public WebElement rating;

//    @FindBy(xpath = "//a[contains(text(), 'Предложения')]")
//    public WebElement offersTab;
//
//    @FindBy(xpath = "//a[contains(text(), 'Условия')]")
//    public WebElement conditionsTab;
//
//    @FindBy(xpath = "//a[contains(text(), 'Документы')]")
//    public WebElement documentsTab;
//
//    @FindBy(xpath = "//a[contains(text(), 'Отзывы')]")
//    public WebElement commentsTab;
//
//    @FindBy(xpath = "//a[contains(text(), 'Об организации')]")
//    public WebElement aboutOrgTab;

    @FindBy(xpath = "//div[@class='offer-full-info-wrapper']//div[contains(text(), 'Ставка')]")
    public WebElement bet;

    @FindBy(xpath = "//div[@class='offer-full-info-wrapper']//div[contains(text(), 'Сумма кредита')]")
    public WebElement sum;

    @FindBy(xpath = "//div[@class='offer-full-info-wrapper']//div[contains(text(), 'Срок')]")
    public WebElement time;

    @FindBy(xpath = "//div[@class='offer-full-info-wrapper']//div[contains(text(), 'Возраст заемщика')]")
    public WebElement age;

    @FindBy(xpath = "//div[@class='offer-full-info-wrapper']//div[contains(text(), 'Предварительное решение')]")
    public WebElement beforeApproved;

    //Внутри одного оффера кнопка подробнее
    @FindBy(css = "button.add-button_show")
    public WebElement showMoreBtn;

    //Блок который появляется по аджакс по нажатию на кнопку подробнее (селектор выше)
    @FindBy(css = ".additional-items")
    public WebElement additionalInfo;

    //В микрозаймах в этом допБлоке есть кнопка Перейти ведущая на подробную страницу
    @FindBy(css = ".additional-items a")
    public WebElement gotoAddInfoLink;

    public CommonElements() {
        PageFactory.initElements(driver, this);
    }
}
