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

/***
 * Cette classe contient les étapes de définition de {@link PasswordResetPage}.
 */
public class PasswordResetPageSteps {
    WebDriver driver = Setup.driver;
    BasePage basePage = new BasePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    MyAccountPage myAccountPage = new MyAccountPage(driver);
    PasswordResetPage passwordResetPage = new PasswordResetPage(driver);

    @Then("I redirected on the <Password reset> page")
    public void iRedirectedOnThePasswordResetPage() {
        Assert.assertEquals(passwordResetPage.getTitle(),"FORGOT YOUR PASSWORD?");
    }
    @Given("I am on the <Password reset> page")
    public void iAmOnThePasswordResetPage() {
        basePage.clickOnSignIn();
        loginPage.clickForgotPassword();
        Assert.assertEquals(passwordResetPage.getTitle(),"FORGOT YOUR PASSWORD?");
    }


    @When("I enter my registered email {string}")
    public void iEnterMyRegisteredEmail(String email) {
        passwordResetPage.sendEmail(email);
    }

    @And("I click the <Retrieve Password> button")
    public void iClickTheRetrievePasswordButton() {
        passwordResetPage.clickButton();
    }


    @Then("I should see a message {string}")
    public void iShouldSeeAMessage(String msg) {
        Assert.assertEquals(passwordResetPage.getConfirmationMessage(),msg);
    }
}
