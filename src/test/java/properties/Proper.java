package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Alexey on 23.05.2017.
 */
public class Proper {
    /*Входные данные*/

        public static final String url = iniProp().getProperty("url");
        public static final String userName = iniProp().getProperty("userName1");
        public static final String friendNameLt = iniProp().getProperty("friendName1");
        public static final String friendNameRS = iniProp().getProperty("friendName2");
        public static final String email = iniProp().getProperty("e_mail");
        public static final String password = iniProp().getProperty("password");
        public static final String tel = iniProp().getProperty("tel1");
        public static final int browserUpPanel = Integer.parseInt(iniProp().getProperty("browserUpPanel"));
        public static final int browserScroll = Integer.parseInt(iniProp().getProperty("browserScroll"));
        public static final int monitorWidth = Integer.parseInt(iniProp().getProperty("monitorWidth"));

        public static final String browDriverName = "webdriver.gecko.driver";
        public static final String browDriverPath = "d:/taa/install/geckodriver-v0.17.0-win64/geckodriver.exe";

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
