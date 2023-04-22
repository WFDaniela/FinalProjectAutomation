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

        UnsuccessfullLoginPage unsuccessfullLoginPage = new UnsuccessfullLoginPage(getDriver());
        unsuccessfullLoginPage.loginFailed(unsuccessfulLoginObject);


    }
}
