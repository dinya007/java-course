package ru.java.course.lesson.four.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author dinyat
 * 03/10/2017
 */
public class Presentation {

    public static void main(String[] args) throws IOException {
        Stream<String> lines = Files.lines(Paths.get("/Users/dinyat/Desktop/some_file.txt"));

        Files.write(Paths.get("/Users/dinyat/Desktop/new_file.txt"), Arrays.asList("1", "123", "12"));

//        List<Integer> list = Arrays.asList(1, 5, 3);
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
    }

}
