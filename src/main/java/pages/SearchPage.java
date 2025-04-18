package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage{


    @FindBy(xpath = "//ul[@class='product_list grid row']//a[@class='product-name']")
    List<WebElement> productList;


    @FindBy(xpath = "//div[@class='breadcrumb clearfix']")
    WebElement currentPageName;

    public SearchPage(WebDriver driver){
        super(driver);
    }

    public Boolean isProductVisible(String productName){
        for (WebElement product:productList){
            if (product.getText().contains(productName)) return true;
        }
        return false;
    }

    public Boolean beOnSearchPage(){
        return currentPageName.getText().contains("Search");
    }

}
