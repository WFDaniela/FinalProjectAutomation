package Tests;

import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class WishlistAddProductTest extends ShareData {

    @Test
    public void metodaTest(){

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

        WebElement explore = driver.findElement(By.className("link-title"));
        explore.click();

        WebElement category = driver.findElement(By.xpath("//div[text()='Dezvoltare personala']"));
        category.click();

        WebElement subCategory = driver.findElement(By.xpath("//div[text()='Gandire pozitiva']"));
        subCategory.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(subCategory);

        WebElement book = driver.findElement(By.xpath("(//div[@class='cover-texture'])[1]"));
        book.click();

        WebElement addWishlist = driver.findElement(By.xpath("//a[text()='Wishlist']"));
        addWishlist.click();
        actions.moveToElement(addWishlist);


    }
}
