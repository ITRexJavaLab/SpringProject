package com.itrex.java.lab.spring;

import com.itrex.java.lab.spring.config.MyApplicationContextConfiguration;
import com.itrex.java.lab.spring.entity.User;
import com.itrex.java.lab.spring.repository.UserRepository;
import com.itrex.java.lab.spring.repository.impl.JDBCUserRepositoryImpl;
import com.itrex.java.lab.spring.service.FlywayService;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.h2.jdbcx.JdbcConnectionPool;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class Runner {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyApplicationContextConfiguration.class);

        JdbcConnectionPool jdbcConnectionPool = ctx.getBean(JdbcConnectionPool.class);
        UserRepository userRepository = ctx.getBean(UserRepository.class);

        System.out.println("===================START APP======================");
        System.out.println("================START MIGRATION===================");
        FlywayService flywayService = new FlywayService();
        flywayService.migrate();

        workWithJDBC(userRepository);

        System.out.println("=========CLOSE ALL UNUSED CONNECTIONS=============");
        jdbcConnectionPool.dispose();
        System.out.println("=================SHUT DOWN APP====================");
    }

    public static void workWithJDBC(UserRepository userRepository) {
        List<User> users = userRepository.selectAll();
        System.out.println("Step 1 select all users:\n" + users);
        User firstAddedUser = new User();
        firstAddedUser.setName("some name");
        firstAddedUser.setEmail("some email");
        firstAddedUser.setDateOfBirth(Timestamp.valueOf(LocalDateTime.now()));

        userRepository.add(firstAddedUser);
        System.out.println("Step 2 add user:\n" + firstAddedUser);

        users = userRepository.selectAll();
        System.out.println("Step 3 select all users:\n" + users);
        List<User> newUsers = new ArrayList<>();
        User user = new User();
        user.setName("some name");
        user.setEmail("some email 2");
        user.setDateOfBirth(Timestamp.valueOf(LocalDateTime.now()));

        newUsers.add(user);
        User user2 = new User();
        user2.setName("some name");
        user2.setEmail("some email 3");
        user2.setDateOfBirth(Timestamp.valueOf(LocalDateTime.now()));
        newUsers.add(user2);

        userRepository.addAll(newUsers);
        System.out.println("Step 4 add all users:\n" + newUsers);

        users = userRepository.selectAll();
        System.out.println("Step 5 select all users:\n" + users);
    }

}
