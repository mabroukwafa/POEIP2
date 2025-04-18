package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model (POM) pour la page Dresses.
 * Représente les éléments et interactions possibles sur la page des robes.
 */
public class DressesPage extends BasePage{

    // Driver Selenium pour interagir avec le navigateur
    WebDriver webDriver;

    /**
     * Localisateur XPath pour le titre de la page Dresses.
     * Trouve l'élément span avec classe 'cat-name' dont le texte commence par 'Dresses'
     */
    @FindBy(xpath = "//span[@class='cat-name' and starts-with(normalize-space(), 'Dresses')]")
    private WebElement dressesTitle;

    /**
     * Constructeur de la classe DressesPage.
     * @param webDriver Instance WebDriver pour interagir avec le navigateur
     */
    public DressesPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Vérifie l'affichage du titre de la page Dresses.
     * @return true si le titre est visible, false sinon
     */
    public boolean dressesTitleIsDisplayed() {
        return dressesTitle.isDisplayed();
    }
}