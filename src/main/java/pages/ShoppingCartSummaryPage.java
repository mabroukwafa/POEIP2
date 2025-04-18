package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartSummaryPage extends BasePage {

    WebDriver driver;
    public ShoppingCartSummaryPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    @FindBy(xpath = " //div[@id='center_column']//h1[@id='cart_title']")
    WebElement title;

    public String getTitle(){
        return title.getText();
    }


}
