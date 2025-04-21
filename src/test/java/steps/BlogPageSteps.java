package steps;

import hooks.Setup;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BlogPage;

/**
 * Cette classe contient les étapes de test pour la page {@link BlogPage}.
 */
public class BlogPageSteps {
    // Une instance de WebDriver de la classe Setup
    WebDriver webDriver = Setup.driver;
    BlogPage blogPage = new BlogPage(webDriver);

    /**
     * Implémentation de l'étape "I am redirected to the PrestaShop blog site".
     * Cette méthode vérifie que l'utilisateur est redirigé vers le site du blog
     * @throws AssertionError si le titre du blog n'est pas affiché.
     */
    @Then("I am redirected to the PrestaShop blog site")
    public void assertOnPrestaShopBlogSite() {
        Assert.assertTrue(blogPage.blogTitleIsDisplayed());
    }
}
