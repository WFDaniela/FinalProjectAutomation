package Tests;

import Objects.BookBorrowObject;
import Pages.BookBorrowPage;
import Pages.IndexPage;

import ShareData.Hooks;
import org.testng.annotations.Test;

public class BookBorrowTest extends Hooks {


    @Test
    public void bookBorrow() {
        BookBorrowObject bookBorrowObject = new BookBorrowObject(TestData);

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickConnect();

        BookBorrowPage bookBorrowPage = new BookBorrowPage(getDriver());
        bookBorrowPage.borrowBook(bookBorrowObject);



    }
}
