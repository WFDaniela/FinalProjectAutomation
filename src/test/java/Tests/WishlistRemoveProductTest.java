package Tests;

import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishlistRemoveProductTest extends ShareData {


    @Test
    public void metodaTest() {

        WebElement connect = driver.findElement(By.className("link-border"));
        connect.click();

        WebElement email = driver.findElement(By.id("username"));
        String emailValue = "laurentiu.solomon@btrl.ro";
        email.sendKeys(emailValue);

        WebElement password = driver.findElement(By.id("password"));
        String passwordValue = "Solanj78";
        password.sendKeys(passwordValue);

        WebElement login = driver.findElement(By.className("submit-button"));
        login.click();

        WebElement menu = driver.findElement(By.className("icon-settings"));
        menu.click();

        WebElement profile = driver.findElement(By.cssSelector("ul>li>a"));
        profile.click();

        WebElement wishlist = driver.findElement(By.xpath("//div[text()='Wishlist']"));
        wishlist.click();


        WebElement book = driver.findElement(By.xpath("//div[@class='cover']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(book).perform();

        WebElement dropdown = driver.findElement(By.xpath("(//div[@class='menu-icon dropdown-toggle'])[1]"));
        dropdown.click();

        WebElement removeFromWishlist = driver.findElement(By.xpath("(//a[@class='ng-binding ng-scope'])"));
        removeFromWishlist.click();

        WebElement validateMessage = driver.findElement(By.xpath("//div[@class='message-empty col-xs-12 ng-binding ng-scope']"));
        String expectedMessage = "Nu ai niciun material în wishlist";
        String actualMessage = validateMessage.getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }
}
