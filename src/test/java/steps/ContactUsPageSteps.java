package steps;

import hooks.Setup;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ContactUsPage;

/**
 * Cette classe contient les étapes de test pour la page {@link ContactUsPage}
 */
public class ContactUsPageSteps {

    // Une instance de WebDriver de la classe Setup
    WebDriver webDriver  = Setup.driver;
    ContactUsPage contactUsPage = new ContactUsPage(webDriver);

    /**
     * Implémentation de l'étape "I am redirected to the Contact us".
     * Cette méthode vérifie que l'utilisateur est redirigé vers la page ContactUs
     * @throws AssertionError si le titre de la page de contact n'est pas affiché.
     */
    @Then("I am redirected to the Contact us page")
    public void assertOnContactUsPage() {
        Assert.assertTrue(contactUsPage.contactUsTitleIsDisplayed());
    }
}
