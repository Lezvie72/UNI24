package pages.blogs;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;
import pagesUrls.PagesUrls;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class BlogPage extends Base {
    private Header headerPage = new Header();
    private Footer footerPage = new Footer();

    @FindBy(xpath = "//h1[@class='blog-h1']")
    private WebElement blogTitle;

    @FindBy(css = ".blog-articles-title")
    private WebElement blogArticlesTitle;

    @FindBy(css = ".blog-articles-list")
    private WebElement blogArticlesList;

    @FindBy(xpath = "//li[@class='blog-articles-list-item']")
    private List<WebElement> blogArticles;

    @FindBy(css = ".blog-articles-more")
    private WebElement blogArticlesMore;

    @FindBy(xpath = "//div[@class='blog-news-list-item-description']")
    private List<WebElement> blogNewsDescription;

    @FindBy(xpath = "//div[@class='blog-news-list-item-img']")
    private List<WebElement> blogNewsImages;

    @FindBy(css = ".blog-news-more")
    private WebElement blogNewsMore;

    @FindBy(css = ".blog-subscribe")
    private WebElement blogSubscribeBlock;

    @FindBy(xpath = "//label[@class='blog-subscribe-content-controls-input-wrapper']/input")
    private WebElement blogEmailInput;

    @FindBy(xpath = "//button[contains(text(), 'Подписаться')]")
    private WebElement blogSubBTN;

    @FindBy(css = ".blog-selected-title")
    private WebElement blogSelectedTitle;

    @FindBy(xpath = "//li[@class='blog-selected-list-item']")
    private List<WebElement> blogSelectedList;

    private final List<WebElement> elements;

    public BlogPage() {
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(blogTitle, blogArticlesTitle, blogArticlesList, blogArticlesMore, blogNewsMore,
                blogSubscribeBlock, blogEmailInput, blogSubBTN);
    }

    public void onBlogPage(){
        driver.get(PagesUrls.blogPageUrl());
    }

    public void pageIsDisplayed(){
        allElementsAreVisible(headerPage.getMainHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footerPage.getFooter());
        Assert.assertTrue(blogArticles.size()>0);
        Assert.assertTrue(blogNewsDescription.size() == blogNewsImages.size());
        if (isElementVisible(blogSelectedTitle)){
        Assert.assertTrue(blogSelectedList.size()>=1);}
    }

    public void blogPostClick(){
        blogArticles.get(0).click();
    }



}
