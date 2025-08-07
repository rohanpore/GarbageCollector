package com.rohanpore.GarbageCollector.services.impl;

import com.rohanpore.GarbageCollector.model.Consumer;
import com.rohanpore.GarbageCollector.repository.ConsumerRepository;
import com.rohanpore.GarbageCollector.services.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    ConsumerRepository consumerRepository;

    @Override
    public List<Consumer> getConsumerDetails() {
        return consumerRepository.fetchConsumerDetails();
    }

    @Override
    public Consumer getConsumerById(Integer ConsumerId) {
        return consumerRepository.getConsumerById(ConsumerId);
    }

    @Override
    public void addConsumerDetails(Consumer Consumer) {
        consumerRepository.addConsumerDetails(Consumer);
    }

    @Override
    public void updateConsumerDetails(Consumer Consumer, Integer ConsumerId) {
        consumerRepository.updateConsumerDetails(Consumer, ConsumerId);
    }

    @Override
    public void deleteConsumerDetails(Integer ConsumerId) {
        consumerRepository.deleteConsumerDetails(ConsumerId);
    }
}
