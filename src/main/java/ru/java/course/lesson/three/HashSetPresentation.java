package ru.java.course.lesson.three;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.util.HashMap;

/**
 * @author dinyat
 * 16/08/2017
 */
public class HashSetPresentation {

    public static void main(String[] args) throws Exception {
        HashMap<String, Integer> map = new HashMap<>();

        Student alex = new Student("Alex", "Smith", 17);
        Student kate = new Student("Kate", "Williams", 16);
        Student john = new Student("John", "Taylor", 18);

        map.put("Alex", 10);
        map.put("Kate", 12);
        map.put("John", 20);

        Integer age1 = map.get("Alex");
        Integer age2 = map.get("Kate");
        Integer age3 = map.get("John");

        System.out.println(age1);
        System.out.println(age2);
        System.out.println(age3);

        String hash = "35454B055CC325EA1AF2126E27707052";
        String password = "keyword";

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter
            .printHexBinary(digest).toUpperCase();

        System.out.println(myHash);
        System.out.println(myHash.equals(hash));
    }

}
