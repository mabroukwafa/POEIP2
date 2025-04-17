package steps;

import hooks.Setup;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class MyAccountPageSteps {
    WebDriver driver = Setup.driver;
    BasePage basePage = new BasePage(driver);
    MyAccountPage myAccountPage = new MyAccountPage(driver);

    @Then("I should be redirected to <My Account> page")
    public void iShouldBeRedirectedToMyAccountPage() {
        Assert.assertEquals("MY ACCOUNT",myAccountPage.getTitle());
    }


}
