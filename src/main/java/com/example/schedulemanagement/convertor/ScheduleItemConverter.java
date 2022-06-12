package com.example.schedulemanagement.convertor;

import com.example.schedulemanagement.domain.Account;
import com.example.schedulemanagement.domain.ScheduleItem;
import com.example.schedulemanagement.domain.ScheduleLineItem;
import com.example.schedulemanagement.model.request.ScheduleItemRequest;
import com.example.schedulemanagement.repository.ScheduleItemRepository;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
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

    /*private List<ScheduleLineItem> createScheduleLineItems(ScheduleItemRequest request, List<Account> accounts, ScheduleItem scheduleItem) {
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
    }*/

    private List<ScheduleLineItem> createScheduleLineItems(ScheduleItemRequest request, List<Account> accounts, ScheduleItem scheduleItem) {
        Set<List<Object>> setOfLists = Sets.cartesianProduct(request.getAccountIds(), request.getPeriods(), request.getMeasures(), request.getScenarios());
        setOfLists.forEach(System.out::println);
        var accountMap = accounts.stream().collect(Collectors.toMap(Account::getAccountId, Function.identity()));
        return setOfLists.stream().map(list -> createLineItem(list,accountMap,scheduleItem)).collect(Collectors.toList());

    }

    private ScheduleLineItem createLineItem(List<Object> list, Map<Long, Account> accountMap, ScheduleItem scheduleItem) {
        var account = accountMap.get(list.get(0));
        return new ScheduleLineItem(account, String.valueOf(list.get(1)), String.valueOf(list.get(2)), String.valueOf(list.get(3)), scheduleItem);
    }

}


