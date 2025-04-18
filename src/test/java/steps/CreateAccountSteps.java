package steps;

import hooks.Setup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.Map;

import static org.junit.Assert.assertTrue;
import static utils.Utils.generateRandomEmail;

public class CreateAccountSteps {
    WebDriver driver = Setup.driver;
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    CreateAccountPage createAccountPage = new CreateAccountPage(driver);
    @Given( "I am on the Create an account page")
    public void iAmOnTheCreateAccountPage() {
        homePage.clickOnSignIn();
        loginPage.sendEmailCreate(generateRandomEmail(5,8));
        loginPage.clickCreateAccountButton();
    }

    @When("I enter {string} in the Email address field from the Create an account page")
    public void iEnterInTheEmailAddressField(String email) {
        loginPage.sendEmailCreate(email);
        loginPage.clickCreateAccountButton();
    }

    @Then("no error message appears")
    public void no_error_message_appears() {
        try {
            String error = loginPage.errorMessage();
            assertTrue("Un message d'erreur est affiché : " + error, error.trim().isEmpty());
        } catch (NoSuchElementException e) {

        }
    }
    @Then("I click on Create an account")
    public void iClickOnCreateAnAccount() {
        createAccountPage.clickRegisterButton();
    }


    @Then("an Invalid email address message appears")
    public void anInvalidEmailAddressMessageAppears() {
        loginPage.errorMessage();
    }



    @When("I fill in only the required fields:")
    public void i_fill_in_only_the_required_fields(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);

        String firstName = data.get("First Name");
        String lastName = data.get("Last Name");
        String email = data.get("Email address");
        String password = data.get("Password");

        // DEBUG
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email address: " + email);
        System.out.println("Password: " + password);


        createAccountPage.fillrequired(firstName, lastName, password);
    }



    @And("I click on REGISTER")
    public void iClickOnREGISTER() {
        createAccountPage.clickRegister();
    }

    @Then("I am redirected to My account with the message Your account has been created.")
    public void iAmRedirectedToMyAccountWithTheMessageYourAccountHasBeenCreated() {
    }

    @When("I fill in all fields with valid information:")
    public void iFillInAllFieldsWithValidInformation(io.cucumber.datatable.DataTable dataTable) {

            Map<String, String> data = dataTable.asMaps().get(0);

            String gender = data.get("Gender");
            String firstName = data.get("First Name");
            String lastName = data.get("Last Name");
            String email = data.get("Email address");
            String password = data.get("Password");
            String newsletter = data.get("Newsletter");
            String days = data.get("Days");
            String months = data.get("Months");
            String years = data.get("Years");

            // DEBUG
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Email address: " + email);
            System.out.println("Password: " + password);
            System.out.println("Gender");
            createAccountPage.fillBasicAccountDetails(firstName, lastName, password,newsletter, gender, days, months, years);
    }

    @When("I fill in the fields with a password shorter than {int} characters")
    public void iFillInTheFieldsWithAPasswordShorterThanCharacters(int length) {
        // Ici tu peux générer un mot de passe aléatoire plus court que `length`
        String shortPassword = "a".repeat(Math.max(0, length - 1));
        // Remplir les champs avec ce mot de passe
        System.out.println("Using password: " + shortPassword);
    }


    @Then("an Password is invalid message appears")
    public void anPasswordIsInvalidMessageAppears() {


    }

    @When("I fill in the fields with a valid password")
    public void iFillInTheFieldsWithAValidPassword() {
        // Ici tu peux générer un mot de passe valide
        String password = "mdp12!";
        // Remplir les champs avec ce mot de passe
        System.out.println("Using password: " + password);
    }

}
