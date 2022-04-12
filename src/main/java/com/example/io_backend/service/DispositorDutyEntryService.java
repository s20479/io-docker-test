package com.example.io_backend.service;

import com.example.io_backend.exception.NotFoundException;
import com.example.io_backend.model.DispositorDutyEntry;
import com.example.io_backend.repository.DispositorDutyEntryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DispositorDutyEntryService {

    private final DispositorDutyEntryRepository dispositorDutyEntryRepository;

    public List<DispositorDutyEntry> getDispositorDutyEntries(){
        return dispositorDutyEntryRepository.findAll();
    }

    public DispositorDutyEntry getDispositorDutyEntryById(Integer id) {
        return dispositorDutyEntryRepository.findById(id).orElseThrow(() -> new NotFoundException("No record with that Id"));
    }

    public DispositorDutyEntry addDispositorDutyEntry(DispositorDutyEntry dispositorDutyEntry) {
        return dispositorDutyEntryRepository.save(dispositorDutyEntry);
    }

    public void updateDispositorDutyEntry(DispositorDutyEntry dispositorDutyEntry, Integer id) {
        var d = dispositorDutyEntryRepository.findById(id).orElseThrow(() -> new NotFoundException("No record with that Id"));

        d.setId(dispositorDutyEntry.getId());
        d.setDutyStart(dispositorDutyEntry.getDutyStart());
        d.setDutyEnd(dispositorDutyEntry.getDutyEnd());
        d.setComment(dispositorDutyEntry.getComment());
        d.setStaff(dispositorDutyEntry.getStaff());

        dispositorDutyEntryRepository.save(d);
    }

    public void deleteDispositorDutyEntry(Integer id) {
        var d = dispositorDutyEntryRepository.findById(id).orElseThrow(() -> new NotFoundException("No record with that Id"));

        dispositorDutyEntryRepository.delete(d);
    }

}
