package steps;

import hooks.Setup;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.MyCreditSlipsPage;
import pages.OrderHistoryPage;

public class MyCreditSlipsPageSteps {
    WebDriver driver = Setup.driver;
    MyCreditSlipsPage myCreditSlipsPage = new MyCreditSlipsPage(driver);

    @Then("I see the list of my assets")
    public void Iseethelistofmyassets(){
               Assert.assertEquals(myCreditSlipsPage.pageTitle(),"CREDIT SLIPS");
    }

}
