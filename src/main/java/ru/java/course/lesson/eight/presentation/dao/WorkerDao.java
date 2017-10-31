package ru.java.course.lesson.eight.presentation.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.java.course.lesson.eight.presentation.domain.Worker;

import java.util.List;

@Repository
public interface WorkerDao extends CrudRepository< Worker, Long> {

//    Long save(Worker worker);

    Worker getById(Long id);

    List<Worker> getByName(String name);

}
