package properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

import static properties.Proper.*;

/**
 * Created by Alexey on 23.05.2017.
 */
public class Browser {
    public static WebDriver driver;
    public WebDriver browser(String browserName) {
        if (browserName.equals("firefox")){
            System.setProperty(iniProp().getProperty("fireFoxDriverName"), iniProp().getProperty("fireFoxDriverPath"));
            driver = new FirefoxDriver();}
            else if (browserName.equals("chrome")){
            System.setProperty(iniProp().getProperty("chromeDriverName"), iniProp().getProperty("chromeDriverPath"));
            driver = new ChromeDriver();
        }
        return driver;
    }

/*        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        ownerPage = new OwnerPage(driver);
        filtersResult = new FiltersResult(driver);
        photos = new Photos(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(URL);*/
    }

