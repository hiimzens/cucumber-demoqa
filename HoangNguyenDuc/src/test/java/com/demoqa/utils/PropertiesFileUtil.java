package com.demoqa.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileUtil {
    public static Properties loadPropertiesFromFile(String filePath) throws IOException {
        try (InputStream input = new FileInputStream(filePath)) {
            Properties properties = new Properties();
            properties.load(input);
            return properties;
        }
    }

    public static void appendSystemProperties(Properties properties) {
        for (String name : properties.stringPropertyNames()) {
            String value = properties.getProperty(name);
            System.setProperty(name, value);
        }
    }
}
