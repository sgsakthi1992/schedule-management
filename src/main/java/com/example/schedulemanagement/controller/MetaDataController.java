package com.example.schedulemanagement.controller;

import com.example.schedulemanagement.model.request.MetaDataRequest;
import com.example.schedulemanagement.model.response.MetaDataResponse;
import com.example.schedulemanagement.service.MetaDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/schedule")
public class MetaDataController {

    private MetaDataService service;

    @GetMapping("/metadata")
    public MetaDataResponse getMetaData() {
        return service.getMetaData();
    }

    @PostMapping("/metadata")
    public void saveMetaData(MetaDataRequest request){
        service.saveElement(request);
    }
}
