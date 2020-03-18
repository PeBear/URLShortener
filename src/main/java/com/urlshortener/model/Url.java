package com.urlshortener.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Urls")
public class Url {
    @Id
    private String hash_url;
    private String original_url;
    private Date create_date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    @JsonIgnore
    private User user;

    public Url() {
    }

    public String getHash_url() {
        return hash_url;
    }

    public void setHash_url(String hash_url) {
        this.hash_url = hash_url;
    }

    public String getOriginal_url() {
        return original_url;
    }

    public void setOriginal_url(String original_url) {
        this.original_url = original_url;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Url{" +
                "hash_url='" + hash_url + '\'' +
                ", original_url='" + original_url + '\'' +
                ", create_date=" + create_date +
                '}';
    }
}
