package com.ushwamala.kafkaexample.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaService {

    private final KafkaTemplate<String,String> kafkaTemplate;

    public void publishMessageToTopic(String topic, String message){
        kafkaTemplate.send(topic, message);
    }
}
