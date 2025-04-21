package steps;

import hooks.Setup;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

/**
 * Classe implémentant les étapes Cucumber relatives à la page {@link HomePage}.
 * Contient les définitions des steps pour les scénarios de test impliquant la HomePage.
 */
public class HomePageSteps {

    // Initialisation du WebDriver via la classe Setup (hooks Cucumber)
    WebDriver webDriver = Setup.driver;

    // Instances des Page Objects nécessaires
    HomePage homePage = new HomePage(webDriver);

    /**
     * Implémentation de l'étape "I click on an advertisement".
     * Effectue un clic sur la bannière publicitaire de la page d'accueil.
     * Cette action déclenche normalement une redirection.
     */
    @When("I click on an advertisement")
    public void clickOnAnAdvertisement() {
        homePage.clickOnAdvertisement();
    }



}