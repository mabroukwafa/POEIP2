package steps;

import hooks.Setup;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.*;

public class PersonalInformationPageSteps {
    WebDriver webDriver = Setup.driver;
    PersonalInformationPage personalInformationPage= new PersonalInformationPage(webDriver);

    @Then("I can view my personal information on the Personal information page")
    public void iCanViewMyPersonalInformationOnThePersonalInformationPage() {
        Assert.assertEquals(personalInformationPage.getTitle(),"YOUR PERSONAL INFORMATION");
    }


}
