package com.example.kafka.application;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class RecibiendoMensajes {

    @KafkaListener(topics = "${message.topic.name:grgBackend}", groupId = "${message.group.name:backend}")
    public void listenTopic1(String message) {
        System.out.println("Recieved Message of topic1 in  listener: " + message);
    }

    @KafkaListener(topics = "${message.topic.name2:grgBackend2}", groupId = "${message.group.name:backend}")
    public void listenTopic2(String message) {
        System.out.println("Recieved Message of topic2 in  listener "+message);
    }
}

