package ru.java.course.lesson.eight.presentation.service;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import ru.java.course.lesson.eight.presentation.dao.WorkerDao;
import ru.java.course.lesson.eight.presentation.domain.Worker;

import java.math.BigDecimal;

public class WorkerServiceImplTest {

    @Test
    public void calculateBonusWithSalaryLessThanFiftyThousands() throws Exception {
        WorkerDao workerDao = Mockito.mock(WorkerDao.class);
        Worker worker = new Worker("", BigDecimal.valueOf(45_000));
        Mockito.doReturn(worker).when(workerDao).getById(Mockito.anyLong());
        WorkerService workerService = new WorkerServiceImpl(workerDao);

        BigDecimal result = workerService.calculateBonus(0L);

        Assert.assertEquals(11_250, result.longValue());
    }

    @Test
    public void calculateBonusWithSalaryGreaterOrEqualThanFiftyThousands() throws Exception {
        WorkerDao workerDao = Mockito.mock(WorkerDao.class);
        Worker worker = new Worker("", BigDecimal.valueOf(50_000));
        Mockito.doReturn(worker).when(workerDao).getById(Mockito.anyLong());
        WorkerService workerService = new WorkerServiceImpl(workerDao);

        BigDecimal result = workerService.calculateBonus(0L);

        Assert.assertEquals(25_000, result.longValue());
    }

}