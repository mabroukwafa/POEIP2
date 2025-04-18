package steps;

import hooks.Setup;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ArticlePage;

public class ArticlePageSteps {

    WebDriver webDriver = Setup.driver;
    ArticlePage articlePage = new ArticlePage(webDriver);

    @Then("I am redirected to the article page related to {string}")
    public void assertOnRightArticle(String articleName) {
        Assert.assertEquals(articleName,articlePage.getArticleName());
    }
}
