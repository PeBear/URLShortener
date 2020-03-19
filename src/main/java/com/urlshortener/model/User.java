package com.urlshortener.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "Users")
public class User {
    @Id
    private String username;
    private String password;
    private boolean gender;
    private String email;
    private String active_string;
    private String fogot_string;
    private Date expired_active;
    private Date expired_forgot;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @JsonIgnore
    private Collection<Url> urls;

    public User() {
    }
    public User(String username, String password, boolean gender, String email){
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.email = email;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActive_string() {
        return active_string;
    }

    public void setActive_string(String active_string) {
        this.active_string = active_string;
    }

    public String getFogot_string() {
        return fogot_string;
    }

    public void setFogot_string(String fogot_string) {
        this.fogot_string = fogot_string;
    }

    public Date getExpired_active() {
        return expired_active;
    }

    public void setExpired_active(Date expired_active) {
        this.expired_active = expired_active;
    }

    public Date getExpired_forgot() {
        return expired_forgot;
    }

    public void setExpired_forgot(Date expired_forgot) {
        this.expired_forgot = expired_forgot;
    }

    public Collection<Url> getUrls() {
        return urls;
    }

    public void setUrls(Collection<Url> urls) {
        this.urls = urls;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", active_string='" + active_string + '\'' +
                ", fogot_string='" + fogot_string + '\'' +
                ", expired_active=" + expired_active +
                ", expired_forgot=" + expired_forgot +
                '}';
    }
}
