package Tests;

import Pages.IndexPage;
import Pages.SuccessfulLoginPage;
import ShareData.ShareData;
import org.testng.annotations.Test;

public class SuccessfulLoginTest extends ShareData {


    @Test
    public void loginSuccessful() {

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickConnect();

        SuccessfulLoginPage successfulLoginPage = new SuccessfulLoginPage(getDriver());
        successfulLoginPage.loginValid("laurentiu.solomon@btrl.ro", "Solanj78");

        String emailValue = "laurentiu.solomon@btrl.ro";
        String passwordValue = "Solanj78";
    }
}
