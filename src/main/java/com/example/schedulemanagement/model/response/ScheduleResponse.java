package com.example.schedulemanagement.model.response;

import com.example.schedulemanagement.domain.Account;
import com.example.schedulemanagement.domain.Measure;
import com.example.schedulemanagement.domain.Period;
import com.example.schedulemanagement.domain.Scenario;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder(setterPrefix = "with")
@Data
public class ScheduleResponse {
    private Long scheduleId;
    private String scheduleName;
    private List<Account> accounts;
    private List<Measure> measures;
    private List<Period> periods;
    private List<Scenario> scenarios;
}
