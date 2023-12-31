package com.wendy.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/10/2 15:48
 * @Version 1.0
 */
public class PropertiesUtils {
    public static String getProperty(String key) {
        Property property = new Property("application.properties");
        property.load();
        return property.getProperty(key);
    }

    public static String getProperty(String key, String fileName) {
        Property property = new Property(fileName);
        property.load();
        return property.getProperty(key);
    }

    static class Property {
        private String fileName;

        private Map<String, String> map = new HashMap<>();

        public Property(String fileName) {
            this.fileName = fileName;
        }

        private void load() {
            try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
                 InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                 BufferedReader br = new BufferedReader(inputStreamReader)) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] setting = line.split("=");
                    map.put(setting[0], setting[1]);
                }
            } catch (IOException e) {
                throw new RuntimeException("Load settings info from properties error.");
            }
        }

        private String getProperty(String key) {
            if (!map.containsKey(key)) {
                throw new RuntimeException("Key does not exist.");
            }
            return map.get(key);
        }
    }
}
