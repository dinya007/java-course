package ru.java.course.lesson.eight.presentation.service;

import java.math.BigDecimal;

public interface WorkerService {

    BigDecimal calculateBonus(Long workerId);

    Long create(String name, BigDecimal salary);

}
