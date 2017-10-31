//package ru.java.course.lesson.eight.presentation.dao;
//
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//import ru.java.course.lesson.eight.presentation.domain.Worker;
//
//import java.math.BigDecimal;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.atomic.AtomicLong;
//
//@Component
//public class WorkerDaoImpl implements WorkerDao {
//
//
//    private final ConcurrentHashMap<Long, Worker> workers = new ConcurrentHashMap<>();
//    private final AtomicLong atomicLong = new AtomicLong();
//    private JdbcTemplate jdbcTemplate;
//
//    @Override
//    public Long save(Worker worker) {
//        Long id = worker.getId();
//        if (id == null) {
//            id = atomicLong.incrementAndGet();
//            worker.setId(id);
//        }
//        workers.put(id, worker);
//        return id;
//
//    }
//
//    @Override
//    public Worker getById(Long id) {
//        return jdbcTemplate.queryForObject("SELECT * FROM worker WHERE id = ? and name = ?",
//                (rs, n) -> new Worker(rs.getString("name"), BigDecimal.valueOf(rs.getLong("name"))),
//                id);
//    }
//
//}
