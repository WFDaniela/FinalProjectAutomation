package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessfulLoginPage extends BasePage {
    @FindBy(id="username")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(className ="submit-button")
    private WebElement login;

    public SuccessfulLoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginValid(String emailValue, String passwordValue){

        elementMethods.fillElement(email, emailValue);
        elementMethods.fillElement(password, passwordValue);
        elementMethods.clickElement(login);
    }

}
