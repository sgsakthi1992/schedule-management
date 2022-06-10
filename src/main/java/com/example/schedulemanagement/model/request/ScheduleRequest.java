package com.example.schedulemanagement.model.request;

import lombok.Data;

import java.util.List;

@Data
public class ScheduleRequest {
    private final Long scheduleId;
    private final List<Long> accountIds;
    private final List<Long> measureIds;
    private final List<Long> periodIds;
    private final List<Long> scenarioIds;
}
