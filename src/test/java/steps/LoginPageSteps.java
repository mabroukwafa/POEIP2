package steps;

import hooks.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.ConfigReader;
import utils.Utils;


/**
 * Cette classe contient les étapes de test pour la page {@link LoginPage}
 */
public class LoginPageSteps {
    WebDriver webDriver = Setup.driver;
    HomePage homePage = new HomePage(webDriver);
    LoginPage loginPage = new LoginPage(webDriver);


    /**
     * Implémentation de l'étape "I am redirected to the Sign in page".
     * Vérifie que l'utilisateur est redirigé vers la page de connexion
     * en confirmant l'affichage du titre spécifique à cette page.
     *
     * @throws AssertionError si le titre de la page de connexion n'est pas affiché.
     */
    @Then ("I am redirected to the Sign in page")
    public void assertOnLoginPage(){
        Assert.assertTrue(loginPage.titleIsDisplayed());
    }

    /**
     * Implémentation de l'étape "I enter {string} in the <Email address> field".
     * @param email L'adresse e-mail à entrer dans le champ.
     */
    @When("I enter {string} in the <Email address> field")
    public void enterEmailAddressToLogin(String email) {
        loginPage.sendEmail(email);
    }

    /**
     * Implémentation de l'étape "I enter {string} in the <Password> field".
     * @param password Le mot de passe à entrer dans le champ.
     */
    @And("I enter {string} in the <Password> field")
    public void enterPassword(String password) {
        loginPage.sendPassword(password);
    }

    /**
     * Implémentation de l'étape "I click <Sign in>".
     * Cette méthode clique sur le bouton de connexion.
     */
    @And("I click <Sign in>")
    public void clickSignIn() {
        loginPage.clickLoginButton();
    }

    /**
     * Implémentation de l'étape "I should see {string} error message".
     * Cette méthode vérifie qu'un message d'erreur est affiché.
     * @param message Le message d'erreur attendu.
     */
    @Then("I should see {string} error message")
    public void assertErrorMessage(String message) {
        Assert.assertEquals(message, loginPage.getLoginErrorMessage());
    }

    /**
     * Implémentation de l'étape "I click on the <Forgot your password?>".
     * Cette méthode clique sur le lien de réinitialisation du mot de passe.
     */
    @When("I click on the <Forgot your password?>")
    public void clickOnForgotPasswordLink() {
        loginPage.clickForgotPassword();
    }


    /**
     * I enter {string} in the <Email address> field to create an account.
     * Cette méthode remplit le champ d'adresse e-mail pour la création d'un compte.
     * @param email L'adresse e-mail à entrer dans le champ.
     */
    @When("I enter {string} in the <Email address> field to create an account")
    public void enterEmailAddressToCreateAnAccount(String email) {
        loginPage.sendEmailCreate(email);
    }

    /**
     * Implémentation de l'étape "I click on Create an account".
     * Cette méthode clique sur le bouton de création de compte.
     */
    @Then("I click on Create an account")
    public void clickOnCreateAnAccount() {
        loginPage.clickCreateAccountButton();
    }

    /**
     * Implémentation de l'étape "I enter a valid email in the <Email address> field to create an account".
     * Entre une adresse mail valide générée aléatoirement pour créer un nouveau compte
     */
    @When("I enter a valid email in the <Email address> field to create an account")
    public void enterValidEmailToCreateAnAccount() {
        loginPage.sendEmailCreate(
                Utils.generateRandomEmail(Integer.parseInt(ConfigReader.getProperty("numberOfCharactersBeforeAt")),
                        Integer.parseInt(ConfigReader.getProperty("numberOfCharactersAfterAt"))));
    }


    /**
     * Implémentation de l'étape "I am logged in without a saved address".
     * Cette méthode simule la connexion d'un utilisateur sans adresse enregistrée.
     */
    @Given("I'm logged in without a saved address")
    public void connectWithoutSavedAddress() {
        homePage.clickOnSignIn();
        loginPage.sendEmail(ConfigReader.getProperty("emailValid2"));
        loginPage.sendPassword(ConfigReader.getProperty("mdpValid2"));
        loginPage.clickLoginButton();
    }

    /**
     * Implémentation de l'étape "an Invalid email address message appears".
     * Cette méthode vérifie qu'un message d'erreur est affiché.
     */
    @Then("an Invalid email address message appears")
    public void assertInvalidEmailAddressMessage() {
        Assert.assertTrue(loginPage.isCreateAccountErrorMessageVisible());
    }
}
