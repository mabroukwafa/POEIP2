package steps;

import hooks.Setup;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.OrderHistoryPage;

public class OrderHistoryPageSteps {

    WebDriver webDriver = Setup.driver;
    OrderHistoryPage orderHistoryPage = new OrderHistoryPage(webDriver);

    @Then("I see the list of my orders on the Order History page")
    public void iSeeTheListOfMyOrdersOnTheOrderHistoryPage(){
        Assert.assertEquals(orderHistoryPage.pageTitle(), "ORDER HISTORY");
    }


}
