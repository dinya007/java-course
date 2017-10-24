package ru.java.course.lesson.seven.presentation.value;

public class ValuePresentation {

    public static void main(String[] args) throws Exception {
        DataObject dataObject = ObjectFactory.newObject(DataObject.class);
        System.out.println(dataObject);
    }

}
