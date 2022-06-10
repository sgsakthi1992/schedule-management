package com.example.schedulemanagement.controller;

import com.example.schedulemanagement.model.request.ScheduleNameRequest;
import com.example.schedulemanagement.model.request.ScheduleRequest;
import com.example.schedulemanagement.model.response.ScheduleNameResponse;
import com.example.schedulemanagement.model.response.ScheduleResponse;
import com.example.schedulemanagement.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponse>> getAllSchedules() {
        return ResponseEntity.ok(scheduleService.getAllSchedules());
    }

    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponse> getScheduleById(@PathVariable Long scheduleId) {
        return ResponseEntity.ok(scheduleService.getScheduleById(scheduleId));
    }

    @GetMapping("/names")
    public ResponseEntity<List<ScheduleNameResponse>> getAllScheduleNames() {
        return ResponseEntity.ok(scheduleService.getAllScheduleNames());
    }

    @PostMapping
    public ResponseEntity<ScheduleNameResponse> createSchedule(@RequestBody ScheduleNameRequest scheduleNameRequest) {
        return ResponseEntity.ok(scheduleService.createSchedule(scheduleNameRequest));
    }

    @PutMapping
    public ResponseEntity<ScheduleResponse> updateSchedule(@RequestBody ScheduleRequest scheduleRequest) {
        return ResponseEntity.ok(scheduleService.updateSchedule(scheduleRequest));
    }
}
