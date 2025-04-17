package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    @FindBy(xpath = "//img[@class='logo img-responsive']")
    private WebElement logo;

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signIn;

    @FindBy(xpath = "//input[@id='search_query_top']")
    private WebElement fieldSearch;

    @FindBy(xpath = "//button[contains(@class, 'button-search')]")
    private WebElement loupeSearch;

    @FindBy(xpath = "//a[b='Cart']")
    private WebElement accessCart;

    @FindBy(xpath = "//a[@title='Women']")
    private WebElement filtreWomen;

    @FindBy(xpath = "//a[@title='Dresses']")
    private WebElement filtreDresses;

    @FindBy(xpath = "//a[@title='T-shirts']")
    private WebElement filtreTShirts;

    public BasePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void clickOnLogo(){
        logo.click();
    }

    public void clickOnSignIn(){
        signIn.click();
    }

    public void insertInFieldSearch(String string){
        fieldSearch.sendKeys(string);
    }

    public void clickOnLoupeSearch(){
        loupeSearch.click();
    }

    public void clickOnAccessCart(){
        accessCart.click();
    }

    public void clickOnFiltreWomen(){
        filtreWomen.click();
    }

    public void clickOnFiltreDresses(){
        filtreDresses.click();
    }

    public void clickOnFiltreTShirts(){
        filtreTShirts.click();
    }



}
