package steps;

import hooks.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.YopMailPage;

public class YopMailPageSteps {

    WebDriver webDriver = Setup.driver;
    public static String resetPasswordMail;

    YopMailPage yopMailPage = new YopMailPage(webDriver);

    @Given("I created an email")
    public void createYopMail(){
        yopMailPage.goToYopMailGenerator();
        yopMailPage.clickAuthorizeButton();
        yopMailPage.clickNewGenButton();
        resetPasswordMail = yopMailPage.getTextBeforeAt() + "@yopmail.com";
        yopMailPage.goToTab(0);

    }

    @And("I check my emails")
    public void iCheckMyEmails() {
        yopMailPage.goToTab(1);
        yopMailPage.dismissAdd();
        yopMailPage.goToMail();
    }

    @And("I click on the reset password link")
    public void iClickOnTheResetPasswordLink() throws InterruptedException {
        Thread.sleep(3000);
        yopMailPage.clickRefreshButton();
        yopMailPage.clickPasswordResetLink();
        yopMailPage.goToTab(2);
    }
}
