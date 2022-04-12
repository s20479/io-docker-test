package com.example.io_backend.service;

import com.example.io_backend.exception.NotFoundException;
import com.example.io_backend.model.Staff;
import com.example.io_backend.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffService {

    private final StaffRepository staffRepository;

    public List<Staff> getStaff() {
        return staffRepository.findAll();
    }

    public Staff getStaffById(Integer id) {
        return staffRepository.findById(id).orElseThrow(() -> new NotFoundException("No record with that id"));
    }

    public Staff addStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public void updateStaff(Staff staff, Integer id) {
        var s = staffRepository.findById(id).orElseThrow(() -> new NotFoundException("Staff member not found"));
        s.setId(staff.getId());
        s.setFirstName(staff.getFirstName());
        s.setLastName(staff.getLastName());
        s.setMail(staff.getMail());
        s.setPasswordHash(staff.getPasswordHash());
        s.setSalt(staff.getSalt());
        s.setStaffType(staff.getStaffType());

        staffRepository.save(s);

    }

    public void deleteStaff(Integer id) {
        var s = staffRepository.findById(id).orElseThrow(() -> new NotFoundException("staff not found"));
        staffRepository.delete(s);
    }

}
