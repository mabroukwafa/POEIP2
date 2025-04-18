package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model (POM) for the Blog page.
 * Contient les éléments et les interactions possibles sur la page Blog.
 */
public class BlogPage {

    // WebDriver instance to interact with the browser
    WebDriver webDriver;

    /**
     * Localisateur XPath pour le titre de la page Blog.
     * Trouver l'élément h1 dont le texte est 'Blog'.
     */
    @FindBy(xpath = "//h1[text()='Blog']")
    private WebElement blogTitle;

    /**
     * Constructeur de la classe BlogPage.
     * @param driver instance de WebDriver pour interagir avec le navigateur
     */
    public BlogPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Vérifie si le titre de la page Blog est affiché.
     * @return vrai si le titre est visible, faux sinon
     */
    public boolean blogTitleIsDisplayed() {
        return blogTitle.isDisplayed();
    }
}