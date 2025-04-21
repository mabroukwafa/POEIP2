package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model (POM) pour la page d'accueil.
 * Elle hérite de la classe {@link BasePage}.
 */
public class HomePage extends BasePage {

    // Localisateur XPath pour la bannière publicitaire
    @FindBy(xpath = "(//img[contains(@src, 'banner-img')])[1]")
    WebElement advertisement;

    /**
     * Constructeur de la classe {@link BasePage} que la classe HomePage hérite.
     * @param webDriver Le WebDriver utilisé pour naviguer et interagir avec la page
     */
    public HomePage(WebDriver webDriver) {
        super(webDriver); // Appelle le constructeur parent de BasePage
    }

    /**
     * Clique sur la bannière publicitaire de la page d'accueil.
     * Cette action déclenche normalement une redirection vers une page partenaire.
     */
    public void clickOnAdvertisement() {
        advertisement.click();
    }
}