package com.example.io_backend.controller;

import com.example.io_backend.model.AccidentReport;
import com.example.io_backend.service.AccidentReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/accidentReport")
@RequiredArgsConstructor
public class AccidentReportController {

    private final AccidentReportService accidentReportService;

    @GetMapping("")
    public List<AccidentReport> getAll() {
        return accidentReportService.getAccidentReports();
    }

    @GetMapping("{id}")
    public AccidentReport getById(@PathVariable Long id) {
        return accidentReportService.getAccidentReportById(id);
    }

    @PostMapping("")
    public AccidentReport add(@RequestBody AccidentReport accidentReport) {
        return accidentReportService.addAccidentReport(accidentReport);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody AccidentReport accidentReport,@PathVariable Long id){
        accidentReportService.updateAccidentReport(accidentReport,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        accidentReportService.deleteAccidentReport(id);
    }

}
