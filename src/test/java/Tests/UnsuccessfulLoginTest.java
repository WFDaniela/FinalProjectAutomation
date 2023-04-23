package Tests;

import Objects.UnsuccessfulLoginObject;
import Pages.IndexPage;
import Pages.UnsuccessfullLoginPage;

import ShareData.Hooks;
import org.testng.annotations.Test;

public class UnsuccessfulLoginTest extends Hooks {
    @Test
    public void loginUnsuccessfull(){
        UnsuccessfulLoginObject unsuccessfulLoginObject =new UnsuccessfulLoginObject(TestData);

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickConnect();
        testReport.attachReport("pass", "I clicked on Connect button");

        UnsuccessfullLoginPage unsuccessfullLoginPage = new UnsuccessfullLoginPage(getDriver());
        unsuccessfullLoginPage.loginFailed(unsuccessfulLoginObject);
        testReport.attachReport("pass", "I manage to validate invalid login");


    }
}
