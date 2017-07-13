package properties;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;
import java.util.stream.Stream;

/**
 * Created by Alexey on 04.07.2017.
 */
public class ProperRead {

    private static Properties PROPERTIES;
    static {
        PROPERTIES = new Properties();
        URL props = ClassLoader.getSystemResource("configTs.properties");
        URL props2 = ClassLoader.getSystemResource("messages.properties");

        try {

            PROPERTIES.load(new InputStreamReader(props.openStream(), "UTF-8"));
            PROPERTIES.load(new InputStreamReader(props2.openStream(), "UTF-8"));

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String getProperty(String key){
        return PROPERTIES.getProperty(key);
    }
}
