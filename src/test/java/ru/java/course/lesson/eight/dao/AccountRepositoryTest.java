package ru.java.course.lesson.eight.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.java.course.lesson.eight.TestConfiguration;
import ru.java.course.lesson.eight.domain.Account;

import java.math.BigDecimal;

public class AccountRepositoryTest extends TestConfiguration {

    @Autowired
    private AccountRepository accountRepository;

    private Account account = new Account("denis", BigDecimal.valueOf(100));

    @Test
    public void testSaveAccount() throws Exception {
        System.out.println(account);

        Account savedAccount = accountRepository.save(account);

        System.out.println(savedAccount);
        Assert.assertNotNull(savedAccount.getId());

        savedAccount.setAmount(BigDecimal.ONE);
        System.out.println(savedAccount);

        accountRepository.save(savedAccount);

        account = accountRepository.findOne(1L);

        Assert.assertEquals(1L, account.getAmount().longValue());
    }

    @Test
    public void testFindByName() throws Exception {
        accountRepository.save(account);

        Account byOwnerName = accountRepository.findByOwnerName("denis");

        System.out.println(byOwnerName);
        Assert.assertNotNull(byOwnerName);
    }
}