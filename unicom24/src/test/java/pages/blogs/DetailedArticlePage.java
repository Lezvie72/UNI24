package pages.blogs;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.commonElementsForAllPages.Footer;
import pages.commonElementsForAllPages.Header;
import pagesUrls.PagesUrls;

import java.util.Arrays;
import java.util.List;

public class DetailedArticlePage extends Base {
    private Header headerPage = new Header();
    private Footer footerPage = new Footer();

    @FindBy(xpath = "//div[@class='blog-detail-img']/img")
    private WebElement articleImg;

    @FindBy(xpath = "//li[@class='blog-detail-breadcrumbs-item']")
    private List<WebElement> articleBreadCrumbs;

    @FindBy(xpath = "//li[@class='blog-detail-social-list-item']")
    private List<WebElement> articleSocialLinks;

    @FindBy(css = ".blog-detail-content")
    private WebElement articleText;

    @FindBy(css = ".blog-detail-attention")
    private WebElement articleAttentionBlock;

    @FindBy(xpath = "//li[@class='blog-detail-attention-list-item']")
    private List<WebElement> articleAttentionList;

    @FindBy(css = ".blog-detail-similar-title")
    private WebElement articlesSimilarTitle;

    @FindBy(xpath = "//li[@class='blog-detail-similar-list-item']")
    private List<WebElement> articleSimilarList;

    private final List<WebElement> elements;

    public DetailedArticlePage() {
        PageFactory.initElements(driver, this);
        elements = Arrays.asList(articleImg, articleText, articleAttentionBlock, articlesSimilarTitle);
    }

    public void pageIsDisplayed(){
        allElementsAreVisible(headerPage.getMainHeader());
        allElementsAreVisible(elements);
        allElementsAreVisible(footerPage.getFooter());
        Assert.assertTrue(articleBreadCrumbs.size() == 3);
        Assert.assertTrue(articleSocialLinks.size() == 4);
        Assert.assertTrue(articleAttentionList.size() > 0);
        Assert.assertTrue(articleSimilarList.size() > 0);
    }

}
