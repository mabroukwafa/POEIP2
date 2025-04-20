package steps;

import hooks.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.MyAddressesPage;

import static org.junit.Assert.assertEquals;

public class MyAddressesPageSteps {
    WebDriver driver = Setup.driver;
    BasePage basePage = new BasePage(driver);
    MyAddressesPage myAdressesPage = new MyAddressesPage(driver);

    @And("I click on <Add a new Address>")
    public void iClickOnAddANewAddress() {
        myAdressesPage.clickMyAddressButton();
    }

    @Then("The displayed title should be {string}")
    public void theDisplayedTitleShouldBe(String arg0) {
        assertEquals(myAdressesPage.AddressTitle(),arg0);
    }

    @When("I click on <Update>")
    public void iClickOn() {
        myAdressesPage.clickUpdateButton();
    }

    @And("The displayed address should be {string}")
    public void theDisplayedAddressShouldBe(String arg0) {
        assertEquals(myAdressesPage.UpdatedAddress1Title(),arg0);
    }

    @And("The displayed phone should be {string}")
    public void theDisplayedPhoneShouldBe(String arg0) {
        Assert.assertEquals(myAdressesPage.UpdatedPhone(),arg0);
    }

    @Then("I am redirected to the <My Addresses> page")
    public void iAmRedirectedToThePage() {
    Assert.assertEquals(myAdressesPage.pageTitle(),"MY ADDRESSES");
    }

    @And("The displayed firstname should be {string}")
    public void theDisplayedNameShouldBe(String arg0) {
        Assert.assertEquals(myAdressesPage.myFirstname(),arg0);
    }

    @And("The displayed lastname should be {string}")
    public void theDisplayedLastnameShouldBe(String arg0) {
        Assert.assertEquals(myAdressesPage.myLastname(),arg0);

    }


}
