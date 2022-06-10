package com.example.schedulemanagement.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long scheduleId;
    @Column(unique = true)
    private String scheduleName;
    @OneToMany
    private List<Account> accounts;
    @OneToMany
    private List<Measure> measures;
    @OneToMany
    private List<Period> periods;
    @OneToMany
    private List<Scenario> scenarios;
}
