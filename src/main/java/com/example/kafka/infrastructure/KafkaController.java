package com.example.kafka.infrastructure;

import com.example.kafka.application.EnviandoMensajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    @Autowired
    EnviandoMensajes emisor;

    @PostMapping("/add/{topic}")
    public void addIdCustomer(@PathVariable String topic, @RequestBody String body)
    {
        emisor.sendMessage(topic,body);
    }
}
