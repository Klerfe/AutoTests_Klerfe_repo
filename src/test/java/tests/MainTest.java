package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FiltersResult;
import pages.LoginPage;
import pages.MainPage;
import pages.OwnerPage;
import static properties.Proper.*;

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

    @BeforeClass
    public static void setup() {
        System.setProperty(browDriverName, browDriverPath);
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
    public static void test() {                                                     // Проверка, что на главной странице
        loginPage.writeEmail(tel);                                                 // имя пользователя совпадает с заданным
        loginPage.writePass(password);
        loginPage.logIn();
        /*mainPage.setBlackScreenClickable();*/
        String userName1 = mainPage.getUserName();
        Assert.assertEquals(userName1, userName);
    }

    @Test
    public static void test2() {
        Assert.assertEquals(mainPage.viewUiSearchInput(), true);                // Проверка, что поиск на главной странице
        mainPage.setSearchInput(userName);                                          // находит соответствующих людей
        Assert.assertEquals(userName, filtersResult.getFirstPersonFinded());
        driver.get(url);
    }

    @Test
    public static void test2_1() {
        Assert.assertEquals(mainPage.viewUiSearchInput(), true);                // Проверка, что поиск на главной странице
        mainPage.setSearchInput(friendNameLt);                                          // находит соответствующих людей
        filtersResult.personsFindedCheck(friendNameLt, friendNameRS);
        driver.get(url);
    }

    @Test
    public static void test2_2() {
        Assert.assertEquals(mainPage.getColor(mainPage.topPanelBar), "#365899");  // проверка цвета верхнего бара MainPage
    }

    @Test
    public static void test3() {                                                            // проверить что основные блоки главной
        Assert.assertTrue(mainPage.sizeSumMainDiv() <= (monitorWidth - browserScroll));  // не выходят за границы экрана монитора
    }

    @Test
    public static void test99() {                                                    // Проверить, что на странице Польз-ля имя
        mainPage.moveToOwnerPage();                                                 // поль-ля совпадает с именем на Гл.странице
        Assert.assertEquals(userName, ownerPage.OwnerName());
        mainPage.exitOwnerAccount();
    }

    @AfterClass
    public void closePage() {
        driver.quit();
    }

}
