
package project.ApexGlobal.Utilities;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream(
                    "project/ApexGlobal/Config/config.properties")) {

            if (input == null) {
                throw new RuntimeException(
                    "config.properties file not found!");
            }

            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException(
                "Failed to load config.properties file!", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
