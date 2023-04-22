package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookBorrowPage extends BasePage{
    public BookBorrowPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="username")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(className ="submit-button")
    private WebElement login;

    @FindBy(xpath = "//input[@placeholder='Caută următoarea ta lectură...']")
    private WebElement searchField;

    @FindBy(xpath = "//a[@ng-href='https://www.bookster.ro/books/cand-corpul-spune-nu/']//span[@class='result-title ng-binding']")
    private  WebElement selectBook;

    @FindBy(xpath = "//button[contains(text(),'Împrumută')]")
    private WebElement borrow;

    @FindBy(xpath = "//div[@class='inmodal borrow-popup ng-scope']")
    private WebElement borrowWindow;

    @FindBy(xpath = "//h3[text()='Cand corpul spune nu']")
    private WebElement validateTitle;

    @FindBy(xpath = "//h5[text()='carte de Gabor Mate']")
    private WebElement validateAuthor;

    @FindBy(xpath = "//button[text()='                                Împrumută în Română                            ']")
    private WebElement borrowButton;

    public void borrowBook(String emailValue, String passwordValue, String textValue, String expectedTitle, String expectedAuthor){

        elementMethods.fillElement(email,emailValue);
        elementMethods.fillElement(password, passwordValue);
        elementMethods.clickElement(login);
        elementMethods.clickElement(searchField);
        elementMethods.fillElement(searchField, textValue);
        elementMethods.clickElement(selectBook);
        elementMethods.clickElement(borrow);
        elementMethods.moveToElement(borrowWindow);
        elementMethods.validateMessage(validateTitle, expectedTitle);
        elementMethods.validateMessage(validateAuthor, expectedAuthor);
        elementMethods.clickElement(borrowButton);
    }
}
