package ru.java.course.lesson.seven.presentation.value;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

@Profile
public class FileSystemPropertyService implements PropertyService {

    @Override
    public String get(String name) {
        try {
            Properties properties = new Properties();
            properties.load(new InputStreamReader(this.getClass().getResourceAsStream("/app.properties"), "UTF-8"));
            return properties.getProperty(name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
