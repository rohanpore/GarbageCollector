package com.rohanpore.GarbageCollector.services;

import com.rohanpore.GarbageCollector.model.Collector;

import java.util.List;

public interface CollectorService {
    List<Collector> getCollectorDetails();
    Collector getCollectorById(Integer collectorId);
    void addCollectorDetails(Collector collector);
    void updateCollectorDetails(Collector collector, Integer CollectorId);
    void deleteCollectorDetails(Integer collectorId);
}
