package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model (POM) pour la page T-Shirts.
 * Cette classe représente les éléments et interactions possibles sur la page des produits T-Shirts.
 */
public class TShirtsPage extends BasePage{

    // Driver Selenium pour interagir avec le navigateur
    WebDriver webDriver;

    /**
     * Localisateur XPath pour le titre de la page T-Shirts.
     * Trouve l'élément span avec classe 'cat-name' dont le texte commence par 'T-shirts'
     */
    @FindBy(xpath = "//span[@class='cat-name' and starts-with(normalize-space(), 'T-shirts')]")
    private WebElement tShirtTitle;

    /**
     * Constructeur de la classe TShirtsPage.
     * Initialise les éléments de la page avec PageFactory.
     *
     * @param webDriver Le WebDriver utilisé pour naviguer et interagir avec la page
     */
    public TShirtsPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Vérifie si le titre de la page T-Shirts est affiché.
     *
     * @return true si le titre est visible, false sinon
     */
    public boolean tShirtTitleIsDisplayed() {
        return tShirtTitle.isDisplayed();
    }
}