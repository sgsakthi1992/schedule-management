package com.example.schedulemanagement.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ScheduleLineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Account account;
    private String period;
    private String measure;
    private String scenario;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private ScheduleItem scheduleItem;

    public ScheduleLineItem(Account account, String period, String measure, String scenario, ScheduleItem scheduleItem) {
        this.account = account;
        this.period = period;
        this.measure = measure;
        this.scenario = scenario;
        this.scheduleItem = scheduleItem;
    }
}
