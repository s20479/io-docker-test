package com.example.io_backend.dto.converter;

import com.example.io_backend.dto.UserMedicalInfoDto;
import com.example.io_backend.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMedicalInfoConverter {

    public UserMedicalInfoDto entityToDto(User user) {
        UserMedicalInfoDto dto = new UserMedicalInfoDto();
        dto.setUserId(user.getId());
        dto.setLastName(user.getLastName());
        dto.setFirstName(user.getFirstName());
        dto.setBirthDate(user.getBirthDate());
        dto.setPhone(user.getPhone());
        dto.setBandCode(user.getBandCode());
        dto.setMedicalInfoId(user.getMedicalInfo().getId());
        dto.setBloodType(user.getMedicalInfo().getBloodType());
        dto.setChronicDiseases(user.getMedicalInfo().getChronicDiseases());
        dto.setAllergies(user.getMedicalInfo().getAllergies());
        return dto;
    }
}
