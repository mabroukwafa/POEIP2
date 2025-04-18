package steps;

import hooks.Setup;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.TShirtsPage;
import pages.WomenPage;

/**
 * Classe implémentant les étapes Cucumber relatives à la page "Women".
 * Contient les définitions des steps pour les scénarios de test impliquant la page des produits Women.
 */
public class WomenPageSteps {

    // Initialisation du WebDriver via la classe Setup (hooks Cucumber)
    WebDriver webDriver = Setup.driver;

    // Instance du Page Object pour la page Women
    WomenPage womenPage = new WomenPage(webDriver);

    /**
     * Implémentation de l'étape "I am redirected to the Women product page".
     * Vérifie que l'utilisateur est bien redirigé vers la page des produits Women
     * en contrôlant l'affichage du titre spécifique à cette page.
     *
     * @throws AssertionError si le titre de la page Women n'est pas visible
     */
    @Then("I am redirected to the Women product page")
    public void iAmRedirectedToTheOngletProductPage() {
        Assert.assertTrue(
                "Le titre de la page Women devrait être affiché",
                womenPage.womenTitleIsDisplayed()
        );
    }
}