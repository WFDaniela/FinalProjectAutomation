package Tests;

import Pages.AddToWishlistPage;
import Pages.IndexPage;
import ShareData.ShareData;
import org.testng.annotations.Test;

public class WishlistAddProductTest extends ShareData {

    @Test
    public void addToWishlist(){
        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickConnect();

        AddToWishlistPage addToWishlistPage = new AddToWishlistPage(getDriver());
        addToWishlistPage.addBookToWishlist("laurentiu.solomon@btrl.ro", "Solanj78");

    }
}
