package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToWishlistPage extends  BasePage{
    public AddToWishlistPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(className = "submit-button")
    private WebElement login;

    @FindBy(className = "link-title")
    private WebElement explore;

    @FindBy(xpath = "//div[text()='Dezvoltare personală']")
    private WebElement category;

    @FindBy(xpath = "//div[text()='Gândire pozitivă']")
    private WebElement subCategory;

    @FindBy(xpath = "(//div[@class='cover-texture'])[1]")
    private WebElement book;

    @FindBy(xpath = "//a[text()='Wishlist']")
    private WebElement addToWishlist;

    public void addBookToWishlist(String emailValue, String passwordValue){

        elementMethods.fillElement(email,emailValue);
        elementMethods.fillElement(password, passwordValue);
        elementMethods.clickElement(login);
        elementMethods.clickElement(explore);
        elementMethods.clickElement(category);
        elementMethods.clickElement(subCategory);
        elementMethods.clickElement(book);
        elementMethods.clickElement(addToWishlist);
    }

}
