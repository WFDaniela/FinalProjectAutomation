package Tests;

import Objects.WishlistAddProductObject;
import Pages.AddToWishlistPage;
import Pages.IndexPage;

import ShareData.Hooks;
import org.testng.annotations.Test;

public class WishlistAddProductTest extends Hooks {

    @Test
    public void addToWishlist(){
        WishlistAddProductObject wishlistAddProductObject = new WishlistAddProductObject(TestData);
        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickConnect();

        AddToWishlistPage addToWishlistPage = new AddToWishlistPage(getDriver());
        addToWishlistPage.addBookToWishlist(wishlistAddProductObject);


    }
}
