package ru.java.course.homework.shpizel.igor;

/**
 * @author dinyat
 * 12/09/2017
 */
public class TestMyList {

    public static void main(String[] args) {
        MyList list = new MyList();
        list.add(4);
        System.out.println(list.get(1)); //должен кидать IndexOutOfBoundException

        list = new MyList(1);
        list.add(4);
        list.add(6);
        list.add(1, 2);
        list.add(7);
        System.out.println(list); //должен вернуть 4,1,6,7
    }

}
