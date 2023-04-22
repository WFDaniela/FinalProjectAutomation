package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RemoveFromWishlistPage extends BasePage{
    public RemoveFromWishlistPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(className = "submit-button")
    private WebElement login;

    @FindBy(className = "icon-settings")
    private WebElement menu;

    @FindBy(css = "ul>li>a")
    private WebElement profile;

    @FindBy(xpath = "//div[text()='Wishlist']")
    private WebElement wishlist;

    @FindBy(xpath = "//div[@class='cover']")
    private WebElement book;

    @FindBy(xpath = "(//div[@class='menu-icon dropdown-toggle'])[1]")
    private WebElement dropdown;

    @FindBy(xpath = "(//a[@class='ng-binding ng-scope'])")
    private WebElement removeFromWishlist;

    @FindBy(xpath = "//div[@class='message-empty col-xs-12 ng-binding ng-scope']")
    private WebElement validateMessage;

    public void removeBookFromWishlist(String emailValue, String passwordValue, String expectedMessage){

        elementMethods.fillElement(email, emailValue);
        elementMethods.fillElement(password, passwordValue);
        elementMethods.clickElement(login);
        elementMethods.clickElement(menu);
        elementMethods.clickElement(profile);
        elementMethods.clickElement(wishlist);
        elementMethods.moveToElement(book);
        elementMethods.clickElement(dropdown);
        elementMethods.clickElement(removeFromWishlist);
        elementMethods.validateMessage(validateMessage, expectedMessage);


    }

}
