package firstweb.tests;

import firstweb.pages.LoginPage;
import firstweb.pages.MainPage;
import firstweb.properties.Proper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alexey on 22.05.2017.
 */
public class LoginTest {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static MainPage mainPage;


    /*Входные данные*/
    public String userName = "Alexey Kozlovets";
    public String email = "alexey.kozlovets@gmail.com";
    public String password = "Ctuvtynbhjdfybt";

    @BeforeClass
    public static void setup() {
        Proper proper = new Proper();
        System.setProperty(proper.getBrowDriverName(), proper.getBrowDriverPath());
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");
    }

    @Test
     public void loginTest(){
        loginPage.writeEmail(this.email);
        loginPage.writePass(this.password);
        loginPage.logIn();
        String userName = mainPage.getUserName();
        Assert.assertEquals(userName, this.userName);
        mainPage.exitOwnerAccount();
        }

    @AfterClass
    public void closePage() {
        driver.quit();
    }

}
