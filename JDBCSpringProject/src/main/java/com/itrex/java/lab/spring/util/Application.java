package com.itrex.java.lab.spring.util;

import org.h2.jdbcx.JdbcConnectionPool;

import static com.itrex.java.lab.spring.properties.Properties.H2_PASSWORD;
import static com.itrex.java.lab.spring.properties.Properties.H2_URL;
import static com.itrex.java.lab.spring.properties.Properties.H2_USER;

public enum Application {
    INSTANCE;

    private JdbcConnectionPool jdbcConnectionPool;

    public JdbcConnectionPool jdbcConnectionPool() {
        if (jdbcConnectionPool == null) {
            jdbcConnectionPool = JdbcConnectionPool.create(H2_URL, H2_USER, H2_PASSWORD);
        }
        return jdbcConnectionPool;
    }

    public void shutdown() {
        if (jdbcConnectionPool != null) {
            jdbcConnectionPool.dispose();
        }
    }
}
