package Tests;

import HelpMethods.ElementMethods;
import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishlistRemoveProductTest extends ShareData {


    @Test
    public void removeFromWishlist() {

        ElementMethods elementMethods= new ElementMethods(getDriver());

        WebElement connect = getDriver().findElement(By.className("link-border"));
        elementMethods.clickElement(connect);

        WebElement email = getDriver().findElement(By.id("username"));
        String emailValue = "laurentiu.solomon@btrl.ro";
        elementMethods.fillElement(email, emailValue);

        WebElement password = getDriver().findElement(By.id("password"));
        String passwordValue = "Solanj78";
        elementMethods.fillElement(password, passwordValue);

        WebElement login = getDriver().findElement(By.className("submit-button"));
        elementMethods.clickElement(login);

        WebElement menu = getDriver().findElement(By.className("icon-settings"));
        elementMethods.clickElement(menu);

        WebElement profile = getDriver().findElement(By.cssSelector("ul>li>a"));
        elementMethods.clickElement(profile);

        WebElement wishlist = getDriver().findElement(By.xpath("//div[text()='Wishlist']"));
        elementMethods.clickElement(wishlist);


        WebElement book =getDriver().findElement(By.xpath("//div[@class='cover']"));
        elementMethods.moveToElement(book);

        WebElement dropdown = getDriver().findElement(By.xpath("(//div[@class='menu-icon dropdown-toggle'])[1]"));
        elementMethods.clickElement(dropdown);

        WebElement removeFromWishlist = getDriver().findElement(By.xpath("(//a[@class='ng-binding ng-scope'])"));
        elementMethods.clickElement(removeFromWishlist);

        WebElement validateMessage = getDriver().findElement(By.xpath("//div[@class='message-empty col-xs-12 ng-binding ng-scope']"));
        String expectedMessage = "Nu ai niciun material în wishlist";
        elementMethods.validateMessage(validateMessage, expectedMessage);

    }
}
