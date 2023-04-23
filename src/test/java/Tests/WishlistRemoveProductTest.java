package Tests;

import Objects.WishlistRemoveProductObject;
import Pages.IndexPage;
import Pages.RemoveFromWishlistPage;

import ShareData.Hooks;
import org.testng.annotations.Test;

public class WishlistRemoveProductTest extends Hooks {


    @Test
    public void removeFromWishlist() {
        WishlistRemoveProductObject wishlistRemoveProductObject = new WishlistRemoveProductObject(TestData);
        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickConnect();
        testReport.attachReport("pass", "I clicked on Connect button");

        RemoveFromWishlistPage removeFromWishlistPage = new RemoveFromWishlistPage(getDriver());
        removeFromWishlistPage.removeBookFromWishlist(wishlistRemoveProductObject);
        testReport.attachReport("pass", "A product was removed from the wishlist");


    }

}

