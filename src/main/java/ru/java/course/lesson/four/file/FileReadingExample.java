package ru.java.course.lesson.four.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author dinyat
 * 02/10/2017
 */
public class FileReadingExample {

    public static void main(String[] args) {

        File file = new File("/Users/dinyat/Desktop/some_file.txt");
        try (
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            bufferedReader.lines().forEach(System.out::println);
//            file.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
