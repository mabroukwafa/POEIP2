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
import utils.ConfigReader;

public class MyAccountPageSteps {
    WebDriver driver = Setup.driver;
    BasePage basePage = new BasePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    MyAccountPage myAccountPage = new MyAccountPage(driver);

    @Then("I should be redirected to <My Account> page")
    public void iShouldBeRedirectedToMyAccountPage() {
        Assert.assertEquals("MY ACCOUNT",myAccountPage.getTitle());
    }


    @Given("I am on the <My Account> page")
    public void iAmOnTheMyAccountPage() {
        basePage.clickOnSignIn();
        loginPage.sendEmail(ConfigReader.getProperty("emailValid"));
        loginPage.sendPassword(ConfigReader.getProperty("mdpValid"));
        loginPage.clickLoginButton();
    }

    @When("I click on the <Sign out> button")
    public void iClickOnTheSignOutButton() {
        basePage.clickOnSignOut();
    }

    @When("I click on <My Addresses>")
    public void iClickOnAddAddress() {
        myAccountPage.clickMyAddressButton();
    }


    @When("I click on <Home> button")
    public void iClickOnHomeButton() {
        myAccountPage.clickHomeButton();

    }

    @When("I click on the <Personal information> button")
    public void iClickOnThePersonalInformationButton() {
        myAccountPage.clickPersonalInformationButton();
    }
}
