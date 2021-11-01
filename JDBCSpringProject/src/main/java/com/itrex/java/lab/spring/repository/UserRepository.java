package com.itrex.java.lab.spring.repository;

import com.itrex.java.lab.spring.entity.User;
import java.util.List;

public interface UserRepository {

    List<User> selectAll();
    void add(User user);
    void addAll(List<User> users);

}
