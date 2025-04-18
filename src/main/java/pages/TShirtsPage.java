package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TShirtsPage {

    WebDriver webDriver;

    @FindBy(xpath = "//span[@class='cat-name' and starts-with(normalize-space(), 'T-shirts')]")
    WebElement tShirtTitle;


    public TShirtsPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public boolean tShirtTitleIsDisplayed(){
        return tShirtTitle.isDisplayed();
    }


}
