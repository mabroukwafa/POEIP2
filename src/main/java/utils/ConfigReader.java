package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Cette classe est responsable de la lecture du fichier de configuration
 * et de la récupération des propriétés.
 */
public class ConfigReader {
    private static Properties properties;

    static {
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties")) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration file");
        }
    }

    /**
     * Récupère la valeur d'une propriété à partir du fichier de configuration.
     *
     * @param key La clé de la propriété à récupérer.
     * @return La valeur de la propriété correspondante.
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

