package com.ushwamala.notification.service;

import com.ushwamala.clients.notification.NotificationRequest;
import com.ushwamala.notification.model.Notification;
import com.ushwamala.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record NotificationService(NotificationRepository notificationRepository) {
    public void sendNotification(NotificationRequest request) {
        Notification notification = Notification.builder()
                .toCustomerId(request.toCustomerId())
                .toCustomerEmail(request.toCustomerName())
                .sender("Ushamah Wamala")
                .message(request.message())
                .sentAt(LocalDateTime.now())
                .build();
        notificationRepository.save(notification);
    }
}