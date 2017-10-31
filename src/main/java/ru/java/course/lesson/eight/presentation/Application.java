package ru.java.course.lesson.eight.presentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.java.course.lesson.eight.presentation.service.WorkerService;

import java.math.BigDecimal;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        WorkerService workerService = context.getBean(WorkerService.class);

        Long id = workerService.create("denis", BigDecimal.valueOf(10_000));
        System.out.println("Bonus: " + workerService.calculateBonus(id));
        System.out.println("Id: " + id);
    }

}
