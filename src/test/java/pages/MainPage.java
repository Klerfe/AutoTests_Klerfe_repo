package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Alexey on 22.05.2017.
 */
public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;


    @FindBy(css = "body > div._n8._3qx.uiLayer._3qw > div._3ixn")
    private WebElement blackScreenClickable;                                            // при входе на гл.страницу черный экран

    @FindBy(xpath = "//*[@id=\"navItem_100001825392498\"]/a/div")
    private WebElement pagesUsersName;                                                  // подпись Имени пользователя

    @FindBy(xpath = "//*[@id=\"pageLoginAnchor\"]")
    private WebElement upPopupMenu;                                                     // вызов всплыв. меню на верх. панели(стрелка)

    @FindBy(className = "_54nh")//xpath = "//*[contains(@id, 'js')]/div/div/ul/li[12]/a"
    private WebElement iUPMLogOut;                                                      // п.вспл.меню "Выход"

    @FindBy(xpath = "//*[@id=\"q\"]")
    private WebElement uiSearchInput;                                                   // элемент поиска



    public boolean viewUiSearchInput(){
        return uiSearchInput.isDisplayed();                                             // проверяем есть ли элемент поиска
    }

    public void setSearchInput(String args) {
        uiSearchInput.sendKeys(args);
        uiSearchInput.submit();
    }

    public void setBlackScreenClickable(){
        if(blackScreenClickable.isEnabled()){
        blackScreenClickable.click();}
    }

    public void exitOwnerAccount(){                                                     // выход из аккаунта
        /*if (blackScreenClickable.isDisplayed()) */
        upPopupMenu.click();
        iUPMLogOut.click();
    }

    public String getUserName(){                                                         // надпись имени Польз-ля на странице
        String userName = pagesUsersName.getText();
        return userName;
    }

    public void moveToOwnerPage(){                                                        // переход на страницу Пользователя [OwnerPage]
        pagesUsersName.click();
    }


}
