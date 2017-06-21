package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(className = "_32mo")                     // все найденные пользователи
    private List<WebElement> personsFinded;


    public String getFirstPersonFinded() {          // имя найденного (1-го)
      return personFinded.getText();
    }

    public boolean personsFindedCheck(String nameLt, String nameKr) {     // проверка, что найденные пользователи соответствуют заданному условию
        int count = 0;
        for (WebElement element: personsFinded) {
            if(element.getText().equals(nameKr) || element.getText().equals(nameLt)) count++; else continue;    ;
        }
        return count == personsFinded.size();
    }


}