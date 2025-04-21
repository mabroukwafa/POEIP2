package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Page Object Model (POM) pour la page "Your Addresses".
 * Elle hérite de la classe {@link BasePage}.
 */
public class YourAddressesPage extends BasePage {

    // Localisateurs XPath
    @FindBy(xpath = "//div[@id='center_column']//h1[normalize-space()='Your addresses']")
    WebElement pageTitle;

    @FindBy(xpath = "//input[@id='firstname']")
    WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastname']")
    WebElement lastNameField;

    @FindBy(xpath = "//input[@id='company']")
    WebElement companyField;

    @FindBy(xpath = "//input[@id='address1']")
    WebElement address1Field;

    @FindBy(xpath = "//input[@id='address2']")
    WebElement address2Field;

    @FindBy(xpath = "//input[@id='city']")
    WebElement cityField;

    @FindBy(xpath = "//input[@id='phone']")
    WebElement homePhoneField;

    @FindBy(xpath = "//input[@id='phone_mobile']")
    WebElement mobilePhoneField;

    @FindBy(xpath = "//textarea[@id='other']")
    WebElement additionalInformationField;

    @FindBy(xpath = "//input[@id='alias']")
    WebElement addressTitleField;

    @FindBy(xpath = "//input[@id='postcode']")
    WebElement postcodeField;

    @FindBy(xpath = "//select[@id='id_state']")
    WebElement stateField;

    @FindBy(xpath = "//select[@id='id_country']")
    WebElement countryField;

    @FindBy(xpath = "//button[@id='submitAddress']")
    WebElement saveButton;

    /**
     * Constructeur de la classe {@link BasePage} que la classe YourAddressesPage hérite.
     *
     * @param webDriver Le WebDriver utilisé pour naviguer et interagir avec la page
     */
    public YourAddressesPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Méthode pour insérer le prénom à la page.
     *
     * @param firstname Le prénom à insérer
     */
    public void sendFirstName(String firstname) {
        firstNameField.clear();
        firstNameField.sendKeys(firstname);
    }

    /**
     * Méthode pour insérer le nom de famille à la page.
     *
     * @param lastname Le nom de famille à insérer
     */
    public void sendLastName(String lastname) {
        lastNameField.clear();
        lastNameField.sendKeys(lastname);
    }

    /**
     * Méthode pour insérer le nom de la société à la page.
     *
     * @param company Le nom de la société à insérer
     */
    public void sendCompany(String company) {
        companyField.clear();
        companyField.sendKeys(company);
    }

    /**
     * Méthode pour insérer l'adresse 1 à la page.
     *
     * @param address1 L'adresse 1 à insérer
     */
    public void sendAddress1(String address1) {
        address1Field.clear();
        address1Field.sendKeys(address1);
    }

    /**
     * Méthode pour insérer l'adresse 2 à la page.
     *
     * @param address2 L'adresse 2 à insérer
     */
    public void sendAddress2(String address2) {
        address2Field.clear();
        address2Field.sendKeys(address2);
    }

    /**
     * Méthode pour insérer la ville à la page.
     *
     * @param city La ville à insérer
     */
    public void sendCity(String city) {
        cityField.clear();
        cityField.sendKeys(city);
    }

    /**
     * Méthode pour insérer le numéro de téléphone mobile à la page.
     *
     * @param phone Le numéro de téléphone mobile à insérer
     */
    public void sendMobilePhone(String phone) {
        mobilePhoneField.clear();
        mobilePhoneField.sendKeys(phone);
    }

    /**
     * Méthode pour insérer le numéro de téléphone fixe à la page.
     *
     * @param phone Le numéro de téléphone fixe à insérer
     */
    public void sendHomePhone(String phone) {
        homePhoneField.clear();
        homePhoneField.sendKeys(phone);
    }

    /**
     * Méthode pour insérer des informations supplémentaires à la page.
     *
     * @param information Les informations supplémentaires à insérer
     */
    public void sendInformation(String information) {
        additionalInformationField.clear();
        additionalInformationField.sendKeys(information);
    }

    /**
     * Méthode pour insérer le titre de l'adresse à la page.
     *
     * @param addressTitle Le titre de l'adresse à insérer
     */
    public void sendAddressTitle(String addressTitle) {
        addressTitleField.clear();
        addressTitleField.sendKeys(addressTitle);
    }

    /**
     * Méthode pour insérer le code postal à la page.
     *
     * @param postcode Le code postal à insérer
     */
    public void sendPostcode(String postcode) {
        postcodeField.clear();
        postcodeField.sendKeys(postcode);
    }


    /**
     * Méthode pour cliquer sur le bouton "Enregistrer" à la page.
     */
    public void clickSaveButton() {
        saveButton.click();
    }


    /**
     * Méthode pour insérer l'état à la page.
     *
     * @param state L'état à insérer
     */
    public void sendState(String state) {
        Select select = new Select(stateField);
        select.selectByVisibleText(state);
    }

    /**
     * Méthode pour sélectionner le pays à la page.
     *
     * @param country Le pays à sélectionner
     */
    public void sendCountry(String country) {
        chooseSelectionByVisibleText(countryField,country);
    }

    /**
     * Méthode pour récupérer le titre de la page.
     *
     * @return Le titre de la page
     */
    public String getPageTitle() {
        return pageTitle.getText();
    }


}
