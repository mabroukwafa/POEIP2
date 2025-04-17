package steps;

import hooks.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.LoginPage;
import pages.MyAccountPage;


public class ConnexionSteps {
    WebDriver driver = Setup.driver;
    BasePage basePage = new BasePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    MyAccountPage myAccountPage = new MyAccountPage(driver);


    @Given("I am on the \"Sign In\" page")
    public void iAmOnTheSignInPage(){
        loginPage.clickOnSignIn();
    }

    @When("I enter {string} in the <Email address> field")
    public void iEnterInTheEmailAddressField(String email) {
        loginPage.sendEamil(email);
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

    @Then("I should be redirected to <My Account> page")
    public void iShouldBeRedirectedToMyAccountPage() {
        Assert.assertEquals("MY ACCOUNT",myAccountPage.getTitle());
    }

    @And("I should see my name in the menu bar")
    public void iShouldSeeMyNameInTheMenuBar() {
        Assert.assertEquals(basePage.getMyname(),"Valid valid");
    }
}
