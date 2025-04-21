package steps;

import hooks.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.MyAddressesPage;

import static org.junit.Assert.assertEquals;

public class MyAddressesPageSteps {
    WebDriver webDriver = Setup.driver;
    MyAddressesPage myAdressesPage = new MyAddressesPage(webDriver);

    @And("I click on <Add a new Address>")
    public void iClickOnAddANewAddress() {
        myAdressesPage.clickMyAddressButton();
    }

    @Then("The displayed title should be {string}")
    public void theDisplayedTitleShouldBe(String title) {
        assertEquals(myAdressesPage.getAddressTitle(), title);
        myAdressesPage.deleteLastAddress();
    }

    @When("I click on <Update>")
    public void iClickOn() {
        myAdressesPage.clickUpdateButton();
    }

    @And("The displayed address should be {string}")
    public void theDisplayedAddressShouldBe(String address) {
        assertEquals(myAdressesPage.getUpdatedAddress1Title(), address);
    }

    @And("The displayed phone should be {string}")
    public void theDisplayedPhoneShouldBe(String phone) {
        Assert.assertEquals(myAdressesPage.getUpdatedPhone(), phone);
    }

    @Then("I am redirected to the <My Addresses> page")
    public void iAmRedirectedToThePage() {
    Assert.assertEquals(myAdressesPage.getPageTitle(),"MY ADDRESSES");
    }

    @And("The displayed firstname should be {string}")
    public void theDisplayedNameShouldBe(String firstName) {
        Assert.assertEquals(myAdressesPage.getFirstName(), firstName);
    }

    @And("The displayed lastname should be {string}")
    public void theDisplayedLastnameShouldBe(String lastName) {
        Assert.assertEquals(myAdressesPage.getLastName(), lastName);

    }


}
