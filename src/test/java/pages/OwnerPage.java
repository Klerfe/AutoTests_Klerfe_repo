package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Alexey on 02.06.2017.
 */
public class OwnerPage {

    public WebDriver driver;

    public OwnerPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"fb-timeline-cover-name\"]")
    public WebElement ownerName;

    public String ownerName (){
        return ownerName.getText();
    }


}
