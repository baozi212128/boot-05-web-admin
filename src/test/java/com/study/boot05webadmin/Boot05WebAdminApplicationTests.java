package com.study.boot05webadmin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class Boot05WebAdminApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
        Integer integer = jdbcTemplate.queryForObject("select count(*) from user", Integer.class);
        System.out.println(integer);
    }

}
