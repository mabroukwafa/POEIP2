package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
    WebDriver webDriver;

    @FindBy(xpath = "//h1[@class='page-heading bottom-indent']")
    WebElement contactUsTitle;


    public ContactUsPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public boolean contactUsTitleIsDisplayed(){
        return contactUsTitle.isDisplayed();
    }


}
