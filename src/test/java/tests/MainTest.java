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
    public static Properties iniProp() {
        Properties properties = new Properties();

        try {
            FileInputStream fis = new FileInputStream("src/main/resources/configTs.properties");
            properties.load(fis);
        }
        catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
        return properties;
    }
    private static String url = iniProp().getProperty("url");
    private static String userName = iniProp().getProperty("userName1");
    private static String friendNameLt = iniProp().getProperty("friendName1");
    private static String friendNameRS = iniProp().getProperty("friendName2");
    private static String email = iniProp().getProperty("e_mail");
    private static String password = iniProp().getProperty("password");
    private static String tel = iniProp().getProperty("tel1");
    private static int browserUpPanel = Integer.parseInt(iniProp().getProperty("browserUpPanel"));
    private static int browserScroll = Integer.parseInt(iniProp().getProperty("browserScroll"));
    private static int monitorWidth = Integer.parseInt(iniProp().getProperty("monitorWidth"));

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
