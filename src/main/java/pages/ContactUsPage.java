package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends BasePage{

    @FindBy(xpath = "//h1[@class='page-heading bottom-indent']")
    WebElement contactUsTitle;


    public ContactUsPage(WebDriver webDriver){
        super(webDriver);
    }

    public boolean contactUsTitleIsDisplayed(){
        return contactUsTitle.isDisplayed();
    }


}
