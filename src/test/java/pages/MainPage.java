package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
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

    @FindBy(xpath = "//ul/li/a/div")
    public WebElement pagesUsersName;                                                  // подпись Имени пользователя

    @FindBy(xpath = "//*[@id=\"pageLoginAnchor\"]")
    private WebElement upPopupMenu;                                                     // вызов всплыв. меню на верх. панели(стрелка)

    @FindBy(className = "_54nh")//xpath = "//*[contains(@id, 'js')]/div/div/ul/li[12]/a"
    private WebElement iUPMLogOut;                                                      // п.вспл.меню "Выход"

    @FindBy(xpath = "//*[@id=\"q\"]")
    private WebElement uiSearchInput;                                                   // элемент поиска

    @FindBy(xpath = "//*[@id = \"content_container\"]")                                 // блок с контентом (по центру)
    private WebElement divContentContainer;

    @FindBy(xpath = "//*[@id = \"u_0_1i\"]")                                            // блок с чатами (справа)
    private WebElement divChatFriends;

    @FindBy(xpath = "//*[@id = \"pagelet_navigation\"]")                                // блок с меню (слева)
    private WebElement divLetNavigation;

    @FindBy(xpath = "//div/h1/a")                                                       // верхняя панель страницы
    public WebElement topPanelBar;

    @FindBy(xpath = ".//*[@id='appsNav']//a")                                  // левый блок меню, кнопка "Еще"
    public WebElement buttonEshe;

    @FindBy(xpath = ".//*[@id='navItem_2305272732']/a/div")                              // левый блок меню, кнопка "Фото"
    public WebElement buttonPhoto;



/////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean viewUiSearchInput(){
        return uiSearchInput.isDisplayed();                                             // проверяем есть ли элемент поиска
    }

    public void setSearchInput(String args) {                                           // ввод данных в поле поиска
        uiSearchInput.sendKeys(args);                                                    // и подтверждение
        uiSearchInput.submit();
    }

    public void setBlackScreenClickable(){
        if(blackScreenClickable.isEnabled()){                                           // черный экран в Chrome (не изпользую в Firefox)
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

    public int sizeSumMainDiv(){                                                                    //сумма размеров ширины осн. блоков страницы
        int dCF = 0;
        int dCC = 0;
        int dLN = 0;
        if (divChatFriends.isDisplayed()) {dCF = divChatFriends.getSize().getWidth();}
        if (divContentContainer.isDisplayed()) {dCC = divContentContainer.getSize().getWidth();}
        if (divLetNavigation.isDisplayed()) {dCC = divLetNavigation.getSize().getWidth();}
        return (dCF + dCC + dLN);
    }

    public void moveToOwnerPage(){                                                        // переход на страницу Пользователя [OwnerPage]
        pagesUsersName.click();
    }

    public String getColor(WebElement element){
        return Color.fromString(element.getCssValue("color")).asHex();

    }


}
