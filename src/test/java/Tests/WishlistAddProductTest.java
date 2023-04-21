package Tests;

import HelpMethods.ElementMethods;
import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class WishlistAddProductTest extends ShareData {

    @Test
    public void addToWishlist(){
        ElementMethods elementMethods=new ElementMethods(getDriver());

        WebElement connect = getDriver().findElement(By.className("link-border"));
        elementMethods.clickElement(connect);

        WebElement email = getDriver().findElement(By.id("username"));
        String emailValue = "laurentiu.solomon@btrl.ro";
        elementMethods.fillElement(email,emailValue);

        WebElement password = getDriver().findElement(By.id("password"));
        String passwordValue = "Solanj78";
        elementMethods.fillElement(password, passwordValue);

        WebElement login = getDriver().findElement(By.className("submit-button"));
        elementMethods.clickElement(login);

        WebElement explore = getDriver().findElement(By.className("link-title"));
        elementMethods.clickElement(explore);

        WebElement category = getDriver().findElement(By.xpath("//div[text()='Dezvoltare personală']"));
        elementMethods.clickElement(category);

        WebElement subCategory = getDriver().findElement(By.xpath("//div[text()='Gândire pozitivă']"));
        elementMethods.clickElement(subCategory);
        elementMethods.moveToElement(subCategory);

        WebElement book = getDriver().findElement(By.xpath("(//div[@class='cover-texture'])[1]"));
        elementMethods.clickElement(book);

        WebElement addWishlist = getDriver().findElement(By.xpath("//a[text()='Wishlist']"));
        elementMethods.clickElement(addWishlist);
        elementMethods.moveToElement(addWishlist);


    }
}
