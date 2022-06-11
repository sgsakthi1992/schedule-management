package com.example.schedulemanagement.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class ScheduleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;
    private String scheduleName;

    @OneToMany(mappedBy = "scheduleItem")
    List<ScheduleLineItem> lineItems;

    public ScheduleItem(String scheduleName, List<ScheduleLineItem> lineItems) {
        this.scheduleName = scheduleName;
        this.lineItems = lineItems;
    }
}
