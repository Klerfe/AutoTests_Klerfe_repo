package firstweb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Alexey on 22.05.2017.
 */
public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }



    @FindBy(id = "email")
    private WebElement email;                                       // поле email

    @FindBy(id = "pass")
    private WebElement pass;                                        // поле password

    @FindBy(xpath = "//*[@id=\"loginbutton\"]")
    private WebElement loginButton;                                 // кнопка авторизации

    public void writeEmail(String args){                            // заполнить поле email
        email.clear();
        email.sendKeys(args);
    }

    public void writePass(String args){                              // заполнить поле password
        pass.clear();
        pass.sendKeys(args);
    }

    public void logIn(){                                              // нажать авторизацию
        loginButton.click();
    }
}
