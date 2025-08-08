package com.rohanpore.GarbageCollector.controller;

import com.rohanpore.GarbageCollector.model.BookingResponse;
import com.rohanpore.GarbageCollector.model.CollectionServices;
import com.rohanpore.GarbageCollector.model.Consumer;
import com.rohanpore.GarbageCollector.services.CollectionService;
import com.rohanpore.GarbageCollector.services.ConsumerService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/garbage-collector")
@Validated
@OpenAPIDefinition(info =
@Info(title = "Consumer API to access garbage collection services", version = "3.14"))
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @Autowired
    CollectionService collectionService;

    @PostMapping(value="/signUp")
    public ResponseEntity<String> registerConsumer(@Valid @RequestBody Consumer consumer) {
        consumerService.addConsumerDetails(consumer);
        String responseMessage = "Consumer " + consumer.getName() + " registered successfully";
        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }

    // To be implemented
    @PostMapping(value="/signIn")
    public ResponseEntity<String> loginConsumer(@PathVariable String username, @PathVariable String password) {
        String responseMessage = "Consumer " + username + " logged in successfully";
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @ApiResponse(description = "Fetch services")
    @GetMapping(value="/services")
    public ResponseEntity<List<CollectionServices>> viewServices() {
        return new ResponseEntity<>(collectionService.viewServices(), HttpStatus.OK);
    }

    @GetMapping(value="/book/{garbageType}/{garbageCapacity}")
    public ResponseEntity<BookingResponse> bookGarbageCollectionService(
            @PathVariable @Pattern(regexp = "Wet|Dry|Mix", message = "{garbage.type}") String garbageType,
            @PathVariable @Min(value = 10, message = "{garbage.capacity.minimum}") @Max(value = 25, message = "{garbage.capacity.maximum}") Integer garbageCapacity) {
        return new ResponseEntity<>(collectionService.bookGarbageCollection(garbageCapacity, garbageType), HttpStatus.CREATED);
    }

    @GetMapping(value="/book/{bookingId}")
    public ResponseEntity<BookingResponse> viewBookingById(@PathVariable Integer bookingId) {
        return new ResponseEntity<>(collectionService.viewBookingById(bookingId), HttpStatus.FOUND);
    }


}
