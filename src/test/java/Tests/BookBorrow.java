package Tests;

import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookBorrow extends ShareData {


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

        WebElement searchField = driver.findElement(By.xpath("//input[@placeholder='Caută următoarea ta lectură...']"));
        searchField.click();
        String textValue = "Cand corpul spune nu";
        searchField.sendKeys(textValue);

        WebElement selectBook = driver.findElement(By.xpath("//a[@ng-href='https://www.bookster.ro/books/cand-corpul-spune-nu/']//span[@class='result-title ng-binding']"));
        selectBook.click();

        WebElement borrow = driver.findElement(By.xpath("//button[contains(text(),'Împrumută')]"));
        borrow.click();

        WebElement borrowWindow = driver.findElement(By.xpath("//div[@class='inmodal borrow-popup ng-scope']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(borrowWindow).perform();

        WebElement validateTitle= driver.findElement(By.xpath("//h3[text()='Cand corpul spune nu']"));
        String expectedTitle = "Cand corpul spune nu";
        String actualTitle= validateTitle.getText();
        Assert.assertEquals(expectedTitle, actualTitle);

        WebElement validateAuthor= driver.findElement(By.xpath("//h5[text()='carte de Gabor Mate']"));
        String expectedAuthor = "carte de Gabor Mate";
        String actualAuthor= validateAuthor.getText();
        Assert.assertEquals(expectedAuthor, actualAuthor);

        WebElement borrowButton = driver.findElement(By.xpath("//button[text()='                                Împrumută în Română                            ']"));
        borrowButton.click();


    }
}
