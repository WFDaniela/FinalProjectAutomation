package Tests;

import HelpMethods.ElementMethods;
import Pages.IndexPage;
import Pages.RemoveFromWishlistPage;
import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WishlistRemoveProductTest extends ShareData {


    @Test
    public void removeFromWishlist() {
        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickConnect();

        RemoveFromWishlistPage removeFromWishlistPage = new RemoveFromWishlistPage(getDriver());
        removeFromWishlistPage.removeBookFromWishlist("laurentiu.solomon@btrl.ro", "Solanj78", "Nu ai niciun material în wishlist");

    }

}

