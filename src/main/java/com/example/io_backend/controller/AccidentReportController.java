package com.example.io_backend.controller;

import com.example.io_backend.model.AccidentReport;
import com.example.io_backend.service.AccidentReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/accidentReport")
@RequiredArgsConstructor
public class AccidentReportController {

    private final AccidentReportService accidentReportService;

    @GetMapping("")
    public ResponseEntity<List<AccidentReport>> getAll() {
        return new ResponseEntity<>(accidentReportService.getAccidentReports(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<AccidentReport> getById(@PathVariable Long id) {
        return new ResponseEntity<>(accidentReportService.getAccidentReportById(id),HttpStatus.OK) ;
    }

    @PostMapping("")
    public ResponseEntity<AccidentReport> add(@RequestBody AccidentReport accidentReport) {
        return new ResponseEntity<>(accidentReportService.addAccidentReport(accidentReport),HttpStatus.OK);
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
