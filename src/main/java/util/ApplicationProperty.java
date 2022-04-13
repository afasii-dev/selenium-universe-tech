package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApplicationProperty {
    private final static String appConfigPath = Thread.currentThread().getContextClassLoader().getResource("").getPath().concat("app.properties");
    private static final Properties appProps = new Properties();

    static {
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String property) {
        return appProps.getProperty(property);
    }
}
