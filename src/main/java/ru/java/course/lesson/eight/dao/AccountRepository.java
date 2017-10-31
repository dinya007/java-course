package ru.java.course.lesson.eight.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.java.course.lesson.eight.domain.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    Account findByOwnerName(String ownerName);

}
