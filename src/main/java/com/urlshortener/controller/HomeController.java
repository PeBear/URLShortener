package com.urlshortener.controller;

import com.urlshortener.helper.EncodingURL;
import com.urlshortener.model.Staff;
import com.urlshortener.model.Url;
import com.urlshortener.model.User;
import com.urlshortener.service.StaffService;
import com.urlshortener.service.UrlService;
import com.urlshortener.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {
    @Autowired
    private UrlService urlService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String display() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public List<User> getListUser() {
        return userService.getListUsers();
    }
    //USE POSTMAN APPLICATION TO TEST ALL CASE BELOW
    //func add single user
    @RequestMapping(value = "users", method = RequestMethod.POST)
    public void insertUser(@RequestBody User user) {
        userService.insertUser(user);
    }

    //func get single user
    @RequestMapping(value = "users/{username}", method = RequestMethod.GET)
    public User getUser(@PathVariable("username") String username) {
        return userService.getInfoUser(username);
    }

    //func update single user
    @RequestMapping(value = "users", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    //func delete single user
    @RequestMapping(value = "users/{usernmae}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("username") String username) {
        userService.deleteUser(username);
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public void test(){
        String username = "x";
        String password = "123456";
        String email = "xpeter@gmail.com";
        boolean gender = true;
        for (int i = 0; i < 1000000; i++){
            User user = new User(username + i, password, gender, email);
            userService.insertUser(user);
        }

        System.out.println("insert 1m USER success!");

        String original_url = "temp";
        String tempName = "xpeter";
        Date now = new Date();
        User userTemp = userService.getInfoUser("xpeter");
        for (int i = 0; i < 1000000; i++){
            String hashUrl = EncodingURL.encodingURL(original_url + i, tempName);
            Url url = new Url(hashUrl, original_url, now, userTemp);
            urlService.insertUrl(url);
        }

        System.out.println("insert 1m URL success!");
    }

}
