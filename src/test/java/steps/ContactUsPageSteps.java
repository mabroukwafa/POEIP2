package steps;

import hooks.Setup;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.ContactUsPage;

public class ContactUsPageSteps {
    WebDriver webDriver  = Setup.driver;
    ContactUsPage contactUsPage = new ContactUsPage(webDriver);



    @Then("I am redirected to the Contact us page")
    public void iAmRedirectedToTheContactUsPage() {
        Assert.assertTrue(contactUsPage.contactUsTitleIsDisplayed());
    }
}
