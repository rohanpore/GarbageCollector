package com.rohanpore.GarbageCollector.services;

import com.rohanpore.GarbageCollector.model.BookingRequest;
import com.rohanpore.GarbageCollector.model.BookingResponse;
import com.rohanpore.GarbageCollector.model.CollectionServices;

import java.util.List;

public interface CollectionService {
    List<CollectionServices> viewServices();
    BookingResponse bookGarbageCollection(Integer capacity, String garbageType);
    List<BookingRequest> viewBookings();
    BookingResponse viewBookingById(Integer id);
}
