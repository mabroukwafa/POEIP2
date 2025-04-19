package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model (POM) pour la page "Contact Us".
 * Elle hérite de la classe {@link BasePage}.
 */
public class ContactUsPage extends BasePage{
    /**
     * Localisateur XPath pour le titre de la page "Contact Us".
     * Il trouve l'élément h1 avec la classe 'page-heading bottom-indent'.
     */
    @FindBy(xpath = "//h1[@class='page-heading bottom-indent']")
    WebElement contactUsTitle;

    /**
     * Constructeur de la classe {@link ContactUsPage} que la classe ContactUsPage hérite.
     * @param webDriver Le WebDriver utilisé pour interagir avec le navigateur
     */
    public ContactUsPage(WebDriver webDriver){
        super(webDriver);
    }

    /**
     * Vérifie si le titre de la page "Contact Us" est affiché.
     *
     * @return true si le titre est visible, false sinon
     */
    public boolean contactUsTitleIsDisplayed(){
        return contactUsTitle.isDisplayed();
    }


}
