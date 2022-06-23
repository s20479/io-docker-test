package com.example.io_backend.service;

import com.example.io_backend.exception.NotFoundException;
import com.example.io_backend.model.AccidentReport;
import com.example.io_backend.model.Staff;
import com.example.io_backend.model.enums.StaffType;
import com.example.io_backend.repository.AccidentReportRepository;
import com.example.io_backend.repository.DispositorDutyEntryRepository;
import com.example.io_backend.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class AccidentReportService {

    private final AccidentReportRepository accidentReportRepository;
    private final StaffRepository staffRepository;
    private final DispositorDutyEntryRepository dispositorDutyEntryRepository;

    public List<AccidentReport> getAccidentReports(){
        return accidentReportRepository.findAll();
    }

    public AccidentReport getAccidentReportById(Integer id){
        return accidentReportRepository.findById(id).orElseThrow(()-> new NotFoundException("No record with that ID"));
    }

    public AccidentReport addAccidentReport(AccidentReport accidentReport){
        AtomicReference<Staff> least = null;
        AtomicLong count = new AtomicLong(Long.MAX_VALUE);
        staffRepository.getAllByStaffType(StaffType.DISPOSITOR).stream()
                .filter(it -> dispositorDutyEntryRepository.getFirstByDutyEndIsNotNullAndStaffEquals(it) != null)
                .forEach(it -> {
                    long current = accidentReportRepository.countByStaff(it);
                    if (current < count.get()) {
                        count.set(current);
                        least.set(it);
                    }
                });

        accidentReport.setStaff(least.get());

        return accidentReportRepository.save(accidentReport);
    }

    public void updateAccidentReport(AccidentReport accidentReport, Integer id) {
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

    public void deleteAccidentReport(Integer id) {
        var a = accidentReportRepository.findById(id).orElseThrow(()-> new NotFoundException("No record with that ID"));

        accidentReportRepository.delete(a);
    }
}
