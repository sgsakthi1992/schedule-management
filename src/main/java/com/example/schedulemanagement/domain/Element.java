package com.example.schedulemanagement.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long elementId;
    private String elementValue;
    @Enumerated(EnumType.STRING)
    private ElementType elementType;

    public Element(String elementValue, ElementType elementType) {
        this.elementValue = elementValue;
        this.elementType = elementType;
    }
}
