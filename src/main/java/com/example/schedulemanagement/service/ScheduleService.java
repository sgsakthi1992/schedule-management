package com.example.schedulemanagement.service;

import com.example.schedulemanagement.convertor.ScheduleConvertor;
import com.example.schedulemanagement.convertor.ScheduleNameResponseConvertor;
import com.example.schedulemanagement.convertor.ScheduleResponseConvertor;
import com.example.schedulemanagement.exception.ScheduleIdNotFoundException;
import com.example.schedulemanagement.model.request.ScheduleNameRequest;
import com.example.schedulemanagement.model.request.ScheduleRequest;
import com.example.schedulemanagement.model.response.ScheduleNameResponse;
import com.example.schedulemanagement.model.response.ScheduleResponse;
import com.example.schedulemanagement.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {
    private final ScheduleConvertor scheduleConvertor;
    private final ScheduleRepository scheduleRepository;
    private final ScheduleNameResponseConvertor scheduleNameResponseConvertor;
    private final ScheduleResponseConvertor scheduleResponseConvertor;

    public ScheduleService(ScheduleConvertor scheduleConvertor, ScheduleRepository scheduleRepository,
                           ScheduleNameResponseConvertor scheduleNameResponseConvertor,
                           ScheduleResponseConvertor scheduleResponseConvertor) {
        this.scheduleConvertor = scheduleConvertor;
        this.scheduleRepository = scheduleRepository;
        this.scheduleNameResponseConvertor = scheduleNameResponseConvertor;
        this.scheduleResponseConvertor = scheduleResponseConvertor;
    }

    public ScheduleNameResponse createSchedule(ScheduleNameRequest scheduleNameRequest) {
        return scheduleNameResponseConvertor.convert(scheduleRepository.save(scheduleConvertor.convert(scheduleNameRequest)));
    }

    public ScheduleResponse updateSchedule(ScheduleRequest scheduleRequest) {
        return scheduleResponseConvertor.convert(scheduleRepository.save(scheduleConvertor.convert(scheduleRequest)));
    }

    public ScheduleResponse getScheduleById(Long scheduleId) {
        return scheduleResponseConvertor.convert(scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new ScheduleIdNotFoundException("Schedule not found")));
    }

    public List<ScheduleResponse> getAllSchedules() {
        return scheduleRepository.findAll().stream()
                .map(scheduleResponseConvertor::convert)
                .collect(Collectors.toList());
    }

    public List<ScheduleNameResponse> getAllScheduleNames() {
        return scheduleRepository.findAll().stream()
                .map(scheduleNameResponseConvertor::convert)
                .collect(Collectors.toList());
    }
}
