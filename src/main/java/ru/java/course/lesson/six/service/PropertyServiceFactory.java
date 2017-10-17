package ru.java.course.lesson.six.service;

import ru.java.course.lesson.six.annotation.Profile;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PropertyServiceFactory {

    private static PropertyService propertyService = new ClasspathPropertyService();

    public static PropertyService getPropertyService() {
        return (PropertyService) Proxy.newProxyInstance(PropertyServiceFactory.class.getClassLoader(), new Class[]{PropertyService.class}, new ProfileInvocationHandler());
    }

    private static class ProfileInvocationHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long start = System.currentTimeMillis();
            Object result = method.invoke(propertyService, args);
            long end = System.currentTimeMillis();
            if (ClasspathPropertyService.class.isAnnotationPresent(Profile.class)) {
                System.out.println("Method " + method.getName() + " worked " + (end - start) + " millis");
            }
            return result;
        }
    }
}
