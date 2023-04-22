package Tests;

import HelpMethods.ElementMethods;
import Pages.IndexPage;
import Pages.UnsuccessfullLoginPage;
import ShareData.ShareData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnsuccessfullLoginTest extends ShareData {
    @Test
    public void loginUnsuccessfull(){

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.clickConnect();

        UnsuccessfullLoginPage unsuccessfullLoginPage = new UnsuccessfullLoginPage(getDriver());
        unsuccessfullLoginPage.loginFailed("daniela.solo@email.ro", "Daniela81","Email sau parola incorecte!" );



    }
}
