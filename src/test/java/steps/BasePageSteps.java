package steps;

import hooks.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.LoginPage;
import pages.MyAccountPage;
import utils.ConfigReader;

/**
 * Cette classe contient les étapes de définition de {@link BasePage}.
 */
public class BasePageSteps {

    /*
    * Initialisation du WebDriver via la classe Setup (hooks Cucumber)
     */
    WebDriver webDriver = Setup.driver;

    /*
    * Instances des Pages Objects nécessaires
     */
    BasePage basePage = new BasePage(webDriver);
    LoginPage loginPage = new LoginPage(webDriver);
    MyAccountPage myAccountPage=new MyAccountPage(webDriver);


    /**
     * Implémentation de l'étape "I click on the Blog tab".
     * Clique sur le bouton redirigeant vers le blog
     */
    @When("I click on the Blog tab")
    public void clickOnBlogTab() {
        basePage.clickOnBlogTab();

        // Changement de fenêtre
        Object[] windowHandles = webDriver.getWindowHandles().toArray();
        webDriver.switchTo().window((String) windowHandles[1]);

    }

    /**
     * Implémentation de l'étape "I click on Sign in".
     * Clique sur le bouton sign in
     */
    @When("I click on Sign in")
    public void clickOnSignIn() {
        basePage.clickOnSignIn();
    }

    /**
     * Implémentation de l'étape "I click on Contact us"
     * Clique sur le bouton Contact us
     */
    @When("I click on Contact us")
    public void clickOnContactUs() {
        basePage.clickOnContactUs();
    }

    /**
     * Implémentation de l'étape "I click on the logo".
     * Clique sur le logo
     */
    @When("I click on the logo")
    public void clickOnLogo() {
        basePage.clickOnLogo();
    }

    /**
     * Implémentation de l'étape "I click on the {string} tab".
     * Clique sur un onglet
     * @param tabName le nom de l'onglet sur lequel cliquer
     */
    @When("I click on the {string} tab")
    public void chooseTab(String tabName) {
        switch (tabName){
            case "Women":
                basePage.clickOnWomenFilter();
                break;
            case "Dresses":
                basePage.clickOnDressesFilter();
                break;
            case "T-Shirts":
                basePage.clickOnTShirtsFilter();
                break;
        }
    }

    /**
     * Implémentation de l'étape "I click on the cart link in the header".
     * Clique sur le panier
     */
    @When("I click on the cart link in the header")
    public void clickOnCartLink() {
        basePage.clickOnAccessCart();
    }

    /**
     * Implémentation de l'étape "I am on the {string} page".
     * Rejoins la page demandée depuis la page d'accueil
     * @param page le page à rejoindre
     */
    @Given("I am on the {string} page")
    public void goToPage(String page) {
          switch (page.toLowerCase()) {
                case "home":
                    Assert.assertEquals(
                        "L'URL devrait être celle de la page d'accueil",
                        ConfigReader.getProperty("homePageUrl"),
                        webDriver.getCurrentUrl()
                    );
                    break;
                case "login":
                    basePage.clickOnSignIn();
                    break;
                case "my account":
                    basePage.clickOnSignIn();
                    loginPage.sendEmail(ConfigReader.getProperty("emailValid"));
                    loginPage.sendPassword(ConfigReader.getProperty("mdpValid"));
                    loginPage.clickLoginButton();
                    Assert.assertEquals("MY ACCOUNT",myAccountPage.getTitle());
                    break;

                default:
                    throw new IllegalArgumentException("Page inconnue : " + page);
            }
        }

    /**
     * Implémentation de l'étape "the search bar is visible".
     * S'assure que la barre de recherche est visible
     */
    @And("the search bar is visible")
    public void assertSearchBarVisible() {
        Assert.assertTrue(basePage.isSearchFieldVisible());
    }

    /**
     * Implémentation de l'étape "I type {string} in the search bar".
     * Entre la valeur donnée dans la barre de recherche
     * @param search la valeur à entrer
     */
    @When("I type {string} in the search bar")
    public void sendToSearchBar(String search) {
        basePage.insertInSearchField(search);
    }

    /**
     * Implémentation de l'étape "I click on the search icon".
     * Clique sur la loupe de recherche
     */
    @And("I click on the search icon")
    public void clickOnSearchIcon() {
        basePage.clickOnLoupeSearch();
    }

    /**
     * Implémentation de l'étape "I select the suggestion {string}".
     * Choisit la suggestion demandée dans la liste de suggestion de la barre de recherche
     * @param suggestion la suggestion à choisir
     */
    @And("I select the suggestion {string}")
    public void selectSuggestion(String suggestion) {
        basePage.chooseSuggestion(suggestion);
    }

    /**
     * Implémentation de l'étape "I should see {string} in the menu bar".
     * Vérifie le nom associé au compte connecté
     * @param myName le nom attendu
     */
    @And("I should see {string} in the menu bar")
    public void assertNameOfAccount(String myName) {
        Assert.assertEquals(basePage.getConnectedAccountName(),myName);
    }

    /**
     * Implémentation de l'étape "I click on the <Sign out> button".
     * Clique sur le bouton Sign out
     */
    @When("I click on the <Sign out> button")
    public void clickOnSignOutButton() {
        basePage.clickOnSignOut();
    }

    /**
     * Implémentation de l'étape "the menu bar should show {string}".
     * Vérifie que le texte du bouton de connexion correspond à la valeur attendue.
     *
     * @param signIn le texte attendu pour le bouton SignIn
     * @throws AssertionError si le texte ne correspond pas
     */
    @And("the menu bar should show {string}")
    public void assertRightMenuBar(String signIn) {
        Assert.assertEquals(
                "Le texte du menu SignIn ne correspond pas",
                basePage.getSignInText(),
                signIn
        );
    }
}
