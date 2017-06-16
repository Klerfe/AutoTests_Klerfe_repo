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

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
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
/*    public static void iniProp() {
        FileInputStream fis;
        Properties properties = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/configTs.properties");
            properties.load(fis);
        }
        catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }*/

        private static String url = "https://www.facebook.com/";
        private static String userName1 = "Alexey Kozlovets";
        private static String email = "alexey.kozlovets@gmail.com";
        private static String password = "Ctuvtynbhjdfybt";
        private static int monitorWidth = 1280;
        private static int browserUpPanel = 20;
        private static int browserScroll = 10;



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
    public static void test() {                                                     // Проверка, что на главной странице
        loginPage.writeEmail(email);                                                 // имя пользователя совпадает с заданным
        loginPage.writePass(password);
        loginPage.logIn();
        /*mainPage.setBlackScreenClickable();*/
        String userName = mainPage.getUserName();
        Assert.assertEquals(userName1, userName);
    }

    @Test
    public static void test2() {
        Assert.assertEquals(mainPage.viewUiSearchInput(), true);                // Проверка, что поиск на главной странице
        mainPage.setSearchInput(userName1);                                          // находит соответствующих людей
        Assert.assertEquals(userName1, filtersResult.getFirstPersonFinded());
        driver.get(url);
    }

    @Test
    public static void test3() {                                                            // проверить что основные блоки главной
        Assert.assertTrue(mainPage.sizeSumMainDiv() <= (monitorWidth - browserScroll));  // не выходят за границы экрана монитора
    }

    @Test
    public static void test99() {                                                    // Проверить, что на странице Польз-ля имя
        mainPage.moveToOwnerPage();                                                 // поль-ля совпадает с именем на Гл.странице
        Assert.assertEquals(userName1, ownerPage.OwnerName());
        mainPage.exitOwnerAccount();
    }

    @AfterClass
    public void closePage() {
        driver.quit();
    }

}
