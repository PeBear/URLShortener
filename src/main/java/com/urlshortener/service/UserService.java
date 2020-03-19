package com.urlshortener.service;

import com.urlshortener.dao.UserDAO;
import com.urlshortener.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> getListUsers() {
        return userDAO.getListUser();
    }

    public User getInfoUser(String username) {
        return userDAO.getInfoUser(username);
    }

    public boolean insertUser(User user) {
        return userDAO.insertUser(user);
    }

    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }

    public boolean deleteUser(String username) {
        return userDAO.deleteUser(username);
    }

}
