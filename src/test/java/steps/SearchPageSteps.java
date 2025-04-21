package steps;

import hooks.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;

/**
 * Cette classe contient les étapes de test pour la page {@link SearchPage}
 */
public class SearchPageSteps {
    WebDriver webDriver = Setup.driver;
    SearchPage searchPage = new SearchPage(webDriver);

    @Then("I am redirected to the Search page")
    public void assertSearchPage(){
        Assert.assertTrue(searchPage.beOnSearchPage());
    }

    @And("I see the article {string}")
    public void iSeeTheArticle(String articleName) {
        Assert.assertTrue(searchPage.isProductVisible(articleName));
    }
}

