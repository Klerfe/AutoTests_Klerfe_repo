package tests;

import pages.FiltersResult;
import pages.LoginPage;
import pages.MainPage;
import pages.OwnerPage;
import properties.Proper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alexey on 22.05.2017.
 */
public class MainTest {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static MainPage mainPage;
    public static OwnerPage ownerPage;
    public static FiltersResult filtersResult;


    /*Входные данные*/
    public static String url = "https://www.facebook.com/";
    public static String userName1 = "Alexey Kozlovets";
    public static String email = "alexey.kozlovets@gmail.com";
    public static String password = "Ctuvtynbhjdfybt";


    @BeforeClass
    public static void setup() {
        Proper proper = new Proper();
        System.setProperty(proper.getBrowDriverName(), proper.getBrowDriverPath());
        driver = new FirefoxDriver();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        ownerPage = new OwnerPage(driver);
        filtersResult = new FiltersResult(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    @Test
    public static void test() {                                                     // Проверка что на главной странице
        loginPage.writeEmail(email);                                                 // имя пользователя совпадает с заданным
        loginPage.writePass(password);
        loginPage.logIn();
        /*mainPage.setBlackScreenClickable();*/
        String userName = mainPage.getUserName();
        Assert.assertEquals(userName1, userName);
    }

    @Test
    public static void test2() {
        Assert.assertEquals(mainPage.viewUiSearchInput(), true);
        mainPage.setSearchInput(userName1);
        Assert.assertEquals(userName1, filtersResult.getFirstPersonFinded());
        driver.get(url);
    }

    @Test
    public static void test3() {                                                    // Проверить что на странице Польз-ля имя
        mainPage.moveToOwnerPage();                                                 // поль-ля совпадает с именем на Гл.странице
        Assert.assertEquals(userName1, ownerPage.OwnerName());
        mainPage.exitOwnerAccount();
    }

    @AfterClass
    public void closePage() {
        driver.quit();
    }

}
