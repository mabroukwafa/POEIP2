package steps;

import hooks.Setup;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.MyCreditSlipsPage;

public class MyCreditSlipsPageSteps {
    WebDriver webDriver = Setup.driver;
    MyCreditSlipsPage myCreditSlipsPage = new MyCreditSlipsPage(webDriver);

    @Then("I see the list of my assets")
    public void iSeeTheListOfMyAssets(){
               Assert.assertEquals(myCreditSlipsPage.pageTitle(),"CREDIT SLIPS");
    }

}
