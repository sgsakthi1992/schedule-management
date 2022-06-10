package com.example.schedulemanagement.convertor;

import com.example.schedulemanagement.domain.Schedule;
import com.example.schedulemanagement.model.response.ScheduleNameResponse;
import com.example.schedulemanagement.model.response.ScheduleResponse;
import org.springframework.stereotype.Service;

@Service
public class ScheduleNameResponseConvertor {
    public ScheduleNameResponse convert(Schedule schedule) {
        return ScheduleNameResponse.builder()
                .withScheduleId(schedule.getScheduleId())
                .withScheduleName(schedule.getScheduleName())
                .build();
    }
}
