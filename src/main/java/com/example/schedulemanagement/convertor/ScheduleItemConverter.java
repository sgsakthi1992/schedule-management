package com.example.schedulemanagement.convertor;

import com.example.schedulemanagement.domain.Account;
import com.example.schedulemanagement.domain.ScheduleItem;
import com.example.schedulemanagement.domain.ScheduleLineItem;
import com.example.schedulemanagement.model.request.ScheduleItemRequest;
import com.example.schedulemanagement.repository.ScheduleItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ScheduleItemConverter {

    @Autowired
    private ScheduleItemRepository repository;

    public ScheduleItem convert(ScheduleItemRequest request, List<Account> accounts) {
        var item = repository.findById(request.getScheduleId()).orElseThrow();
        item.setLineItems(createScheduleLineItems(request, accounts, item));
        return item;
    }

    private List<ScheduleLineItem> createScheduleLineItems(ScheduleItemRequest request, List<Account> accounts, ScheduleItem scheduleItem) {
        var list = new ArrayList<ScheduleLineItem>();
        var accountMap = accounts.stream().collect(Collectors.toMap(Account::getAccountId, Function.identity()));
        var accountIds = request.getAccountIds();
        var measures = request.getMeasures();
        var periods = request.getPeriods();
        var scenarios = request.getScenarios();
        for (var id : accountIds) {
            var acc = accountMap.get(id);
            for (var mesaure : measures) {
                for (var period : periods) {
                    for (var scenario : scenarios) {
                        var s = new ScheduleLineItem(acc, period, mesaure, scenario, scheduleItem);
                        list.add(s);
                    }
                }
            }
        }

        return list;
    }


}


