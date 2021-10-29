package com.ontech.messagebus.proxy.stream;

import com.ontech.messagebus.proxy.models.Event;
import com.ontech.messagebus.proxy.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class InputEventStreamService {

    static EventRepository eventRepository;

    static StreamBridge streamBridge;

    @Autowired
    public InputEventStreamService(EventRepository eventRepository, StreamBridge streamBridge){
        InputEventStreamService.eventRepository = eventRepository;
        InputEventStreamService.streamBridge = streamBridge;
    }

    public static void  saveEventAndSendOnOriginalQueue(Event event){

        System.out.println("Current Thread Name- " + Thread.currentThread().getName());
        boolean isSent = streamBridge.send(event.getReceiverQueueName(), event.getBody());
        event.setIsSuccessfullySent(isSent);
        event.setReceivedAt(new Date());
        eventRepository.save(event);

//        System.out.println(event.getId());
    }
}
