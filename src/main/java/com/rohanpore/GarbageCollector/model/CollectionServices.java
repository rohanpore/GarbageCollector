package com.rohanpore.GarbageCollector.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CollectionServices {
    private Map<String, Integer> chargesPerKgs;
    private String requestURL;
}
