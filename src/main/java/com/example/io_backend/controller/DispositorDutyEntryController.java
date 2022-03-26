package com.example.io_backend.controller;

import com.example.io_backend.model.DispositorDutyEntry;
import com.example.io_backend.service.DispositorDutyEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/dispositorDutyEntry")
@RequiredArgsConstructor
public class DispositorDutyEntryController {

    private final DispositorDutyEntryService dispositorDutyEntryService;

    @GetMapping("")
    public List<DispositorDutyEntry> getAll() {
        return dispositorDutyEntryService.getDispositorDutyEntries();
    }

    @GetMapping("{id}")
    public DispositorDutyEntry getById(@PathVariable Integer id) {
        return dispositorDutyEntryService.getDispositorDutyEntryById(id);
    }

    @PostMapping("")
    public DispositorDutyEntry add(@RequestBody DispositorDutyEntry dispositorDutyEntry) {
        return dispositorDutyEntryService.addDispositorDutyEntry(dispositorDutyEntry);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody DispositorDutyEntry dispositorDutyEntry,@PathVariable Integer id){
        dispositorDutyEntryService.updateDispositorDutyEntry(dispositorDutyEntry,id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        dispositorDutyEntryService.deleteDispositorDutyEntry(id);
    }

}
