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
}
