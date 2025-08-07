package com.rohanpore.GarbageCollector.repository;

import com.github.javafaker.Faker;
import com.rohanpore.GarbageCollector.exception.UserNotFoundException;
import com.rohanpore.GarbageCollector.model.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CollectionRepository {

    Faker faker = new Faker();

    List<BookingRequest> bookingRequestList = new ArrayList<>(); {

        String consumerFirstName = faker.name().firstName();
        String consumerLastName = faker.name().lastName();
        String consumerName = consumerFirstName + " " + consumerLastName;
        String consumerEmailID = consumerFirstName + "@gmail.com";

        Consumer consumer = new Consumer();
        consumer.setId(1001);
        consumer.setName(consumerName);
        consumer.setEmail(consumerEmailID);
        consumer.setContact(faker.phoneNumber().subscriberNumber(10));
        consumer.setLocation(faker.address().fullAddress());

        Collector collector = new Collector();
        collector.setId(101);
        collector.setName(faker.gameOfThrones().character());
        collector.setContact(faker.phoneNumber().subscriberNumber(10));
        collector.setStatus("Available");
        collector.setNumberOfPickups(1);

        BookingRequest bookingRequest = new BookingRequest();
        bookingRequest.setBooking_id(111);
        bookingRequest.setGarbageType("Wet");
        bookingRequest.setCapacity(10);
        bookingRequest.setCharges(200);
        bookingRequest.setConsumer(consumer);
        bookingRequest.setCollector(collector);

        bookingRequestList.add(bookingRequest);
    }

    List<BookingResponse> bookingResponseList = new ArrayList<>(); {
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBooking_id(111);
        bookingResponse.setMessage("Successful");
        bookingResponse.setContact(faker.phoneNumber().subscriberNumber(10));
        bookingResponse.setCharges(200);
        bookingResponse.setCollector_name(faker.gameOfThrones().character());
        bookingResponseList.add(bookingResponse);
    }

    public void addBookingRequestDetails(BookingRequest bookingRequest, BookingResponse bookingResponse) {
        bookingRequestList.add(bookingRequest);
        bookingResponseList.add(bookingResponse);
    }

    public List<BookingRequest> fetchBookingDetails() {
        return bookingRequestList;
    }

    public BookingResponse fetchBookingById(Integer id) {
        return bookingResponseList.stream()
                .filter(booking -> booking.getBooking_id().equals(id))
                .findAny().orElseThrow(() -> new UserNotFoundException("No booking found for id " + id));
    }

    public Integer fetchRecentBookingId() {
        Optional<BookingRequest> latestBookingId =  bookingRequestList.stream()
                .max(Comparator.comparing(BookingRequest::getBooking_id));
        return latestBookingId.get().getBooking_id();
    }

}
