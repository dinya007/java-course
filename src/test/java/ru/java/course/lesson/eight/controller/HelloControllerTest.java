package ru.java.course.lesson.eight.controller;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import ru.java.course.lesson.eight.TestConfiguration;


public class HelloControllerTest extends TestConfiguration {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testGetHelloWorld() throws Exception {
        String result = testRestTemplate.getForObject("/hello", String.class);

        System.out.println(result);
        Assert.assertEquals("Hello world!", result);
    }
}