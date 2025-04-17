package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlogPage {

    @FindBy(xpath = "//h1[text()='Blog']")
    private WebElement blogTitle;


    WebDriver webDriver;

    public BlogPage(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(webDriver,this);


    }

    public boolean blogTitleIsDisplayed(){
        return blogTitle.isDisplayed();
    }
}
