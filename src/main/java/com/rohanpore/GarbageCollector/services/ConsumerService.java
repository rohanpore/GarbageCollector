package com.rohanpore.GarbageCollector.services;

import com.rohanpore.GarbageCollector.model.Consumer;

import java.util.List;

public interface ConsumerService {
    List<Consumer> getConsumerDetails();
    Consumer getConsumerById(Integer consumerId);
    void addConsumerDetails(Consumer consumer);
    void updateConsumerDetails(Consumer consumer, Integer ConsumerId);
    void deleteConsumerDetails(Integer consumerId);
}
