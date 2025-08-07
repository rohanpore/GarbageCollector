package com.rohanpore.GarbageCollector.services.impl;

import com.rohanpore.GarbageCollector.model.Collector;
import com.rohanpore.GarbageCollector.repository.CollectorRepository;
import com.rohanpore.GarbageCollector.services.CollectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectorServiceImpl implements CollectorService {
    
    @Autowired
    CollectorRepository collectorRepository;
    
    @Override
    public List<Collector> getCollectorDetails() {
        return collectorRepository.fetchCollectorDetails();
    }

    @Override
    public Collector getCollectorById(Integer collectorId) {
        return collectorRepository.getCollectorById(collectorId);
    }

    @Override
    public void addCollectorDetails(Collector collector) {
        collectorRepository.addCollectorDetails(collector);
    }

    @Override
    public void updateCollectorDetails(Collector collector, Integer collectorId) {
        collectorRepository.updateCollectorDetails(collector, collectorId);
    }

    @Override
    public void deleteCollectorDetails(Integer collectorId) {
        collectorRepository.deleteCollectorDetails(collectorId);
    }
}
