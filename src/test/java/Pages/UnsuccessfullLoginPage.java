package Pages;

import HelpMethods.ElementMethods;
import Objects.UnsuccessfulLoginObject;
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

    public void loginFailed(UnsuccessfulLoginObject unsuccessfulLoginObject){
        elementMethods.fillElement(email, unsuccessfulLoginObject.getEmail());
        elementMethods.fillElement(password, unsuccessfulLoginObject.getPassword());
        elementMethods.clickElement(login);
        elementMethods.validateMessage(error, unsuccessfulLoginObject.getError());
    }

}
