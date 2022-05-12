package com.example.io_backend.service;

import com.example.io_backend.exception.NotFoundException;
import com.example.io_backend.model.AccidentReport;
import com.example.io_backend.repository.AccidentReportRepository;
import com.example.io_backend.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccidentReportService {

    private final AccidentReportRepository accidentReportRepository;
    private final StaffRepository staffRepository;

    public List<AccidentReport> getAccidentReports(){
        return accidentReportRepository.findAll();
    }

    public AccidentReport getAccidentReportById(Long id){
        return accidentReportRepository.findById(id).orElseThrow(()-> new NotFoundException("No record with that ID"));
    }

    public AccidentReport addAccidentReport(AccidentReport accidentReport){
        staffRepository.
        return accidentReportRepository.save(accidentReport);
    }

    public void updateAccidentReport(AccidentReport accidentReport, Long id) {
        var a = accidentReportRepository.findById(id).orElseThrow(()-> new NotFoundException("No record with that ID"));

        a.setId(accidentReport.getId());
        a.setAmbulances(accidentReport.getAmbulances());
        a.setClosed(accidentReport.getClosed());
        a.setReportSurvey(accidentReport.getReportSurvey());
        a.setDate(accidentReport.getDate());
        a.setDangerRating(accidentReport.getDangerRating());
        a.setStaff(accidentReport.getStaff());
        a.setUser(accidentReport.getUser());
        accidentReportRepository.save(a);
    }

    public void deleteAccidentReport(Long id) {
        var a = accidentReportRepository.findById(id).orElseThrow(()-> new NotFoundException("No record with that ID"));

        accidentReportRepository.delete(a);
    }
}
