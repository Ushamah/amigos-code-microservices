package com.ushwamala.kafkaexample.listener;

import com.ushwamala.kafkaexample.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Slf4j
@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "amigoscode",
            groupId = "groupId"
    )
    <T> void listener(T data) {
            log.info("Listener received: {}", data);
    }
}
