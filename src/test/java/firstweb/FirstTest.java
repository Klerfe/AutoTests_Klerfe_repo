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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void userLogin() throws IOException {

        WebElement loginField = driver.findElement(By.id("email"));
        loginField.clear();
        loginField.sendKeys("alexey.kozlovets@gmail.com");

        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("Ctuvtynbhjdfybt");

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"loginbutton\"]"));
        loginButton.click();

        WebElement loginUsers = driver.findElement(By.xpath("//*[@id=\"navItem_100001825392498\"]/a/div"));
        Assert.assertEquals(loginUsers.getText(), "Alexey Kozlovets");
    }

    @AfterClass
    public void closePage() {
        driver.findElement(By.cssSelector("body > div._n8._3qx.uiLayer._3qw > div._3ixn")).click();
        driver.findElement(By.xpath("//*[@id=\"pageLoginAnchor\"]")).click();

        driver.findElement(By.xpath("//*[contains(@id, 'js')]/div/div/ul/li[12]/a")).click();// локатор заморачивался-заморачивался
        driver.quit();
    }
}
//*[@id="PH_logoutLink"]