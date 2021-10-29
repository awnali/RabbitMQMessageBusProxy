package com.ontech.messagebus.proxy.repositories;

import com.ontech.messagebus.proxy.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

@Repository
public class EventRepositoryImpl implements EventRepository {

    @Autowired
    MongoEventRepository mongoEventRepository;

    @Override
    @Async("MessageTaskExecutor")
    public void save(Event event) {
        System.out.println("Current Thread Name- " + Thread.currentThread().getName());
        mongoEventRepository.save(event);
    }
}
