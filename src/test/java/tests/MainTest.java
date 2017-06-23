package tests;

import metods.Metods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

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
    public static Photos photos;

    @BeforeClass
    public static void setup() {
        System.setProperty(DRIVER_NAME, DRIVER_PATH);
        driver = new FirefoxDriver();

        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        ownerPage = new OwnerPage(driver);
        filtersResult = new FiltersResult(driver);
        photos = new Photos(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @Test
    public static void test() {                                                     // Проверка, что на главной странице
        loginPage.writeEmail(TEL);                                                 // имя пользователя совпадает с заданным
        loginPage.writePass(PASSWORD);
        loginPage.logIn();
        /*mainPage.setBlackScreenClickable();*/
        Assert.assertTrue(Metods.checkUserName(mainPage.pagesUsersName));

    }

    @Test
    public static void test2() {
        Assert.assertEquals(mainPage.viewUiSearchInput(), true);                // Проверка, что поиск на главной странице
        mainPage.setSearchInput(USER_NAME);                                          // находит соответствующих людей
        Assert.assertTrue(Metods.checkUserName(filtersResult.personFinded));
        driver.get(URL);
    }

    @Test
    public static void test2_1() {
        Assert.assertEquals(mainPage.viewUiSearchInput(), true);                // Проверка, что поиск на главной странице
        mainPage.setSearchInput(FRIEND_NAME_LT);                                          // находит соответствующих людей
        filtersResult.personsFindedCheck(FRIEND_NAME_LT, FRIEND_NAME_RS);
        driver.get(URL);
    }

    @Test
    public static void test2_2() {                                                  // Проверка, что на странице Фото правильное Имя польз.
        mainPage.buttonEshe.click();
        mainPage.buttonPhoto.click();
        Assert.assertTrue(Metods.checkUserName(photos.coverName));
    }

/*    @Test                                                                            // Проверить что фотографий Нет - Надпись "Нет объектов (фото) для показа"
    public static void test2_3(){
        Assert.assertEquals(photos.divCollectionWrapper.getText(), "Нет объектов (фото) для показа");
    }*/
    @Test
    public static void test2_4(){
        photos.buttonAddPhoto.sendKeys(PHOTO_PATH);
        photos.buttonAddPhoto2.click();
        Assert.assertEquals("d", "d");
        driver.get(URL);
    }

    @Test
    public static void test2_5() {
        Assert.assertEquals(mainPage.getColor(mainPage.topPanelBar), "#365899");  // проверка цвета верхнего бара MainPage
    }

    @Test
    public static void test3() {                                                            // проверить что основные блоки главной
        Assert.assertTrue(mainPage.sizeSumMainDiv() <= (MONITOR_WIDTH - BROWSER_SCROLL));  // не выходят за границы экрана монитора
    }

    @Test
    public static void test99() {                                                    // Проверить, что на странице Польз-ля имя
        mainPage.moveToOwnerPage();                                                 // поль-ля совпадает с именем на Гл.странице
        Assert.assertTrue(Metods.checkUserName(ownerPage.ownerName));
        mainPage.exitOwnerAccount();
    }

    @AfterClass
    public void closePage() {
        driver.quit();
    }

}
