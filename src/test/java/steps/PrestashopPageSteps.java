package steps;

import hooks.Setup;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.PrestashopPage;

/**
 * Classe contenant les étapes (steps) Cucumber pour les tests relatifs à la page PrestaShop.
 * Cette classe implémente les définitions des étapes Gherkin pour les scénarios de test.
 */
public class PrestashopPageSteps {

    // Initialisation du WebDriver à partir de la configuration de l'environnement
    // (récupéré via la classe Setup contenant les hooks Cucumber)
    WebDriver driver = Setup.driver;

    // Création d'une instance de la page PrestaShop
    // Permet d'interagir avec les éléments de la page via le Page Object Model
    PrestashopPage prestashopPage = new PrestashopPage(driver);

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
                prestashopPage.titrePrestashopIsDisplayed()
        );
    }
}