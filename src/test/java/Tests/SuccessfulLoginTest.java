package Tests;

import Objects.SuccessfulLoginObject;
import Pages.IndexPage;
import Pages.SuccessfulLoginPage;
import ShareData.Hooks;
import org.testng.annotations.Test;

public class SuccessfulLoginTest extends Hooks {


    @Test
    public void loginSuccessful() {

        SuccessfulLoginObject successfullLoginObject = new SuccessfulLoginObject(TestData);

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickConnect();
        testReport.attachReport("pass", "I clicked on Connect button");

        SuccessfulLoginPage successfulLoginPage = new SuccessfulLoginPage(getDriver());
        successfulLoginPage.loginValid(successfullLoginObject);
        testReport.attachReport("pass", "I manage to login");


    }
}
