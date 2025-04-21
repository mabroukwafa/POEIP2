package steps;

import hooks.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.BlogPage;
import pages.HomePage;
import utils.ConfigReader;

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