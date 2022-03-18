package com.ushwamala.kafkaexample.controller;

import com.ushwamala.kafkaexample.domain.Message;
import com.ushwamala.kafkaexample.domain.MessageRequest;
import com.ushwamala.kafkaexample.service.KafkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/vi/messages")
public class MessageController {

    private final KafkaService kafkaService;

   /* @PostMapping
    public void publish(@RequestBody MessageRequest request){
       kafkaService.publishStringToTopic("amigoscode", request.message());
    }*/

    @PostMapping
    public void publishMessage(@RequestBody MessageRequest request){
        Message message = new Message(request.message(), LocalDateTime.now());
        kafkaService.publishMessageToTopic("amigoscode", message);
    }


}
