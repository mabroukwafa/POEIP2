package steps;

import hooks.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.ConfigReader;

/**
 * Cette classe contient les étapes de test pour la page {@link MyAccountPage}
 */
public class MyAccountPageSteps {
    WebDriver webDriver = Setup.driver;
    MyAccountPage myAccountPage = new MyAccountPage(webDriver);

    /**
     * Implémentation de l'étape "I am redirected to the <My Account> page".
     * Vérifie que l'utilisateur est bien redirigé vers la page My Account
     * en confirmant l'affichage du titre spécifique à cette page.
     *
     * @throws AssertionError si le titre de la page My Account n'est pas visible
     */
    @Then("I should be redirected to <My Account> page")
    public void iShouldBeRedirectedToMyAccountPage() {
        Assert.assertEquals("MY ACCOUNT",myAccountPage.getTitle());
    }

    /**
     * Implémentation de l'étape "I click on <My Addresses>".
     * Effectue un clic sur le bouton "My Addresses" de la page My Account.
     */
    @When("I click on <My Addresses>")
    public void iClickOnAddAddress() {
        myAccountPage.clickMyAddressButton();
    }


    /**
     * Implémentation de l'étape "I click on <Home> button".
     * Effectue un clic sur le bouton "Home" de la page My Account.
     */
    @When("I click on <Home> button")
    public void iClickOnHomeButton() {
        myAccountPage.clickHomeButton();

    }

    /**
     * Implémentation de l'étape "I click one the <Personal information> button".
     * Effectue un clic sur le bouton "Personal information" de la page My Account.
     */
    @When("I click on the <Personal information> button")
    public void iClickOnThePersonalInformationButton() {
        myAccountPage.clickPersonalInformationButton();
    }

    /**
     * Implémentation de l'étape "I click on the <Orders history> option".
     * Effectue un clic sur le bouton "Orders history" de la page My Account.
     */
    @When("I click on the <Order history> option")
    public void iClickOnTheOrderHistoryOption() {
        myAccountPage.clickOrderButton();
    }

    /**
     * Implémentation de l'étape "I click on the <My Credit Slips> option".
     * Effectue un clic sur le bouton "My Credit Slips" de la page My Account.
     */
    @When("I click on the <My Credit Slips> option")
    public void iClickOnTheMyCreditSlipsOption() {
        myAccountPage.clickCreditsButton();
    }

    /**
     * Implémentation de l'étape "I click on <My Addresses>".
     * Effectue un clic sur le button d'ajout d'une nouvelle adresse de la page My Account.
     */
    @When("I click on <Add my first Address>")
    public void iClickOnAddMyFirstAddress() {
        myAccountPage.clickAddNewAddressButton();
    }
}
