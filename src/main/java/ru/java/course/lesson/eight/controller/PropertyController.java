package ru.java.course.lesson.eight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private Environment environment;

    @Value("${default.value}")
    private String defaultProperty;

    @RequestMapping
    public String get(@RequestParam String name) {
        return environment.getProperty(name);
    }

    @RequestMapping("/default")
    public String getDefaultProperty() {
        return defaultProperty;
    }

}
