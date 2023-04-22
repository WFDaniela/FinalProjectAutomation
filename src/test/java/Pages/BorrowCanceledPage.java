package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BorrowCanceledPage extends BasePage {
    public BorrowCanceledPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="username")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(className ="submit-button")
    private WebElement login;

    @FindBy(className = "icon-settings")
    private WebElement menu;

    @FindBy(css = "ul>li>a")
    private WebElement profile;

    @FindBy(xpath = "//a[@ng-href='https://www.bookster.ro/books/cand-corpul-spune-nu/']")
    private WebElement borrowedBook;

    @FindBy(xpath = "//a[text()='Anulează']")
    private WebElement cancel;

    @FindBy(xpath = "//div[@class='inmodal ng-scope']")
    private WebElement cancelWindow;

    @FindBy(xpath = "//h3[text()='Cand corpul spune nu']")
    private WebElement validateTitle;

    @FindBy(xpath = "//h5[text()='carte de Gabor Mate']")
    private WebElement validateAuthor;

    @FindBy(xpath = "//p[text()='Ești sigur că vrei să anulezi acest împrumut?']")
    private WebElement confirmMessage;

    @FindBy(xpath = "//button[contains(text(),'Anulează împrumutul')]")
    private WebElement borrowedCancel;

    @FindBy(xpath = "//div[contains(text(),'Nu ai niciun material în drum spre tine')]")
    private WebElement cancelConfirm;

    public void cancelBookBorrow(String emailValue, String passwordValue, String expectedTitle, String expectedAuthor, String expectedConfirmMessage, String expectedCancelConfirm){

        elementMethods.fillElement(email, emailValue);
        elementMethods.fillElement(password, passwordValue);
        elementMethods.clickElement(login);
        elementMethods.clickElement(menu);
        elementMethods.clickElement(profile);
        elementMethods.moveToElement(borrowedBook);
        elementMethods.clickElement(cancel);
        elementMethods.moveToElement(cancelWindow);
        elementMethods.validateMessage(validateTitle, expectedTitle);
        elementMethods.validateMessage(validateAuthor, expectedAuthor);
        elementMethods.validateMessage(confirmMessage, expectedConfirmMessage);
        elementMethods.clickElement(borrowedCancel);
        elementMethods.validateMessage(cancelConfirm, expectedCancelConfirm);

    }

}
