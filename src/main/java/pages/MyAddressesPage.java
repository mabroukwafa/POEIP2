package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model (POM) pour la page "My Addresses".
 * Elle hérite de la classe {@link BasePage}.
 */
public class MyAddressesPage extends BasePage{

    /**
     * Constructeur de la classe {@link BasePage} que la classe MyAddressesPage hérite.
     * @param webDriver Le WebDriver utilisé pour naviguer et interagir avec la page
     */
    public MyAddressesPage(WebDriver webDriver){
        super(webDriver);
    }

    //Xpath
    @FindBy(xpath = "//a[@title='Add an address']")
    WebElement addAddressButton;

    //je modifie la premiere adresse dans la liste
    @FindBy(xpath = "//a[@title='Update']")
    WebElement updateButton;

    // je teste tjrs sur la derniere adresse dans la list
    @FindBy(xpath = "//ul[contains(@class, 'last_item')]//li/h3")
    WebElement addressTitle;

    @FindBy(xpath = "//div[@id='center_column']/h1")
    WebElement title;

    @FindBy(xpath = "//ul[contains(@class, 'first_item')]//li/span[@class='address_address1']")
    WebElement UpdatedAddress1 ;

    @FindBy(xpath = "//ul[contains(@class, 'first_item')]//li/span[@class='address_name'][1]")
    WebElement myFirstName ;

    @FindBy(xpath = "//ul[contains(@class, 'first_item')]//li/span[@class='address_name'][2]")
    WebElement myLastName ;

    @FindBy(xpath = "//ul[contains(@class, 'first_item')]//li/span[@class='address_phone_mobile']")
    WebElement updatedPhone ;

    /**
     * Clique sur le bouton "Add an address" pour ajouter une nouvelle adresse.
     */
    public void clickMyAddressButton(){
        addAddressButton.click();
    }

    /**
     * Clique sur le bouton "Update" pour mettre à jour les nouvelles informations.
     */
    public void clickUpdateButton(){
        updateButton.click();
    }

    /**
     * Récupère le titre de l'adresse affichée sur la page.
     * @return le titre de l'adresse.
     */
    public String AddressTitle(){
        return addressTitle.getText();
    }

    /**
     * Récupère le titre de l'adresse mise à jour affichée sur la page.
     * @return le titre de l'adresse mise à jour.
     */
    public String UpdatedAddress1Title(){
        return UpdatedAddress1.getText();
    }

    /**
     * Récupère le numéro de téléphone affiché sur la page.
     * @return le numéro de téléphone.
     */
    public String UpdatedPhone(){
        return updatedPhone.getText();
    }

    /**
     * Récupère le titre de la page affichée.
     * @return le titre de la page.
     */
    public String pageTitle(){
        return title.getText();
    }

    /**
     * Récupère le prénom affiché sur la page.
     * @return le prénom.
     */
    public String myFirstname(){
        return myFirstName.getText();
    }

    /**
     * Récupère le nom affiché sur la page.
     * @return le nom.
     */
    public String myLastname(){
        return myLastName.getText();
    }


}
