package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Alexey on 23.06.2017.
 */
public class Photos {
    public Photos(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;


    @FindBy(xpath = ".//*[@id='collection_wrapper_2305272732']/div")
    public WebElement divCollectionWrapper;

    @FindBy(xpath = ".//*[@id='fb-timeline-cover-name']")
    public WebElement coverName;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement buttonAddPhoto;

    @FindBy(xpath = ".//*[@id='js_g2']/div[2]/div[2]/div/div[2]/div/span[2]/button")
    public WebElement buttonAddPhoto2;


    /////////////////////////////////////////////////////////////////////////

    /*public boolean checkName*/
}
