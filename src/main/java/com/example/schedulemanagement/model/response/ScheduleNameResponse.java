package com.example.schedulemanagement.model.response;

import lombok.Builder;
import lombok.Data;

@Builder(setterPrefix = "with")
@Data
public class ScheduleNameResponse {
    private Long scheduleId;
    private String scheduleName;
}
