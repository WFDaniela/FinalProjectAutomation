package ShareData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class ShareData {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }


    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://landing.bookster.ro/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }



    public void Clear(){
        driver.quit();
    }


}
