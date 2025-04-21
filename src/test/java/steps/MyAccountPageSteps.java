package steps;

import hooks.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.ConfigReader;

public class MyAccountPageSteps {
    WebDriver webDriver = Setup.driver;
    HomePage homePage = new HomePage(webDriver);
    LoginPage loginPage = new LoginPage(webDriver);
    MyAccountPage myAccountPage = new MyAccountPage(webDriver);

    @Then("I should be redirected to <My Account> page")
    public void iShouldBeRedirectedToMyAccountPage() {
        Assert.assertEquals("MY ACCOUNT",myAccountPage.getTitle());
    }


    @Given("I am on the <My Account> page")
    public void iAmOnTheMyAccountPage() {
        homePage.clickOnSignIn();
        loginPage.sendEmail(ConfigReader.getProperty("emailValid"));
        loginPage.sendPassword(ConfigReader.getProperty("mdpValid"));
        loginPage.clickLoginButton();
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

    @When("I click on the <Order history> option")
    public void iClickOnTheOrderHistoryOption() {
        myAccountPage.clickOrderButton();
    }

    @When("I click on the <My Credit Slips> option")
    public void iClickOnTheMyCreditSlipsOption() {
        myAccountPage.clickCreditsButton();
    }

    @When("I click on <Add my first Address>")
    public void iClickOnAddMyFirstAddress() {
        myAccountPage.clickAddNewAddressButton();
    }
}
