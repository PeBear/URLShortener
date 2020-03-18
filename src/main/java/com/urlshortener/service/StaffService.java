package com.urlshortener.service;

import com.urlshortener.model.Staff;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StaffService {
    private List<Staff> list = new ArrayList<>(Arrays.asList(
            new Staff(1,"xPeter", 20, "peter@gmail.com"),
            new Staff(2,"xPeter1", 21, "peter1@gmail.com"),
            new Staff(3,"xPeter2", 22, "peter2@gmail.com"),
            new Staff(4,"xPeter3", 23, "peter3@gmail.com"),
            new Staff(5,"xPeter4", 24, "peter4@gmail.com")
    ));

    public List<Staff> getStaffs() {
        return list;
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public Staff getStaff(int id) {
        return list.stream().filter(staff -> staff.getId() == id).findFirst().get();
    }

    public void addStaff(Staff staff) {
        list.add(staff);
    }

    public void updateStaff(Staff staff, int id){
        Staff temp = list.stream().filter(s -> s.getId() == id).findFirst().get();
        list.set(list.indexOf(temp),staff);
    }

    public void deleteStaff(int id){
        Staff temp = list.stream().filter(s -> s.getId() == id).findFirst().get();
        list.remove(list.indexOf(temp));
    }
}
