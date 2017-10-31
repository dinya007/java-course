package ru.java.course.lesson.seven.enumeration;

public enum SomeEnum {

    VALUE1("value1", String.class),
    VALUE2("value2", Integer.class);

    private String name;
    private Class<?> clazz;

    SomeEnum() {
    }

    SomeEnum(String name, Class<?> clazz) {
        this.name = name;
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return this.name() + "{" +
                "name='" + name + '\'' +
                ", clazz=" + clazz +
                '}';
    }
}
