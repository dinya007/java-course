package ru.java.course.lesson.seven.presentation.value;

public class DataObject {

    @Value
    private String defaut;
    @Value(name = "first.name")
    private String firstName;
    private String lastName;


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "DataObject{" +
                "defaut='" + defaut + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
