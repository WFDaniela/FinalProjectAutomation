package Tests;

import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnsuccessfullLoginTest extends ShareData {
    @Test
    public void metodaTest(){

        WebElement connect = driver.findElement(By.className("link-border"));
        connect.click();

        WebElement email = driver.findElement(By.id("username"));
        String emailValue = "daniela.solo@email.ro";
        email.sendKeys(emailValue);

        WebElement password = driver.findElement(By.id("password"));
        String passwordValue = "Daniela81";
        password.sendKeys(passwordValue);

        WebElement login = driver.findElement(By.className("submit-button"));
        login.click();

        WebElement error = driver.findElement(By.className("login-error-message"));
        String expectedError = "Email sau parola incorecte!";
        String actualError = error.getText();
        Assert.assertEquals(expectedError, actualError);

    }
}
