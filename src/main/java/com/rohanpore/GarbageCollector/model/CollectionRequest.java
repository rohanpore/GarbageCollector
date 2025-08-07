package com.rohanpore.GarbageCollector.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CollectionRequest {

    private String garbageType;

    private Integer capacity;

}
