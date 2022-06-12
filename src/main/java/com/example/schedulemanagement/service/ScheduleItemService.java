package com.example.schedulemanagement.service;

import com.example.schedulemanagement.convertor.ScheduleItemConverter;
import com.example.schedulemanagement.domain.ScheduleItem;
import com.example.schedulemanagement.model.request.ScheduleItemRequest;
import com.example.schedulemanagement.model.request.ScheduleNameRequest;
import com.example.schedulemanagement.repository.AccountRepository;
import com.example.schedulemanagement.repository.ScheduleItemRepository;
import com.example.schedulemanagement.repository.ScheduleLineItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@AllArgsConstructor

public class ScheduleItemService {

    private ScheduleItemRepository repository;
    private ScheduleItemConverter converter;

    private AccountRepository accountRepository;

    private ScheduleLineItemRepository lineItemRepository;

    @PutMapping("/update")
    public void addMetaDataToSchedule(ScheduleItemRequest request) {
        var scheduleItem = converter.convert(request, accountRepository.findAll());
        lineItemRepository.saveAll(scheduleItem.getLineItems());
        repository.save(scheduleItem);
    }

    @PostMapping("/create")
    public void createSchedule(@RequestBody ScheduleNameRequest request) {
        ScheduleItem item = new ScheduleItem();
        item.setScheduleName(request.getScheduleName());
        repository.save(item);
    }

    @GetMapping("get/{id}")
    public ScheduleItem getScheduleItem(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }
}
