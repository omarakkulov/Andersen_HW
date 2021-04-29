package ru.akkulov.connection;

import lombok.Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Data
public class SimpleProperties {
    private FileInputStream inputStream;
    private Properties properties = new Properties();
    private String url = "";
    private String user = "";
    private String password = "";

    private SimpleProperties() {
        downloadProperties();
    }

    public static SimpleProperties getProperties() {
        return new SimpleProperties();
    }

    private void downloadProperties() {
        try {
            inputStream = new FileInputStream("src/main/resources/application.properties");
            properties.load(inputStream);

            url = properties.getProperty("jdbc.url");
            user = properties.getProperty("jdbc.user");
            password = properties.getProperty("jdbc.password");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
