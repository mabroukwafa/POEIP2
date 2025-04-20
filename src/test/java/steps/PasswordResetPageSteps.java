package steps;

import hooks.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;

/***
 * Cette classe contient les étapes de définition de {@link PasswordResetPage}.
 */
public class PasswordResetPageSteps {
    WebDriver driver = Setup.driver;
    BasePage basePage = new BasePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    CreateAccountPage createAccountPage = new CreateAccountPage(driver);
    PasswordResetPage passwordResetPage = new PasswordResetPage(driver);

    @Then("I redirected on the <Password reset> page")
    public void iRedirectedOnThePasswordResetPage() {
        Assert.assertEquals(passwordResetPage.getTitle(),"FORGOT YOUR PASSWORD?");
    }
    @Given("I am on the <Password reset> page")
    public void iAmOnThePasswordResetPage() {
        basePage.clickOnSignIn();
        loginPage.sendEmailCreate(YopMailPageSteps.resetPasswordMail);
        loginPage.clickCreateAccountButton();
        createAccountPage.fillrequired("Reset","Password","password");
        createAccountPage.clickRegister();
        basePage.clickOnSignOut();
        loginPage.clickForgotPassword();
        Assert.assertEquals(passwordResetPage.getTitle(),"FORGOT YOUR PASSWORD?");
    }


    @When("I enter my registered email")
    public void iEnterMyRegisteredEmail() {
        passwordResetPage.sendEmail(YopMailPageSteps.resetPasswordMail);
    }

    @And("I click the <Retrieve Password> button")
    public void iClickTheRetrievePasswordButton() {
        passwordResetPage.clickButton();
        Assert.assertTrue(passwordResetPage.isConfirmationMessageBeforeResetVisible());
    }


    @Then("I should see a message {string}")
    public void iShouldSeeAMessage(String msg) {
        Assert.assertEquals(passwordResetPage.getConfirmationMessageBeforeReset(),msg);
    }

    @Then("I should see a message that confirms the password change")
    public void iShouldSeeAMessageThatConfirmsThePasswordChange() {
        Assert.assertTrue(passwordResetPage.isConfirmationMessageAfterResetVisible());
    }
}
