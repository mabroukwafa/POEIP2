package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrestashopPage {

    @FindBy(xpath = "//h1[@class='color-3 t0--5 t0 title']")
    private WebElement titrePrestashop;

    WebDriver webDriver;

    public PrestashopPage(WebDriver driver){
        this.webDriver = driver;
        PageFactory.initElements(webDriver,this);

    }

    public boolean titrePrestashopIsDisplayed(){
        return titrePrestashop.isDisplayed();
    }



}
