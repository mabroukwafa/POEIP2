package steps;

import hooks.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.PasswordResetPage;
import pages.LoginPage;
import pages.MyAccountPage;


public class LoginPageSteps {
    WebDriver driver = Setup.driver;
    BasePage basePage = new BasePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    MyAccountPage myAccountPage = new MyAccountPage(driver);
    PasswordResetPage forgotYourPswdPage = new PasswordResetPage(driver);


    @Then ("I am redirected to the Sign in page")
    public void assertOnLoginPage(){
        Assert.assertTrue(loginPage.titleIsDisplayed());
    }

    @Given("I am on the <Sign In> page")
    public void iAmOnTheSignInPage(){
        loginPage.clickOnSignIn();
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
        Assert.assertEquals(message, loginPage.errorMessage());
    }

    @And("I should see {string} in the menu bar")
    public void iShouldSeeInTheMenuBar(String myName) {
        Assert.assertEquals(basePage.getMyname(),myName);

    }

    @When("I click on the <Forgot your password?>")
    public void iClickOnTheForgotYourPassword() {
        loginPage.clickForgotPassword();
    }



}
