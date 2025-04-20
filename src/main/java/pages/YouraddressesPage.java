package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class YouraddressesPage extends BasePage{
    public YouraddressesPage(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }
    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstnameField;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastnameField;

    @FindBy(xpath = "//input[@id='company']")
    private WebElement companyField;

    @FindBy(xpath = "//input[@id='address1']")
    private WebElement address1Field;

   @FindBy(xpath = "//input[@id='address2']")
    private WebElement address2Field;

  @FindBy(xpath = "//input[@id='city']")
    private WebElement cityField;

  @FindBy(xpath = "//input[@id='phone']")
    private WebElement homePhoneField;

 @FindBy(xpath = "//input[@id='phone_mobile']")
    private WebElement mobilePhoneField;

 @FindBy(xpath = "//textarea[@id='other']")
    private WebElement additionalInformationField;

 @FindBy(xpath = "//input[@id='alias']")
    private WebElement addressTitleField;

 @FindBy(xpath = "//input[@id='postcode']")
    private WebElement postcodeField;

 @FindBy(xpath = "//select[@id='id_state']")
    private WebElement stateField;

 @FindBy(xpath = "//select[@id='id_country']")
    private WebElement countryField;

 @FindBy(xpath = "//button[@id='submitAddress']")
    private WebElement saveButton;

    public void sendFirstname(String firstname){
        firstnameField.clear();
        firstnameField.sendKeys(firstname);
    }
   public void sendLastname(String lastname){
        lastnameField.clear();
        lastnameField.sendKeys(lastname);
    }

    public void sendCompany(String company){
        companyField.clear();
        companyField.sendKeys(company);
    }
    public void sendAddress1(String address1){
        address1Field.clear();
        address1Field.sendKeys(address1);
    }

    public void sendAddress2(String address2){
        address2Field.clear();
        address2Field.sendKeys(address2);
    }
    public void sendCity(String city){
        cityField.clear();
        cityField.sendKeys(city);
    }
    public void sendMobilephone(String phone){
        mobilePhoneField.clear();
        mobilePhoneField.sendKeys(phone);
    }
    public void sendHomePhone(String phone){
        homePhoneField.clear();
        homePhoneField.sendKeys(phone);
    }
    public void sendInformation(String information){
        additionalInformationField.clear();
        additionalInformationField.sendKeys(information);
    }
    public void sendAddressTitle(String addressTitle){

        addressTitleField.clear();
        addressTitleField.sendKeys(addressTitle);
    }
    public void sendPostcode(String postcode){
        postcodeField.clear();
        postcodeField.sendKeys(postcode);
    }

    public void clickButton(){
        saveButton.click();
    }

    public void sendState(String state){
        Select select = new Select(stateField);
       select.selectByVisibleText(state);
    }
    public void sendCountry(String country){
        Select select = new Select(countryField);
       select.selectByVisibleText(country);
    }







}
