package ru.java.course.lesson.seven.presentation.value;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ObjectFactory {

    private static final PropertyService propertyService = newPropertyService();

    public static <T> T newObject(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        T object = clazz.newInstance();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Value.class)) {
                Value value = field.getAnnotation(Value.class);
                String property = propertyService.get(value.name());
                field.setAccessible(true);
                field.set(object, property);
//                System.out.println(field.getName() + " : " + value.name());
            }
        }
        return object;
    }

    public static PropertyService newPropertyService() {
        FileSystemPropertyService fileSystemPropertyService = new FileSystemPropertyService();
        if (FileSystemPropertyService.class.isAnnotationPresent(Profile.class)) {
            return (PropertyService) Proxy.newProxyInstance(FileSystemPropertyService.class.getClassLoader(),
                    new Class[]{PropertyService.class},
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            long start = System.currentTimeMillis();
                            Object result = method.invoke(fileSystemPropertyService, args);
                            System.out.println("Method " + method.getName() + " with args " + Arrays.toString(args) + " wasted " + String.valueOf(System.currentTimeMillis() - start));

                            return result;
                        }
                    }
            );
        }
        return fileSystemPropertyService;
    }

}
