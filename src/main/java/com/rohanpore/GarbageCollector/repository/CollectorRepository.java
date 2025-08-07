package com.rohanpore.GarbageCollector.repository;

import com.github.javafaker.Faker;
import com.rohanpore.GarbageCollector.exception.UserNotFoundException;
import com.rohanpore.GarbageCollector.model.Collector;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CollectorRepository {

    Faker faker = new Faker();
    List<Collector> collectorList = new ArrayList<>(); {
        int id = 101;
        for(int i=0; i< 3; i++, id++) {
            Collector collector = new Collector();
            collector.setId(id);
            collector.setName(faker.gameOfThrones().character());
            collector.setContact(faker.phoneNumber().subscriberNumber(10));
            collector.setStatus("Available");
            collector.setNumberOfPickups(0);
            collectorList.add(collector);
        }
    }

    public List<Collector> fetchCollectorDetails() {
        return collectorList;
    }

    public Collector getCollectorById(Integer id) {
        return collectorList.stream()
                .filter(collector -> collector.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new UserNotFoundException("Collector with id " + id + " does not exist"));
    }

    public void addCollectorDetails(Collector collector) {
        collectorList.add(collector);
    }

    public void updateCollectorDetails(Collector collectorDTO, Integer id) {
        collectorList.stream()
                .filter(collector -> collector.getId().equals(id))
                .peek(collector -> {
                    collector.setName(collectorDTO.getName());
                    collector.setContact(collectorDTO.getContact());
                })
                .findAny()
                .orElseThrow(() -> new UserNotFoundException("Collector with id " + id + " does not exist"));
    }

    public Collector getAvailableCollector() {
        return collectorList.stream()
                .filter(collector -> collector.getStatus().equals("Available") & collector.getNumberOfPickups()<5)
                .peek(collector -> {
                    if(collector.getNumberOfPickups() == 4) {
                        collector.setNumberOfPickups(collector.getNumberOfPickups() + 1);
                        collector.setStatus("Booked");
                    } else {
                        collector.setNumberOfPickups(collector.getNumberOfPickups() + 1);
                    }
                })
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("Collectors are busy at the moment, please book after some time"));
    }

    public void deleteCollectorDetails(Integer id) {
        collectorList.removeIf(collector -> collector.getId().equals(id));
    }

}
