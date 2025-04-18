package steps;

import hooks.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.BlogPage;
import pages.LoginPage;
import pages.MyAccountPage;
import utils.ConfigReader;

public class BasePageSteps {

    WebDriver webDriver = Setup.driver;
    BasePage basePage = new BasePage(webDriver);
    LoginPage loginPage = new LoginPage(webDriver);
    MyAccountPage myAccountPage=new MyAccountPage(webDriver);

    @When("I click on the Blog tab")
    public void IClickOnTheBlogTab() {
        basePage.clickOnBlogTab();

        //fetch handles of all windows, there will be two, [0]- default, [1] - new window
        Object[] windowHandles = webDriver.getWindowHandles().toArray();
        webDriver.switchTo().window((String) windowHandles[1]);

    }


    @When("I click on Sign in")
    public void iClickOnSignIn() {
        basePage.clickOnSignIn();
    }


    @When("I click on Contact us")
    public void iClickOnContactUs() {
        basePage.clickOnContactUs();
    }


    @When("I click on the logo")
    public void iClickOnTheLogo() {
        basePage.clickOnLogo();
    }

    @When("I click on the {string} tab")
    public void iClickOnTheTab(String arg0) {
        switch (arg0){
            case "Women":
                basePage.clickOnFiltreWomen();
                break;
            case "Dresses":
                basePage.clickOnFiltreDresses();
                break;
            case "T-Shirts":
                basePage.clickOnFiltreTShirts();
                break;
        }
    }

    @When("I click on the cart link in the header")
    public void iClickOnTheCartLinkInTheHeader() {
        basePage.clickOnAccessCart();
    }

    @Given("I am on the {string} page")
    public void iAmOnThePage(String page) {
          switch (page.toLowerCase()) {
                case "home":
                    break;
                case "login":
                    basePage.clickOnSignIn();
                    break;
                case "my account":
                    basePage.clickOnSignIn();
                    loginPage.sendEmail(ConfigReader.getProperty("emailValid"));
                    loginPage.sendPassword(ConfigReader.getProperty("mdpValid"));
                    loginPage.clickLoginButton();
                    Assert.assertEquals("MY ACCOUNT",myAccountPage.getTitle());
                    break;

                default:
                    throw new IllegalArgumentException("Page inconnue : " + page);
            }
        }

    @And("the search bar is visible")
    public void theSearchBarIsVisible() {
        Assert.assertTrue(basePage.isFieldSearchVisible());
    }

    @When("I type {string} in the search bar")
    public void iTypeInTheSearchBar(String search) {
        basePage.insertInFieldSearch(search);
    }

    @And("I click on the search icon")
    public void iClickOnTheSearchIcon() {
        basePage.clickOnLoupeSearch();
    }

    @And("I select the suggestion {string}")
    public void iSelectTheSuggestion(String suggestion) {
        basePage.chooseSuggestion(suggestion);
    }
}
