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

public class CreateAccountSteps {

    WebDriver driver = Setup.driver;
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    CreateAccountPage createAccountPage = new CreateAccountPage(driver);

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
     * Implémentation de l'étape "no error message appears".
     * Cette méthode vérifie qu'aucun message d'erreur n'est affiché.
     */
    // TODO: catch NoSuchElementException ?
    @Then("no error message appears")
    public void no_error_message_appears() {
        try {
            String error = loginPage.getLoginErrorMessage();
            assertTrue("Un message d'erreur est affiché : " + error, error.trim().isEmpty());
        } catch (NoSuchElementException e) {

        }
    }



    /**
     * Implémentation de l'étape "an Invalid email address message appears".
     * Cette méthode vérifie qu'un message d'erreur "Invalid email address" est affiché.
     */
    // TODO: Assert ?
    @Then("an Invalid email address message appears")
    public void anInvalidEmailAddressMessageAppears() {
        loginPage.getLoginErrorMessage();
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
        String email = data.get("Email address");
        String password = data.get("Password");

        // DEBUG
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email address: " + email);
        System.out.println("Password: " + password);


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
     * Implémentation de l'étape "I am redirected to My account with the message Your account has been created".
     * Cette méthode vérifie que l'utilisateur est redirigé vers la page de son compte avec le message de succès.
     */
    //TODO: step vide
    @Then("I am redirected to My account with the message Your account has been created.")
    public void iAmRedirectedToMyAccountWithTheMessageYourAccountHasBeenCreated() {
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
            String email = data.get("Email address");
            String password = data.get("Password");
            String newsletter = data.get("Newsletter");
            String days = data.get("Days");
            String months = data.get("Months");
            String years = data.get("Years");

            // DEBUG
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Email address: " + email);
            System.out.println("Password: " + password);
            System.out.println("Gender");
            createAccountPage.fillBasicAccountDetails(firstName, lastName, password,newsletter, gender, days, months, years);
    }

    /**
     * Implémentation de l'étape "I fill in the fields with a password shorter than {int} characters".
     * Cette méthode remplit les champs avec un mot de passe plus court que la longueur spécifiée.
     * @param length La longueur maximale du mot de passe.
     */
    //TODO: entrer le mot de passe
    @When("I fill in the fields with a password shorter than {int} characters")
    public void iFillInTheFieldsWithAPasswordShorterThanCharacters(int length) {
        String shortPassword = "a".repeat(Math.max(0, length - 1));
        // Remplir les champs avec ce mot de passe
        System.out.println("Using password: " + shortPassword);
    }

    /*
     * Implémentation de l'étape "an Password is invalid message appears".
     * Cette méthode vérifie qu'un message d'erreur "Password is invalid" est affiché.
     */
    //TODO: step vide
    @Then("an Password is invalid message appears")
    public void anPasswordIsInvalidMessageAppears() {


    }

    /**
     * Implémentation de l'étape "I fill in the fields with a valid password".
     * Cette méthode remplit les champs avec un mot de passe valide.
     */
    //TODO: entrer le mot de passe
    @When("I fill in the fields with a valid password")
    public void iFillInTheFieldsWithAValidPassword() {
        // Ici tu peux générer un mot de passe valide
        String password = "mdp12!";
        // Remplir les champs avec ce mot de passe
        System.out.println("Using password: " + password);
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
}
