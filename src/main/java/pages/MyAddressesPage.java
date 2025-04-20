package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAddressesPage extends BasePage{
    public MyAddressesPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = "//a[@title='Add an address']")
    WebElement addAddressButton;

    //je modifie la premiere adresse dans la liste
    @FindBy(xpath = "//a[@title='Update']")
    WebElement updateButton;

    // je teste tjrs sur la derniere adresse dans la list
    @FindBy(xpath = "//ul[contains(@class, 'last_item')]//li/h3")
    WebElement addressTitle;

    @FindBy(xpath = "//div[@id='center_column']/h1")
    WebElement title;

    @FindBy(xpath = "//ul[contains(@class, 'first_item')]//li/span[@class='address_address1']")
    WebElement UpdatedAddress1 ;

    @FindBy(xpath = "//ul[contains(@class, 'first_item')]//li/span[@class='address_name'][1]")
    WebElement myFirstName ;

    @FindBy(xpath = "//ul[contains(@class, 'first_item')]//li/span[@class='address_name'][2]")
    WebElement myLastName ;

    @FindBy(xpath = "//ul[contains(@class, 'first_item')]//li/span[@class='address_phone_mobile']")
    WebElement updatedPhone ;

    public void clickMyAddressButton(){
        addAddressButton.click();
    }
    public void clickUpdateButton(){
        updateButton.click();
    }

    public String AddressTitle(){
        return addressTitle.getText();
    }
    public String UpdatedAddress1Title(){
        return UpdatedAddress1.getText();
    }
    public String UpdatedPhone(){
        return updatedPhone.getText();
    }

    public String pageTitle(){
        return title.getText();
    }

    public String myFirstname(){
        return myFirstName.getText();
    }
    public String myLastname(){
        return myLastName.getText();
    }


}
