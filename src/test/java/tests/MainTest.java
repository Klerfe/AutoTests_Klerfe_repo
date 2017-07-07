package tests;

import metods.Metods;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import properties.BrowserIni;

import static properties.ConstIni.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alexey on 22.05.2017.
 */
public class MainTest extends BrowserIni {

    public static LoginPage loginPage;
    public static MainPage mainPage;
    public static OwnerPage ownerPage;
    public static FiltersResult filtersResult;
    public static Photos photos;



    @BeforeClass

        public void setup () {
            driver = super.browser(BROWSER_NAME);
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
    public void aAutorisationCorrect() {                                                     // Проверка, что на главной странице
        loginPage.writeEmail(TEL);                                                 // имя пользователя совпадает с заданным
        loginPage.writePass(PASSWORD);
        loginPage.logIn();
        /*mainPage.setBlackScreenClickable();*/
        Assert.assertTrue(Metods.checkUserName(mainPage.pagesUsersName));

    }

    @Test (dependsOnMethods = { "aAutorisationCorrect" })
    public void assertSearchPeople() {
        driver.get(URL);
        Assert.assertEquals(mainPage.viewUiSearchInput(), true);                // Проверка, что поиск на главной странице
        mainPage.setSearchInput(USER_NAME);                                          // находит соответствующих людей
        Assert.assertTrue(Metods.checkUserName(filtersResult.personFinded));
    }

    @Test (dependsOnMethods = { "aAutorisationCorrect" })
    public void assertSearchPeople2() {
        driver.get(URL);
        Assert.assertEquals(mainPage.viewUiSearchInput(), true);                // Проверка, что поиск на главной странице
        mainPage.setSearchInput(FRIEND_NAME_LT);                                          // находит соответствующих людей
        filtersResult.personsFindedCheck(FRIEND_NAME_LT, FRIEND_NAME_RS);
    }

    @Test (dependsOnMethods = { "aAutorisationCorrect" })
    public void assertUserName_PhotoPage() {                                                  // Проверка, что на странице Фото правильное Имя польз.
        driver.get(URL);
        mainPage.buttonEshe.click();
        mainPage.buttonPhoto.click();
        Assert.assertTrue(Metods.checkUserName(photos.coverName));
    }

/*    @Test
    public static void test2_4(){
        photos.buttonAddPhoto.sendKeys(PHOTO_PATH);
        Assert.assertEquals("d", "d");
        driver.get(URL);
    }*/

    @Test (dependsOnMethods = { "aAutorisationCorrect" })
    public void assertColorUpBar_MainPage() {
        driver.get(URL);
        Assert.assertEquals(mainPage.getColor(mainPage.topPanelBar), "#365899");  // проверка цвета верхнего бара MainPage
    }

    @Test (dependsOnMethods = { "aAutorisationCorrect" })
    public void assertCorrectSizeDivs_MainPage() {                                                            // проверить что основные блоки главной
        driver.get(URL);
        Assert.assertTrue(mainPage.sizeSumMainDiv() <= (MONITOR_WIDTH - BROWSER_SCROLL));  // не выходят за границы экрана монитора
    }

    @Test (dependsOnMethods = { "aAutorisationCorrect" })
    public void assertUserName_OwnerPage() {
        driver.get(URL);                                                            // Проверить, что на странице Польз-ля имя
        mainPage.moveToOwnerPage();                                                 // поль-ля совпадает с именем на Гл.странице
        Assert.assertTrue(Metods.checkUserName(ownerPage.ownerName));
        mainPage.exitOwnerAccount();
    }

    @AfterClass
    public void closePage() {
        driver.quit();
    }

}

