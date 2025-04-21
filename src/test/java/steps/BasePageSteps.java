package steps;

import hooks.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.BlogPage;
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

    /*
    * Implémentation de l'étape "I am on the Home page".
     */
    @When("I click on the Blog tab")
    public void IClickOnTheBlogTab() {
        basePage.clickOnBlogTab();

        // Changement de fenêtre
        Object[] windowHandles = webDriver.getWindowHandles().toArray();
        webDriver.switchTo().window((String) windowHandles[1]);

    }

    // Implémentation de l'étape "I click on Sign in"
    @When("I click on Sign in")
    public void iClickOnSignIn() {
        basePage.clickOnSignIn();
    }


    @When("I click on Contact us")
    public void iClickOnContactUs() {
        basePage.clickOnContactUs();
    }


    @When("I click on the logo")
    public void iClickOnTheLogo() {
        basePage.clickOnLogo();
    }

    @When("I click on the {string} tab")
    public void iClickOnTheTab(String arg0) {
        switch (arg0){
            case "Women":
                basePage.clickOnFiltreWomen();
                break;
            case "Dresses":
                basePage.clickOnFiltreDresses();
                break;
            case "T-Shirts":
                basePage.clickOnFiltreTShirts();
                break;
        }
    }

    @When("I click on the cart link in the header")
    public void iClickOnTheCartLinkInTheHeader() {
        basePage.clickOnAccessCart();
    }

    @Given("I am on the {string} page")
    public void iAmOnThePage(String page) {
          switch (page.toLowerCase()) {
                case "home":
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

    @And("the search bar is visible")
    public void theSearchBarIsVisible() {
        Assert.assertTrue(basePage.isFieldSearchVisible());
    }

    @When("I type {string} in the search bar")
    public void iTypeInTheSearchBar(String search) {
        basePage.insertInFieldSearch(search);
    }

    @And("I click on the search icon")
    public void iClickOnTheSearchIcon() {
        basePage.clickOnLoupeSearch();
    }

    @And("I select the suggestion {string}")
    public void iSelectTheSuggestion(String suggestion) {
        basePage.chooseSuggestion(suggestion);
    }

    @And("I should see {string} in the menu bar")
    public void iShouldSeeInTheMenuBar(String myName) {
        Assert.assertEquals(basePage.getMyname(),myName);
    }

    @When("I click on the <Sign out> button")
    public void iClickOnTheSignOutButton() {
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
    public void theMenuBarShouldShow(String signIn) {
        Assert.assertEquals(
                "Le texte du menu SignIn ne correspond pas",
                basePage.getSignInText(),
                signIn
        );
    }
}
