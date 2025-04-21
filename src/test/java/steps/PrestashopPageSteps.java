package steps;

import hooks.Setup;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.PrestashopPage;

/**
 * Cette classe contient les étapes de test pour la page {@link PrestashopPage}
 */
public class PrestashopPageSteps {

    // Une instance de WebDriver de la classe Setup
    WebDriver webDriver = Setup.driver;

    // Création d'une instance de la page PrestaShop
    PrestashopPage prestashopPage = new PrestashopPage(webDriver);

    /**
     * Implémentation de l'étape "I am redirected to the PrestaShop partner site".
     * Vérifie que l'utilisateur est bien redirigé vers le site partenaire de PrestaShop
     * en contrôlant l'affichage du titre de la page.
     *
     * @throws AssertionError si le titre de la page PrestaShop n'est pas visible
     */
    @Then("I am redirected to the PrestaShop partner site")
    public void iAmRedirectedToThePrestaShopPartnerSite() {
        // Assertion pour vérifier que le titre de la page PrestaShop est affiché
        Assert.assertTrue(
                "Le titre de la page PrestaShop devrait être affiché",
                prestashopPage.isPrestashopTitleDisplayed()
        );
    }
}