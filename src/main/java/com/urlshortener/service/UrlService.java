package com.urlshortener.service;

import com.urlshortener.dao.UrlDAO;
import com.urlshortener.model.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlService {
    @Autowired
    private UrlDAO urlDAO;

    public void setUrlDAO(UrlDAO urlDAO) {
        this.urlDAO = urlDAO;
    }

    public List<Url> getListUrl(){
        return urlDAO.getListUrl();
    }

    public Url getUrl(String hash_url){
        return urlDAO.getInfoUrl(hash_url);
    }

    public boolean insertUrl(Url url){
        return urlDAO.insertUrl(url);
    }
    public boolean updateUrl(Url url){
        return urlDAO.updateUrl(url);
    }
    public boolean deleteUrl(String hash_url){
        return urlDAO.deleteUrl(hash_url);
    }
}
