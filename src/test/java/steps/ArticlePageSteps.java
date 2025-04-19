package steps;

import hooks.Setup;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ArticlePage;

/**
 * Cette classe contient les étapes de test pour la page {@link ArticlePage}.
 */
public class ArticlePageSteps {

    // Une instance de WebDriver de la classe Setup
    WebDriver webDriver = Setup.driver;
    ArticlePage articlePage = new ArticlePage(webDriver);

    /**
     * Cette méthode vérifie que l'utilisateur est redirigé vers la page d'article
     * correspondant au nom de l'article donné.
     *
     * @param articleName Le nom de l'article attendu.
     * @throws AssertionError si le nom de l'article affiché
     *  ne correspond pas au nom de l'article attendu.
     */
    @Then("I am redirected to the article page related to {string}")
    public void assertOnRightArticle(String articleName) {
        Assert.assertEquals(articleName,articlePage.getArticleName());
    }
}
