package com.ushwamala.kafkaexample.controller;

import com.ushwamala.kafkaexample.domain.MessageRequest;
import com.ushwamala.kafkaexample.service.KafkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/vi/messages")
public class MessageController {

    private final KafkaService kafkaService;

    @PostMapping
    public void publish(@RequestBody MessageRequest request){
       kafkaService.publishMessageToTopic("amigoscode", request.message());
    }
}
