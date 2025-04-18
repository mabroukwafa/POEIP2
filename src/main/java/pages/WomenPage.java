package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model (POM) pour la page Women.
 * Cette classe représente les éléments et interactions possibles sur la page des produits Women.
 */
public class WomenPage {

    // Driver Selenium pour interagir avec le navigateur
    private WebDriver webDriver;

    /**
     * Localisateur XPath pour le titre de la page Women.
     * Trouve l'élément span avec classe 'cat-name' dont le texte commence par 'Women'
     */
    @FindBy(xpath = "//span[@class='cat-name' and starts-with(normalize-space(), 'Women')]")
    private WebElement womenTitle;

    /**
     * Constructeur de la classe WomenPage.
     * Initialise les éléments de la page avec PageFactory.
     *
     * @param webDriver Le WebDriver utilisé pour naviguer et interagir avec la page
     */
    public WomenPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Vérifie si le titre de la page Women est affiché.
     *
     * @return true si le titre est visible, false sinon
     */
    public boolean womenTitleIsDisplayed() {
        return womenTitle.isDisplayed();
    }
}