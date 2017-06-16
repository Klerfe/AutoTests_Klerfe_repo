package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Alexey on 14.06.2017.
 */
public class FiltersResult {

    public WebDriver driver;

    public FiltersResult(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(className = "_32mo")
    private WebElement personFinded;                // результаты поиска людей(1-й из найденных)


    public String getFirstPersonFinded() {          // имя найденного (1-го)
      return personFinded.getText();
    }
}