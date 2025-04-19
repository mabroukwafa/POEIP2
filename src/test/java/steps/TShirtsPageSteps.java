package steps;

import hooks.Setup;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.TShirtsPage;

/**
 * Cette classe contient les étapes de test pour la page {@link TShirtsPage}
 */
public class TShirtsPageSteps {

    // Initialisation du WebDriver via la classe Setup contenant les configurations de test
    WebDriver webDriver = Setup.driver;

    // Instance du Page Object pour interagir avec la page T-Shirts
    TShirtsPage tShirtsPage = new TShirtsPage(webDriver);

    /**
     * Implémentation de l'étape "I am redirected to the T-Shirts product page".
     * Vérifie que l'utilisateur est bien redirigé vers la page T-Shirts
     * en confirmant l'affichage du titre spécifique à cette page.
     *
     * @throws AssertionError si le titre de la page T-Shirts n'est pas visible
     */
    @Then("I am redirected to the T-Shirts product page")
    public void iAmRedirectedToTheOngletProductPage() {
        Assert.assertTrue(
                "Le titre de la page T-Shirts devrait être visible",
                tShirtsPage.tShirtTitleIsDisplayed()
        );
    }
}