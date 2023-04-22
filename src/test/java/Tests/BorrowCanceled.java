package Tests;

import Pages.BorrowCanceledPage;
import Pages.IndexPage;
import ShareData.ShareData;
import org.testng.annotations.Test;

public class BorrowCanceled extends ShareData {
    @Test
    public void borrowCanceled() {
        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickConnect();

        BorrowCanceledPage borrowCanceledPage = new BorrowCanceledPage(getDriver());
        borrowCanceledPage.cancelBookBorrow("laurentiu.solomon@btrl.ro", "Solanj78", "Cand corpul spune nu",
                "carte de Gabor Mate", "Ești sigur că vrei să anulezi acest împrumut?", "Nu ai niciun material în drum spre tine");


    }
}
