package HelpMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ElementMethods  {
    private WebDriver driver;

    public ElementMethods(WebDriver driver) {
        this.driver = driver;
    }
    public void clickElement(WebElement element){
        waitElementVisible(element);
        element.click();
    }

    public void waitElementVisible(WebElement element){
        WebDriverWait waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitExplicit.until(ExpectedConditions.visibilityOf(element));
    }

    public void fillElement(WebElement element, String value){
        waitElementVisible(element);
        element.sendKeys(value);
    }

    public void validateMessage(WebElement element, String value){
        waitElementVisible(element);
        String actual = element.getText();
        Assert.assertEquals(value, actual);
    }

    public void moveToElement(WebElement element){
        waitElementVisible(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

}
