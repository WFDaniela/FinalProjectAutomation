package Tests;

import HelpMethods.ElementMethods;
import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BorrowCanceled extends ShareData {
    @Test
    public void borrowCanceled() {

        ElementMethods elementMethods = new ElementMethods(getDriver());

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

        WebElement borrowedBook = getDriver().findElement(By.xpath("//a[@ng-href='https://www.bookster.ro/books/cand-corpul-spune-nu/']"));

        WebElement cancel = getDriver().findElement(By.xpath("//a[text()='Anulează']"));
        elementMethods.clickElement(cancel);

        WebElement cancelWindow = getDriver().findElement(By.xpath("//div[@class='inmodal ng-scope']"));
        elementMethods.moveToElement(cancelWindow);

        WebElement validateTitle= getDriver().findElement(By.xpath("//h3[text()='Cand corpul spune nu']"));
        String expectedTitle = "Cand corpul spune nu";
        elementMethods.validateMessage(validateTitle, expectedTitle);

        WebElement validateAuthor= getDriver().findElement(By.xpath("//h5[text()='carte de Gabor Mate']"));
        String expectedAuthor = "carte de Gabor Mate";
        elementMethods.validateMessage(validateAuthor, expectedAuthor);

        WebElement confirmMessage = getDriver().findElement(By.xpath("//p[text()='Ești sigur că vrei să anulezi acest împrumut?']"));
        String expectedConfirmMessage = "Ești sigur că vrei să anulezi acest împrumut?";
        elementMethods.validateMessage(confirmMessage, expectedConfirmMessage);

        WebElement borrowedCancel = getDriver().findElement(By.xpath("//button[contains(text(),'Anulează împrumutul')]"));
        elementMethods.clickElement(borrowedCancel);

        WebElement cancelConfirm = getDriver().findElement(By.xpath("//div[contains(text(),'Nu ai niciun material în drum spre tine')]"));
        String expectedCancelConfirm = "Nu ai niciun material în drum spre tine";
        elementMethods.validateMessage(cancelConfirm, expectedCancelConfirm);

    }
}
