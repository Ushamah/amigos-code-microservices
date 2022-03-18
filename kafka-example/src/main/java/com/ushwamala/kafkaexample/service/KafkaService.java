package com.ushwamala.kafkaexample.service;

import com.ushwamala.kafkaexample.domain.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class KafkaService<T> {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, T> genericKafkaTemplate;

    public void publishStringToTopic(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }

    public void publishMessageToTopic(String topic, Message request) {
        genericKafkaTemplate.send(topic, (T) new Message(request.message(), LocalDateTime.now()));
    }

}
