package Pages;

import HelpMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends BasePage{
    @FindBy(className = "link-border")
    private WebElement connect;

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public void clickConnect(){
        elementMethods.clickElement(connect);
    }
}
