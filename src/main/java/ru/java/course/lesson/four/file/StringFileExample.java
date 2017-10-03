package ru.java.course.lesson.four.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author dinyat
 * 02/10/2017
 */
public class StringFileExample {

    public static void main(String[] args) {

        File file = new File("/Users/dinyat/Desktop/some_file.txt");
        File writeFile = new File("/Users/dinyat/Desktop/write_file.txt");
        try (
//            FileReader fileReader = new FileReader(file);
//            BufferedReader bufferedReader = new BufferedReader(fileReader)
            Scanner scanner = new Scanner(new FileInputStream(file));
            BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()));
            BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(writeFile.getAbsolutePath()));
        ) {

            bufferedReader.lines().forEach(System.out::println);
            System.out.println("Scanner");
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }

//            file.delete();

            bufferedWriter.write("1");
            bufferedWriter.newLine();
            bufferedWriter.write("2");
            writeFile.delete();
            Files.write(Paths.get(writeFile.getAbsolutePath()), Arrays.asList("3", "4"));
            System.out.println(Files.readAllLines(Paths.get(writeFile.getAbsolutePath())));
            writeFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
