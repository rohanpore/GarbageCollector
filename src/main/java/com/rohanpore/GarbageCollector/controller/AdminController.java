package com.rohanpore.GarbageCollector.controller;

import com.rohanpore.GarbageCollector.model.BookingRequest;
import com.rohanpore.GarbageCollector.model.Collector;
import com.rohanpore.GarbageCollector.model.Consumer;
import com.rohanpore.GarbageCollector.services.CollectionService;
import com.rohanpore.GarbageCollector.services.CollectorService;
import com.rohanpore.GarbageCollector.services.ConsumerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/garbage-collector")
public class AdminController {

    @Autowired
    ConsumerService consumerService;

    @Autowired
    CollectorService collectorService;

    @Autowired
    CollectionService collectionService;

    @GetMapping(value="/consumers")
    public ResponseEntity<List<Consumer>> viewConsumers() {
        return new ResponseEntity<>(consumerService.getConsumerDetails(), HttpStatus.OK);
    }

    @GetMapping(value="/consumers/{consumerId}")
    public ResponseEntity<Consumer> getConsumerById(@PathVariable Integer consumerId) {
        return new ResponseEntity<>(consumerService.getConsumerById(consumerId), HttpStatus.FOUND);
    }

    @PostMapping(value="/collectors")
    public ResponseEntity<String> addCollector(@Valid @RequestBody Collector collector) {
        collectorService.addCollectorDetails(collector);
        String responseMessage = "Controller " + collector.getName() + " added successfully";
        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }

    @GetMapping(value="/collectors")
    public ResponseEntity<List<Collector>> viewCollector() {
        return new ResponseEntity<>(collectorService.getCollectorDetails(), HttpStatus.OK);
    }

    @GetMapping(value="/collectors/{collectorId}")
    public ResponseEntity<Collector> getCollectorById(@PathVariable Integer collectorId) {
        return new ResponseEntity<>(collectorService.getCollectorById(collectorId), HttpStatus.FOUND);
    }

    @PutMapping(value="collectors/{collectorId}")
    public ResponseEntity<String> updateCollector(@Valid @RequestBody Collector collector, @PathVariable Integer collectorId) {
        collectorService.updateCollectorDetails(collector, collectorId);
        String responseMessage = "Controller with id " + collectorId + " updated successfully";
        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }

    @DeleteMapping(value="collectors/{collectorId}")
    public ResponseEntity<String> deleteCollector(@PathVariable Integer collectorId) {
        collectorService.deleteCollectorDetails(collectorId);
        String responseMessage = "Controller with id " + collectorId + " deleted successfully";
        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }

    @GetMapping(value="/bookings")
    public ResponseEntity<List<BookingRequest>> getBookingDetails() {
        return new ResponseEntity<>(collectionService.viewBookings(), HttpStatus.CREATED);
    }
}
