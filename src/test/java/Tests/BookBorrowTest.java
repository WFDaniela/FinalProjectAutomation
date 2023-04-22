package Tests;

import Pages.BookBorrowPage;
import Pages.IndexPage;
import ShareData.ShareData;
import org.testng.annotations.Test;

public class BookBorrowTest extends ShareData {


    @Test
    public void bookBorrow() {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickConnect();

        BookBorrowPage bookBorrowPage = new BookBorrowPage(getDriver());
        bookBorrowPage.borrowBook("laurentiu.solomon@btrl.ro", "Solanj78", "Cand corpul spune nu", "Cand corpul spune nu", "carte de Gabor Mate");

        String emailValue = "laurentiu.solomon@btrl.ro";
        String passwordValue = "Solanj78";
        String textValue = "Cand corpul spune nu";
        String expectedTitle = "Cand corpul spune nu";
        String expectedAuthor = "carte de Gabor Mate";

    }
}