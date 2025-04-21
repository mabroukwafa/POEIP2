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


public class LoginPageSteps {
    WebDriver webDriver = Setup.driver;
    HomePage homePage = new HomePage(webDriver);
    LoginPage loginPage = new LoginPage(webDriver);


    @Then ("I am redirected to the Sign in page")
    public void assertOnLoginPage(){
        Assert.assertTrue(loginPage.titleIsDisplayed());
    }

    @When("I enter {string} in the <Email address> field")
    public void iEnterInTheEmailAddressField(String email) {
        loginPage.sendEmail(email);
    }

    @And("I enter {string} in the <Password> field")
    public void iEnterInThePasswordField(String password) {
        loginPage.sendPassword(password);
    }

    @And("I click <Sign in>")
    public void iClickSignIn() {
        loginPage.clickLoginButton();
    }

    @Then("I should see {string} error message")
    public void iShouldSeeErrorMessage(String message) {
        Assert.assertEquals(message, loginPage.getLoginErrorMessage());
    }

    @When("I click on the <Forgot your password?>")
    public void iClickOnTheForgotYourPassword() {
        loginPage.clickForgotPassword();
    }


    @When("I enter {string} in the <Email address> field to create an account")
    public void iEnterInTheEmailAddressFieldToCreateAnAccount(String email) {
        loginPage.sendEmailCreate(email);
    }

    /**
     * Implémentation de l'étape "I click on Create an account".
     * Cette méthode clique sur le bouton de création de compte.
     */
    @Then("I click on Create an account")
    public void iClickOnCreateAnAccount() {
        loginPage.clickCreateAccountButton();
    }

    @When("I enter a valid email in the <Email address> field to create an account")
    public void iEnterAValidEmailInTheEmailAddressFieldToCreateAnAccount() {
        loginPage.sendEmailCreate(Utils.generateRandomEmail(5,6));
    }


    @Given("I'm logged in without a saved address")
    public void iMLoggedInWithoutASavedAddress() {
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
    public void anInvalidEmailAddressMessageAppears() {
        Assert.assertTrue(loginPage.isCreateAccountErrorMessageVisible());
    }
}
