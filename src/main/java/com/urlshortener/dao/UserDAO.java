package com.urlshortener.dao;

import com.urlshortener.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> getListUser() {
        Session session = sessionFactory.openSession();
        List<User> list = session.createQuery("FROM User").list();
        session.close();
        return list;
    }

    public User getInfoUser(String username) {
        Session session = sessionFactory.openSession();
        User user = (User) session.get(User.class, username);
        session.close();
        return user;
    }

    public boolean insertUser(User user) {
        if (getInfoUser(user.getUsername()) != null) {
            return false;
        }
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public boolean updateUser(User user) {
        if (getInfoUser(user.getUsername()) == null) {
            return false;
        }
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    public boolean deleteUser(String username) {
        User user = getInfoUser(username);
        if (user == null) {
            return false;
        }
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }
}
