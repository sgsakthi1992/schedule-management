package com.example.schedulemanagement.model.response;

import com.example.schedulemanagement.domain.Account;
import lombok.Data;

import java.util.Set;

@Data
public class MetaDataResponse {
    Set<Account> accountList;
    Set<String> Measures;
    Set<String> periods;
    Set<String> scenarios;

}
