package Tests;

import HelpMethods.ElementMethods;
import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnsuccessfullLoginTest extends ShareData {
    @Test
    public void loginUnsuccessfull(){

        ElementMethods elementMethods = new ElementMethods(getDriver());

        WebElement connect = getDriver().findElement(By.className("link-border"));
        elementMethods.clickElement(connect);

        WebElement email = getDriver().findElement(By.id("username"));
        String emailValue = "daniela.solo@email.ro";
        elementMethods.fillElement(email, emailValue);

        WebElement password = getDriver().findElement(By.id("password"));
        String passwordValue = "Daniela81";
        elementMethods.fillElement(password, passwordValue);

        WebElement login = getDriver().findElement(By.className("submit-button"));
        elementMethods.clickElement(login);

        WebElement error = getDriver().findElement(By.className("login-error-message"));
        String expectedError = "Email sau parola incorecte!";
        elementMethods.validateMessage(error, expectedError);

    }
}
