package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.ws.Action;
import java.io.IOException;

/**
 * Created by Alexey on 13.07.2017.
 */
public class LoginFailedPage {
    public WebDriver driver;

    public LoginFailedPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = ".//*[@id='globalContainer']/div[3]/div/div/div")
    public WebElement errorHint;

    @FindBy(xpath = ".//*[@id='error_box']/div[2]")
    private WebElement errorBox;

    @FindBy(xpath = ".//*[@id='pass']")
    private WebElement passField;

    @FindBy(xpath = ".//*[@id='header_block']/span/div/div[1]/div[2]/span")
    private WebElement titleInput;
    ////////////////////////////////////////////////////////////////////////////////////

    public String messageFailedAutorisation(){
        return errorBox.getText();
    }

    public String messageFailedAutorisationHint(){
        Actions actions = new Actions(driver);
        actions.moveToElement(passField);
        try {
            if (errorHint.isDisplayed());
        } catch (NullPointerException e){ e.printStackTrace();}
        return errorHint.getText();
    }

    public String titleInputFailedAutorisation(){
        return titleInput.getText();
    }
}
