package steps;

import hooks.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.Utils;

import java.util.Map;

/**
 * Cette classe contient les étapes de test pour la page {@link CreateAccountPage}.
 */

public class CreateAccountPageSteps {

    WebDriver webDriver = Setup.driver;
    HomePage homePage = new HomePage(webDriver);
    LoginPage loginPage = new LoginPage(webDriver);
    CreateAccountPage createAccountPage = new CreateAccountPage(webDriver);

    /**
     * Implémentation de l'étape "I am on the Create an account page".
     * Cette méthode dirige l'utilisateur vers la page de création de compte.
     */
    @Given( "I am on the Create an account page")
    public void goToCreateAccountPage() {
        homePage.clickOnSignIn();
        loginPage.sendEmailCreate(
                Utils.generateRandomEmail(Integer.parseInt(ConfigReader.getProperty("numberOfCharactersBeforeAt")),
                Integer.parseInt(ConfigReader.getProperty("numberOfCharactersAfterAt"))));
        loginPage.clickCreateAccountButton();
    }

    /**
     * Implémentation de l'étape "I enter {string} in the Email address field from the Create an account page".
     * Cette méthode remplit le champ d'email sur la page de création de compte.
     * @param email L'email à entrer dans le champ.
     */
    @When("I enter {string} in the Email address field from the Create an account page")
    public void sendEmailAddressToCreateAccount(String email) {
        createAccountPage.enterEmailToCreateAccount(email);
    }

    /**
     * Implémentation de l'étape "I fill in only the required fields".
     * Cette méthode remplit uniquement les champs obligatoires du formulaire de création de compte.
     * @param dataTable Les données à remplir dans le formulaire.
     */
    @When("I fill in only the required fields:")
    public void fillOnlyRequiredFields(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);

        String firstName = data.get("First Name");
        String lastName = data.get("Last Name");
        String password = data.get("Password");

        createAccountPage.fillrequired(firstName, lastName, password);
    }


    /**
     * Implémentation de l'étape "I click on REGISTER".
     * Cette méthode clique sur le bouton d'enregistrement.
     */
    @And("I click on REGISTER")
    public void clickOnREGISTER() {
        createAccountPage.clickRegister();
    }

    /**
     * Implémentation de l'étape "I fill in all fields with valid information".
     * Cette méthode remplit tous les champs du formulaire de création de compte avec des informations valides.
     * @param dataTable Les données à remplir dans le formulaire.
     */
    @When("I fill in all fields with valid information:")
    public void fillInAllFields(io.cucumber.datatable.DataTable dataTable) {

            Map<String, String> data = dataTable.asMaps().get(0);

            String gender = data.get("Gender");
            String firstName = data.get("First Name");
            String lastName = data.get("Last Name");
            String password = data.get("Password");
            String newsletter = data.get("Newsletter");
            String days = data.get("Days");
            String months = data.get("Months");
            String years = data.get("Years");

            createAccountPage.fillBasicAccountDetails(firstName, lastName, password,newsletter, gender, days, months, years);
    }

    /**
     * Implémentation de l'étape "I fill in the fields with a password shorter than {int} characters".
     * Cette méthode remplit les champs avec un mot de passe plus court que la longueur spécifiée.
     * @param length La longueur maximale du mot de passe.
     */
    @When("I fill in the fields with a password shorter than {int} characters")
    public void fillShortPassword(int length) {
        String shortPassword = "a".repeat(Math.max(0, length - 1));
        createAccountPage.enterPasswordToCreateAccount(shortPassword);
    }

    /**
     * Implémentation de l'étape "I fill in the fields with a valid password".
     * Cette méthode remplit les champs avec un mot de passe valide.
     */
    @When("I fill in the fields with a valid password")
    public void fillWithValidPassword() {
        String password = "mdp12!";
        createAccountPage.enterPasswordToCreateAccount(password);
    }

    /**
     * Implémentation de l'étape "I am redirected to the Create an account page".
     * Vérifie le fait d'être sur la page de création de compte
     */
    @Then("I am redirected to the Create an account page")
    public void assertOnCreateAnAccountPage() {
        Assert.assertTrue(createAccountPage.getPageTitle().toLowerCase().contains("create an account"));
    }

    /**
     * Implémentation de l'étape "the {string} field is flagged as {string}".
     * Vérifie la bonne apparition d'un check ou d'une croix sur le champ choisi
     * @param field le champ choisi
     * @param status le statut correct ou incorrect du champ
     */
    @Then("the {string} field is flagged as {string}")
    public void assertFieldFlag(String field, String status) {
        Assert.assertTrue(createAccountPage.isFieldCheckOrErrorVisible(field, status));
    }
}
