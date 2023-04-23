package Tests;

import Objects.BorrowCanceledObject;
import Pages.BorrowCanceledPage;
import Pages.IndexPage;

import ShareData.Hooks;
import org.testng.annotations.Test;

public class BorrowCanceledTest extends Hooks {
    @Test
    public void borrowCanceled() {

        BorrowCanceledObject borrowCanceledObject = new BorrowCanceledObject(TestData);
        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickConnect();
        testReport.attachReport("pass", "I clicked on Connect button");

        BorrowCanceledPage borrowCanceledPage = new BorrowCanceledPage(getDriver());
        borrowCanceledPage.cancelBookBorrow(borrowCanceledObject);
        testReport.attachReport("pass", "Borrow canceled!");



    }
}
