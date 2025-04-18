package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage{


    @FindBy(xpath = "//ul[@class='product_list grid row']//a[@class='product_img_link']")
    List<WebElement> productList;


    @FindBy(xpath = "//span[@class='breadcrumb clearfix']")
    WebElement currentPageName;

    public SearchPage(WebDriver driver){
        super(driver);
    }

    public Boolean isProductVisible(String productName){
        for (WebElement product:productList){
            if (productName.equals(product.getText())) return true;
        }
        return false;
    }

    public Boolean beOnSearchPage(){
        return currentPageName.getText().contains("Search");
    }

}
