package com.example.schedulemanagement.convertor;

import com.example.schedulemanagement.domain.Element;
import com.example.schedulemanagement.domain.ElementType;
import com.example.schedulemanagement.model.response.MetaDataResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MetaDataConverter {

    public MetaDataResponse convert(List<Element> elementList) {
        var groupedByType = elementList.stream().collect(
                Collectors.groupingBy(Element::getElementType, Collectors.mapping(Element::getElementValue, Collectors.toSet()))
        );

        MetaDataResponse response = new MetaDataResponse();
        response.setMeasures(groupedByType.get(ElementType.Measure));
        response.setPeriods(groupedByType.get(ElementType.Period));
        response.setScenarios(groupedByType.get(ElementType.Scenario));
        return response;
    }
}
