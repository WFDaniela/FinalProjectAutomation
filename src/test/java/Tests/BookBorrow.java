package Tests;

import HelpMethods.ElementMethods;
import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookBorrow extends ShareData {


    @Test
    public void bookBorrow() {
        ElementMethods elementMethods = new ElementMethods(getDriver());

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

        WebElement searchField = getDriver().findElement(By.xpath("//input[@placeholder='Caută următoarea ta lectură...']"));
        elementMethods.clickElement(searchField);
        String textValue = "Cand corpul spune nu";
        elementMethods.fillElement(searchField, textValue);

        WebElement selectBook = getDriver().findElement(By.xpath("//a[@ng-href='https://www.bookster.ro/books/cand-corpul-spune-nu/']//span[@class='result-title ng-binding']"));
        elementMethods.clickElement(selectBook);

        WebElement borrow = getDriver().findElement(By.xpath("//button[contains(text(),'Împrumută')]"));
        elementMethods.clickElement(borrow);

        WebElement borrowWindow = getDriver().findElement(By.xpath("//div[@class='inmodal borrow-popup ng-scope']"));
        elementMethods.moveToElement(borrowWindow);

        WebElement validateTitle= getDriver().findElement(By.xpath("//h3[text()='Cand corpul spune nu']"));
        String expectedTitle = "Cand corpul spune nu";
        elementMethods.validateMessage(validateTitle, expectedTitle);

        WebElement validateAuthor= getDriver().findElement(By.xpath("//h5[text()='carte de Gabor Mate']"));
        String expectedAuthor = "carte de Gabor Mate";
        elementMethods.validateMessage(validateAuthor, expectedAuthor);

        WebElement borrowButton = getDriver().findElement(By.xpath("//button[text()='                                Împrumută în Română                            ']"));
        elementMethods.clickElement(borrowButton);


    }
}
