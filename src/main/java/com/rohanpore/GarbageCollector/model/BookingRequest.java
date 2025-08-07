package com.rohanpore.GarbageCollector.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {

    private Integer booking_id;

    private String garbageType;

    private Integer capacity;

    private double charges;

    private Collector collector;

    private Consumer consumer;

}
