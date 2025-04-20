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
    BasePage basePage = new BasePage(webDriver);

    /**
     * Implémentation de l'étape "I am on the Home page".
     * Vérifie que l'URL courante correspond bien à l'URL de la page d'accueil
     * définie dans le fichier de configuration.
     *
     * @throws AssertionError si l'URL ne correspond pas
     */
    @Given("I am on the Home page")
    public void iAmOnTheHomePage() {
        Assert.assertEquals(
                "L'URL devrait être celle de la page d'accueil",
                ConfigReader.getProperty("homePageUrl"),
                webDriver.getCurrentUrl()
        );
    }

    /**
     * Implémentation de l'étape "the menu bar should show {string}".
     * Vérifie que le texte du bouton de connexion correspond à la valeur attendue.
     *
     * @param signIn le texte attendu pour le bouton SignIn
     * @throws AssertionError si le texte ne correspond pas
     */
    @And("the menu bar should show {string}")
    public void theMenuBarShouldShow(String signIn) {
        Assert.assertEquals(
                "Le texte du menu SignIn ne correspond pas",
                basePage.getSignInText(),
                signIn
        );
    }

    /**
     * Implémentation de l'étape "I click on an advertisement".
     * Effectue un clic sur la bannière publicitaire de la page d'accueil.
     * Cette action déclenche normalement une redirection.
     */
    @When("I click on an advertisement")
    public void iClickOnAnAdvertisement() {
        homePage.clickOnAdvertisement();
    }



}