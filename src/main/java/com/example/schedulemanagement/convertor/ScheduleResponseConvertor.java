package com.example.schedulemanagement.convertor;

import com.example.schedulemanagement.domain.Schedule;
import com.example.schedulemanagement.model.response.ScheduleResponse;
import org.springframework.stereotype.Service;

@Service
public class ScheduleResponseConvertor {
    public ScheduleResponse convert(Schedule schedule) {
        return ScheduleResponse.builder()
                .withScheduleId(schedule.getScheduleId())
                .withScheduleName(schedule.getScheduleName())
                .withAccounts(schedule.getAccounts())
                .withMeasures(schedule.getMeasures())
                .withPeriods(schedule.getPeriods())
                .withScenarios(schedule.getScenarios())
                .build();
    }
}
