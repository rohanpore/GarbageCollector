package com.rohanpore.GarbageCollector.repository;

import com.github.javafaker.Faker;
import com.rohanpore.GarbageCollector.exception.UserNotFoundException;
import com.rohanpore.GarbageCollector.model.Consumer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ConsumerRepository {

    Faker faker = new Faker();

    List<Consumer> consumerList = new ArrayList<>(); {
        consumerList.add(
                new Consumer(
                        1001,
                        faker.name().fullName(),
                        faker.name().fullName()+"@gmail.com",
                        faker.phoneNumber().phoneNumber(),
                        faker.address().fullAddress()
                )
        );
    }

    public List<Consumer> fetchConsumerDetails() {
        return consumerList;
    }

    public Consumer getConsumerById(Integer id) {
        return consumerList.stream()
                .filter(Consumer -> Consumer.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new UserNotFoundException("Consumer with id " + id + " does not exist"));
    }

    public void addConsumerDetails(Consumer Consumer) {
        consumerList.add(Consumer);
    }

    public void updateConsumerDetails(Consumer ConsumerDTO, Integer id) {
        consumerList.stream()
                .filter(Consumer -> Consumer.getId().equals(id))
                .peek(Consumer -> {
                    Consumer.setName(ConsumerDTO.getName());
                    Consumer.setEmail(ConsumerDTO.getEmail());
                }).findAny()
                .orElseThrow(() -> new UserNotFoundException("Consumer with id " + id + " does not exist"));
    }

    public void deleteConsumerDetails(Integer id) {
        consumerList.removeIf(Consumer -> Consumer.getId().equals(id));
    }

}
