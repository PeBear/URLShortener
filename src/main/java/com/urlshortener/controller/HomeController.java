package com.urlshortener.controller;

import com.urlshortener.model.Staff;
import com.urlshortener.model.User;
import com.urlshortener.service.StaffService;
import com.urlshortener.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {
    @Autowired
    private StaffService staffService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String display() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "staffs", method = RequestMethod.GET)
    public List<Staff> getStaffs() {
        return staffService.getStaffs();
    }

    //USE POSTMAN APPLICATION TO TEST ALL CASE BELOW
    //func add single staff
    @RequestMapping(value = "staffs", method = RequestMethod.POST)
    public void addStaff(@RequestBody Staff staff) {
        staffService.addStaff(staff);
    }

    //func get single staff
    @RequestMapping(value = "staffs/{id}", method = RequestMethod.GET)
    public Staff getStaff(@PathVariable("id") int id) {
        return staffService.getStaff(id);
    }

    //func update single staff
    @RequestMapping(value = "staffs/{id}", method = RequestMethod.PUT)
    public void updateStaff(@RequestBody Staff staff, @PathVariable("id") int id) {
        staffService.updateStaff(staff, id);
    }

    //func delete single staff
    @RequestMapping(value = "staffs/{id}", method = RequestMethod.DELETE)
    public void deleteStaff(@PathVariable("id") int id) {
        staffService.deleteStaff(id);
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public void getListUsers() {
        List<User> list = userService.getListUsers();
        for (User x : list) {
            System.out.println(x);
        }
    }
    @RequestMapping(value = "users/users", method = RequestMethod.GET)
    public List<User> getListUsersTemp() {
        return userService.getListUsers();
    }
}
