package Tests;

import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BorrowCanceled extends ShareData {
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

        WebElement borrowedBook = driver.findElement(By.xpath("//a[@ng-href='https://www.bookster.ro/books/cand-corpul-spune-nu/']"));

        WebElement cancel = driver.findElement(By.xpath("//a[text()='Anulează']"));
        cancel.click();

        WebElement cancelWindow = driver.findElement(By.xpath("//div[@class='inmodal ng-scope']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(cancelWindow).perform();

        WebElement validateTitle= driver.findElement(By.xpath("//h3[text()='Cand corpul spune nu']"));
        String expectedTitle = "Cand corpul spune nu";
        String actualTitle= validateTitle.getText();
        Assert.assertEquals(expectedTitle, actualTitle);

        WebElement validateAuthor= driver.findElement(By.xpath("//h5[text()='carte de Gabor Mate']"));
        String expectedAuthor = "carte de Gabor Mate";
        String actualAuthor= validateAuthor.getText();
        Assert.assertEquals(expectedAuthor, actualAuthor);

        WebElement confirmMessage = driver.findElement(By.xpath("//p[text()='Ești sigur că vrei să anulezi acest împrumut?']"));
        String expectedConfirmMessage = "Ești sigur că vrei să anulezi acest împrumut?";
        String actualConfirmMessage = confirmMessage.getText();
        Assert.assertEquals(expectedConfirmMessage, actualConfirmMessage);

        WebElement borrowedCancel = driver.findElement(By.xpath("//button[contains(text(),'Anulează împrumutul')]"));
        borrowedCancel.click();


    }
}
