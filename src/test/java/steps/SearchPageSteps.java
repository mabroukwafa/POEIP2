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

    /**
     * Implémentation de l'étape "I am redirected to the Search page".
     * Vérifie que l'utilisateur est bien redirigé vers la page de recherche
     * en confirmant l'affichage du titre spécifique à cette page.
     *
     * @throws AssertionError si le titre de la page de recherche n'est pas visible
     */
    @Then("I am redirected to the Search page")
    public void assertSearchPage(){
        Assert.assertTrue(searchPage.beOnSearchPage());
    }

    /**
     * Implémentation de l'étape "I search for an article".
     * Effectue une recherche d'article sur la page de recherche.
     *
     * @param articleName le nom de l'article à rechercher
     */
    @And("I see the article {string}")
    public void assertArticle(String articleName) {
        Assert.assertTrue(searchPage.isProductVisible(articleName));
    }
}

