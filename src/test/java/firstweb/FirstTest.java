package firstweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Class tests mail.ru
 * Created by Klerfe on 04.05.2017.
 */
public class FirstTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "d:/taa/install/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://mail.ru/");
    }

    @Test
    public void userLogin() throws IOException {
        WebElement loginField = driver.findElement(By.id("mailbox__login"));
        loginField.clear();
        loginField.sendKeys("kozlovets");

        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"mailbox__password\"]"));
        passwordField.sendKeys("Ctuvtynbhjdfybt");

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"mailbox__auth__button\"]"));
        loginButton.click();

        WebElement loginUsers = driver.findElement(By.xpath("//*[@id=\"PH_user-email\"]"));
        Assert.assertEquals(loginUsers.getText(), "kozlovets@mail.ru");

    }

    @AfterClass
    public void closePage() {
        driver.findElement(By.xpath("//*[@id=\"PH_logoutLink\"]"));
        driver.quit();
    }
}
//*[@id="PH_logoutLink"]