package com.example.schedulemanagement.controller;

import com.example.schedulemanagement.domain.ScheduleItem;
import com.example.schedulemanagement.model.request.ScheduleItemRequest;
import com.example.schedulemanagement.model.request.ScheduleNameRequest;
import com.example.schedulemanagement.service.ScheduleItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/schedule")
public class ScheduleItemController {

    private ScheduleItemService service;

    @GetMapping("get/{id}")
    public ScheduleItem getScheduleItem(Long id) {
        return service.getScheduleItem(id);
    }

    @PutMapping("/update")
    public void addMetaDataToSchedule(ScheduleItemRequest request) {
        service.addMetaDataToSchedule(request);
    }

    @PostMapping("/create")
    public void createSchedule(@RequestBody ScheduleNameRequest request) {
        service.createSchedule(request);
    }


}
