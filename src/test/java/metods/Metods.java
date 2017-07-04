package metods;
import org.openqa.selenium.WebElement;

import static properties.ConstIni.*;

/**
 * Created by Alexey on 23.06.2017.
 */
public class Metods {

    public static boolean checkUserName(WebElement element){
        return element.getText().equals(USER_NAME);
    }
}
