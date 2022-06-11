package com.example.schedulemanagement.model.request;

import lombok.Data;

import java.util.Set;

@Data
public class ScheduleItemRequest {
    private Long scheduleId;
    private Set<Long> accountIds;
    private Set<String> measures;
    private Set<String> periods;
    private Set<String> scenarios;
}
