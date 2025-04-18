package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model (POM) pour la page d'accueil.
 * Hérite de BasePage pour les fonctionnalités communes à toutes les pages.
 */
public class HomePage extends BasePage {

    // Driver Selenium pour interagir avec le navigateur
    WebDriver webDriver;

    // Localisateur XPath pour la bannière publicitaire
    @FindBy(xpath = "(//img[contains(@src, 'banner-img')])[1]")
    private WebElement advertisement;

    /**
     * Constructeur de la classe HomePage.
     * Initialise les éléments de la page avec PageFactory.
     *
     * @param driver Le WebDriver utilisé pour naviguer et interagir avec la page
     */
    public HomePage(WebDriver driver) {
        super(driver); // Appelle le constructeur parent de BasePage
    }

    /**
     * Clique sur la bannière publicitaire de la page d'accueil.
     * Cette action déclenche normalement une redirection vers une page partenaire.
     */
    public void clickOnAdvertisement() {
        advertisement.click();
    }
}