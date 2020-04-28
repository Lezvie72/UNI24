package stepDefinitions.blogs;

import base.Base;
import cucumber.api.java.ru.Тогда;
import pages.blogs.DetailedArticlePage;

public class DetailedArticlePageStepDefinition extends Base {
    private final DetailedArticlePage detailedArticlePage = new DetailedArticlePage();

    @Тогда("^отображается подробная страница поста$")
    public void blogPostPageIsDisplayed(){
        detailedArticlePage.pageIsDisplayed();
    }
}
