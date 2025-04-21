package steps;

import hooks.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.Map;

import static org.junit.Assert.assertTrue;
import static utils.Utils.generateRandomEmail;

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
    public void iAmOnTheCreateAccountPage() {
        homePage.clickOnSignIn();
        loginPage.sendEmailCreate(generateRandomEmail(5,8));
        loginPage.clickCreateAccountButton();
    }

    /**
     * Implémentation de l'étape "I enter {string} in the Email address field from the Create an account page".
     * Cette méthode remplit le champ d'email sur la page de création de compte.
     * @param email L'email à entrer dans le champ.
     */
    @When("I enter {string} in the Email address field from the Create an account page")
    public void iEnterInTheEmailAddressField(String email) {
        createAccountPage.enterEmailToCreateAccount(email);
    }

    /**
     * Implémentation de l'étape "I fill in only the required fields".
     * Cette méthode remplit uniquement les champs obligatoires du formulaire de création de compte.
     * @param dataTable Les données à remplir dans le formulaire.
     */
    @When("I fill in only the required fields:")
    public void i_fill_in_only_the_required_fields(io.cucumber.datatable.DataTable dataTable) {
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
    public void iClickOnREGISTER() {
        createAccountPage.clickRegister();
    }

    /**
     * Implémentation de l'étape "I fill in all fields with valid information".
     * Cette méthode remplit tous les champs du formulaire de création de compte avec des informations valides.
     * @param dataTable Les données à remplir dans le formulaire.
     */
    @When("I fill in all fields with valid information:")
    public void iFillInAllFieldsWithValidInformation(io.cucumber.datatable.DataTable dataTable) {

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
    public void iFillInTheFieldsWithAPasswordShorterThanCharacters(int length) {
        String shortPassword = "a".repeat(Math.max(0, length - 1));
        createAccountPage.enterPasswordToCreateAccount(shortPassword);
    }

    /**
     * Implémentation de l'étape "I fill in the fields with a valid password".
     * Cette méthode remplit les champs avec un mot de passe valide.
     */
    @When("I fill in the fields with a valid password")
    public void iFillInTheFieldsWithAValidPassword() {
        String password = "mdp12!";
        createAccountPage.enterPasswordToCreateAccount(password);
    }

    @Then("I am redirected to the Create an account page")
    public void iAmRedirectedToTheCreateAnAccountPage() {
        Assert.assertTrue(createAccountPage.getPageTitle().toLowerCase().contains("create an account"));
    }

    @Then("the email field is flagged as incorrect")
    public void theEmailFieldIsFlaggedAsIncorrect() {
        Assert.assertTrue(createAccountPage.isEmailErrorVisible());
    }

    @Then("the email field is flagged as correct")
    public void theEmailFieldIsFlaggedAsCorrect() {
        Assert.assertTrue(createAccountPage.isEmailCheckVisible());
    }

    @Then("the password field is flagged as incorrect")
    public void thePasswordFieldIsFlaggedAsIncorrect() {
        Assert.assertTrue(createAccountPage.isPasswordErrorVisible());
    }

    @Then("the password field is flagged as correct")
    public void thePasswordFieldIsFlaggedAsCorrect() {
        Assert.assertTrue(createAccountPage.isPasswordCheckVisible());
    }
}
