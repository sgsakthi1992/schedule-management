package com.example.schedulemanagement.convertor;

import com.example.schedulemanagement.domain.Account;
import com.example.schedulemanagement.domain.Measure;
import com.example.schedulemanagement.domain.Period;
import com.example.schedulemanagement.domain.Scenario;
import com.example.schedulemanagement.domain.Schedule;
import com.example.schedulemanagement.exception.ScheduleIdNotFoundException;
import com.example.schedulemanagement.model.request.ScheduleNameRequest;
import com.example.schedulemanagement.model.request.ScheduleRequest;
import com.example.schedulemanagement.repository.AccountRepository;
import com.example.schedulemanagement.repository.MeasureRepository;
import com.example.schedulemanagement.repository.PeriodRepository;
import com.example.schedulemanagement.repository.ScenarioRepository;
import com.example.schedulemanagement.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScheduleConvertor {
    private final AccountRepository accountRepository;
    private final MeasureRepository measureRepository;
    private final PeriodRepository periodRepository;
    private final ScenarioRepository scenarioRepository;
    private final ScheduleRepository scheduleRepository;

    public ScheduleConvertor(AccountRepository accountRepository,
                             MeasureRepository measureRepository,
                             PeriodRepository periodRepository,
                             ScenarioRepository scenarioRepository, ScheduleRepository scheduleRepository) {
        this.accountRepository = accountRepository;
        this.measureRepository = measureRepository;
        this.periodRepository = periodRepository;
        this.scenarioRepository = scenarioRepository;
        this.scheduleRepository = scheduleRepository;
    }

    public Schedule convert(ScheduleNameRequest scheduleNameRequest) {
        var schedule = new Schedule();
        schedule.setScheduleName(scheduleNameRequest.getScheduleName());
        return schedule;
    }

    public Schedule convert(ScheduleRequest scheduleRequest) {
        var schedule = getSchedule(scheduleRequest.getScheduleId());
        schedule.setAccounts(getAccounts(scheduleRequest.getAccountIds()));
        schedule.setMeasures(getMeasures(scheduleRequest.getMeasureIds()));
        schedule.setPeriods(getPeriods(scheduleRequest.getPeriodIds()));
        schedule.setScenarios(getScenarios(scheduleRequest.getScenarioIds()));
        return schedule;
    }

    private Schedule getSchedule(Long scheduleId) {
        return scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new ScheduleIdNotFoundException("Schedule not found"));
    }

    private List<Account> getAccounts(List<Long> accountIds) {
        return accountIds.parallelStream()
                .map(accountRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private List<Measure> getMeasures(List<Long> measureIds) {
        return measureIds.parallelStream()
                .map(measureRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private List<Period> getPeriods(List<Long> periodIds) {
        return periodIds.parallelStream()
                .map(periodRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private List<Scenario> getScenarios(List<Long> scenarioIds) {
        return scenarioIds.parallelStream()
                .map(scenarioRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

}
