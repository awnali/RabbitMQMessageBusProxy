package com.ontech.messagebus.proxy.repositories;

import com.ontech.messagebus.proxy.models.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoEventRepository extends MongoRepository<Event, String> {
}
