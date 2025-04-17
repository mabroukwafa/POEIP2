package steps;

import hooks.Setup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BlogPage;
import pages.HomePage;

public class BlogPageSteps {

    private final WebDriver webDriver = Setup.driver;
    BlogPage blogPage = new BlogPage(webDriver);


    @Then("I am redirected to the PrestaShop blog site")
    public void iAmRedirectedToThePrestaShopBlogSite() {

        Assert.assertTrue(blogPage.blogTitleIsDisplayed());
    }
}
