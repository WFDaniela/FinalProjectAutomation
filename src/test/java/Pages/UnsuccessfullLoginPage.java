package Pages;

import HelpMethods.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnsuccessfullLoginPage extends BasePage {
    @FindBy(id = "username")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(className = "submit-button")
    private WebElement login;

    @FindBy(className = "login-error-message")
    private WebElement error;

    public UnsuccessfullLoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginFailed(String emailValue, String passwordValue, String expectedError){
        elementMethods.fillElement(email, emailValue);
        elementMethods.fillElement(password, passwordValue);
        elementMethods.clickElement(login);
        elementMethods.validateMessage(error, expectedError);
    }

}
