package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model (POM) pour la page Women.
 * Elle hérite de la classe {@link BasePage}.
 */
public class WomenPage extends BasePage{

    /**
     * Localisateur XPath pour le titre de la page Women.
     * Trouve l'élément span avec classe 'cat-name' dont le texte commence par 'Women'
     */
    @FindBy(xpath = "//span[@class='cat-name' and starts-with(normalize-space(), 'Women')]")
    private WebElement womenTitle;

    /**
     * Constructeur de la classe BasePage que la classe DressesPage hérite.
     * @param webDriver Le WebDriver utilisé pour naviguer et interagir avec la page
     */
    public WomenPage(WebDriver webDriver) {
        super(webDriver);
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