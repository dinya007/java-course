package ru.java.course.lesson.eight.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String getHelloWorld() {
        return "Hello world!";
    }

    @RequestMapping("/hello/{name}")
    public String getHelloWorld(@PathVariable String name) {
        return "Hello " + name + "!";
    }

}
