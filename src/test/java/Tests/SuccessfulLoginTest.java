package Tests;

import HelpMethods.ElementMethods;
import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SuccessfulLoginTest extends ShareData {


    @Test
    public void loginSuccessful() {

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
    }
}
