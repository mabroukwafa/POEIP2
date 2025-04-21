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
    WebDriver webDriver = Setup.driver;
    HomePage homePage = new HomePage(webDriver);
    LoginPage loginPage = new LoginPage(webDriver);
    CreateAccountPage createAccountPage = new CreateAccountPage(webDriver);
    PasswordResetPage passwordResetPage = new PasswordResetPage(webDriver);

    @Then("I am redirected on the <Password reset> page")
    public void iRedirectedOnThePasswordResetPage() {
        Assert.assertEquals(passwordResetPage.getTitle(),"FORGOT YOUR PASSWORD?");
    }
    @Given("I am on the <Password reset> page")
    public void iAmOnThePasswordResetPage() {
        homePage.clickOnSignIn();
        loginPage.sendEmailCreate(YopMailPageSteps.resetPasswordMail);
        loginPage.clickCreateAccountButton();
        createAccountPage.fillrequired("Reset","Password","password");
        createAccountPage.clickRegister();
        createAccountPage.clickOnSignOut();
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

    @Then("I should see a message that confirms the password change")
    public void iShouldSeeAMessageThatConfirmsThePasswordChange() {
        Assert.assertTrue(passwordResetPage.isConfirmationMessageAfterResetVisible());
    }
}
