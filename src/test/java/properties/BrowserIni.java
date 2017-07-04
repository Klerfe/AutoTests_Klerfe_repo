package properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static properties.ConstIni.*;

/**
 * Created by Alexey on 23.05.2017.
 */
public class BrowserIni {
    public static WebDriver driver;
    public WebDriver browser(String browserName) {
        if (browserName.equals("firefox")){
            System.setProperty(getProperty("fireFoxDriverName"), getProperty("fireFoxDriverPath"));
            driver = new FirefoxDriver();}
            else if (browserName.equals("chrome")){
            System.setProperty(getProperty("chromeDriverName"), getProperty("chromeDriverPath"));
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

