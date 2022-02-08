package com.ushwamala.notification.controller;

import com.ushwamala.clients.notification.NotificationRequest;
import com.ushwamala.notification.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/notification")
public record NotificationController(NotificationService notificationService) {

    @PostMapping()
    public void sendNotification(@RequestBody NotificationRequest request){
        log.info("New notification... {}", request);
        notificationService.sendNotification(request);
    }


}
