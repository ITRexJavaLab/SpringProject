package com.itrex.java.lab.spring.repository;

import static com.itrex.java.lab.spring.properties.Properties.H2_PASSWORD;
import static com.itrex.java.lab.spring.properties.Properties.H2_URL;
import static com.itrex.java.lab.spring.properties.Properties.H2_USER;

import com.itrex.java.lab.spring.service.FlywayService;
import com.itrex.java.lab.spring.util.Application;
import org.h2.jdbcx.JdbcConnectionPool;
import org.junit.After;
import org.junit.Before;

public abstract class BaseRepositoryTest {

    private final FlywayService flywayService;
    private final JdbcConnectionPool connectionPool;

    public BaseRepositoryTest () {
        flywayService = new FlywayService();
        connectionPool = Application.INSTANCE.jdbcConnectionPool();
    }

    @Before
    public void initDB() {
        flywayService.migrate();
    }

    @After
    public void cleanDB() {
        flywayService.clean();
    }

    public JdbcConnectionPool getConnectionPool() {
        return connectionPool;
    }

}
