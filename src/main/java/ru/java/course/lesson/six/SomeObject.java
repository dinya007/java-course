package ru.java.course.lesson.six;

import ru.java.course.lesson.six.annotation.Profile;
import ru.java.course.lesson.six.annotation.Value;

@Profile
public class SomeObject {

    @Value("some.value")
    private String value;

    @Override
    public String toString() {
        return "SomeObject{" +
                "value='" + value + '\'' +
                '}';
    }
}
