package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.User;

public interface UserService {
    User createUser(User user);

    User getUserById(int id);
    User getUserByPhoneNumber(String phoneNumber);
    List<User> getAllUsers();

    User updateUser(User user);

    boolean deleteUser(String phoneNumber);
}
