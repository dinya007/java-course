package ru.java.course.lesson.eight.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.java.course.lesson.eight.presentation.dao.WorkerDao;
import ru.java.course.lesson.eight.presentation.domain.Worker;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    private final WorkerDao workerDao;

    @Autowired
    public WorkerController(WorkerDao workerDao) {
        this.workerDao = workerDao;
    }


    @RequestMapping("/{name}")
    public List<Worker> getWorkerById(@PathVariable String name) {
        return workerDao.getByName(name);
    }

}
