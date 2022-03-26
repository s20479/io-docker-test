package com.example.io_backend.service;

import com.example.io_backend.exception.NotFoundException;
import com.example.io_backend.model.MedicalInfo;
import com.example.io_backend.repository.MedicalInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalInfoService {

    private final MedicalInfoRepository medicalInfoRepository;

    public List<MedicalInfo> getMedicalInfo() {
        return medicalInfoRepository.findAll();
    }

    public MedicalInfo getMedicalInfoById(Long id) {
        return medicalInfoRepository.findById(id).orElseThrow(() -> new NotFoundException("No record with that id "));
    }

    public MedicalInfo addMedicalInfo(MedicalInfo medicalInfo) {
        return medicalInfoRepository.save(medicalInfo);
    }

    public void updateMedicalInfo(MedicalInfo medicalInfo, Long id){
        var m = medicalInfoRepository.findById(id).orElseThrow(() -> new NotFoundException("Medical Info not found"));
        m.setId(medicalInfo.getId());
        m.setAllergies(medicalInfo.getAllergies());
        m.setBloodType(medicalInfo.getBloodType());
        m.setChronicDiseases(medicalInfo.getChronicDiseases());

        medicalInfoRepository.save(m);
    }

    public void deleteMedicalInfo(Long id) {
        var m = medicalInfoRepository.findById(id).orElseThrow(() -> new NotFoundException("Medical Info not found "));

        medicalInfoRepository.delete(m);
    }

}
