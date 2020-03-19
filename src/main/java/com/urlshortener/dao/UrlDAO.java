package com.urlshortener.dao;

import com.urlshortener.model.Url;
import com.urlshortener.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class UrlDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Url> getListUrl() {
        Session session = sessionFactory.openSession();
        List<Url> list = session.createQuery("FROM Url").list();
        session.close();
        return list;
    }

    public Url getInfoUrl(String hash_url) {
        Session session = sessionFactory.openSession();
        Url url = (Url) session.get(Url.class, hash_url);
        session.close();
        return url;
    }

    public boolean insertUrl(Url url) {
        if (getInfoUrl(url.getHash_url()) != null) {
            return false;
        }
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(url);
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

    public boolean updateUrl(Url url) {
        if (getInfoUrl(url.getHash_url()) == null) {
            return false;
        }
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(url);
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

    public boolean deleteUrl(String hash_url) {
        Url url = getInfoUrl(hash_url);
        if (url == null) {
            return false;
        }
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(url);
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
