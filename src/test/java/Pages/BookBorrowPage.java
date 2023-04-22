package Pages;

import Objects.BookBorrowObject;
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

    public void borrowBook(BookBorrowObject bookBorrowObject){

        elementMethods.fillElement(email,bookBorrowObject.getEmail());
        elementMethods.fillElement(password, bookBorrowObject.getPassword());
        elementMethods.clickElement(login);
        elementMethods.clickElement(searchField);
        elementMethods.fillElement(searchField, bookBorrowObject.getText());
        elementMethods.clickElement(selectBook);
        elementMethods.clickElement(borrow);
        elementMethods.moveToElement(borrowWindow);
        elementMethods.validateMessage(validateTitle, bookBorrowObject.getTitle());
        elementMethods.validateMessage(validateAuthor, bookBorrowObject.getAuthor());
        elementMethods.clickElement(borrowButton);
    }
}
