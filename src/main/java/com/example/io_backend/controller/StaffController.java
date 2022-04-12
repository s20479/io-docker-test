package com.example.io_backend.controller;

import com.example.io_backend.model.Staff;
import com.example.io_backend.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/staff")
@RequiredArgsConstructor
public class StaffController {

    private final StaffService staffService;

    @GetMapping("")
    public List<Staff> getAll() {
        return staffService.getStaff();
    }

    @GetMapping("/{id}")
    public Staff getById(@PathVariable Integer id) {
        return staffService.getStaffById(id);
    }

    @PostMapping("")
    public Staff add(@RequestBody Staff staff) {
        return staffService.addStaff(staff);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Staff staff, @PathVariable Integer id){
        staffService.updateStaff(staff,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        staffService.deleteStaff(id);
    }

}
