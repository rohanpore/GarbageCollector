package com.rohanpore.GarbageCollector.services.impl;

import com.rohanpore.GarbageCollector.model.*;
import com.rohanpore.GarbageCollector.repository.CollectionRepository;
import com.rohanpore.GarbageCollector.repository.CollectorRepository;
import com.rohanpore.GarbageCollector.repository.ConsumerRepository;
import com.rohanpore.GarbageCollector.services.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class CollectionServiceImpl implements CollectionService {

    private static final String BOOKING_SUCCESS = "Your booking was successful";
    private static final String BOOKING_REQUEST_URL = "http://localhost:8080/garbage-collector/book/{{garbageType}}/{{garbageCapacity}}";

    @Autowired
    CollectionRepository collectionRepository;

    @Autowired
    CollectorRepository collectorRepository;

    @Autowired
    ConsumerRepository consumerRepository;

    Map<String, Integer> serviceMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER); {
        serviceMap.put("Dry", 10);
        serviceMap.put("Wet", 20);
        serviceMap.put("All", 25);
    }

    List<CollectionServices> collectionServicesList = new ArrayList<>(); {
        collectionServicesList.add(new CollectionServices(serviceMap, BOOKING_REQUEST_URL));
    }

    @Override
    public List<CollectionServices> viewServices() {
        return collectionServicesList;
    }

    @Override
    public BookingResponse bookGarbageCollection(Integer capacity, String garbageType) {
        double charges = serviceMap.get(garbageType) * capacity;

        // Get consumer details (hardcoded)
        // Implement logic to retrieve logged-in user
        Consumer consumer = consumerRepository.getConsumerById(1001);

        // Get collector details and update status
        Collector collector = collectorRepository.getAvailableCollector();
        Integer bookingId = collectionRepository.fetchRecentBookingId() + 1;

        BookingRequest bookingRequest = new BookingRequest(bookingId, garbageType, capacity, charges, collector, consumer);
        BookingResponse bookingResponse = new BookingResponse(BOOKING_SUCCESS, bookingId, collector.getName(), collector.getContact(), charges);

        // Add booking request
        collectionRepository.addBookingRequestDetails(bookingRequest, bookingResponse);
        return bookingResponse;
    }

    @Override
    public List<BookingRequest> viewBookings() {
        return collectionRepository.fetchBookingDetails();
    }

    public BookingResponse viewBookingById(Integer id) {
        return collectionRepository.fetchBookingById(id);
    }
}
