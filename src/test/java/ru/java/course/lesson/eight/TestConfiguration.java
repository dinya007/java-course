package ru.java.course.lesson.eight;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class TestConfiguration {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Before
    public void cleanTables() throws Exception {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "account");
    }
}
