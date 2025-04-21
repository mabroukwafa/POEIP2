package steps;

import hooks.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.MyAddressesPage;

import static org.junit.Assert.assertEquals;

/**
 * Cette classe contient les étapes de test pour la page {@link MyAddressesPage}
 */
public class MyAddressesPageSteps {
    WebDriver webDriver = Setup.driver;
    MyAddressesPage myAdressesPage = new MyAddressesPage(webDriver);

    /**
     * Implémentation de l'étape "I click on <Add a new Address>".
     * Cette méthode simule le clic sur le bouton "Add a new Address"
     */
    @And("I click on <Add a new Address>")
    public void clickOnAddANewAddress() {
        myAdressesPage.clickMyAddressButton();
    }

    /**
     * Implémentation de l'étape "I am redirected to the <My Addresses> page".
     * Cette méthode vérifie que l'utilisateur est redirigé vers la page "My Addresses"
     * @param title le titre de la page
     */
    @Then("The displayed title should be {string}")
    public void assertDisplayedTitle(String title) {
        assertEquals(myAdressesPage.getAddressTitle(), title);
        myAdressesPage.deleteLastAddress();
    }

    /**
     * Implémentation de l'étape "I click on <Update>".
     * Cette méthode simule le clic sur le bouton "Update"
     */
    @When("I click on <Update>")
    public void clickOnUpdate() {
        myAdressesPage.clickUpdateButton();
    }

    /**
     * Implémentation de l'étape "The displayed address should be {string}".
     * Cette méthode vérifie que l'adresse affichée est correcte
     * @param address l'adresse à vérifier
     */
    @And("The displayed address should be {string}")
    public void AssertDisplayedAddress(String address) {
        assertEquals(myAdressesPage.getUpdatedAddress1Title(), address);
    }

    /**
     * Implémentation de l'étape "The displayed phone should be {string}".
     * Cette méthode vérifie que le téléphone affiché est correcte
     * @param phone le téléphone à vérifier.
     */
    @And("The displayed phone should be {string}")
    public void assertDisplayedPhone(String phone) {
        Assert.assertEquals(myAdressesPage.getUpdatedPhone(), phone);
    }

    /**
     * Implémentation de l'étape "I am redirected to the <My Addresses> page".
     * Cette méthode vérifie que l'utilisateur est redirigé vers la page "My Addresses"
     * @throws AssertionError si le titre de la page "My Addresses" n'est pas visible
     */
    @Then("I am redirected to the <My Addresses> page")
    public void assertOnMyAddressesPage() {
    Assert.assertEquals("MY ADDRESSES", myAdressesPage.getPageTitle());
    }

    /**
     * Implémentation de l'étape "The displayed firstname should be {string}".
     * Cette méthode vérifie que le prénom affiché est correct
     * @param firstName le prénom à vérifier
     */
    @And("The displayed firstname should be {string}")
    public void assertDisplayedFirstName(String firstName) {
        Assert.assertEquals(myAdressesPage.getFirstName(), firstName);
    }

    /**
     * Implémentation de l'étape "The displayed lastname should be {string}".
     * Cette méthode vérifie que le nom affiché est correct
     * @param lastName le nom à vérifier
     */
    @And("The displayed lastname should be {string}")
    public void assertDisplayedLastname(String lastName) {
        Assert.assertEquals(myAdressesPage.getLastName(), lastName);

    }
}
