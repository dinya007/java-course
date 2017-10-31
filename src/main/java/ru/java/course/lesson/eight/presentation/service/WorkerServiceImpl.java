package ru.java.course.lesson.eight.presentation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.java.course.lesson.eight.presentation.dao.WorkerDao;
import ru.java.course.lesson.eight.presentation.domain.Worker;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Component
public class WorkerServiceImpl implements WorkerService {

    private final WorkerDao workerDao;

    @Autowired
    public WorkerServiceImpl(WorkerDao workerDao) {
        this.workerDao = workerDao;
    }

    @PostConstruct
    public void init() {
        System.out.println("Initializing...");
    }

    @Override
    public BigDecimal calculateBonus(Long workerId) {
        Worker worker = workerDao.getById(workerId);
        BigDecimal salary = worker.getSalary();
        BigDecimal factor;
        if (salary.compareTo(BigDecimal.valueOf(50_000)) < 0) {
            factor = BigDecimal.valueOf(0.25);
        } else {
            factor = BigDecimal.valueOf(0.5);
        }
        return salary.multiply(factor);
    }

    @Override
    public Long create(String name, BigDecimal salary) {
        Worker worker = new Worker(name, salary);
        worker = workerDao.save(worker);
        return worker.getId();
    }

}
