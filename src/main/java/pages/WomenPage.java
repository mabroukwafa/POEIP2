package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WomenPage {

    WebDriver webDriver;

    @FindBy(xpath = "//span[@class='cat-name' and starts-with(normalize-space(), 'Women')]")
    WebElement womenTitle;


    public WomenPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public boolean womenTitleIsDisplayed(){
        return womenTitle.isDisplayed();
    }


}
