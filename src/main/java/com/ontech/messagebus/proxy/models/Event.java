package com.ontech.messagebus.proxy.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Event {

    @Id
    String id;
    String senderServiceId;
    Object body;
    String receiverQueueName;
    @Indexed
    Boolean isSuccessfullySent;
    Date sentAt;
    Date receivedAt;
}
