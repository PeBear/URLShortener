package com.example.controller;

import com.example.model.Staff;
import com.example.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {
    @Autowired
    private StaffService staffService;

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
}
