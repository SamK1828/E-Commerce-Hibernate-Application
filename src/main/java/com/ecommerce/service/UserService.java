package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.User;

public interface UserService {
    User createUser(User user);

    User getUserById(int id);

    List<User> getAllUsers();

    User updateUser(User user);

    boolean deleteUser(int id);
}
