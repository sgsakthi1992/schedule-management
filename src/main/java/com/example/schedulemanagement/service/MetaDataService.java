package com.example.schedulemanagement.service;

import com.example.schedulemanagement.convertor.MetaDataConverter;
import com.example.schedulemanagement.domain.Account;
import com.example.schedulemanagement.domain.Element;
import com.example.schedulemanagement.model.request.MetaDataRequest;
import com.example.schedulemanagement.model.response.MetaDataResponse;
import com.example.schedulemanagement.repository.AccountRepository;
import com.example.schedulemanagement.repository.ElementRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MetaDataService {

    private ElementRepository repository;
    private MetaDataConverter converter;

    private AccountRepository accountRepository;

    public MetaDataResponse getMetaData() {
        var response = converter.convert(repository.findAll());
        response.setAccountList(new HashSet<>(accountRepository.findAll()));
        return response;
    }

    public void saveElement(MetaDataRequest request) {
        Element element = new Element(request.getElementValue(), request.getElementType());
        repository.save(element);
    }
}
