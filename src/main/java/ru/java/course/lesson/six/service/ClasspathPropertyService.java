package ru.java.course.lesson.six.service;

import ru.java.course.lesson.six.annotation.Profile;

import java.io.IOException;
import java.util.Properties;

@Profile
class ClasspathPropertyService implements PropertyService {

    public ClasspathPropertyService() {
    }

    @Override
    public String get(String name) {
        try {
            Properties properties = new Properties();
            properties.load(this.getClass().getResourceAsStream("/application.properties"));
            return properties.getProperty(name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
