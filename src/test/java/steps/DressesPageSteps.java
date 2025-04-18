package steps;

import hooks.Setup;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.DressesPage;

/**
 * Classe implémentant les étapes Cucumber relatives à la page "Dresses".
 * Contient les définitions des steps pour les scénarios de test impliquant la page des robes.
 */
public class DressesPageSteps {

    // Driver Selenium initialisé via la classe Setup (hooks Cucumber)
    WebDriver webDriver = Setup.driver;

    // Instance du Page Object pour interagir avec la page Dresses
    DressesPage dressesPage = new DressesPage(webDriver);

    /**
     * Implémentation de l'étape "I am redirected to the Dresses product page".
     * Vérifie que l'utilisateur est bien redirigé vers la page Dresses
     * en confirmant l'affichage du titre spécifique à cette page.
     *
     * @throws AssertionError si le titre de la page Dresses n'est pas visible
     */
    @Then("I am redirected to the Dresses product page")
    public void iAmRedirectedToTheOngletProductPage() {
        Assert.assertTrue(
                "Le titre de la page Dresses devrait être affiché",
                dressesPage.dressesTitleIsDisplayed()
        );
    }
}