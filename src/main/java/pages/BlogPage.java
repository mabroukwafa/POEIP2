package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model (POM) for the Blog page.
 * Contains web elements and methods to interact with the Blog page.
 */
public class BlogPage {

    // WebDriver instance to interact with the browser
    WebDriver webDriver;

    /**
     * Locator for the Blog page title element.
     * Finds the h1 element with exact text "Blog"
     */
    @FindBy(xpath = "//h1[text()='Blog']")
    private WebElement blogTitle;

    /**
     * Constructor to initialize the BlogPage.
     * @param driver WebDriver instance to be used for page interactions
     */
    public BlogPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Verifies if the Blog page title is displayed.
     * @return true if the title is visible, false otherwise
     */
    public boolean blogTitleIsDisplayed() {
        return blogTitle.isDisplayed();
    }
}