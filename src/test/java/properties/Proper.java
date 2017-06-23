package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Alexey on 23.05.2017.
 */
public class Proper {
    /*Входные данные*/

        public static final String URL = iniProp().getProperty("url");
        public static final String USER_NAME = iniProp().getProperty("userName1");
        public static final String FRIEND_NAME_LT = iniProp().getProperty("friendName1");
        public static final String FRIEND_NAME_RS = iniProp().getProperty("friendName2");
        public static final String E_MAIL = iniProp().getProperty("e_mail");
        public static final String PASSWORD = iniProp().getProperty("password");
        public static final String TEL = iniProp().getProperty("tel1");
        public static final String PHOTO_PATH = iniProp().getProperty("photoPath");
        public static final int BROWSER_UP_PANEL = Integer.parseInt(iniProp().getProperty("browserUpPanel"));
        public static final int BROWSER_SCROLL = Integer.parseInt(iniProp().getProperty("browserScroll"));
        public static final int MONITOR_WIDTH = Integer.parseInt(iniProp().getProperty("monitorWidth"));

        public static final String DRIVER_NAME = iniProp().getProperty("browDriverName");
        public static final String DRIVER_PATH = iniProp().getProperty("browDriverPath");

    static Properties iniProp() {
        Properties properties = new Properties();

        try {
            FileInputStream fis = new FileInputStream("src/main/resources/configTs.properties");
            properties.load(fis);
        }
        catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
        return properties;
    }


}
