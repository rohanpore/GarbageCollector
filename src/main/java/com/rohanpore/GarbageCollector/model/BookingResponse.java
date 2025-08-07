package com.rohanpore.GarbageCollector.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
    private String message;
    private Integer booking_id;
    private String collector_name;
    private String contact;
    private double charges;
}
