package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Page Object Model (POM) pour la page de création de compte.
 * Elle hérite de la classe {@link BasePage}.
 */
public class CreateAccountPage extends BasePage {
    WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }


    // ----- Account creation form (visible after email is submitted) -----
    @FindBy(xpath = "//input[@id = 'email']")
    WebElement emailCreateField;

    @FindBy(xpath = "//button[@name = 'SubmitCreate']")
    WebElement buttonCreateAccount ;

    @FindBy(id = "id_gender1")
    public WebElement genderMrRadio;

    @FindBy(id = "id_gender2")
    public WebElement genderMrsRadio;

    @FindBy(id = "customer_firstname")
    public WebElement firstNameInput;

    @FindBy(id = "customer_lastname")
    public WebElement lastNameInput;

    @FindBy(id = "passwd")
    public WebElement enterPassword;

    @FindBy(id = "days")
    public WebElement dayDropdown;

    @FindBy(id = "months")
    public WebElement monthDropdown;

    @FindBy(id = "years")
    public WebElement yearDropdown;

    @FindBy(id = "newsletter")
    public WebElement newsletterCheckbox;


    @FindBy(id = "submitAccount")
    public WebElement registerButton;


    // Méthode pour entrer l'email et soumettre la création du compte
    public void enterEmailToCreateAccount(String email) {
        emailCreateField.clear();
        emailCreateField.sendKeys(email);
        buttonCreateAccount.click();
    }
    public void clickCreateAccountButton() {
        buttonCreateAccount.click(); // Cette ligne clique sur le bouton "Create an account"
    }

    public void clickRegister() {
        registerButton.click();
    }

    // Méthode pour sélectionner le genre
    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("Mr")) {
            genderMrRadio.click();
        } else if (gender.equalsIgnoreCase("Mrs")) {
            genderMrsRadio.click();
        }
    }

    // Méthode pour remplir les informations de base pour la création du compte
    public void fillBasicAccountDetails(String firstName, String lastName, String password,
                                        String newsletter, String gender, String days, String months, String years) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        enterPassword.sendKeys(password);
        newsletterCheckbox.sendKeys(newsletter);
        genderMrRadio.click();
        dayDropdown.sendKeys(days);
        monthDropdown.sendKeys(months);
        yearDropdown.sendKeys(years);



    }
    public void fillrequired(String firstName, String lastName, String password) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        enterPassword.sendKeys(password);


    }


//    public void subscribeToNewsletter() {
//        WebElement newsletterCheckbox = driver.findElement(By.id("newsletter"));
//        if (!newsletterCheckbox.isSelected()) {
//            newsletterCheckbox.click();
//        }
//    }

    // Méthode pour soumettre la création du compte
    public void clickRegisterButton() {
        registerButton.click();
    }

}
