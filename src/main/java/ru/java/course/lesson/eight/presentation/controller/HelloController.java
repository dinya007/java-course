package ru.java.course.lesson.eight.presentation.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("")
    public String helloWorld() {
        return "Hello world!";
    }

    @RequestMapping("/hello/{name}")
    public String helloByName(@PathVariable String name) {
        return "Hello <b>" + name + "</b>!";
    }

}
