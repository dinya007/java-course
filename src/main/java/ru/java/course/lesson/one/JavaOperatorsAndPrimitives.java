package ru.java.course.lesson.one;

public class JavaOperatorsAndPrimitives {

    public static void main(String[] args) {
        boolean booleanVariable = true;
        byte byteVariable = 1;
        char charVariable = 'J';
        short shortVariable = 4;
        int intVariable = 3 + 5;
        float floatVariable = 3.1f + 4.5f;
        double doubleVariable = 3 + 4.5;
        long longVariable = Integer.MAX_VALUE + 1L;
        String stringVariable = "Java";

        System.out.println(booleanVariable);
        System.out.println(byteVariable);
        System.out.println(charVariable);
        System.out.println(shortVariable);
        System.out.println('J' + 'a' + 'v' + 'a');
        System.out.println(stringVariable);
        System.out.println(intVariable);
        System.out.println(doubleVariable);
        System.out.println(floatVariable);
        System.out.println(longVariable);

        System.out.println(Integer.MAX_VALUE );
        System.out.println(Integer.MAX_VALUE + 1L);
    }

}
