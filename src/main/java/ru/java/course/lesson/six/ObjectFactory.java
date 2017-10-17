package ru.java.course.lesson.six;

import ru.java.course.lesson.six.annotation.Value;
import ru.java.course.lesson.six.service.PropertyService;
import ru.java.course.lesson.six.service.PropertyServiceFactory;

import java.lang.reflect.Field;

public class ObjectFactory {

    private static final PropertyService propertyService = PropertyServiceFactory.getPropertyService();

    public static <T> T newObject(Class<T> clazz) {
        try {
            T t = clazz.newInstance();
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Value.class)) {
                    Value annotation = field.getAnnotation(Value.class);
                    String property = propertyService.get(annotation.value());
                    field.setAccessible(true);
                    field.set(t, property);
                }
            }
            return t;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
