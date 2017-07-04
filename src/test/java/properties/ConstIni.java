package properties;

/**
 * Created by Alexey on 23.05.2017.
 */
public class ConstIni extends ProperRead {
    /*Входные данные*/
        public static final String BROWSER_NAME = getProperty("browser_name");
        public static final String URL = getProperty("url");
        public static final String USER_NAME = getProperty("userName1");
        public static final String FRIEND_NAME_LT = getProperty("friendName1");
        public static final String FRIEND_NAME_RS = getProperty("friendName2");
        public static final String E_MAIL = getProperty("e_mail");
        public static final String PASSWORD = getProperty("password");
        public static final String TEL = getProperty("tel1");
        public static final String PHOTO_PATH = getProperty("photoPath");
        public static final int BROWSER_UP_PANEL = Integer.parseInt(getProperty("browserUpPanel"));
        public static final int BROWSER_SCROLL = Integer.parseInt(getProperty("browserScroll"));
        public static final int MONITOR_WIDTH = Integer.parseInt(getProperty("monitorWidth"));

        public static final String DRIVER_NAME = getProperty("browDriverName");
        public static final String DRIVER_PATH = getProperty("browDriverPath");


  /*  static String iniProp(String key) {
        Properties properties = new Properties();
        props = ClassLoader.getSystemResource("config.properties");
        try {
            FileInputStream fis = new FileInputStream("C:/Users/Alexey/AutoTests_Klerfe_repo/FirstAutoTest/src/main/resources/configTs.properties");
            properties.load(fis);
        }
        catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
        return properties.getProperty(key);
    }*/


}
