package com.ecommerce.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.ecommerce.dao.DAOUser;
import com.ecommerce.entity.User;
import com.ecommerce.service.UserService;

public class UserServiceImpl implements UserService {
     private final DAOUser userDao;

    public UserServiceImpl(SessionFactory sessionFactory) {
        this.userDao = new DAOUser(sessionFactory);
    }

    @Override
    public User createUser(User user) {
        userDao.saveUser(user);
        return user;
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User updateUser(User user) {
        userDao.updateUser(user);
        return user;
    }

    @Override
    public boolean deleteUser(int id) {
        User user = userDao.getUserById(id);
        if (user != null) {
            userDao.deleteUser(id);
            return true;
        }
        return false;
    }

    @Override
    public User getUserByPhoneNumber(String phoneNumber) {
        // TODO Auto-generated method stub
        return userDao.getUserByPhone(phoneNumber);
    }
}
