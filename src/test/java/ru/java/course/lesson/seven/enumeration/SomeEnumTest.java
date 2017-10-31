package ru.java.course.lesson.seven.enumeration;

import org.junit.Test;

import java.util.Arrays;

public class SomeEnumTest {

    @Test
    public void name() throws Exception {
        print();
        EnumUtils.addEnum(SomeEnum.class, "VALUE3", new Class[]{String.class, Class.class}, new Object[]{"value3", EnumUtils.class});
        EnumUtils.addEnum(SomeEnum.class, "VALUE4", new Class[]{}, new Object[]{});
        print();
        System.out.println(SomeEnum.valueOf("VALUE3"));
    }

    private void print() {
        System.out.println(Arrays.toString(SomeEnum.values()));
    }

}