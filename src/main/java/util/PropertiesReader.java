package util;

import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;

import java.io.InputStream;
import java.util.Properties;

import static java.lang.String.format;

@Log
@UtilityClass
public class PropertiesReader {

    private static final String CONFIG_PROPERTIES = "config.properties";

    private static Properties PROPERTIES;

    public static String getProperty(final String propertyName) {

        if (PROPERTIES == null) {
            synchronized (PropertiesReader.class) {
                if (PROPERTIES == null) {
                    try (InputStream reader = PropertiesReader.class
                            .getClassLoader()
                            .getResourceAsStream(CONFIG_PROPERTIES)) {

                        Properties properties = new Properties();
                        properties.load(reader);
                        PROPERTIES = properties;
                    } catch (Exception ex) {
                        throw new IllegalStateException(format("An issue: '%s' occurred during reading config.properties file !!", ex));
                    }
                }
            }
        }

        String systemProperty = System.getProperty(propertyName);

        return systemProperty == null
                ? PROPERTIES.getProperty(propertyName, "Wrong config.properties name was set !!")
                : systemProperty;
    }
}
