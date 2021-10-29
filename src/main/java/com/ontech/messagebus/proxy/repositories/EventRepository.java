package com.ontech.messagebus.proxy.repositories;

import com.ontech.messagebus.proxy.models.Event;

public interface EventRepository {
    void save(Event event);
}
