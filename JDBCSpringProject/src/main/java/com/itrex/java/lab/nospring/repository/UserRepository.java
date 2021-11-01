package com.itrex.java.lab.nospring.repository;

import com.itrex.java.lab.nospring.entity.User;
import java.util.List;

public interface UserRepository {

    List<User> selectAll();
    void add(User user);
    void addAll(List<User> users);

}
