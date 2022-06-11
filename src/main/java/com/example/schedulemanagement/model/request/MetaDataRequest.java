package com.example.schedulemanagement.model.request;

import com.example.schedulemanagement.domain.ElementType;
import lombok.Data;

@Data
public class MetaDataRequest {
    private ElementType elementType;
    private String elementValue;
}
